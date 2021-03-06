package com.ecommerce.hiBean;

/**
 * UserItemId entity. @author MyEclipse Persistence Tools
 */

public class UserItemId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer itemId;
	private Integer itemNumber;

	// Constructors

	/** default constructor */
	public UserItemId() {
	}

	/** full constructor */
	public UserItemId(Integer userId, Integer itemId, Integer itemNumber) {
		this.userId = userId;
		this.itemId = itemId;
		this.itemNumber = itemNumber;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		if (!(other instanceof UserItemId))
			return false;
		UserItemId castOther = (UserItemId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
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
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37
				* result
				+ (getItemNumber() == null ? 0 : this.getItemNumber()
						.hashCode());
		return result;
	}

}