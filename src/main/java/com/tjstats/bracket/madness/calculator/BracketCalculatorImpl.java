package com.tjstats.bracket.madness.calculator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tjstats.bracket.madness.assembler.PlayerAssembler;
import com.tjstats.bracket.madness.assembler.PlayerBracketAssembler;
import com.tjstats.bracket.madness.data.BracketRepository;
import com.tjstats.bracket.madness.domain.Bracket;
import com.tjstats.bracket.madness.domain.Player;
import com.tjstats.bracket.madness.generator.Championship;
import com.tjstats.bracket.madness.generator.EliteEight;
import com.tjstats.bracket.madness.generator.FinalFour;
import com.tjstats.bracket.madness.generator.OverrideBracket;
import com.tjstats.bracket.madness.generator.SecondRound;
import com.tjstats.bracket.madness.generator.SweetSixteen;
import com.tjstats.bracket.madness.vo.FullBracketVO;
import com.tjstats.bracket.madness.vo.PlayerVO;
import com.tjstats.bracket.madness.vo.RegionBracketVO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

@Component
public class BracketCalculatorImpl implements BracketCalculator{ 
	
	public String percentComplete = "0%";
	public DecimalFormat format = new DecimalFormat("##.00");
	
	@Autowired
	BracketRepository bracketRepository;
	
	public List<Player> processBracketCalculations(List<Bracket> playerBrackets, 
			int numberOfBrackets, Bracket overrideBracket, boolean isOfficialSimulation){		
		 
		//Build Player and Override Brackets
		List<FullBracketVO> playerBracketVOs = PlayerBracketAssembler.getPlayerBrackets(playerBrackets);
		FullBracketVO overrideBracketVO = PlayerBracketAssembler.getOverrideBracket(overrideBracket);
		
		//Build Player Stats
		Map<String, PlayerVO> playerStats = new HashMap<String, PlayerVO>();
		List<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		for (FullBracketVO bracket : playerBracketVOs){
			PlayerVO player = new PlayerVO(bracket.getBracketName());
			playerStats.put(bracket.getBracketName(), player);
			playerVOs.add(player);
		}
		
		//Start Calculations
		for (int i = 0; i < numberOfBrackets; i++){
			percentComplete = format.format(i/Double.valueOf(numberOfBrackets)*100)+"%";
			bracketCalculations(playerStats, playerBracketVOs,  playerVOs, overrideBracketVO);
		}
		percentComplete = "100%";
		List<Player> players = PlayerAssembler.buildPlayers(playerVOs, numberOfBrackets);
		
		//Calculate Stat change from previous run and save new data 
		calculateStatChange(players, playerBrackets);
		if (isOfficialSimulation) {
			saveCurrentBracketStats(players, playerBrackets);
		}
		
		return players;
	}

	private static void bracketCalculations(Map<String, PlayerVO> players, 
			List<FullBracketVO> playerBrackets, List<PlayerVO> playerVOs, FullBracketVO overrideBracketVO) {
		FullBracketVO sampleBracket = simulateBracket(overrideBracketVO);
		for (FullBracketVO playerBracket: playerBrackets){
			int points = PointCalculator.calculatePlayerPoints(sampleBracket, playerBracket);
			players.get(playerBracket.getBracketName()).setPoints(points);
		}
		
		//Sort Players by Most Points
		Collections.sort(playerVOs, new Comparator<PlayerVO>() {
             public int compare(PlayerVO o1, PlayerVO o2) {
                 return o2.getPoints() - o1.getPoints();
             }
		});
		determineWinnersAndTopThree(playerVOs);
	}

	private static void determineWinnersAndTopThree(List<PlayerVO> playerVOs) {
		int firstPlace = 0;
		int thirdPlace = 0;
		int lastPlace = 0;
		if (playerVOs.size() > 0){
			firstPlace = playerVOs.get(0).getPoints();
			lastPlace = playerVOs.get(playerVOs.size()-1).getPoints();
		}
		if (playerVOs.size() > 2){
			thirdPlace = playerVOs.get(2).getPoints();
		}
		int positionFinished = 1;
		for (PlayerVO player : playerVOs){
			if (player.getPoints() >= firstPlace){
				player.setTimesWon(player.getTimesWon() + 1);
			} 
			if (player.getPoints() >= thirdPlace){
				player.setTimesTopThree(player.getTimesTopThree() + 1);
			}
			if (player.getPoints() <= lastPlace){
				player.setTimesLast(player.getTimesLast() + 1);
			}
			player.setTotalPositionsFinished(player.getTotalPositionsFinished() + positionFinished);
			player.setTotalPoints(player.getTotalPoints() + player.getPoints());
			positionFinished++;
		}
	}

	private static FullBracketVO simulateBracket(FullBracketVO overrideBracketVO) {
		FullBracketVO fullBracketVO = new FullBracketVO();
		
		RegionBracketVO topLeftRegion = new RegionBracketVO();
		buildRegion(topLeftRegion, overrideBracketVO.getTopLeftRegion());
		
		RegionBracketVO bottomLeftRegion = new RegionBracketVO();
		buildRegion(bottomLeftRegion, overrideBracketVO.getBottomLeftRegion());
		
		RegionBracketVO topRightRegion = new RegionBracketVO();
		buildRegion(topRightRegion, overrideBracketVO.getTopRightRegion());
		
		RegionBracketVO bottomRightRegion = new RegionBracketVO();
		buildRegion(bottomRightRegion, overrideBracketVO.getBottomRightRegion());
		
		fullBracketVO.setTopLeftRegion(topLeftRegion);
		fullBracketVO.setBottomLeftRegion(bottomLeftRegion);
		fullBracketVO.setTopRightRegion(topRightRegion);
		fullBracketVO.setBottomRightRegion(bottomRightRegion);
		
		Championship.populateChampion(fullBracketVO);
		OverrideBracket.addChampionOverride(fullBracketVO, overrideBracketVO);
		
		return fullBracketVO;
	}

	private static void buildRegion(RegionBracketVO region, RegionBracketVO overrideRegionVO) {	
		SecondRound.populateSecondRound(region);
		OverrideBracket.addSecondRoundOverrides(region, overrideRegionVO);
		
		SweetSixteen.populateSweetSixteen(region);
		OverrideBracket.addSweetOverrides(region, overrideRegionVO);
		
		EliteEight.populateEliteEight(region);
		OverrideBracket.addEliteOverrides(region, overrideRegionVO);
		
		FinalFour.populateFinalFour(region);
		OverrideBracket.addFinalFourOverride(region, overrideRegionVO);
	}
	
	private void calculateStatChange(List<Player> players, List<Bracket> playerBrackets) {
		for (Bracket bracket : playerBrackets){
			for (Player player : players){
				if (bracket.getName().equalsIgnoreCase(player.getPlayerName())){
					//Populate keys for players
					player.setScoreKey(bracket.getPreviousScoreKey());
					player.setBracketId(bracket.getBracketId());
					//Calculate change in stats from previous run
					if (bracket.getPreviousScore() != null){
						Double winChange = Double.valueOf(player.getWinPercentage()) - Double.valueOf(bracket.getPreviousScore().getWinPercentage());
						Double top3Change = Double.valueOf(player.getTop3Percentage()) - Double.valueOf(bracket.getPreviousScore().getTop3Percentage());
						Double lastChange = Double.valueOf(player.getLastPercentage()) - Double.valueOf(bracket.getPreviousScore().getLastPercentage());
						if (winChange > 0){
							player.setWinChangePositive(true);
						}
						if (top3Change > 0){
							player.setTop3ChangePositive(true);
						}
						if (lastChange > 0){
							player.setLastChangePositive(true);
						}
						player.setWinChange(format.format(winChange));
						player.setTop3Change(format.format(top3Change));
						player.setLastChange(format.format(lastChange));
					}
				}
			}
		}
		
	}
	
	private void saveCurrentBracketStats(List<Player> players, List<Bracket> playerBrackets) {
		for (Player player : players){
			if (player.getScoreKey() != null && player.getScoreKey() != 0L){
				bracketRepository.updateScore(player);
			} else {
				bracketRepository.insertScore(player);
				bracketRepository.updateBracketWithScoreKey(player);
			}
		}
	}
	
	public String getPercentComplete(){
		return percentComplete;
	}

	public void resetPercentComplete() {
		percentComplete = "0%";
	}

	public List<Player> convertBracketsToPlayers(List<Bracket> playerBrackets) {
		List<Player> players = new ArrayList<Player>();
		for (Bracket bracket : playerBrackets){
			Player player = new Player();
			player.setPlayerName(bracket.getName());
			if (bracket.getPreviousScore() != null){
				player.setAvgFinish(bracket.getPreviousScore().getPosition());
				player.setAvgPoints(bracket.getPreviousScore().getPoints());
				player.setLastChange(bracket.getPreviousScore().getLastChange());
				if (!player.getLastChange().contains("-")){
					player.setLastChangePositive(true);
				}
				player.setLastPercentage(bracket.getPreviousScore().getLastPercentage());
				player.setMoneyLine(bracket.getPreviousScore().getMoneyLine());
				player.setOdds(bracket.getPreviousScore().getOdds());
				player.setTop3Change(bracket.getPreviousScore().getTop3Change());
				if (!player.getTop3Change().contains("-")){
					player.setTop3ChangePositive(true);
				}
				player.setTop3Percentage(bracket.getPreviousScore().getTop3Percentage());
				player.setWinChange(bracket.getPreviousScore().getWinChange());
				if (!player.getWinChange().contains("-")){
					player.setWinChangePositive(true);
				}
				player.setWinPercentage(bracket.getPreviousScore().getWinPercentage());
			}
			players.add(player);
		}
		
		//Sort Players by Most Points
		Collections.sort(players, new Comparator<Player>() {
             public int compare(Player o1, Player o2) {
            	 if (o1.getWinPercentage() == null || o2.getWinPercentage() == null){
            		 return 0;
            	 } else {
            		 return Double.compare(Double.valueOf(o2.getWinPercentage()), Double.valueOf(o1.getWinPercentage()));
            	 }
             }
		});
		
		return players;
	}
}
