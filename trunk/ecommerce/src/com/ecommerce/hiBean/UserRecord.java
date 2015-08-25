package com.ecommerce.hiBean;

/**
 * UserRecord entity. @author MyEclipse Persistence Tools
 */

public class UserRecord implements java.io.Serializable {

	// Fields

	private UserRecordId id;
	private Users users;
	private Orders orders;

	// Constructors

	/** default constructor */
	public UserRecord() {
	}

	/** full constructor */
	public UserRecord(UserRecordId id, Users users, Orders orders) {
		this.id = id;
		this.users = users;
		this.orders = orders;
	}

	// Property accessors

	public UserRecordId getId() {
		return this.id;
	}

	public void setId(UserRecordId id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}