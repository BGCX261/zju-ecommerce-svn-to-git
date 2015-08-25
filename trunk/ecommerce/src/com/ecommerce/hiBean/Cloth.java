package com.ecommerce.hiBean;

/**
 * Cloth entity. @author MyEclipse Persistence Tools
 */

public class Cloth implements java.io.Serializable {

	// Fields

	private Integer clothId;
	private Item item;
	private String clothType;
	private String brand;
	private String consumer;
	private String consumerGender;
	private String style;
	private String size;
	private String color;
	private String material;

	// Constructors

	/** default constructor */
	public Cloth() {
	}

	/** full constructor */
	public Cloth(Item item, String clothType, String brand, String consumer,
			String consumerGender, String style, String size, String color,
			String material) {
		this.item = item;
		this.clothType = clothType;
		this.brand = brand;
		this.consumer = consumer;
		this.consumerGender = consumerGender;
		this.style = style;
		this.size = size;
		this.color = color;
		this.material = material;
	}

	// Property accessors

	public Integer getClothId() {
		return this.clothId;
	}

	public void setClothId(Integer clothId) {
		this.clothId = clothId;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getClothType() {
		return this.clothType;
	}

	public void setClothType(String clothType) {
		this.clothType = clothType;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getConsumer() {
		return this.consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getConsumerGender() {
		return this.consumerGender;
	}

	public void setConsumerGender(String consumerGender) {
		this.consumerGender = consumerGender;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}