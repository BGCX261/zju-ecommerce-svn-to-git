package com.ecommerce.dao;

import java.util.ArrayList;

import com.ecommerce.bean.Item;

public interface IItemDAO {
	/**
	 * ����Ʒ����ѯ��Ʒ������Ϣ
	 * @param itemName
	 * @return Item
	 */
	public ArrayList<Item> getItemByName(String itemName);
	
}
