package com.ecommerce.hiBean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Digital entity. @author MyEclipse Persistence Tools
 */

public class Digital implements java.io.Serializable {

	// Fields

	private Integer digitalId;
	private Item item;
	private String digitalType;
	private String usedTime;
	private Float originPrice;
	private Date serviceDeadline;
	private Set telephones = new HashSet(0);

	// Constructors

	/** default constructor */
	public Digital() {
	}

	/** full constructor */
	public Digital(Item item, String digitalType, String usedTime,
			Float originPrice, Date serviceDeadline, Set telephones) {
		this.item = item;
		this.digitalType = digitalType;
		this.usedTime = usedTime;
		this.originPrice = originPrice;
		this.serviceDeadline = serviceDeadline;
		this.telephones = telephones;
	}

	// Property accessors

	public Integer getDigitalId() {
		return this.digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getDigitalType() {
		return this.digitalType;
	}

	public void setDigitalType(String digitalType) {
		this.digitalType = digitalType;
	}

	public String getUsedTime() {
		return this.usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}

	public Float getOriginPrice() {
		return this.originPrice;
	}

	public void setOriginPrice(Float originPrice) {
		this.originPrice = originPrice;
	}

	public Date getServiceDeadline() {
		return this.serviceDeadline;
	}

	public void setServiceDeadline(Date serviceDeadline) {
		this.serviceDeadline = serviceDeadline;
	}

	public Set getTelephones() {
		return this.telephones;
	}

	public void setTelephones(Set telephones) {
		this.telephones = telephones;
	}

}