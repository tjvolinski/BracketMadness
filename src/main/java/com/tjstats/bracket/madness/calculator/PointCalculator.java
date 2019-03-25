package com.tjstats.bracket.madness.calculator;

import com.tjstats.bracket.madness.vo.FullBracketVO;
import com.tjstats.bracket.madness.vo.RegionBracketVO;

public class PointCalculator {
	
	public static int calculatePlayerPoints(FullBracketVO sampleBracket, FullBracketVO playerBracket){
		Integer points = 0;
		
		points += getRegionTotal(sampleBracket.getTopLeftRegion(), playerBracket.getTopLeftRegion());
		points += getRegionTotal(sampleBracket.getBottomLeftRegion(), playerBracket.getBottomLeftRegion());
		points += getRegionTotal(sampleBracket.getTopRightRegion(), playerBracket.getTopRightRegion());
		points += getRegionTotal(sampleBracket.getBottomRightRegion(), playerBracket.getBottomRightRegion());
		
		//Finalists
		if (sampleBracket.getLeftFinalist().equals(playerBracket.getLeftFinalist())){
			points += 16;
		}
		if (sampleBracket.getRightFinalist().equals(playerBracket.getRightFinalist())){
			points += 16;
		}

		//Champion
		if (sampleBracket.getChampion().equals(playerBracket.getChampion())){
			points += 32;
		}
		
		return points;
	}

	private static Integer getRegionTotal(RegionBracketVO sampleRegion, RegionBracketVO playerRegion) {
		Integer regionPoints = 0;
		
		//Round of 32
		if (sampleRegion.getWinner1v16() == playerRegion.getWinner1v16()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner2v15() == playerRegion.getWinner2v15()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner3v14() == playerRegion.getWinner3v14()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner4v13() == playerRegion.getWinner4v13()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner5v12() == playerRegion.getWinner5v12()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner6v11() == playerRegion.getWinner6v11()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner7v10() == playerRegion.getWinner7v10()){
			regionPoints += 1;
		}
		if (sampleRegion.getWinner8v9() == playerRegion.getWinner8v9()){
			regionPoints += 1;
		}
		
		//Sweet 16
		if (sampleRegion.getSweetTeam1() == playerRegion.getSweetTeam1()){
			regionPoints += 2;
		}
		if (sampleRegion.getSweetTeam2() == playerRegion.getSweetTeam2()){
			regionPoints += 2;
		}
		if (sampleRegion.getSweetTeam3() == playerRegion.getSweetTeam3()){
			regionPoints += 2;
		}
		if (sampleRegion.getSweetTeam4() == playerRegion.getSweetTeam4()){
			regionPoints += 2;
		}
		
		//Elite 8
		if (sampleRegion.getEliteTeam1() == playerRegion.getEliteTeam1()){
			regionPoints += 4;
		}
		if (sampleRegion.getEliteTeam2() == playerRegion.getEliteTeam2()){
			regionPoints += 4;
		}
		
		//Final 4
		if (sampleRegion.getRegionChampion() == playerRegion.getRegionChampion()){
			regionPoints += 8;
		}
		
		return regionPoints;
	}
}
