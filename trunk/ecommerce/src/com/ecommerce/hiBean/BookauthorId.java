package com.ecommerce.hiBean;

/**
 * BookauthorId entity. @author MyEclipse Persistence Tools
 */

public class BookauthorId implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String author;

	// Constructors

	/** default constructor */
	public BookauthorId() {
	}

	/** full constructor */
	public BookauthorId(Integer bookId, String author) {
		this.bookId = bookId;
		this.author = author;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookauthorId))
			return false;
		BookauthorId castOther = (BookauthorId) other;

		return ((this.getBookId() == castOther.getBookId()) || (this
				.getBookId() != null
				&& castOther.getBookId() != null && this.getBookId().equals(
				castOther.getBookId())))
				&& ((this.getAuthor() == castOther.getAuthor()) || (this
						.getAuthor() != null
						&& castOther.getAuthor() != null && this.getAuthor()
						.equals(castOther.getAuthor())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBookId() == null ? 0 : this.getBookId().hashCode());
		result = 37 * result
				+ (getAuthor() == null ? 0 : this.getAuthor().hashCode());
		return result;
	}

}