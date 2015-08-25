package com.ecommerce.hiBean;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private CommentsId id;
	private Store store;
	private Users users;
	private Item item;
	private String comments;
	private Float points;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(CommentsId id, Store store, Users users, Item item) {
		this.id = id;
		this.store = store;
		this.users = users;
		this.item = item;
	}

	/** full constructor */
	public Comments(CommentsId id, Store store, Users users, Item item,
			String comments, Float points, Timestamp commentTime) {
		this.id = id;
		this.store = store;
		this.users = users;
		this.item = item;
		this.comments = comments;
		this.points = points;
		this.commentTime = commentTime;
	}

	// Property accessors

	public CommentsId getId() {
		return this.id;
	}

	public void setId(CommentsId id) {
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Float getPoints() {
		return this.points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}