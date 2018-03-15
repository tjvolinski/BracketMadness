package bracket.madness.domain;

public class Player {
	private String playerName;
	private String winPercentage;
	private String top3Percentage;
	private String lastPercentage;
	private String avgFinish;
	private String avgPoints;
	private String moneyLine;
	private String odds;
	private int timesWon;
	private String winChange;
	private String top3Change;
	private String lastChange;
	private boolean winChangePositive;
	private boolean top3ChangePositive;
	private boolean lastChangePositive;
	
	private Long scoreKey;
	private Long bracketId;
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getWinPercentage() {
		return winPercentage;
	}
	
	public void setWinPercentage(String winPercentage) {
		this.winPercentage = winPercentage;
	}

	public String getTop3Percentage() {
		return top3Percentage;
	}

	public void setTop3Percentage(String top3Percentage) {
		this.top3Percentage = top3Percentage;
	}

	public String getLastPercentage() {
		return lastPercentage;
	}

	public void setLastPercentage(String lastPercentage) {
		this.lastPercentage = lastPercentage;
	}

	public String getAvgFinish() {
		return avgFinish;
	}

	public void setAvgFinish(String avgFinish) {
		this.avgFinish = avgFinish;
	}

	public int getTimesWon() {
		return timesWon;
	}

	public void setTimesWon(int timesWon) {
		this.timesWon = timesWon;
	}

	public String getAvgPoints() {
		return avgPoints;
	}

	public void setAvgPoints(String avgPoints) {
		this.avgPoints = avgPoints;
	}

	public String getMoneyLine() {
		return moneyLine;
	}

	public void setMoneyLine(String moneyLine) {
		this.moneyLine = moneyLine;
	}

	public String getOdds() {
		return odds;
	}

	public void setOdds(String odds) {
		this.odds = odds;
	}

	public Long getScoreKey() {
		return scoreKey;
	}

	public void setScoreKey(Long scoreKey) {
		this.scoreKey = scoreKey;
	}

	public Long getBracketId() {
		return bracketId;
	}

	public void setBracketId(Long bracketId) {
		this.bracketId = bracketId;
	}

	public String getWinChange() {
		return winChange;
	}

	public void setWinChange(String winChange) {
		this.winChange = winChange;
	}

	public String getTop3Change() {
		return top3Change;
	}

	public void setTop3Change(String top3Change) {
		this.top3Change = top3Change;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	public boolean isWinChangePositive() {
		return winChangePositive;
	}

	public void setWinChangePositive(boolean winChangePositive) {
		this.winChangePositive = winChangePositive;
	}

	public boolean isTop3ChangePositive() {
		return top3ChangePositive;
	}

	public void setTop3ChangePositive(boolean top3ChangePositive) {
		this.top3ChangePositive = top3ChangePositive;
	}

	public boolean isLastChangePositive() {
		return lastChangePositive;
	}

	public void setLastChangePositive(boolean lastChangePositive) {
		this.lastChangePositive = lastChangePositive;
	}
}
