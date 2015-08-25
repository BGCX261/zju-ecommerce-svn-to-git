package com.ecommerce.hiBean;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcart implements java.io.Serializable {

	// Fields

	private ShoppingcartId id;
	private Users users;
	private Item item;

	// Constructors

	/** default constructor */
	public Shoppingcart() {
	}

	/** full constructor */
	public Shoppingcart(ShoppingcartId id, Users users, Item item) {
		this.id = id;
		this.users = users;
		this.item = item;
	}

	// Property accessors

	public ShoppingcartId getId() {
		return this.id;
	}

	public void setId(ShoppingcartId id) {
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