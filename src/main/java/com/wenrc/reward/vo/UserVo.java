package com.wenrc.reward.vo;

import com.wenrc.reward.bean.user.UserBean;

public class UserVo extends BaseVo<UserBean> {
	
	/**用户名**/
	private String name;
	
	/**用户电话**/
	private String mobile;
	
	/**注册日期从**/
	private String regDateFrom;
	
	/**注册日期至**/
	private String regDateTo;
	
	/**用户等级**/
	private Integer level;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegDateFrom() {
		return regDateFrom;
	}

	public void setRegDateFrom(String regDateFrom) {
		this.regDateFrom = regDateFrom;
	}

	public String getRegDateTo() {
		return regDateTo;
	}

	public void setRegDateTo(String regDateTo) {
		this.regDateTo = regDateTo;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

}
