package com.tjstats.bracket.madness.assembler;

import java.util.ArrayList;
import java.util.List;

import com.tjstats.bracket.madness.domain.Bracket;
import com.tjstats.bracket.madness.domain.Region;
import com.tjstats.bracket.madness.vo.FullBracketVO;
import com.tjstats.bracket.madness.vo.RegionBracketVO;


public class PlayerBracketAssembler {

	public static List<FullBracketVO> getPlayerBrackets(List<Bracket> playerBrackets) {
		List<FullBracketVO> fullPlayerBrackets = new ArrayList<FullBracketVO>();
		
		for (Bracket bracket : playerBrackets){
			FullBracketVO fullBracket = new FullBracketVO();
			fullBracket.setTopLeftRegion(getRegion(fullBracket, bracket.getRegion1()));
			fullBracket.setBottomLeftRegion(getRegion(fullBracket, bracket.getRegion2()));
			fullBracket.setTopRightRegion(getRegion(fullBracket, bracket.getRegion3()));
			fullBracket.setBottomRightRegion(getRegion(fullBracket, bracket.getRegion4()));
			fullBracket.setChampion(bracket.getWinner());
			if (bracket.getWinner().contains("A") || bracket.getWinner().contains("B")){
				fullBracket.setLeftFinalist(bracket.getWinner());
				fullBracket.setRightFinalist(bracket.getLoser());
			} else {
				fullBracket.setLeftFinalist(bracket.getLoser());
				fullBracket.setRightFinalist(bracket.getWinner());
			}
			fullBracket.setBracketName(bracket.getName());
			fullPlayerBrackets.add(fullBracket);
		}
		
		return fullPlayerBrackets;
	}
	
	public static FullBracketVO getOverrideBracket(Bracket overrideBracket) {
		FullBracketVO fullBracket = new FullBracketVO();
		fullBracket.setTopLeftRegion(getRegion(fullBracket, overrideBracket.getRegion1()));
		fullBracket.setBottomLeftRegion(getRegion(fullBracket, overrideBracket.getRegion2()));
		fullBracket.setTopRightRegion(getRegion(fullBracket, overrideBracket.getRegion3()));
		fullBracket.setBottomRightRegion(getRegion(fullBracket, overrideBracket.getRegion4()));
		fullBracket.setChampion(overrideBracket.getWinner());
		if (overrideBracket.getWinner().contains("A") || overrideBracket.getWinner().contains("B")){
			fullBracket.setLeftFinalist(overrideBracket.getWinner());
			fullBracket.setRightFinalist(overrideBracket.getLoser());
		} else {
			fullBracket.setLeftFinalist(overrideBracket.getLoser());
			fullBracket.setRightFinalist(overrideBracket.getWinner());
		}
		fullBracket.setBracketName(overrideBracket.getName());
		return fullBracket;
	}

	private static RegionBracketVO getRegion(FullBracketVO fullBracket, Region region) {
		return new RegionBracketVO(region.getRegionId().toString(), region.getWinner1v16(), region.getWinner8v9(), 
				region.getWinner5v12(), region.getWinner4v13(), region.getWinner6v11(), region.getWinner3v14(), 
				region.getWinner7v10(), region.getWinner2v15(), region.getSweet1(), region.getSweet2(), 
				region.getSweet3(), region.getSweet4(), region.getElite1(), region.getElite2(), region.getChamp());
	}

}
