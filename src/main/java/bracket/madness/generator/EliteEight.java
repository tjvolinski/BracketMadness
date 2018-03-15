package bracket.madness.generator;

import java.util.Random;

import bracket.madness.vo.RegionBracketVO;

public class EliteEight {
	
	public static void populateEliteEight(RegionBracketVO regionBracketVO){
		regionBracketVO.setEliteTeam1(getEliteTeam1(regionBracketVO));
		regionBracketVO.setEliteTeam2(getEliteTeam2(regionBracketVO));
	}

	private static Integer getEliteTeam1(RegionBracketVO regionBracketVO) {
		if (getRandomInteger() < 50){
			return regionBracketVO.getSweetTeam1();
		} else {
			return regionBracketVO.getSweetTeam2();
		}
	}

	private static Integer getEliteTeam2(RegionBracketVO regionBracketVO) {
		if (getRandomInteger() < 50){
			return regionBracketVO.getSweetTeam3();
		} else {
			return regionBracketVO.getSweetTeam4();
		}
	}
	
	private static int getRandomInteger(){
		return new Random().nextInt(100);
	}
}
