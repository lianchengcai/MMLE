package com.mmle.entity;

import java.util.Date;

/**
 *处罚表
 * @author MyPC
 *
 */
public class PenaltyDecision {
	
    private Integer id;//处罚决定ID

    private String partiesInformation;//当事人信息

    private String violateContent;//违反内容

    private String evidence;//证据

    private String violateRule;//违反条款

    private String basis;;//违反条款依据

    private String location;//缴纳罚款位置

    private Date date;//处罚时间
    
    private Integer lawEnforcementId;//执法表ID

    private Boolean flag;//信息是否有效，即是否删除 .true有效,flase删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPartiesInformation() {
		return partiesInformation;
	}

	public void setPartiesInformation(String partiesInformation) {
		this.partiesInformation = partiesInformation;
	}

	public String getViolateContent() {
		return violateContent;
	}

	public void setViolateContent(String violateContent) {
		this.violateContent = violateContent;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getViolateRule() {
		return violateRule;
	}

	public void setViolateRule(String violateRule) {
		this.violateRule = violateRule;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "PenaltyDecision [id=" + id + ", partiesInformation=" + partiesInformation + ", violateContent="
				+ violateContent + ", evidence=" + evidence + ", violateRule=" + violateRule + ", basis=" + basis
				+ ", location=" + location + ", date=" + date + ", lawEnforcementId=" + lawEnforcementId + ", flag="
				+ flag + "]";
	}


   
}