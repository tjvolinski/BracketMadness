package com.tjstats.bracket.madness.generator;

import java.util.Random;

import com.tjstats.bracket.madness.vo.RegionBracketVO;

public class SweetSixteen {
	
	public static void populateSweetSixteen(RegionBracketVO regionBracketVO){
		regionBracketVO.setSweetTeam1(getSweetTeam1(regionBracketVO));
		regionBracketVO.setSweetTeam2(getSweetTeam2(regionBracketVO));
		regionBracketVO.setSweetTeam3(getSweetTeam3(regionBracketVO));
		regionBracketVO.setSweetTeam4(getSweetTeam4(regionBracketVO));
	}

	private static Integer getSweetTeam1(RegionBracketVO regionBracketVO) {
		if (regionBracketVO.getWinner1v16() == 1 && regionBracketVO.getWinner8v9() == 8){
			if (getRandomInteger() < 80){ 
				return 1;
			} else {
				return 8;
			}
		}
		if (regionBracketVO.getWinner1v16() == 1 && regionBracketVO.getWinner8v9() == 9){
			if (getRandomInteger() < 89){ 
				return 1;
			} else {
				return 9;
			}
		}
		if (getRandomInteger() < 10){
			return regionBracketVO.getWinner8v9();
		} else {
			return 16;
		}
	}
	
	private static Integer getSweetTeam2(RegionBracketVO regionBracketVO) {
		if (regionBracketVO.getWinner4v13() == 4 && regionBracketVO.getWinner5v12() == 5){
			if (getRandomInteger() < 56){
				return 4;
			} else {
				return 5;
			}
		}
		if (regionBracketVO.getWinner4v13() == 4 && regionBracketVO.getWinner5v12() == 12){
			if (getRandomInteger() < 69){
				return 4;
			} else {
				return 12;
			}
		}
		if (regionBracketVO.getWinner4v13() == 13 && regionBracketVO.getWinner5v12() == 5){
			if (getRandomInteger() < 18){ 
				return 13;
			} else {
				return 5;
			}
		}
		if (regionBracketVO.getWinner4v13() == 13 && regionBracketVO.getWinner5v12() == 12){
			if (getRandomInteger() < 27){
				return 13;
			} else {
				return 12;
			}
		}
		return 0;
	}
	
	private static Integer getSweetTeam3(RegionBracketVO regionBracketVO) {
		if (regionBracketVO.getWinner3v14() == 3 && regionBracketVO.getWinner6v11() == 6){
			if (getRandomInteger() < 56){
				return 3;
			} else {
				return 6;
			}
		}
		if (regionBracketVO.getWinner3v14() == 3 && regionBracketVO.getWinner6v11() == 11){
			if (getRandomInteger() < 69){
				return 3;
			} else {
				return 11;
			}
		}
		if (regionBracketVO.getWinner3v14() == 14){
			if (getRandomInteger() < 14){
				return 14;
			} else {
				return regionBracketVO.getWinner6v11();
			}
		}
		return 0;
	}

	private static Integer getSweetTeam4(RegionBracketVO regionBracketVO) {
		if (regionBracketVO.getWinner2v15() == 2 && regionBracketVO.getWinner7v10() == 7){
			if (getRandomInteger() < 70){ 
				return 2;
			} else {
				return 7;
			}
		}
		if (regionBracketVO.getWinner2v15() == 2 && regionBracketVO.getWinner7v10() == 10){
			if (getRandomInteger() < 61){ 
				return 2;
			} else {
				return 10;
			}
		}
		if (regionBracketVO.getWinner2v15() == 15){
			if (getRandomInteger() < 10){
				return 15;
			} else {
				return regionBracketVO.getWinner7v10();
			}
		}
		return 0;
	}

	private static int getRandomInteger(){
		return new Random().nextInt(100);
	}
}
