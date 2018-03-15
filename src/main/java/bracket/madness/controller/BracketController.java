package bracket.madness.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bracket.madness.calculator.BracketCalculator;
import bracket.madness.common.Constants;
import bracket.madness.data.BracketRepository;
import bracket.madness.domain.Bracket;
import bracket.madness.domain.Player;
import bracket.madness.domain.Region;
import bracket.madness.domain.Simulation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bracket")
public class BracketController {
    
	@Autowired
	BracketRepository bracketRepository;
	
	@Autowired
	BracketCalculator bracketCalculator;
	
    @RequestMapping(value = "/addBracket", method = RequestMethod.POST)
    public @ResponseBody void addBracket(@RequestBody Bracket bracket) {
    	addEmptyRegions(bracket);
    	bracketRepository.addBracket(bracket);
    }

	@RequestMapping(value = "/getBracket", method = RequestMethod.POST)
    public @ResponseBody Bracket getBracket(@RequestBody String bracketName) {
        return bracketRepository.getBracket(bracketName);
    }
    
    @RequestMapping(value = "/updateBracket", method = RequestMethod.POST)
    public @ResponseBody void updateBracket(@RequestBody Bracket bracket) {
    	bracketRepository.updateBracket(bracket);
    }
    
    @RequestMapping(value = "/deleteBracket", method = RequestMethod.POST)
    public @ResponseBody void deleteBracket(@RequestBody Bracket bracket) {
    	bracketRepository.deleteBracket(bracket);
    }
    
    @RequestMapping(value = "/simulateMadness", method = RequestMethod.POST)
	public @ResponseBody List<Player> simulateMadness(@RequestBody Simulation simulation) {
    	if (StringUtils.isNumeric(simulation.getSimulationCount()) && !simulation.getSimulationCount().isEmpty()){
	        List<Bracket> playerBrackets = bracketRepository.getAllPlayerBrackets();
	        bracketRepository.populateAllPreviousScores(playerBrackets);
	        if (simulation.getNote() != null){
	        	addNewNote(simulation.getNote());
	        }
	        Bracket overrideBracket = bracketRepository.getBracket(Constants.OVERRIDE_BRACKET_NAME);
	        return bracketCalculator.processBracketCalculations(playerBrackets, Integer.valueOf(simulation.getSimulationCount()), 
	        		overrideBracket, simulation.isOfficialSimulation(), this);
    	}
    	return new ArrayList<Player>();
    }
    
    private void addNewNote(String note) {
		String existingNote = bracketRepository.getNote();
		if (existingNote != null){
			bracketRepository.updateNote(note);
		} else {
			bracketRepository.insertNote(note);
		}
	}

	@RequestMapping(value = "/getResults", method = RequestMethod.POST)
	public @ResponseBody List<Player> getResults(@RequestBody String simulationCount) {
        List<Bracket> playerBrackets = bracketRepository.getAllPlayerBrackets();
        bracketRepository.populateAllPreviousScores(playerBrackets);
	    return bracketCalculator.convertBracketsToPlayers(playerBrackets);
    }
    
    @RequestMapping(value = "/getPic", method = RequestMethod.POST)
	public @ResponseBody String getPic(@RequestBody String simulationCount) {
    	Integer num = new Random().nextInt(100);
    	if (num < 20){
    		return "resources/images/tj4.jpg";
    	} else if (num < 40 && num >= 20){
    		return "resources/images/tj5.jpg";
    	} else if (num >= 40 && num < 60){
    		return "resources/images/tj6.jpg";
    	} else if (num >= 80){
    		return "resources/images/tj7.jpg";
    	} else {
    		return "resources/images/tj8.jpg";
    	}
    }
    
    @RequestMapping(value = "/getBanner", method = RequestMethod.POST)
	public @ResponseBody String getBanner(@RequestBody String simulationCount) {
    	Integer num = new Random().nextInt(100);
    	if (num < 20){
    		return "resources/images/izzo.jpg";
    	} else if (num < 40 && num >= 20){
    		return "resources/images/valentine.jpg";
    	} else if (num >= 40 && num < 60){
    		return "resources/images/costello.jpg";
    	} else if (num >= 80){
    		return "resources/images/harris.jpg";
    	} else {
    		return "resources/images/forbes.jpg";
    	}
    }
    
    @RequestMapping(value = "/getNote", method = RequestMethod.POST)
   	public @ResponseBody String getNote(@RequestBody String simulationCount) {
    	String note = bracketRepository.getNote();
    	if (note == null){
    		return "";
    	} else {
    		return note;
    	}
     }
    
    @RequestMapping(value = "/getPercentComplete", method = RequestMethod.GET)
	public @ResponseBody String getPercentComplete() {
        return bracketCalculator.getPercentComplete();
    }
    
    @RequestMapping(value = "/resetPercentComplete", method = RequestMethod.POST)
   	public @ResponseBody void resetPercentComplete() {
           bracketCalculator.resetPercentComplete();
       }
    
    @RequestMapping("/layout")
    public String getBracketPartialPage() {
        return "bracket/layout";
    }
    
    private void addEmptyRegions(Bracket bracket) {
		if (bracket.getRegion1() == null){
			bracket.setRegion1(new Region());
		}
		if (bracket.getRegion2() == null){
			bracket.setRegion2(new Region());
		}
		if (bracket.getRegion3() == null){
			bracket.setRegion3(new Region());
		}
		if (bracket.getRegion4() == null){
			bracket.setRegion4(new Region());
		}
	}
}
