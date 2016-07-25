package com.mmle.entity;

public class LawEnforcementExtend extends LawEnforcement{
	
	private Exploration exploration;
	
	private PenaltyDecision penaltyDecision;
	
	private Record record;

	public Exploration getExploration() {
		return exploration;
	}

	public void setExploration(Exploration exploration) {
		this.exploration = exploration;
	}

	public PenaltyDecision getPenaltyDecision() {
		return penaltyDecision;
	}

	public void setPenaltyDecision(PenaltyDecision penaltyDecision) {
		this.penaltyDecision = penaltyDecision;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "LawEnforcementExtend [exploration=" + exploration + ", penaltyDecision=" + penaltyDecision + ", record="
				+ record + "]";
	}
	
	

}
