package bracket.madness.generator;

import java.util.Random;

import bracket.madness.vo.RegionBracketVO;

public class SecondRound {
	
	public static void populateSecondRound (RegionBracketVO regionBracket){
		regionBracket.setWinner1v16(getWinner1v16());
		regionBracket.setWinner2v15(getWinner2v15());
		regionBracket.setWinner3v14(getWinner3v14());
		regionBracket.setWinner4v13(getWinner4v13());
		regionBracket.setWinner5v12(getWinner5v12());
		regionBracket.setWinner6v11(getWinner6v11());
		regionBracket.setWinner7v10(getWinner7v10());
		regionBracket.setWinner8v9(getWinner8v9());
	}

	private static Integer getWinner1v16() {
		if (getRandomInteger() < 99){
			return 1;
		} else {
			return 16;
		}
	}
	
	private static Integer getWinner2v15() {
		if (getRandomInteger() < 94){ 
			return 2;
		} else {
			return 15;
		}
	}

	private static Integer getWinner3v14() {
		if (getRandomInteger() < 84){ 
			return 3;
		} else {
			return 14;
		}
	}

	private static Integer getWinner4v13() {
		if (getRandomInteger() < 80){ 
			return 4;
		} else {
			return 13;
		}
	}

	private static Integer getWinner5v12() {
		if (getRandomInteger() < 67){
			return 5;
		} else {
			return 12;
		}
	}

	private static Integer getWinner6v11() {
		if (getRandomInteger() < 65){ 
			return 6;
		} else {
			return 11;
		}
	}

	private static Integer getWinner7v10() {
		if (getRandomInteger() < 61){ 
			return 7;
		} else {
			return 10;
		}
	}
	
	private static Integer getWinner8v9() {
		if (getRandomInteger() < 53){
			return 8;
		} else {
			return 9;
		}
	}

	private static int getRandomInteger(){
		return new Random().nextInt(100);
	}
}
