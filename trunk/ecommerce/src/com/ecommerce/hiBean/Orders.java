package com.ecommerce.hiBean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Users users;
	private Timestamp submintTime;
	private String orderStatus;
	private Timestamp successTime;
	private Float money;
	private Set userRecords = new HashSet(0);
	private Set orderItems = new HashSet(0);
	private Set storeRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Users users) {
		this.users = users;
	}

	/** full constructor */
	public Orders(Users users, Timestamp submintTime, String orderStatus,
			Timestamp successTime, Float money, Set userRecords,
			Set orderItems, Set storeRecords) {
		this.users = users;
		this.submintTime = submintTime;
		this.orderStatus = orderStatus;
		this.successTime = successTime;
		this.money = money;
		this.userRecords = userRecords;
		this.orderItems = orderItems;
		this.storeRecords = storeRecords;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Timestamp getSubmintTime() {
		return this.submintTime;
	}

	public void setSubmintTime(Timestamp submintTime) {
		this.submintTime = submintTime;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getSuccessTime() {
		return this.successTime;
	}

	public void setSuccessTime(Timestamp successTime) {
		this.successTime = successTime;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Set getUserRecords() {
		return this.userRecords;
	}

	public void setUserRecords(Set userRecords) {
		this.userRecords = userRecords;
	}

	public Set getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}

	public Set getStoreRecords() {
		return this.storeRecords;
	}

	public void setStoreRecords(Set storeRecords) {
		this.storeRecords = storeRecords;
	}

}