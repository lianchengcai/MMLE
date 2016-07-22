package com.mmle.entity;

import java.util.Date;

public class Check {
    private Integer checkId;

    private Integer type;

    private Integer boat;

    private Integer checkMan;

    private Date checkTime;

    private String title;

    private String boatImage;

    private String manImage;

    private Boolean nationality;

    private Boolean boatCheck;

    private Boolean fishing;

    private Boolean sailing;

    private Boolean boater;

    private Boolean chiefEngineer;

    private Boolean satelliteNavigation;

    private Boolean radar;

    private Boolean ssb;

    private Boolean compass;

    private Boolean flag;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBoat() {
        return boat;
    }

    public void setBoat(Integer boat) {
        this.boat = boat;
    }

    public Integer getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(Integer checkMan) {
        this.checkMan = checkMan;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBoatImage() {
        return boatImage;
    }

    public void setBoatImage(String boatImage) {
        this.boatImage = boatImage == null ? null : boatImage.trim();
    }

    public String getManImage() {
        return manImage;
    }

    public void setManImage(String manImage) {
        this.manImage = manImage == null ? null : manImage.trim();
    }

    public Boolean getNationality() {
        return nationality;
    }

    public void setNationality(Boolean nationality) {
        this.nationality = nationality;
    }

    public Boolean getBoatCheck() {
        return boatCheck;
    }

    public void setBoatCheck(Boolean boatCheck) {
        this.boatCheck = boatCheck;
    }

    public Boolean getFishing() {
        return fishing;
    }

    public void setFishing(Boolean fishing) {
        this.fishing = fishing;
    }

    public Boolean getSailing() {
        return sailing;
    }

    public void setSailing(Boolean sailing) {
        this.sailing = sailing;
    }

    public Boolean getBoater() {
        return boater;
    }

    public void setBoater(Boolean boater) {
        this.boater = boater;
    }

    public Boolean getChiefEngineer() {
        return chiefEngineer;
    }

    public void setChiefEngineer(Boolean chiefEngineer) {
        this.chiefEngineer = chiefEngineer;
    }

    public Boolean getSatelliteNavigation() {
        return satelliteNavigation;
    }

    public void setSatelliteNavigation(Boolean satelliteNavigation) {
        this.satelliteNavigation = satelliteNavigation;
    }

    public Boolean getRadar() {
        return radar;
    }

    public void setRadar(Boolean radar) {
        this.radar = radar;
    }

    public Boolean getSsb() {
        return ssb;
    }

    public void setSsb(Boolean ssb) {
        this.ssb = ssb;
    }

    public Boolean getCompass() {
        return compass;
    }

    public void setCompass(Boolean compass) {
        this.compass = compass;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}