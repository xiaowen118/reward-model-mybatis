package com.wenrc.reward.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "sys_role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Role extends LongIdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3341943927925685461L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "roleKey")
	private String roleKey;
	
	@Column(name = "des")
	private String des;
	
	@Column(name = "enable")
	private Integer enable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
}
