package com.ecommerce.hiBean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private Item item;
	private String bookName;
	private String isbn;
	private String publisher;
	private Short fineness;
	private Short version;
	private String bookLanguage;
	private String bookType;
	private String major;
	private Date publishTime;
	private Set bookauthors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(Item item, String bookName, String isbn, String publisher,
			Short fineness, Short version, String bookLanguage,
			String bookType, String major, Date publishTime, Set bookauthors) {
		this.item = item;
		this.bookName = bookName;
		this.isbn = isbn;
		this.publisher = publisher;
		this.fineness = fineness;
		this.version = version;
		this.bookLanguage = bookLanguage;
		this.bookType = bookType;
		this.major = major;
		this.publishTime = publishTime;
		this.bookauthors = bookauthors;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Short getFineness() {
		return this.fineness;
	}

	public void setFineness(Short fineness) {
		this.fineness = fineness;
	}

	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	public String getBookLanguage() {
		return this.bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Set getBookauthors() {
		return this.bookauthors;
	}

	public void setBookauthors(Set bookauthors) {
		this.bookauthors = bookauthors;
	}

}