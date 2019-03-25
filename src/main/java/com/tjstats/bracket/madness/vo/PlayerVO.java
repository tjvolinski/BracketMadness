package com.tjstats.bracket.madness.vo;

public class PlayerVO {
	
	private String playerName;
	private int timesWon;
	private int timesTopThree;
	private int points;
	private int timesLast;
	private int totalPositionsFinished;
	private long totalPoints;
	
	public PlayerVO(String playerName){
		this.playerName = playerName;
		this.timesWon = 0;
		this.timesTopThree = 0;
		this.timesLast = 0;
		this.totalPositionsFinished = 0;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getTimesWon() {
		return timesWon;
	}
	
	public void setTimesWon(int timesWon) {
		this.timesWon = timesWon;
	}
	
	public int getTimesTopThree() {
		return timesTopThree;
	}
	
	public void setTimesTopThree(int timesTopThree) {
		this.timesTopThree = timesTopThree;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getTimesLast() {
		return timesLast;
	}

	public void setTimesLast(int timesLast) {
		this.timesLast = timesLast;
	}
	
	public int getTotalPositionsFinished() {
		return totalPositionsFinished;
	}

	public void setTotalPositionsFinished(int totalPositionsFinished) {
		this.totalPositionsFinished = totalPositionsFinished;
	}

	public long getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}
}
