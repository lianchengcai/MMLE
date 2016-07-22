package com.mmle.entity;

public class Role {
    private Integer roleId;

    private String name;

    private Integer permissionId;

    private Boolean flag;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", permissionId=" + permissionId + ", flag=" + flag + "]";
	}
    
}