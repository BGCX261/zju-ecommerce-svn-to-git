package com.ecommerce.hiBean;

/**
 * OrderItem entity. @author MyEclipse Persistence Tools
 */

public class OrderItem implements java.io.Serializable {

	// Fields

	private OrderItemId id;
	private Orders orders;
	private Item item;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(OrderItemId id, Orders orders, Item item) {
		this.id = id;
		this.orders = orders;
		this.item = item;
	}

	// Property accessors

	public OrderItemId getId() {
		return this.id;
	}

	public void setId(OrderItemId id) {
		this.id = id;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}