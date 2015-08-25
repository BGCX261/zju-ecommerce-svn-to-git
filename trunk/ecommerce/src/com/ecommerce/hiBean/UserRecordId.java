package com.ecommerce.hiBean;

/**
 * UserRecordId entity. @author MyEclipse Persistence Tools
 */

public class UserRecordId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer sellerId;
	private Integer orderId;

	// Constructors

	/** default constructor */
	public UserRecordId() {
	}

	/** full constructor */
	public UserRecordId(Integer userId, Integer sellerId, Integer orderId) {
		this.userId = userId;
		this.sellerId = sellerId;
		this.orderId = orderId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRecordId))
			return false;
		UserRecordId castOther = (UserRecordId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getSellerId() == castOther.getSellerId()) || (this
						.getSellerId() != null
						&& castOther.getSellerId() != null && this
						.getSellerId().equals(castOther.getSellerId())))
				&& ((this.getOrderId() == castOther.getOrderId()) || (this
						.getOrderId() != null
						&& castOther.getOrderId() != null && this.getOrderId()
						.equals(castOther.getOrderId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getSellerId() == null ? 0 : this.getSellerId().hashCode());
		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		return result;
	}

}