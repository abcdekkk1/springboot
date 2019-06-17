package com.example.demo2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="role",
		uniqueConstraints ={
				@UniqueConstraint(name="role_uk", columnNames = "role_name")})
public class AppRole {

	@Id
	@GeneratedValue
	@Column(name="role_id", nullable = false)
	private long roleId;
	@Column(name="role_name", length = 30, nullable = false)
	private String roleName;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
