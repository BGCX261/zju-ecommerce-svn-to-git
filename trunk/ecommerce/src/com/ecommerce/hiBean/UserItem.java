package com.ecommerce.hiBean;

/**
 * UserItem entity. @author MyEclipse Persistence Tools
 */

public class UserItem implements java.io.Serializable {

	// Fields

	private UserItemId id;
	private Users users;
	private Item item;

	// Constructors

	/** default constructor */
	public UserItem() {
	}

	/** full constructor */
	public UserItem(UserItemId id, Users users, Item item) {
		this.id = id;
		this.users = users;
		this.item = item;
	}

	// Property accessors

	public UserItemId getId() {
		return this.id;
	}

	public void setId(UserItemId id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}