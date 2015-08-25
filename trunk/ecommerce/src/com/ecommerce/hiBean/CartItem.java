package com.ecommerce.hiBean;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CartItem implements Serializable {

	  /* Private Fields */

	  private Item item;
	  private int quantity;
	  private float total;
	  private String picUrl;

	  public float getTotal() {
	    return total;
	  }

	  public Item getItem() {
	    return item;
	  }

	  public void setItem(Item item) {
	    this.item = item;
	    calculateTotal();
	  }

	  public int getQuantity() {
	    return quantity;
	  }

	  public void setQuantity(int quantity) {
	    this.quantity = quantity;
	    calculateTotal();
	  }

	  /* Public methods */

	  public void incrementQuantity() {
	    quantity++;
	    calculateTotal();
	  }

	  /* Private methods */

	  private void calculateTotal() {
	    if (item != null && item.getPrice() != null) {
	      total = item.getPrice()*quantity;
	    } else {
	      total = 0;
	    }
	  }

	public CartItem(Item item, int quantity,String picUrl) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.picUrl = picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	}

