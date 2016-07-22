package com.mmle.entity;

import java.util.Date;

public class FishBoat {
    private Integer boatId;

    private String boatName;

    private String boatLlocation;

    private String homePort;

    private Float length;

    private Float width;

    private Float totalWeight;

    private String fishPermitNo;

    private Date fishPermitTime;

    private String substitutingNo;

    private Date substitutingTime;

    private Date createTime;

    private Boolean state;

    private Boolean flag;

    public Integer getBoatId() {
        return boatId;
    }

    public void setBoatId(Integer boatId) {
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
}