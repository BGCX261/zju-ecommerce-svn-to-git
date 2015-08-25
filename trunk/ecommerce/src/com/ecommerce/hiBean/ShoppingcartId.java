package com.ecommerce.hiBean;

/**
 * ShoppingcartId entity. @author MyEclipse Persistence Tools
 */

public class ShoppingcartId implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public ShoppingcartId() {
	}

	/** full constructor */
	public ShoppingcartId(Integer itemId, Integer userId) {
		this.itemId = itemId;
		this.userId = userId;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShoppingcartId))
			return false;
		ShoppingcartId castOther = (ShoppingcartId) other;

		return ((this.getItemId() == castOther.getItemId()) || (this
				.getItemId() != null
				&& castOther.getItemId() != null && this.getItemId().equals(
				castOther.getItemId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}