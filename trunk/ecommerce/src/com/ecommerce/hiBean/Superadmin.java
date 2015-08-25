package com.ecommerce.hiBean;

/**
 * Superadmin entity. @author MyEclipse Persistence Tools
 */

public class Superadmin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPwd;
	private String email;
	private String phone;
	private String address;

	// Constructors

	/** default constructor */
	public Superadmin() {
	}

	/** minimal constructor */
	public Superadmin(String email, String phone, String address) {
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	/** full constructor */
	public Superadmin(String adminName, String adminPwd, String email,
			String phone, String address) {
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}