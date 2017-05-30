package com.wenrc.reward.vo;

import com.wenrc.reward.bean.resource.ResourceBean;

/**
 * 
 * @author wenrc@szwgmf.com 2017年4月23日
 *
 */
public class ResourceVo extends BaseVo<ResourceBean> {
	
	/**资源名称**/
	private String name;
	
	/**资源代码**/
	private String resKey;
	
	/**资源类型**/
	private String type;
	
	/**资源等级**/
	private String level;
	
	/**id**/
	private String id;
	
	/**父节点id**/
	private String parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
