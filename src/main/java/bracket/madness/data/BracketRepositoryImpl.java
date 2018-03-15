package bracket.madness.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import bracket.madness.common.Constants;
import bracket.madness.domain.Bracket;
import bracket.madness.domain.Player;
import bracket.madness.domain.Region;

@Repository
public class BracketRepositoryImpl implements BracketRepository, BracketSQL{

	private Connection connection;
	
	public int addBracket(Bracket bracket) {
		if (connection == null){
			openDatabaseConnection();
		}
		saveRegion(bracket.getRegion1());
		saveRegion(bracket.getRegion2());
		saveRegion(bracket.getRegion3());
		saveRegion(bracket.getRegion4());
		saveBracket(bracket);
		//closeDatabaseConnection();
		return bracket.getBracketId().intValue();
	}
	
	public int updateBracket(Bracket bracket) {
		if (connection == null){
			openDatabaseConnection();
		}
		updateRegion(bracket.getRegion1());
		updateRegion(bracket.getRegion2());
		updateRegion(bracket.getRegion3());
		updateRegion(bracket.getRegion4());
		updateBracketEntry(bracket);
		//closeDatabaseConnection();
		return bracket.getBracketId().intValue();
	}
	

	public int deleteBracket(Bracket bracket) {
		if (connection == null){
			openDatabaseConnection();
		}
		deleteRegions(bracket);
		deleteBracketEntry(bracket);
		deleteBracketScore(bracket);
		//closeDatabaseConnection();
		return bracket.getBracketId().intValue();
	}

	public Bracket getBracket(String bracketName) {
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(GET_BRACKETS.toString().concat(BY_NAME.toString()), bracketName);
			List<Bracket> brackets = BracketMapper.getBrackets(statement.executeQuery(sql));
			if (brackets.isEmpty()){
				return new Bracket();
			} else {
				return brackets.get(0);
			}
		} catch (SQLException e) {
			System.err.println("Unable to get bracket by name");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return new Bracket();
	}
	
	public List<Bracket> getAllPlayerBrackets() {
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(GET_BRACKETS.toString());
			List<Bracket> brackets = BracketMapper.getBrackets(statement.executeQuery(sql));
			Bracket removeOverride = new Bracket();
			for (Bracket bracket : brackets){
				if (StringUtils.equals(bracket.getName(), Constants.OVERRIDE_BRACKET_NAME)){
					removeOverride = bracket;
				}
			}
			brackets.remove(removeOverride);
			return brackets;
		} catch (SQLException e) {
			System.err.println("Unable to get all brackets");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return new ArrayList<Bracket>();
	}
	
	public void populateAllPreviousScores(List<Bracket> brackets) {
		List<Long> scoreKeys = new ArrayList<Long>();
		for (Bracket bracket : brackets){
			if (bracket.getPreviousScoreKey() != null) {
				scoreKeys.add(bracket.getPreviousScoreKey());
			}
		}
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			for (Bracket bracket : brackets){
				if (bracket.getPreviousScoreKey() != null) {
					Statement statement = connection.createStatement();
					String sql = String.format(GET_PREVIOUS_SCORES.toString(), bracket.getPreviousScoreKey());
					ScoreMapper.addPrevScores(statement.executeQuery(sql), bracket);
				}
			}
		} catch (SQLException e) {
			System.err.println("Unable to add previous scores to brackets");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
	}
	
	public int updateScore(Player player){
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(UPDATE_SCORE.toString(), player.getWinPercentage(), 
					player.getTop3Percentage(), player.getLastPercentage(),  player.getAvgFinish(),
					player.getAvgPoints(), player.getMoneyLine(), player.getOdds(), player.getWinChange(),
					player.getTop3Change(), player.getLastChange(), player.getScoreKey());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update bracket score");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return player.getScoreKey().intValue();
	}
	
	public int insertScore(Player player){
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(INSERT_SCORE.toString(), player.getWinPercentage(), 
					player.getTop3Percentage(), player.getLastPercentage(), player.getAvgFinish(),
					player.getAvgPoints(), player.getMoneyLine(), player.getOdds());
			statement.execute(sql);
			ResultSet rs = statement.executeQuery(LAST_INSERTED_ROW_KEY.toString());
			while(rs.next()){
		    	player.setScoreKey(rs.getLong(1));
		    }
		} catch (SQLException e) {
			System.err.println("Unable to insert score");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return player.getScoreKey().intValue();
	}
	
	public int updateBracketWithScoreKey(Player player){
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(UPDATE_BRACKET_SCORE_KEY.toString(), player.getScoreKey(),
					player.getBracketId());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update bracket score");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return player.getScoreKey().intValue();
	}
	

	public String getNote() {
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_NOTE.toString());
			 while(rs.next()){
		    	return rs.getString("value");
		    }
		} catch (SQLException e) {
			System.err.println("Unable to get note");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
		return null;
	}
	
	public void insertNote(String note) {
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(INSERT_NOTE.toString(), "NOTE", note);
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to insert note");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
	}
	
	public void updateNote(String note) {
		if (connection == null){
			openDatabaseConnection();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(UPDATE_NOTE.toString(), note);
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update note");
			e.printStackTrace();
		}
		//closeDatabaseConnection();
	}

	private void saveRegion(Region region) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(INSERT_REGION.toString(), region.getWinner1v16(), region.getWinner8v9(),
					region.getWinner5v12(), region.getWinner4v13(), region.getWinner6v11(), region.getWinner3v14(),
					region.getWinner7v10(), region.getWinner2v15(), region.getSweet1(), region.getSweet2(),
					region.getSweet3(), region.getSweet4(), region.getElite1(), region.getElite2(), region.getChamp());
			statement.execute(sql);
			ResultSet rs = statement.executeQuery(LAST_INSERTED_ROW_KEY.toString());
		    while(rs.next()){
		    	region.setRegionId(rs.getLong(1));
		    }
		} catch (SQLException e) {
			System.err.println("Unable to save region");
			e.printStackTrace();
		}
	}
	
	private void updateRegion(Region region) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(UPDATE_REGION.toString(), region.getWinner1v16(), region.getWinner8v9(),
					region.getWinner5v12(), region.getWinner4v13(), region.getWinner6v11(), region.getWinner3v14(),
					region.getWinner7v10(), region.getWinner2v15(), region.getSweet1(), region.getSweet2(),
					region.getSweet3(), region.getSweet4(), region.getElite1(), region.getElite2(), region.getChamp(),
					region.getRegionId());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update region");
			e.printStackTrace();
		}
	}
	
	private void deleteRegions(Bracket bracket) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(DELETE_REGIONS.toString(), bracket.getRegion1().getRegionId(),
					bracket.getRegion2().getRegionId(), bracket.getRegion3().getRegionId(), bracket.getRegion4().getRegionId());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update region");
			e.printStackTrace();
		}
		
	}
	
	private void saveBracket(Bracket bracket) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(INSERT_BRACKET.toString(), bracket.getName(), bracket.getWinner(), bracket.getLoser(), 
					bracket.getRegion1().getRegionId(), bracket.getRegion2().getRegionId(), bracket.getRegion3().getRegionId(),
					bracket.getRegion4().getRegionId());
			statement.execute(sql);
			ResultSet rs = statement.executeQuery(LAST_INSERTED_ROW_KEY.toString());
		    while(rs.next()){
		    	bracket.setBracketId(rs.getLong(1));
		    }
		} catch (SQLException e) {
			System.err.println("Unable to save bracket");
			e.printStackTrace();
		}
	}
	
	private void updateBracketEntry(Bracket bracket) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(UPDATE_BRACKET.toString(), bracket.getName(), bracket.getWinner(), 
					bracket.getLoser(), bracket.getBracketId());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update bracket");
			e.printStackTrace();
		}	
	}
	
	private void deleteBracketEntry(Bracket bracket) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(DELETE_BRACKET.toString(), bracket.getBracketId());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update region");
			e.printStackTrace();
		}
	}
	
	private void deleteBracketScore(Bracket bracket) {
		try {
			Statement statement = connection.createStatement();
			String sql = String.format(DELETE_BRACKET_SCORE.toString(), bracket.getPreviousScoreKey());
			statement.execute(sql);
		} catch (SQLException e) {
			System.err.println("Unable to update region");
			e.printStackTrace();
		}
	}

	private void openDatabaseConnection(){
	    try {
			Class.forName(Constants.DATABASE_DRIVER);
			connection = DriverManager.getConnection(Constants.DATABASE_LOCATION);
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to find SQLITE jar");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("No database found at: "+Constants.DATABASE_LOCATION);
			e.printStackTrace();
		}
	}
	
//	private void closeDatabaseConnection(){
//		if (connection != null){
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.err.println("Failed to close database connection");
//				e.printStackTrace();
//			}
//		}
//	}
}
