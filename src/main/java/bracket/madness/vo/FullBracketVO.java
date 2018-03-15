package bracket.madness.vo;

public class FullBracketVO {
	
	//  topLeft	(A)												topRight (C)
	//				leftFinalist    champion	rightFinalist
	//  bottomLeft (B)											bottomRight (D)

	private String bracketName;
	
	private RegionBracketVO topLeftRegion;
	private RegionBracketVO bottomLeftRegion;
	private RegionBracketVO topRightRegion;
	private RegionBracketVO bottomRightRegion;
	
	private String leftFinalist;
	private String rightFinalist;
	private String champion;
	
	public String getBracketName() {
		return bracketName;
	}
	
	public void setBracketName(String bracketName) {
		this.bracketName = bracketName;
	}
	
	public RegionBracketVO getTopLeftRegion() {
		return topLeftRegion;
	}
	
	public void setTopLeftRegion(RegionBracketVO topLeftRegion) {
		this.topLeftRegion = topLeftRegion;
	}
	
	public RegionBracketVO getBottomLeftRegion() {
		return bottomLeftRegion;
	}
	
	public void setBottomLeftRegion(RegionBracketVO bottomLeftRegion) {
		this.bottomLeftRegion = bottomLeftRegion;
	}
	
	public RegionBracketVO getTopRightRegion() {
		return topRightRegion;
	}
	
	public void setTopRightRegion(RegionBracketVO topRightRegion) {
		this.topRightRegion = topRightRegion;
	}

	public RegionBracketVO getBottomRightRegion() {
		return bottomRightRegion;
	}

	public void setBottomRightRegion(RegionBracketVO bottomRightRegion) {
		this.bottomRightRegion = bottomRightRegion;
	}

	public String getLeftFinalist() {
		return leftFinalist;
	}

	public void setLeftFinalist(String leftFinalist) {
		this.leftFinalist = leftFinalist;
	}

	public String getRightFinalist() {
		return rightFinalist;
	}

	public void setRightFinalist(String rightFinalist) {
		this.rightFinalist = rightFinalist;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}
	
	@Override
	public String toString(){
		return topLeftRegion.toString()+bottomLeftRegion.toString()+topRightRegion.toString()
				+bottomRightRegion.toString()+leftFinalist+rightFinalist+champion;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof FullBracketVO){
			if (this.toString().equals(o.toString())){ 
				return true;
			}
		}
		return false;
	}
	
	public void printBracket(){
		System.out.println("LEFT BRACKET");
		System.out.println();
		System.out.println(topLeftRegion.getWinner1v16());
		System.out.println("     "+topLeftRegion.getSweetTeam1());
		System.out.println(topLeftRegion.getWinner8v9());
		System.out.println("          "+topLeftRegion.getEliteTeam1());
		System.out.println(topLeftRegion.getWinner5v12());
		System.out.println("     "+topLeftRegion.getSweetTeam4());
		System.out.println(topLeftRegion.getWinner4v13());
		System.out.println("               "+topLeftRegion.getRegionChampion());
		System.out.println(topLeftRegion.getWinner6v11());
		System.out.println("     "+topLeftRegion.getSweetTeam3());
		System.out.println(topLeftRegion.getWinner3v14());
		System.out.println("          "+topLeftRegion.getEliteTeam2());
		System.out.println(topLeftRegion.getWinner7v10());
		System.out.println("     "+topLeftRegion.getSweetTeam2());
		System.out.println(topLeftRegion.getWinner2v15());
		System.out.println();
		System.out.println("                    "+leftFinalist+"     "+champion);
		System.out.println();
		System.out.println(bottomLeftRegion.getWinner1v16());
		System.out.println("     "+bottomLeftRegion.getSweetTeam1());
		System.out.println(bottomLeftRegion.getWinner8v9());
		System.out.println("          "+bottomLeftRegion.getEliteTeam1());
		System.out.println(bottomLeftRegion.getWinner5v12());
		System.out.println("     "+bottomLeftRegion.getSweetTeam4());
		System.out.println(bottomLeftRegion.getWinner4v13());
		System.out.println("               "+bottomLeftRegion.getRegionChampion());
		System.out.println(bottomLeftRegion.getWinner6v11());
		System.out.println("     "+bottomLeftRegion.getSweetTeam3());
		System.out.println(bottomLeftRegion.getWinner3v14());
		System.out.println("          "+bottomLeftRegion.getEliteTeam2());
		System.out.println(bottomLeftRegion.getWinner7v10());
		System.out.println("     "+bottomLeftRegion.getSweetTeam2());
		System.out.println(bottomLeftRegion.getWinner2v15());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("RIGHT BRACKET");
		System.out.println();
		System.out.println(topRightRegion.getWinner1v16());
		System.out.println("     "+topRightRegion.getSweetTeam1());
		System.out.println(topRightRegion.getWinner8v9());
		System.out.println("          "+topRightRegion.getEliteTeam1());
		System.out.println(topRightRegion.getWinner5v12());
		System.out.println("     "+topRightRegion.getSweetTeam4());
		System.out.println(topRightRegion.getWinner4v13());
		System.out.println("               "+topRightRegion.getRegionChampion());
		System.out.println(topRightRegion.getWinner6v11());
		System.out.println("     "+topRightRegion.getSweetTeam3());
		System.out.println(topRightRegion.getWinner3v14());
		System.out.println("          "+topRightRegion.getEliteTeam2());
		System.out.println(topRightRegion.getWinner7v10());
		System.out.println("     "+topRightRegion.getSweetTeam2());
		System.out.println(topRightRegion.getWinner2v15());
		System.out.println();
		System.out.println("                    "+rightFinalist+"     "+champion);
		System.out.println();
		System.out.println(bottomRightRegion.getWinner1v16());
		System.out.println("     "+bottomRightRegion.getSweetTeam1());
		System.out.println(bottomRightRegion.getWinner8v9());
		System.out.println("          "+bottomRightRegion.getEliteTeam1());
		System.out.println(bottomRightRegion.getWinner5v12());
		System.out.println("     "+bottomRightRegion.getSweetTeam4());
		System.out.println(bottomRightRegion.getWinner4v13());
		System.out.println("               "+bottomRightRegion.getRegionChampion());
		System.out.println(bottomRightRegion.getWinner6v11());
		System.out.println("     "+bottomRightRegion.getSweetTeam3());
		System.out.println(bottomRightRegion.getWinner3v14());
		System.out.println("          "+bottomRightRegion.getEliteTeam2());
		System.out.println(bottomRightRegion.getWinner7v10());
		System.out.println("     "+bottomRightRegion.getSweetTeam2());
		System.out.println(bottomRightRegion.getWinner2v15());
		
	}
}
