package com.ecommerce.hiBean;

/**
 * StoreRecordId entity. @author MyEclipse Persistence Tools
 */

public class StoreRecordId implements java.io.Serializable {

	// Fields

	private Integer storeId;
	private Integer orderId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public StoreRecordId() {
	}

	/** full constructor */
	public StoreRecordId(Integer storeId, Integer orderId, Integer userId) {
		this.storeId = storeId;
		this.orderId = orderId;
		this.userId = userId;
	}

	// Property accessors

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
		if (!(other instanceof StoreRecordId))
			return false;
		StoreRecordId castOther = (StoreRecordId) other;

		return ((this.getStoreId() == castOther.getStoreId()) || (this
				.getStoreId() != null
				&& castOther.getStoreId() != null && this.getStoreId().equals(
				castOther.getStoreId())))
				&& ((this.getOrderId() == castOther.getOrderId()) || (this
						.getOrderId() != null
						&& castOther.getOrderId() != null && this.getOrderId()
						.equals(castOther.getOrderId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStoreId() == null ? 0 : this.getStoreId().hashCode());
		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}