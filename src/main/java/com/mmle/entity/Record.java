package com.mmle.entity;

import java.util.Date;

/**
 * 笔录表
 * @author MyPC
 *
 */
public class Record {
	
    private Integer id;//笔录表ID

    private String location;//笔录询问地点

    private Date startDate;//笔录询问开始时间
    
    private Date endDate;//笔录询问结束时间

    private String ask;//询问人即执法名字 ，2个，以-拼接。

    private String recorder;//记录人即执法人员工号

    private String departmentName;//单位名称

    private String account;//执行证件号即执法人员工号 ，2个，以-拼接。

    private String violateRule;//违反条款

    private String content;//违反内容

    private String asked;//被询问人名称

    private Boolean feedbackOne;//反馈1.是否听清，默认1

    private String feedbackTwo;//反馈2：用户信息

    private Integer lawEnforcementId;//执法表ID
    
    private Boolean flag;//信息是否有效，即是否删除

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
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getViolateRule() {
		return violateRule;
	}

	public void setViolateRule(String violateRule) {
		this.violateRule = violateRule;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAsked() {
		return asked;
	}

	public void setAsked(String asked) {
		this.asked = asked;
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
		this.feedbackTwo = feedbackTwo;
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
		return "Record [id=" + id + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", ask=" + ask + ", recorder=" + recorder + ", departmentName=" + departmentName + ", account="
				+ account + ", violateRule=" + violateRule + ", content=" + content + ", asked=" + asked
				+ ", feedbackOne=" + feedbackOne + ", feedbackTwo=" + feedbackTwo + ", lawEnforcementId="
				+ lawEnforcementId + ", flag=" + flag + "]";
	}


   
}