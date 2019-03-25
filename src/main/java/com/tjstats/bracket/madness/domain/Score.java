package com.tjstats.bracket.madness.domain;

public class Score {
	private Long scoreKey;
	private String winPercentage;
	private String top3Percentage;
	private String lastPercentage;
	private String position;
	private String points;
	private String moneyLine;
	private String odds;
	private String winChange;
	private String top3Change;
	private String lastChange;
	
	public Long getScoreKey() {
		return scoreKey;
	}
	public void setScoreKey(Long scoreKey) {
		this.scoreKey = scoreKey;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
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
}
