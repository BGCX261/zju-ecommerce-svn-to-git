package com.ecommerce.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.bean.Item;
import com.ecommerce.util.DatabaseConnector;


public class ItemDAOImpl implements IItemDAO {

	public ArrayList<Item> getItemByName(String itemName) {
		ArrayList<Item> items = new ArrayList<Item>();
		
		String sql = "select * from item where itemName=?";
		DatabaseConnector dc=new DatabaseConnector();
		PreparedStatement pstmt = (PreparedStatement) dc.getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, itemName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setDescription(rs.getString("description"));
				item.setDiscountPrice(rs.getDouble("discountPrice"));
				item.setItemId(rs.getLong("itemId"));
				item.setItemName(rs.getString("itemName"));
				item.setItemPoint(rs.getDouble("itemPoint"));
				item.setItemStatus(rs.getString("itemStatus"));
				item.setItemType(rs.getString("itemType"));
				item.setItemUrl(rs.getString("itemUrl"));
				item.setLateSoldNumber(rs.getLong("lateSoldNumber"));
				item.setOutStockTime(rs.getString("outStockTime"));
				item.setOwenerId(rs.getLong("owenerId"));
				item.setPrice(rs.getDouble("price"));
				item.setSellerStatus(rs.getShort("sellerStatus"));
				item.setShelveTime(rs.getString("shelveTime"));
				item.setStock(rs.getLong("stock"));
				item.setTag1(rs.getString("tag1"));
				item.setTag2(rs.getString("tag2"));
				item.setTag3(rs.getString("tag3"));
				item.setTag4(rs.getString("tag4"));		
				items.add(item);
			}
			pstmt.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dc.close();
		}
		return items;
	}

}
