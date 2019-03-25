package com.tjstats.bracket.madness.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjstats.bracket.madness.domain.Bracket;
import com.tjstats.bracket.madness.domain.Score;

public class ScoreMapper {

	public static void addPrevScores(ResultSet rs, Bracket bracket) throws SQLException {
		while(rs.next()){
			Score score = new Score();
			score.setScoreKey(rs.getLong("score_key"));
			score.setWinPercentage(rs.getString("win"));
			score.setTop3Percentage(rs.getString("top_three"));
			score.setLastPercentage(rs.getString("last"));
			score.setPosition(rs.getString("position"));
			score.setPoints(rs.getString("points"));
			score.setMoneyLine(rs.getString("money_line"));
			score.setOdds(rs.getString("odds"));
			score.setWinChange(rs.getString("win_change"));
			score.setTop3Change(rs.getString("top_three_change"));
			score.setLastChange(rs.getString("last_change"));

			if (bracket.getPreviousScoreKey().equals(score.getScoreKey())){
				bracket.setPreviousScore(score);
			}
		}
	}
}
