package com.ecommerce.hiBean;

/**
 * Favorites entity. @author MyEclipse Persistence Tools
 */

public class Favorites implements java.io.Serializable {

	// Fields

	private FavoritesId id;
	private Users users;
	private Item item;
	private String itemUrl;

	// Constructors

	/** default constructor */
	public Favorites() {
	}

	/** minimal constructor */
	public Favorites(FavoritesId id, Users users, Item item) {
		this.id = id;
		this.users = users;
		this.item = item;
	}

	/** full constructor */
	public Favorites(FavoritesId id, Users users, Item item, String itemUrl) {
		this.id = id;
		this.users = users;
		this.item = item;
		this.itemUrl = itemUrl;
	}

	// Property accessors

	public FavoritesId getId() {
		return this.id;
	}

	public void setId(FavoritesId id) {
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

	public String getItemUrl() {
		return this.itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

}