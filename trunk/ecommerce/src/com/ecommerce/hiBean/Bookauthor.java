package com.ecommerce.hiBean;

/**
 * Bookauthor entity. @author MyEclipse Persistence Tools
 */

public class Bookauthor implements java.io.Serializable {

	// Fields

	private BookauthorId id;
	private Book book;

	// Constructors

	/** default constructor */
	public Bookauthor() {
	}

	/** full constructor */
	public Bookauthor(BookauthorId id, Book book) {
		this.id = id;
		this.book = book;
	}

	// Property accessors

	public BookauthorId getId() {
		return this.id;
	}

	public void setId(BookauthorId id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}