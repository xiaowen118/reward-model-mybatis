package com.wenrc.reward.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "sys_user_role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1293889554080011192L;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "roleId")
	private Long roleId;
	
	private User user;
	
	private Role role;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
