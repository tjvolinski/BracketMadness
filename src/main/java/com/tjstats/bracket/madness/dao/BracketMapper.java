package com.tjstats.bracket.madness.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.tjstats.bracket.madness.domain2.Bracket;

public class BracketMapper implements RowMapper<Bracket> {

	@Override
	public Bracket map(ResultSet rs, StatementContext ctx) throws SQLException {
		Bracket bracket = new Bracket();
		bracket.setPlayerName(rs.getString("player_name"));
		bracket.setChamp(rs.getString("champ"));
		bracket.setChampRegion(rs.getString("champ_region"));
		bracket.setRunnerUp(rs.getString("runner_up"));
		bracket.setRunnerUpRegion(rs.getString("runner_up_region"));
		return bracket;
	}
}
