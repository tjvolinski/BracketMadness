package com.tjstats.bracket.madness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tjstats.bracket.madness.calculator.BracketCalculator;
import com.tjstats.bracket.madness.dao.BracketDAO;
import com.tjstats.bracket.madness.data.BracketRepository;
import com.tjstats.bracket.madness.domain.Bracket;
import com.tjstats.bracket.madness.domain.Player;

@Controller
public class BracketController {
	
	@Autowired
	BracketRepository bracketRepository;
	
	@Autowired
	BracketCalculator bracketCalculator;
	
	@Autowired
	BracketDAO bracketDAO;

	@GetMapping("/")
    public String index(Model model) {
        return "index";
    }
	
	@GetMapping("/projections.html")
    public String projectionsTab(Model model) {
		//TODO grab data, don't need to run it
		List<Bracket> playerBrackets = bracketRepository.getAllPlayerBrackets();
		Bracket overrideBracket = bracketRepository.getBracket("OVERRIDE");
		List<Player> players = bracketCalculator.processBracketCalculations(playerBrackets, 100000, overrideBracket, false);
		model.addAttribute("players", players);
		return "projections";
	}
	
	@GetMapping("/pick-distributions.html")
    public String pickDistributionsTab(Model model) {
		return "pick-distributions";
	}
	
	@GetMapping("/player-brackets.html")
    public String playerBracketsTab(Model model) {
		return "player-brackets";
	}
}
