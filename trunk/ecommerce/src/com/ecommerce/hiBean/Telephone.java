package com.ecommerce.hiBean;

/**
 * Telephone entity. @author MyEclipse Persistence Tools
 */

public class Telephone implements java.io.Serializable {

	// Fields

	private Integer telephoneId;
	private Digital digital;
	private String screenSize;
	private String color;
	private String system;
	private String pixels;
	private String style;
	private String brand;
	private String memory;
	private String version;

	// Constructors

	/** default constructor */
	public Telephone() {
	}

	/** full constructor */
	public Telephone(Digital digital, String screenSize, String color,
			String system, String pixels, String style, String brand,
			String memory, String version) {
		this.digital = digital;
		this.screenSize = screenSize;
		this.color = color;
		this.system = system;
		this.pixels = pixels;
		this.style = style;
		this.brand = brand;
		this.memory = memory;
		this.version = version;
	}

	// Property accessors

	public Integer getTelephoneId() {
		return this.telephoneId;
	}

	public void setTelephoneId(Integer telephoneId) {
		this.telephoneId = telephoneId;
	}

	public Digital getDigital() {
		return this.digital;
	}

	public void setDigital(Digital digital) {
		this.digital = digital;
	}

	public String getScreenSize() {
		return this.screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getPixels() {
		return this.pixels;
	}

	public void setPixels(String pixels) {
		this.pixels = pixels;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMemory() {
		return this.memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}