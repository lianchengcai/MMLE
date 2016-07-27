package com.mmle.entity;

public class LawEnMessage extends LawEnforcement{

	private String casName ;
	
	private Boolean record;
	
	private Boolean penaltyDecision;
	
	private Boolean exploration;

	public String getCasName() {
		return casName;
	}

	public void setCasName(String casName) {
		this.casName = casName;
	}

	public Boolean getRecord() {
		return record;
	}

	public void setRecord(Boolean record) {
		this.record = record;
	}

	public Boolean getPenaltyDecision() {
		return penaltyDecision;
	}

	public void setPenaltyDecision(Boolean penaltyDecision) {
		this.penaltyDecision = penaltyDecision;
	}

	public Boolean getExploration() {
		return exploration;
	}

	public void setExploration(Boolean exploration) {
		this.exploration = exploration;
	}

	@Override
	public String toString() {
		return "LawEnMessage [casName=" + casName + ", record=" + record + ", penaltyDecision=" + penaltyDecision
				+ ", exploration=" + exploration + "]";
	}

	
	
	
}
