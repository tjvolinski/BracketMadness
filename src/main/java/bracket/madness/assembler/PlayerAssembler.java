package bracket.madness.assembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bracket.madness.domain.Player;
import bracket.madness.utils.StatisticUtil;
import bracket.madness.vo.PlayerVO;

public class PlayerAssembler {

	public static List<Player> buildPlayers(List<PlayerVO> playerVOs, int numberOfBrackets) {
		List<Player> players = new ArrayList<Player>();
		for (PlayerVO playerVO : playerVOs){
			Player player = new Player();
			player.setPlayerName(playerVO.getPlayerName());
			player.setWinPercentage(StatisticUtil.getPercentage(playerVO.getTimesWon(), numberOfBrackets));
			player.setTop3Percentage(StatisticUtil.getPercentage(playerVO.getTimesTopThree(), numberOfBrackets));
			player.setLastPercentage(StatisticUtil.getPercentage(playerVO.getTimesLast(), numberOfBrackets));
			player.setAvgFinish(StatisticUtil.getAverage(Long.valueOf(playerVO.getTotalPositionsFinished()), numberOfBrackets));
			player.setAvgPoints(StatisticUtil.getAverage(playerVO.getTotalPoints(), numberOfBrackets));
			player.setMoneyLine(StatisticUtil.getMoneyLine(playerVO.getTimesWon(), numberOfBrackets));
			player.setOdds(StatisticUtil.getRoundedOdds(playerVO.getTimesWon(), numberOfBrackets));
			player.setTimesWon(playerVO.getTimesWon());
			players.add(player);
		}
		
		//Sort Players by Most Times Won
		Collections.sort(players, new Comparator<Player>() {
             public int compare(Player o1, Player o2) {
                 return o2.getTimesWon() - o1.getTimesWon();
             }
		});
		
		return players;
	}

}
