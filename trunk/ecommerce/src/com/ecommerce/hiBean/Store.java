package com.ecommerce.hiBean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Integer storeId;
	private StoreAdmin storeAdmin;
	private String name;
	private Float storePoint;
	private Timestamp openTime;
	private String url;
	private String homepage;
	private Set storeRecords = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set storeItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** full constructor */
	public Store(StoreAdmin storeAdmin, String name, Float storePoint,
			Timestamp openTime, String url, String homepage, Set storeRecords,
			Set commentses, Set storeItems) {
		this.storeAdmin = storeAdmin;
		this.name = name;
		this.storePoint = storePoint;
		this.openTime = openTime;
		this.url = url;
		this.homepage = homepage;
		this.storeRecords = storeRecords;
		this.commentses = commentses;
		this.storeItems = storeItems;
	}

	// Property accessors

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public StoreAdmin getStoreAdmin() {
		return this.storeAdmin;
	}

	public void setStoreAdmin(StoreAdmin storeAdmin) {
		this.storeAdmin = storeAdmin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getStorePoint() {
		return this.storePoint;
	}

	public void setStorePoint(Float storePoint) {
		this.storePoint = storePoint;
	}

	public Timestamp getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Set getStoreRecords() {
		return this.storeRecords;
	}

	public void setStoreRecords(Set storeRecords) {
		this.storeRecords = storeRecords;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getStoreItems() {
		return this.storeItems;
	}

	public void setStoreItems(Set storeItems) {
		this.storeItems = storeItems;
	}

}