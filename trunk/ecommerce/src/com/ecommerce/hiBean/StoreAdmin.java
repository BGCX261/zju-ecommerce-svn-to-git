package com.ecommerce.hiBean;

import java.util.HashSet;
import java.util.Set;

/**
 * StoreAdmin entity. @author MyEclipse Persistence Tools
 */

public class StoreAdmin implements java.io.Serializable {

	// Fields

	private Integer storeAdminId;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String address;
	private String bankCard;
	private String bankName;
	private String campus;
	private String gender;
	private String realName;
	private String zhifubaoCard;
	private String comments;
	private Set stores = new HashSet(0);

	// Constructors

	/** default constructor */
	public StoreAdmin() {
	}

	/** full constructor */
	public StoreAdmin(String name, String pwd, String email, String phone,
			String address, String bankCard, String bankName, String campus,
			String gender, String realName, String zhifubaoCard,
			String comments, Set stores) {
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.bankCard = bankCard;
		this.bankName = bankName;
		this.campus = campus;
		this.gender = gender;
		this.realName = realName;
		this.zhifubaoCard = zhifubaoCard;
		this.comments = comments;
		this.stores = stores;
	}

	// Property accessors

	public Integer getStoreAdminId() {
		return this.storeAdminId;
	}

	public void setStoreAdminId(Integer storeAdminId) {
		this.storeAdminId = storeAdminId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getBankCard() {
		return this.bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getZhifubaoCard() {
		return this.zhifubaoCard;
	}

	public void setZhifubaoCard(String zhifubaoCard) {
		this.zhifubaoCard = zhifubaoCard;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set getStores() {
		return this.stores;
	}

	public void setStores(Set stores) {
		this.stores = stores;
	}

}