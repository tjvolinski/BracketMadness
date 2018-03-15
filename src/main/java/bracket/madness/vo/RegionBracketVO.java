package bracket.madness.vo;

public class RegionBracketVO {
	
	//  1v16
	//			sweetTeam1
	//  8v9
	//							eliteTeam1
	//  5v12
	//			sweetTeam2
	//  4v13
	//										regionChamp
	//  6v11
	//			sweetTeam3
	//  3v14
	//							eliteTeam2
	//  7v10
	//			sweetTeam4
	//  2v15
	
	private String regionName;
	
	private Integer winner1v16;
	private Integer winner2v15;
	private Integer winner3v14;
	private Integer winner4v13;
	private Integer winner5v12;
	private Integer winner6v11;
	private Integer winner7v10;
	private Integer winner8v9;

	private Integer sweetTeam1;
	private Integer sweetTeam2;
	private Integer sweetTeam3;
	private Integer sweetTeam4;
	
	private Integer eliteTeam1;
	private Integer eliteTeam2;
	
	private Integer regionChampion;
	
	
	public RegionBracketVO (){
		
	}
	
	public RegionBracketVO (String regionName, Integer winner1v16, Integer winner8v9, Integer winner5v12,
			Integer winner4v13, Integer winner6v11, Integer winner3v14, Integer winner7v10, Integer winner2v15,
			Integer sweetTeam1, Integer sweetTeam2, Integer sweetTeam3, Integer sweetTeam4, 
			Integer eliteTeam1, Integer eliteTeam2, Integer regionChampion){
		this.regionName = regionName;
		this.winner1v16 = winner1v16;
		this.winner2v15 = winner2v15;
		this.winner3v14 = winner3v14;
		this.winner4v13 = winner4v13;
		this.winner5v12 = winner5v12;
		this.winner6v11 = winner6v11;
		this.winner7v10 = winner7v10;
		this.winner8v9 = winner8v9;
		this.sweetTeam1 = sweetTeam1;
		this.sweetTeam2 = sweetTeam2;
		this.sweetTeam3 = sweetTeam3;
		this.sweetTeam4 = sweetTeam4;
		this.eliteTeam1 = eliteTeam1;
		this.eliteTeam2 = eliteTeam2;
		this.regionChampion = regionChampion;
	}
	
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getWinner1v16() {
		return winner1v16;
	}

	public void setWinner1v16(Integer winner1v16) {
		this.winner1v16 = winner1v16;
	}

	public Integer getWinner2v15() {
		return winner2v15;
	}

	public void setWinner2v15(Integer winner2v15) {
		this.winner2v15 = winner2v15;
	}

	public Integer getWinner3v14() {
		return winner3v14;
	}

	public void setWinner3v14(Integer winner3v14) {
		this.winner3v14 = winner3v14;
	}

	public Integer getWinner4v13() {
		return winner4v13;
	}

	public void setWinner4v13(Integer winner4v13) {
		this.winner4v13 = winner4v13;
	}

	public Integer getWinner5v12() {
		return winner5v12;
	}

	public void setWinner5v12(Integer winner5v12) {
		this.winner5v12 = winner5v12;
	}

	public Integer getWinner6v11() {
		return winner6v11;
	}

	public void setWinner6v11(Integer winner6v11) {
		this.winner6v11 = winner6v11;
	}

	public Integer getWinner7v10() {
		return winner7v10;
	}

	public void setWinner7v10(Integer winner7v10) {
		this.winner7v10 = winner7v10;
	}

	public Integer getWinner8v9() {
		return winner8v9;
	}

	public void setWinner8v9(Integer winner8v9) {
		this.winner8v9 = winner8v9;
	}

	public Integer getSweetTeam1() {
		return sweetTeam1;
	}

	public void setSweetTeam1(Integer sweetTeam1) {
		this.sweetTeam1 = sweetTeam1;
	}

	public Integer getSweetTeam2() {
		return sweetTeam2;
	}

	public void setSweetTeam2(Integer sweetTeam2) {
		this.sweetTeam2 = sweetTeam2;
	}

	public Integer getSweetTeam3() {
		return sweetTeam3;
	}

	public void setSweetTeam3(Integer sweetTeam3) {
		this.sweetTeam3 = sweetTeam3;
	}

	public Integer getSweetTeam4() {
		return sweetTeam4;
	}

	public void setSweetTeam4(Integer sweetTeam4) {
		this.sweetTeam4 = sweetTeam4;
	}

	public Integer getEliteTeam1() {
		return eliteTeam1;
	}

	public void setEliteTeam1(Integer eliteTeam1) {
		this.eliteTeam1 = eliteTeam1;
	}

	public Integer getEliteTeam2() {
		return eliteTeam2;
	}

	public void setEliteTeam2(Integer eliteTeam2) {
		this.eliteTeam2 = eliteTeam2;
	}

	public Integer getRegionChampion() {
		return regionChampion;
	}

	public void setRegionChampion(Integer regionChampion) {
		this.regionChampion = regionChampion;
	}
	
	@Override
	public String toString(){
		return winner1v16.toString()+winner2v15.toString()+winner3v14.toString()+winner4v13.toString()+winner5v12.toString()+
				winner6v11.toString()+winner7v10.toString()+winner8v9.toString()+sweetTeam1.toString()+sweetTeam2.toString()+
				sweetTeam3.toString()+sweetTeam4.toString()+eliteTeam1.toString()+eliteTeam2.toString()+regionChampion.toString();
		
	}
}
