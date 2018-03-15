package bracket.madness.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bracket.madness.domain.Bracket;
import bracket.madness.domain.Region;

public class BracketMapper {

	public static List<Bracket> getBrackets(ResultSet rs) throws SQLException {
		Map<String, Bracket> bracketMap = new HashMap<String, Bracket>();
		while(rs.next()){
	    	Bracket bracket = buildBracket(rs);
	    	if (bracketMap.containsKey(bracket.getName())){
	    		Bracket existingBracket = bracketMap.get(bracket.getName());
	    		if (bracket.getRegion1() != null){
	    			existingBracket.setRegion1(bracket.getRegion1());
	    		} else if (bracket.getRegion2() != null){
	    			existingBracket.setRegion2(bracket.getRegion2());
	    		} else if (bracket.getRegion3() != null){
	    			existingBracket.setRegion3(bracket.getRegion3());
	    		} else if (bracket.getRegion4() != null){
	    			existingBracket.setRegion4(bracket.getRegion4());
	    		}
	    	} else {
	    		bracketMap.put(bracket.getName(), bracket);
	    	}
	    }
		return convertBracketMapToList(bracketMap);
	}

	private static Bracket buildBracket(ResultSet rs) throws SQLException {
		Bracket bracket = new Bracket();
		bracket.setBracketId(rs.getLong("bracket_id"));
		bracket.setName(rs.getString("bracket_name"));
		bracket.setWinner(rs.getString("winner"));
		bracket.setLoser(rs.getString("loser"));
		bracket.setPreviousScoreKey(rs.getLong("prev_score"));
		Region region = buildRegion(rs);
		if (rs.getLong("region1_key") == region.getRegionId().longValue()){
			bracket.setRegion1(region);
		} else if (rs.getLong("region2_key") == region.getRegionId().longValue()){
			bracket.setRegion2(region);
		} else if (rs.getLong("region3_key") == region.getRegionId().longValue()){
			bracket.setRegion3(region);
		} else if (rs.getLong("region4_key") == region.getRegionId().longValue()){
			bracket.setRegion4(region);
		}
		return bracket;
	}

	private static Region buildRegion(ResultSet rs) throws SQLException {
		Region region = new Region();
		region.setRegionId(rs.getLong("region_key"));
		region.setWinner1v16(rs.getInt("1v16"));
		region.setWinner8v9(rs.getInt("8v9"));
		region.setWinner5v12(rs.getInt("5v12"));
		region.setWinner4v13(rs.getInt("4v13"));
		region.setWinner6v11(rs.getInt("6v11"));
		region.setWinner3v14(rs.getInt("3v14"));
		region.setWinner7v10(rs.getInt("7v10"));
		region.setWinner2v15(rs.getInt("2v15"));
		region.setSweet1(rs.getInt("sweet1"));
		region.setSweet2(rs.getInt("sweet2"));
		region.setSweet3(rs.getInt("sweet3"));
		region.setSweet4(rs.getInt("sweet4"));
		region.setElite1(rs.getInt("elite1"));
		region.setElite2(rs.getInt("elite2"));
		region.setChamp(rs.getInt("champ"));
		return region;
	}
	
	private static List<Bracket> convertBracketMapToList(Map<String, Bracket> bracketMap) {
		List<Bracket> brackets = new ArrayList<Bracket>();
		for (Entry<String, Bracket> entry : bracketMap.entrySet()){
			brackets.add(entry.getValue());
		}
		return brackets;
	}
}
