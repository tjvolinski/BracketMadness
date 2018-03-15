package bracket.madness.generator;

import bracket.madness.vo.FullBracketVO;
import bracket.madness.vo.RegionBracketVO;

public class OverrideBracket {
	
	public static void addSecondRoundOverrides(RegionBracketVO region, RegionBracketVO override) {
		if (override != null){
			if (override.getWinner1v16() != null && override.getWinner1v16() != 0){
				region.setWinner1v16(override.getWinner1v16());
			}
			if (override.getWinner2v15() != null && override.getWinner2v15() != 0){
				region.setWinner2v15(override.getWinner2v15());
			}
			if (override.getWinner3v14() != null && override.getWinner3v14() != 0){
				region.setWinner3v14(override.getWinner3v14());
			}
			if (override.getWinner4v13() != null && override.getWinner4v13() != 0){
				region.setWinner4v13(override.getWinner4v13());
			}
			if (override.getWinner5v12() != null && override.getWinner5v12() != 0){
				region.setWinner5v12(override.getWinner5v12());
			}
			if (override.getWinner6v11() != null && override.getWinner6v11() != 0){
				region.setWinner6v11(override.getWinner6v11());
			}
			if (override.getWinner7v10() != null && override.getWinner7v10() != 0){
				region.setWinner7v10(override.getWinner7v10());
			}
			if (override.getWinner8v9() != null && override.getWinner8v9() != 0){
				region.setWinner8v9(override.getWinner8v9());
			}
		}
	}
	
	public static void addSweetOverrides(RegionBracketVO region, RegionBracketVO override) {
		if (override != null){
			if (override.getSweetTeam1() != null && override.getSweetTeam1() != 0){
				region.setSweetTeam1(override.getSweetTeam1());
			}
			if (override.getSweetTeam2() != null && override.getSweetTeam2() != 0){
				region.setSweetTeam2(override.getSweetTeam2());
			}
			if (override.getSweetTeam3() != null && override.getSweetTeam3() != 0){
				region.setSweetTeam3(override.getSweetTeam3());
			}
			if (override.getSweetTeam4() != null && override.getSweetTeam4() != 0){
				region.setSweetTeam4(override.getSweetTeam4());
			}
		}
	}
	
	public static void addEliteOverrides(RegionBracketVO region, RegionBracketVO override) {
		if (override != null){
			if (override.getEliteTeam1() != null && override.getEliteTeam1() != 0){
				region.setEliteTeam1(override.getEliteTeam1());
			}
			if (override.getEliteTeam2() != null && override.getEliteTeam2() != 0){
				region.setEliteTeam2(override.getEliteTeam2());
			}
		}
	}
	
	public static void addFinalFourOverride(RegionBracketVO region, RegionBracketVO override) {
		if (override != null){
			if (override.getRegionChampion() != null && override.getRegionChampion() != 0){
				region.setRegionChampion(override.getRegionChampion());
			}
		}
	}
	
	public static void addChampionOverride(FullBracketVO bracket, FullBracketVO overrideBracket) {
		if (overrideBracket != null){
			if (overrideBracket.getLeftFinalist() != null && !overrideBracket.getLeftFinalist().isEmpty() &&
					!overrideBracket.getLeftFinalist().equals("null")){
				bracket.setLeftFinalist(overrideBracket.getLeftFinalist());
			}
			if (overrideBracket.getRightFinalist() != null && !overrideBracket.getRightFinalist().isEmpty() &&
					!overrideBracket.getRightFinalist().equals("null")){
				bracket.setRightFinalist(overrideBracket.getRightFinalist());
			}
			if (overrideBracket.getChampion() != null && !overrideBracket.getChampion().isEmpty() &&
					!overrideBracket.getChampion().equals("null")){
				bracket.setChampion(overrideBracket.getChampion());
			}
		}
	}
}
