package com.mmle.entity;

import java.util.Date;

public class Record {
    private Integer id;

    private String location;

    private Date date;

    private String ask;

    private String recorder;

    private String departmentName;

    private String account;

    private String violateRule;

    private String content;

    private String asked;

    private Boolean feedbackOne;

    private String feedbackTwo;

    private Integer caseId;

    private Integer lawEnforcementId;

    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getViolateRule() {
        return violateRule;
    }

    public void setViolateRule(String violateRule) {
        this.violateRule = violateRule == null ? null : violateRule.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAsked() {
        return asked;
    }

    public void setAsked(String asked) {
        this.asked = asked == null ? null : asked.trim();
    }

    public Boolean getFeedbackOne() {
        return feedbackOne;
    }

    public void setFeedbackOne(Boolean feedbackOne) {
        this.feedbackOne = feedbackOne;
    }

    public String getFeedbackTwo() {
        return feedbackTwo;
    }

    public void setFeedbackTwo(String feedbackTwo) {
        this.feedbackTwo = feedbackTwo == null ? null : feedbackTwo.trim();
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