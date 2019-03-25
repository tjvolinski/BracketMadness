package com.tjstats.bracket.madness.calculator;

import java.util.List;

import com.tjstats.bracket.madness.domain.Bracket;
import com.tjstats.bracket.madness.domain.Player;

public interface BracketCalculator {

	public List<Player> processBracketCalculations(List<Bracket> playerBrackets, 
			int numberOfBrackets, Bracket overrideBracket, boolean officialSimulation);
	public String getPercentComplete();
	public void resetPercentComplete();
	public List<Player> convertBracketsToPlayers(List<Bracket> playerBrackets);
}
