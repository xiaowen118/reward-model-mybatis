package com.wenrc.reward.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author wenrc
 *
 */
@Entity(name = "sys_resource")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Resource extends LongIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5329724175252972322L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "parentId")
	private Integer parentId;
	
	@Column(name = "resKey")
	private String resKey;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "resUrl")
	private String resUrl;
	
	@Column(name = "level")
	private Integer level;
	
	@Column(name = "des")
	private String des;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
