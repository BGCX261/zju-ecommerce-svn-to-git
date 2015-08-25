package com.ecommerce.hiBean;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private AddressId id;
	private Users users;
	private String address;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(AddressId id, Users users) {
		this.id = id;
		this.users = users;
	}

	/** full constructor */
	public Address(AddressId id, Users users, String address) {
		this.id = id;
		this.users = users;
		this.address = address;
	}

	// Property accessors

	public AddressId getId() {
		return this.id;
	}

	public void setId(AddressId id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}