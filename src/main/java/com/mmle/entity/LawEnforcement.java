package com.mmle.entity;

import java.util.Date;

/**
 * 执法表
 * @author MyPC
 *
 */
public class LawEnforcement {
	
    private Integer id;//执法表ID
    
    private String caseName;//案件名

    private Integer caseId;//案由ID关联案由表

    private Date date;//执法程序创建时间

    private Integer state;//执法表状态，0:执法信息未完全，1：第一级审批，2：第二级审批3：第三级审批
    
    private Boolean pass;//审核是否通过
    
    private String reason;//审核是否通过的原因

    private String processMan;//审批人ID，关联用户表

    private String lawEnforcementMan;//执法人ID,关联用户表

    private Boolean flag;//信息是否有效，即是否删除 .true有效,flase删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getProcessMan() {
		return processMan;
	}

	public void setProcessMan(String processMan) {
		this.processMan = processMan;
	}

	public String getLawEnforcementMan() {
		return lawEnforcementMan;
	}

	public void setLawEnforcementMan(String lawEnforcementMan) {
		this.lawEnforcementMan = lawEnforcementMan;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LawEnforcement [id=" + id + ", caseName=" + caseName + ", caseId=" + caseId + ", date=" + date
				+ ", state=" + state + ", pass=" + pass + ", reason=" + reason + ", processMan=" + processMan
				+ ", lawEnforcementMan=" + lawEnforcementMan + ", flag=" + flag + "]";
	}

	

	

   
    
    
}