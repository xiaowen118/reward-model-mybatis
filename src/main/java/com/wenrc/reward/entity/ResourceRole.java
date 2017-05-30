package com.wenrc.reward.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月29日
 *
 */
@Entity(name = "sys_role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ResourceRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5950888756747265719L;

	@Column(name = "resId")
	private Integer resId;
	
	@Column(name = "roleId")
	private Integer roleId;

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
