package com.mmle.entity;

import java.util.Date;

public class PenaltyDecision {
    private Integer id;

    private String partiesInformation;

    private String caseName;

    private String violateContent;

    private String evidence;

    private String violateRule;

    private String basis;

    private String location;

    private Date date;

    private Integer caseId;

    private Integer lawEnforcementId;

    private Boolean flag;

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
        this.partiesInformation = partiesInformation == null ? null : partiesInformation.trim();
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    public String getViolateContent() {
        return violateContent;
    }

    public void setViolateContent(String violateContent) {
        this.violateContent = violateContent == null ? null : violateContent.trim();
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence == null ? null : evidence.trim();
    }

    public String getViolateRule() {
        return violateRule;
    }

    public void setViolateRule(String violateRule) {
        this.violateRule = violateRule == null ? null : violateRule.trim();
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis == null ? null : basis.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}