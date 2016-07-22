package com.mmle.entity;

public class Case {
    private Integer caseId;

    private Integer caseType;

    private String caseName;

    private String violateRule;

    private String basisPunishment;

    private String typePunishment;

    private Integer state;

    private Boolean flag;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    public String getViolateRule() {
        return violateRule;
    }

    public void setViolateRule(String violateRule) {
        this.violateRule = violateRule == null ? null : violateRule.trim();
    }

    public String getBasisPunishment() {
        return basisPunishment;
    }

    public void setBasisPunishment(String basisPunishment) {
        this.basisPunishment = basisPunishment == null ? null : basisPunishment.trim();
    }

    public String getTypePunishment() {
        return typePunishment;
    }

    public void setTypePunishment(String typePunishment) {
        this.typePunishment = typePunishment == null ? null : typePunishment.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}