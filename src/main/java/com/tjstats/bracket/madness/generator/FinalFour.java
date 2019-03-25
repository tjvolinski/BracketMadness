package com.tjstats.bracket.madness.generator;

import java.util.Random;

import com.tjstats.bracket.madness.vo.RegionBracketVO;

public class FinalFour {

	public static void populateFinalFour(RegionBracketVO regionBracketVO){
		regionBracketVO.setRegionChampion(getRegionChamp(regionBracketVO));
	}

	private static Integer getRegionChamp(RegionBracketVO regionBracketVO) {
		if (getRandomInteger() < 50){
			return regionBracketVO.getEliteTeam1();
		} else {
			return regionBracketVO.getEliteTeam2();
		}
	}
	
	private static int getRandomInteger(){
		return new Random().nextInt(100);
	}
}
