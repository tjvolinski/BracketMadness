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
		com.tjstats.bracket.madness.domain2.Bracket bracket = new com.tjstats.bracket.madness.domain2.Bracket();
		bracket.setPlayerName("TJ");
		bracket.setChamp("1");
		bracket.setChampRegion("A");
		bracket.setRunnerUp("2");
		bracket.setRunnerUpRegion("D");
		bracketDAO.insertBracket(bracket);
		
		
//		List<Bracket> playerBrackets = bracketRepository.getAllPlayerBrackets();
//		Bracket overrideBracket = bracketRepository.getBracket("OVERRIDE");
//		List<Player> players = bracketCalculator.processBracketCalculations(playerBrackets, 100000, overrideBracket, false);
//		model.addAttribute("players", players);
        return "stats";
    }
}
