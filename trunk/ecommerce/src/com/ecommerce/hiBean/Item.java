package com.ecommerce.hiBean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String itemName;
	private String itemType;
	private Float price;
	private String itemStatus;
	private Float itemPoint;
	private Integer owenerId;
	private Boolean sellerStatus;
	private String itemUrl;
	private Float discountPrice;
	private Integer lateSoldNumber;
	private Timestamp shelveTime;
	private Timestamp outStockTime;
	private String tag1;
	private String tag2;
	private String tag3;
	private String tag4;
	private String description;
	private Set shoppingcarts = new HashSet(0);
	private Set digitals = new HashSet(0);
	private Set orderItems = new HashSet(0);
	private Set userItems = new HashSet(0);
	private Set cloths = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set favoriteses = new HashSet(0);
	private Set storeItems = new HashSet(0);
	private Set photos = new HashSet(0);
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	public Item(String itemName, String itemType, Float price,
			String itemStatus, Float itemPoint, Integer owenerId,
			Boolean sellerStatus, String itemUrl, Float discountPrice,
			Integer lateSoldNumber, Timestamp shelveTime,
			Timestamp outStockTime, String tag1, String tag2, String tag3,
			String tag4, String description, Set shoppingcarts, Set digitals,
			Set orderItems, Set userItems, Set cloths, Set commentses,
			Set favoriteses, Set storeItems, Set photos, Set books) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.itemStatus = itemStatus;
		this.itemPoint = itemPoint;
		this.owenerId = owenerId;
		this.sellerStatus = sellerStatus;
		this.itemUrl = itemUrl;
		this.discountPrice = discountPrice;
		this.lateSoldNumber = lateSoldNumber;
		this.shelveTime = shelveTime;
		this.outStockTime = outStockTime;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.tag4 = tag4;
		this.description = description;
		this.shoppingcarts = shoppingcarts;
		this.digitals = digitals;
		this.orderItems = orderItems;
		this.userItems = userItems;
		this.cloths = cloths;
		this.commentses = commentses;
		this.favoriteses = favoriteses;
		this.storeItems = storeItems;
		this.photos = photos;
		this.books = books;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Float getItemPoint() {
		return this.itemPoint;
	}

	public void setItemPoint(Float itemPoint) {
		this.itemPoint = itemPoint;
	}

	public Integer getOwenerId() {
		return this.owenerId;
	}

	public void setOwenerId(Integer owenerId) {
		this.owenerId = owenerId;
	}

	public Boolean getSellerStatus() {
		return this.sellerStatus;
	}

	public void setSellerStatus(Boolean sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	public String getItemUrl() {
		return this.itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public Float getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getLateSoldNumber() {
		return this.lateSoldNumber;
	}

	public void setLateSoldNumber(Integer lateSoldNumber) {
		this.lateSoldNumber = lateSoldNumber;
	}

	public Timestamp getShelveTime() {
		return this.shelveTime;
	}

	public void setShelveTime(Timestamp shelveTime) {
		this.shelveTime = shelveTime;
	}

	public Timestamp getOutStockTime() {
		return this.outStockTime;
	}

	public void setOutStockTime(Timestamp outStockTime) {
		this.outStockTime = outStockTime;
	}

	public String getTag1() {
		return this.tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return this.tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return this.tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getTag4() {
		return this.tag4;
	}

	public void setTag4(String tag4) {
		this.tag4 = tag4;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getDigitals() {
		return this.digitals;
	}

	public void setDigitals(Set digitals) {
		this.digitals = digitals;
	}

	public Set getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}

	public Set getUserItems() {
		return this.userItems;
	}

	public void setUserItems(Set userItems) {
		this.userItems = userItems;
	}

	public Set getCloths() {
		return this.cloths;
	}

	public void setCloths(Set cloths) {
		this.cloths = cloths;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getFavoriteses() {
		return this.favoriteses;
	}

	public void setFavoriteses(Set favoriteses) {
		this.favoriteses = favoriteses;
	}

	public Set getStoreItems() {
		return this.storeItems;
	}

	public void setStoreItems(Set storeItems) {
		this.storeItems = storeItems;
	}

	public Set getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set photos) {
		this.photos = photos;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}