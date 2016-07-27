package com.mmle.entity;

public class User {
	private String account;

	private String name;

	private String password;

	private Role role;

	private String salt;

	private String remark;

	private Boolean flag;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", name=" + name + ", password=" + password + ", role=" + role + ", salt=" + salt + ", remark=" + remark + ", flag=" + flag + "]";
	}

}