package bracket.madness.generator;

import java.util.Random;

import bracket.madness.vo.FullBracketVO;

public class Championship {

	public static void populateChampion(FullBracketVO fullBracketVO){
		fullBracketVO.setLeftFinalist(getLeftFinalist(fullBracketVO));
		fullBracketVO.setRightFinalist(getRightFinalist(fullBracketVO));
		fullBracketVO.setChampion(getChamp(fullBracketVO));
	}

	private static String getLeftFinalist(FullBracketVO fullBracketVO) {
		String leftChampion = null;
		if (getRandomInteger() < 50){
			leftChampion = fullBracketVO.getTopLeftRegion().getRegionChampion().toString();
			return leftChampion.concat("A");
		} else {
			leftChampion = fullBracketVO.getBottomLeftRegion().getRegionChampion().toString();
			return leftChampion.concat("B");
		}
	}

	private static String getRightFinalist(FullBracketVO fullBracketVO) {
		String rightChampion = null;
		if (getRandomInteger() < 50){
			rightChampion = fullBracketVO.getTopRightRegion().getRegionChampion().toString();
			return rightChampion.concat("C");
		} else {
			rightChampion = fullBracketVO.getBottomRightRegion().getRegionChampion().toString();
			return rightChampion.concat("D");
		}
	}

	private static String getChamp(FullBracketVO fullBracketVO) {
		if (getRandomInteger() < 50){
			return fullBracketVO.getLeftFinalist();
		} else {
			return fullBracketVO.getRightFinalist();
		}
	}
	
	private static int getRandomInteger(){
		return new Random().nextInt(100);
	}
}
