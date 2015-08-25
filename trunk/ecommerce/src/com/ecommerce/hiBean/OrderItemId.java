package com.ecommerce.hiBean;

/**
 * OrderItemId entity. @author MyEclipse Persistence Tools
 */

public class OrderItemId implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer itemId;
	private Integer itemNumber;

	// Constructors

	/** default constructor */
	public OrderItemId() {
	}

	/** full constructor */
	public OrderItemId(Integer orderId, Integer itemId, Integer itemNumber) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemNumber = itemNumber;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemNumber() {
		return this.itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderItemId))
			return false;
		OrderItemId castOther = (OrderItemId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null
				&& castOther.getOrderId() != null && this.getOrderId().equals(
				castOther.getOrderId())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null
						&& castOther.getItemId() != null && this.getItemId()
						.equals(castOther.getItemId())))
				&& ((this.getItemNumber() == castOther.getItemNumber()) || (this
						.getItemNumber() != null
						&& castOther.getItemNumber() != null && this
						.getItemNumber().equals(castOther.getItemNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37
				* result
				+ (getItemNumber() == null ? 0 : this.getItemNumber()
						.hashCode());
		return result;
	}

}