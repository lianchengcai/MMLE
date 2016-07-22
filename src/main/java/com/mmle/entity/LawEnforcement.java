package com.mmle.entity;

import java.util.Date;

public class LawEnforcement {
    private Integer id;

    private Integer caseId;

    private Date date;

    private Integer state;

    private String processMan;

    private String lawEnforcementMan;

    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.processMan = processMan == null ? null : processMan.trim();
    }

    public String getLawEnforcementMan() {
        return lawEnforcementMan;
    }

    public void setLawEnforcementMan(String lawEnforcementMan) {
        this.lawEnforcementMan = lawEnforcementMan == null ? null : lawEnforcementMan.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}