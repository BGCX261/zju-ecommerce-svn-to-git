package com.ecommerce.dao;

import java.util.ArrayList;

import com.ecommerce.bean.Item;

public interface IItemDAO {
	/**
	 * 由商品名查询商品具体信息
	 * @param itemName
	 * @return Item
	 */
	public ArrayList<Item> getItemByName(String itemName);
	
}
