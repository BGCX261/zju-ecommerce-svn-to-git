package com.ecommerce.hiBean;

/**
 * CommentsId entity. @author MyEclipse Persistence Tools
 */

public class CommentsId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer storeId;
	private Integer itemId;

	// Constructors

	/** default constructor */
	public CommentsId() {
	}

	/** full constructor */
	public CommentsId(Integer userId, Integer storeId, Integer itemId) {
		this.userId = userId;
		this.storeId = storeId;
		this.itemId = itemId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentsId))
			return false;
		CommentsId castOther = (CommentsId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getStoreId() == castOther.getStoreId()) || (this
						.getStoreId() != null
						&& castOther.getStoreId() != null && this.getStoreId()
						.equals(castOther.getStoreId())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null
						&& castOther.getItemId() != null && this.getItemId()
						.equals(castOther.getItemId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getStoreId() == null ? 0 : this.getStoreId().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		return result;
	}

}