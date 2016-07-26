package com.mmle.entity;

import java.util.Date;

/**
 * 现场勘查表
 * @author MyPC
 *
 */
public class Exploration {
	
    private Integer explorationId;//勘察表ID

    private Date explorationStartTime;//勘查起始时间
    
    private Date explorationEndTime;//勘查结束时间

    private String explorationLocation;//勘查地点

    private String parties;//当事人

    private String situation;//现场勘查情况
    
    private String accountName;//执法人名2个；

    private String account;//执行证件号即执法人员工号 ，2个，以-拼接。

    private Integer lawEnforcementId;//执法表ID
    
    private Boolean state;//当事人是否确认

    private Boolean flag;//信息是否有效，即是否删除

    private String witnesses;//见证人

	public Integer getExplorationId() {
		return explorationId;
	}

	public void setExplorationId(Integer explorationId) {
		this.explorationId = explorationId;
	}

	public Date getExplorationStartTime() {
		return explorationStartTime;
	}

	public void setExplorationStartTime(Date explorationStartTime) {
		this.explorationStartTime = explorationStartTime;
	}

	public Date getExplorationEndTime() {
		return explorationEndTime;
	}

	public void setExplorationEndTime(Date explorationEndTime) {
		this.explorationEndTime = explorationEndTime;
	}

	public String getExplorationLocation() {
		return explorationLocation;
	}

	public void setExplorationLocation(String explorationLocation) {
		this.explorationLocation = explorationLocation;
	}

	public String getParties() {
		return parties;
	}

	public void setParties(String parties) {
		this.parties = parties;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getLawEnforcementId() {
		return lawEnforcementId;
	}

	public void setLawEnforcementId(Integer lawEnforcementId) {
		this.lawEnforcementId = lawEnforcementId;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
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
		this.witnesses = witnesses;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "Exploration [explorationId=" + explorationId + ", explorationStartTime=" + explorationStartTime
				+ ", explorationEndTime=" + explorationEndTime + ", explorationLocation=" + explorationLocation
				+ ", parties=" + parties + ", situation=" + situation + ", accountName=" + accountName + ", account="
				+ account + ", lawEnforcementId=" + lawEnforcementId + ", state=" + state + ", flag=" + flag
				+ ", witnesses=" + witnesses + "]";
	}

	


}