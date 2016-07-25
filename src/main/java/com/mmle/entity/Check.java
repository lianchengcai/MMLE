package com.mmle.entity;

import java.util.Date;

public class Check {
    private Integer checkId;

    private String type;

   // private Integer boat;
    private FishBoat boat;

    //private Integer checkMan;
    private User checkMan;

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

    private String content;
    
    private String location;
    
    private Boolean state;
    
    
    public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Integer getBoat() {
//        return boat;
//    }
//
//    public void setBoat(Integer boat) {
//        this.boat = boat;
//    }
    

    public FishBoat getBoat() {
		return boat;
	}

	public void setBoat(FishBoat boat) {
		this.boat = boat;
	}

	public User getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(User checkMan) {
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

	@Override
	public String toString() {
		return "Check [checkId=" + checkId + ", type=" + type + ", boat=" + boat + ", checkMan=" + checkMan
				+ ", checkTime=" + checkTime + ", title=" + title + ", boatImage=" + boatImage + ", manImage="
				+ manImage + ", nationality=" + nationality + ", boatCheck=" + boatCheck + ", fishing=" + fishing
				+ ", sailing=" + sailing + ", boater=" + boater + ", chiefEngineer=" + chiefEngineer
				+ ", satelliteNavigation=" + satelliteNavigation + ", radar=" + radar + ", ssb=" + ssb + ", compass="
				+ compass + ", flag=" + flag + ", content=" + content + ", location=" + location + ", state=" + state
				+ "]";
	}


}