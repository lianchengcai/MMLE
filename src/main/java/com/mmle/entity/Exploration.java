package com.mmle.entity;

import java.util.Date;

public class Exploration {
    private Integer explorationId;

    private Date explorationTime;

    private String explorationLocation;

    private String parties;

    private String situation;

    private String account;

    private Integer state;

    private Integer caseId;

    private Integer lawEnforcementId;

    private Boolean flag;

    private String witnesses;

    public Integer getExplorationId() {
        return explorationId;
    }

    public void setExplorationId(Integer explorationId) {
        this.explorationId = explorationId;
    }

    public Date getExplorationTime() {
        return explorationTime;
    }

    public void setExplorationTime(Date explorationTime) {
        this.explorationTime = explorationTime;
    }

    public String getExplorationLocation() {
        return explorationLocation;
    }

    public void setExplorationLocation(String explorationLocation) {
        this.explorationLocation = explorationLocation == null ? null : explorationLocation.trim();
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties == null ? null : parties.trim();
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getLawEnforcementId() {
        return lawEnforcementId;
    }

    public void setLawEnforcementId(Integer lawEnforcementId) {
        this.lawEnforcementId = lawEnforcementId;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String witnesses) {
        this.witnesses = witnesses == null ? null : witnesses.trim();
    }
}