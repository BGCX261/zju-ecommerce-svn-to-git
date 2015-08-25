package com.ecommerce.hiBean;

/**
 * StoreRecord entity. @author MyEclipse Persistence Tools
 */

public class StoreRecord implements java.io.Serializable {

	// Fields

	private StoreRecordId id;
	private Store store;
	private Users users;
	private Orders orders;

	// Constructors

	/** default constructor */
	public StoreRecord() {
	}

	/** full constructor */
	public StoreRecord(StoreRecordId id, Store store, Users users, Orders orders) {
		this.id = id;
		this.store = store;
		this.users = users;
		this.orders = orders;
	}

	// Property accessors

	public StoreRecordId getId() {
		return this.id;
	}

	public void setId(StoreRecordId id) {
		this.id = id;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
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