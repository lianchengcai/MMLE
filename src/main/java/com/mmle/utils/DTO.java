package com.mmle.utils;

import java.util.Date;
import java.util.Map;


import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.entity.Check;
import com.mmle.entity.Exploration;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnMessage;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.Record;
import com.mmle.entity.Role;
import com.mmle.entity.User;


/**   
 * @Title: DTO.java 
 * @Package com.mmle.utils 
 * @Description: TODO(数据传输对象) 
 * @author lbb
 * @date 2016年7月22日 下午9:23:50 
 * @version V1.0   
 */
public class DTO {
	//字段没有全 看之后传输的参数还需要什么，开发的时候在添进去，然后记得把ToString方法重写
	private Integer currentPage = 1;
	private Integer size = 14;
	private Map<String, Object> map;
	private Case cas;
	private CaseType caseType;
	private Check check;
	private Exploration exploration;
	private FishBoat fishBoat;
	private LawEnforcement lawEnforcement;
	private PenaltyDecision penaltyDecision;
	private Record record;
	private User user;
	private Role role;
	private LawEnMessage lawEnMessage;
	private String validateCode;
	private Date lawStartTime;
	private Date lawEndTime;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LawEnMessage getLawEnMessage() {
		return lawEnMessage;
	}
	public void setLawEnMessage(LawEnMessage lawEnMessage) {
		this.lawEnMessage = lawEnMessage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Case getCas() {
		return cas;
	}
	public void setCas(Case cas) {
		this.cas = cas;
	}
	public CaseType getCaseType() {
		return caseType;
	}
	public void setCaseType(CaseType caseType) {
		this.caseType = caseType;
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
	public Exploration getExploration() {
		return exploration;
	}
	public void setExploration(Exploration exploration) {
		this.exploration = exploration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public FishBoat getFishBoat() {
		return fishBoat;
	}
	public void setFishBoat(FishBoat fishBoat) {
		this.fishBoat = fishBoat;
	}
	public LawEnforcement getLawEnforcement() {
		return lawEnforcement;
	}
	public void setLawEnforcement(LawEnforcement lawEnforcement) {
		this.lawEnforcement = lawEnforcement;
	}
	public PenaltyDecision getPenaltyDecision() {
		return penaltyDecision;
	}
	public void setPenaltyDecision(PenaltyDecision penaltyDecision) {
		this.penaltyDecision = penaltyDecision;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	public Date getLawStartTime() {
		return lawStartTime;
	}
	public void setLawStartTime(Date lawStartTime) {
		this.lawStartTime = lawStartTime;
	}
	public Date getLawEndTime() {
		return lawEndTime;
	}
	public void setLawEndTime(Date lawEndTime) {
		this.lawEndTime = lawEndTime;
	}
	@Override
	public String toString() {
		return "DTO [currentPage=" + currentPage + ", size=" + size + ", map=" + map + ", cas=" + cas + ", caseType="
				+ caseType + ", check=" + check + ", exploration=" + exploration + ", fishBoat=" + fishBoat
				+ ", lawEnforcement=" + lawEnforcement + ", penaltyDecision=" + penaltyDecision + ", record=" + record
				+ ", user=" + user + ", role=" + role + ", lawEnMessage=" + lawEnMessage + ", validateCode="
				+ validateCode + ", lawStartTime=" + lawStartTime + ", lawEndTime=" + lawEndTime + "]";
	}
	
	

}
