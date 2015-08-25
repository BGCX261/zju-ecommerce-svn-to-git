package com.ecommerce.hiBean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private String email;
	private String phone;
	private String address;
	private String bankCard;
	private String bankName;
	private String campus;
	private Short gender;
	private String realName;
	private String zhifubaoCard;
	private Date accessDate;
	private String renren;
	private String weibo;
	private String douban;
	private Set orderses = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set userRecords = new HashSet(0);
	private Set userItems = new HashSet(0);
	private Set storeRecords = new HashSet(0);
	private Set favoriteses = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String email, String phone, String address, String campus) {
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.campus = campus;
	}

	/** full constructor */
	public Users(String userName, String userPwd, String email, String phone,
			String address, String bankCard, String bankName, String campus,
			Short gender, String realName, String zhifubaoCard,
			Date accessDate, String renren, String weibo, String douban,
			Set orderses, Set commentses, Set userRecords, Set userItems,
			Set storeRecords, Set favoriteses, Set shoppingcarts) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.bankCard = bankCard;
		this.bankName = bankName;
		this.campus = campus;
		this.gender = gender;
		this.realName = realName;
		this.zhifubaoCard = zhifubaoCard;
		this.accessDate = accessDate;
		this.renren = renren;
		this.weibo = weibo;
		this.douban = douban;
		this.orderses = orderses;
		this.commentses = commentses;
		this.userRecords = userRecords;
		this.userItems = userItems;
		this.storeRecords = storeRecords;
		this.favoriteses = favoriteses;
		this.shoppingcarts = shoppingcarts;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
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

	public Date getAccessDate() {
		return this.accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public String getRenren() {
		return this.renren;
	}

	public void setRenren(String renren) {
		this.renren = renren;
	}

	public String getWeibo() {
		return this.weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getDouban() {
		return this.douban;
	}

	public void setDouban(String douban) {
		this.douban = douban;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getUserRecords() {
		return this.userRecords;
	}

	public void setUserRecords(Set userRecords) {
		this.userRecords = userRecords;
	}

	public Set getUserItems() {
		return this.userItems;
	}

	public void setUserItems(Set userItems) {
		this.userItems = userItems;
	}

	public Set getStoreRecords() {
		return this.storeRecords;
	}

	public void setStoreRecords(Set storeRecords) {
		this.storeRecords = storeRecords;
	}

	public Set getFavoriteses() {
		return this.favoriteses;
	}

	public void setFavoriteses(Set favoriteses) {
		this.favoriteses = favoriteses;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

}