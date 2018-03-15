package bracket.madness.domain;

public class Simulation {
	private String simulationCount;
	private boolean officialSimulation;
	private String note;
	
	public String getSimulationCount() {
		return simulationCount;
	}
	public void setSimulationCount(String simulationCount) {
		this.simulationCount = simulationCount;
	}
	public boolean isOfficialSimulation() {
		return officialSimulation;
	}
	public void setOfficialSimulation(boolean officialSimulation) {
		this.officialSimulation = officialSimulation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
