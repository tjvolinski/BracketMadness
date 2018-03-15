package bracket.madness.calculator;

import java.util.List;

import bracket.madness.controller.BracketController;
import bracket.madness.domain.Bracket;
import bracket.madness.domain.Player;

public interface BracketCalculator {

	public List<Player> processBracketCalculations(List<Bracket> playerBrackets, 
			int numberOfBrackets, Bracket overrideBracket, boolean officialSimulation, 
			BracketController bracketController);
	public String getPercentComplete();
	public void resetPercentComplete();
	public List<Player> convertBracketsToPlayers(List<Bracket> playerBrackets);
}
