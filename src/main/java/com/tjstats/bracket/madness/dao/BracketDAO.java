package com.tjstats.bracket.madness.dao;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.tjstats.bracket.madness.domain2.Bracket;

public interface BracketDAO {

	 @SqlUpdate("insert into brackets (player_name, champ, champ_region, runner_up, runner_up_region) "
	 		+ "values (:playerName, :champ, :champRegion, :runnerUp, :runnerUpRegion)")
	 void insertBracket(@BindBean Bracket bracket);
	 
	 @SqlUpdate("update brackets set champ=:champ, champ_region=:champRegion, "
	 		+ "runner_up=:runnerUp, runner_up_region=:runnerUpRegion where player_name=:playerName")
	 void updateBracket(@BindBean Bracket bracket);
	 
	 @SqlUpdate("delete from brackets where player_name = :playerName")
	 void deleteBracket(@Bind("playerName") String playerName);
	 
	 @SqlQuery("select * from brackets where player_name = :playerName")
	 @RegisterRowMapper(BracketMapper.class)
	 Bracket getBracket(@Bind("playerName") String playerName);
}
