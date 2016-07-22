package com.mmle.entity;

import java.util.Date;

public class Customer {//客户表
	    private String telephone;//客户id(即客户手机号码)

	    private String password;//密码
	    
	    private String sex;//性别

	    private String salt;//盐

	    private String eMail;//e-mail

	    private Date birthday;//生日

	    private String QQ;//QQ

	    private Long defaultAddressId;//默认送货地址id

	    private String imageUrl;//头像（url）

	    private Integer level;//等级

	    private Short locked;//锁定（0：不锁定；1：锁定）
	    
	    private Date lockedTime;//锁定时间

	    private String remark;//备注


   
    public Date getLockedTime() {
			return lockedTime;
		}

		public void setLockedTime(Date lockedTime) {
			this.lockedTime = lockedTime;
		}

	public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ == null ? null : QQ.trim();
    }

    public Long getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Long defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer i) {
        this.level = i;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	@Override
	public String toString() {
		return "Customer [telephone=" + telephone + ", password=" + password + ", sex=" + sex + ", salt=" + salt
				+ ", eMail=" + eMail + ", birthday=" + birthday + ", QQ=" + QQ + ", defaultAddressId="
				+ defaultAddressId + ", imageUrl=" + imageUrl + ", level=" + level + ", locked=" + locked
				+ ", lockedTime=" + lockedTime + ", remark=" + remark + "]";
	}
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String telephone, String password, String sex, String salt, String eMail, Date birthday, String QQ,
			Long defaultAddressId, String imageUrl, Integer level, Short locked, Date lockedTime, String remark) {
		super();
		this.telephone = telephone;
		this.password = password;
		this.sex = sex;
		this.salt = salt;
		this.eMail = eMail;
		this.birthday = birthday;
		this.QQ = QQ;
		this.defaultAddressId = defaultAddressId;
		this.imageUrl = imageUrl;
		this.level = level;
		this.locked = locked;
		this.lockedTime = lockedTime;
		this.remark = remark;
	}


    
}