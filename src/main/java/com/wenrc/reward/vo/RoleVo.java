package com.wenrc.reward.vo;

import com.wenrc.reward.bean.role.RoleBean;

/**
 * 
 * @author wenrc@szwgmf.com 2017年4月22日
 *
 */
public class RoleVo extends BaseVo<RoleBean> {
	/**角色名称**/
	private String name;
	
	/**角色代码**/
	private String roleKey;
	
	/**是否可用（0-不可用；1-可用）**/
	private String enable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
}
