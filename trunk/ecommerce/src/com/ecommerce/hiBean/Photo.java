package com.ecommerce.hiBean;

import java.sql.Timestamp;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo implements java.io.Serializable {

	// Fields

	private Integer picId;
	private Item item;
	private String picUrl;
	private String description;
	private String size;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Item item, String picUrl, String description, String size,
			Timestamp updateTime) {
		this.item = item;
		this.picUrl = picUrl;
		this.description = description;
		this.size = size;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getPicId() {
		return this.picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}