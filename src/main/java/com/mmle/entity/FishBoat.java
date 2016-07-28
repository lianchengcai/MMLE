package com.mmle.entity;

import java.util.Date;

/**
 * 渔船信息表
 * @author MyPC
 *
 */
public class FishBoat {
    private String boatId;//渔船编号

    private String boatName;//渔船名称

    private String boatLlocation;//渔船所属地

    private String homePort;//船港籍

    private Float length;//船长度

    private Float width;//船宽

    private Float totalWeight;//总吨位

    private String fishPermitNo;//捕捞许可证编号

    private Date fishPermitTime;//捕捞许可到期时间

    private String substitutingNo;//船检证书编号

    private Date substitutingTime;//船检证书到期时间

    private Date createTime;//渔船信息更新时间

    private Boolean state;//是否黑名单
    
    private Boolean ifNoPermit;//是否无证捕捞

    private Boolean flag;//信息是否有效，即是否删除

    public String getBoatId() {
        return boatId;
    }

    public void setBoatId(String boatId) {
        this.boatId = boatId;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName == null ? null : boatName.trim();
    }

    public String getBoatLlocation() {
        return boatLlocation;
    }

    public void setBoatLlocation(String boatLlocation) {
        this.boatLlocation = boatLlocation == null ? null : boatLlocation.trim();
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort == null ? null : homePort.trim();
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getFishPermitNo() {
        return fishPermitNo;
    }

    public void setFishPermitNo(String fishPermitNo) {
        this.fishPermitNo = fishPermitNo == null ? null : fishPermitNo.trim();
    }

    public Date getFishPermitTime() {
        return fishPermitTime;
    }

    public void setFishPermitTime(Date fishPermitTime) {
        this.fishPermitTime = fishPermitTime;
    }

    public String getSubstitutingNo() {
        return substitutingNo;
    }

    public void setSubstitutingNo(String substitutingNo) {
        this.substitutingNo = substitutingNo == null ? null : substitutingNo.trim();
    }

    public Date getSubstitutingTime() {
        return substitutingTime;
    }

    public void setSubstitutingTime(Date substitutingTime) {
        this.substitutingTime = substitutingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

	public Boolean getIfNoPermit() {
		return ifNoPermit;
	}

	public void setIfNoPermit(Boolean ifNoPermit) {
		this.ifNoPermit = ifNoPermit;
	}

	@Override
	public String toString() {
		return "FishBoat [boatId=" + boatId + ", boatName=" + boatName + ", boatLlocation=" + boatLlocation
				+ ", homePort=" + homePort + ", length=" + length + ", width=" + width + ", totalWeight=" + totalWeight
				+ ", fishPermitNo=" + fishPermitNo + ", fishPermitTime=" + fishPermitTime + ", substitutingNo="
				+ substitutingNo + ", substitutingTime=" + substitutingTime + ", createTime=" + createTime + ", state="
				+ state + ", ifNoPermit=" + ifNoPermit + ", flag=" + flag + "]";
	}

}