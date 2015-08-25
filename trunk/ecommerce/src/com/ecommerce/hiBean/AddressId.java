package com.ecommerce.hiBean;

/**
 * AddressId entity. @author MyEclipse Persistence Tools
 */

public class AddressId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer addressId;

	// Constructors

	/** default constructor */
	public AddressId() {
	}

	/** full constructor */
	public AddressId(Integer userId, Integer addressId) {
		this.userId = userId;
		this.addressId = addressId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AddressId))
			return false;
		AddressId castOther = (AddressId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getAddressId() == castOther.getAddressId()) || (this
						.getAddressId() != null
						&& castOther.getAddressId() != null && this
						.getAddressId().equals(castOther.getAddressId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		return result;
	}

}