package bracket.madness.domain;

public class Bracket {
	private Region region1;
	private Region region2;
	private Region region3;
	private Region region4;
	
	private String winner;
	private String loser;
	
	private Long bracketId;
	private String name;
	
	private Long previousScoreKey;
	private Score previousScore;
	
	public Region getRegion1() {
		return region1;
	}
	
	public void setRegion1(Region region1) {
		this.region1 = region1;
	}
	
	public Region getRegion2() {
		return region2;
	}
	
	public void setRegion2(Region region2) {
		this.region2 = region2;
	}
	
	public Region getRegion3() {
		return region3;
	}
	
	public void setRegion3(Region region3) {
		this.region3 = region3;
	}
	
	public Region getRegion4() {
		return region4;
	}
	
	public void setRegion4(Region region4) {
		this.region4 = region4;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public String getLoser() {
		return loser;
	}
	
	public void setLoser(String loser) {
		this.loser = loser;
	}

	public Long getBracketId() {
		return bracketId;
	}

	public void setBracketId(Long bracketId) {
		this.bracketId = bracketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getPreviousScore() {
		return previousScore;
	}

	public void setPreviousScore(Score previousScore) {
		this.previousScore = previousScore;
	}

	public Long getPreviousScoreKey() {
		return previousScoreKey;
	}

	public void setPreviousScoreKey(Long previousScoreKey) {
		this.previousScoreKey = previousScoreKey;
	}
}
