//  File: ShoppingCartBussiness.java
//  Author: Mao Jianjun <justmao945@gmail.com>
//

package com.ecommerce.bussiness;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ecommerce.db.HibernateSessionFactory;

import com.ecommerce.hiBean.*;
import com.ecommerce.hiDAO.*;

//+--------+---------+------+-----+---------+-------+
//| Field  | Type    | Null | Key | Default | Extra |
//+--------+---------+------+-----+---------+-------+
//| itemId | int(11) | NO   | PRI | NULL    |       |
//| userId | int(11) | NO   | PRI | NULL    |       |
//+--------+---------+------+-----+---------+-------+

public class ShoppingCartBussiness {

  /// XXX only need @param cart param...as itemId and us
  /// @param item Will be ignored...
	public static boolean addItem(Item item, ShoppingcartId cart){
    return addItem( cart );
  }
  
  /// @param cart CartId including itemId and userId, enough to add item.
	public static boolean addItem(ShoppingcartId cart){
    Session ses  = HibernateSessionFactory.getSession();
    Users user = new UsersDAO().findById( cart.getUserId() );
    
    if ( user == null )
      return false;

    Item item =  new ItemDAO().findById( cart.getItemId() );

    if( item == null )
      return false;

    Shoppingcart sc = new Shoppingcart(cart, user, item);
    Transaction tx = ses.beginTransaction();
    boolean b = true;

    try{
      ses.save(sc);
      tx.commit();
    }catch( Exception e ){
      tx.rollback();
      e.printStackTrace();
      b = false;
    } finally{
      ses.close();
    }
		return b;
	}

  ///XXX   Same with deleteItemById ??
	public static boolean deleteAllItem(ShoppingcartId cart){
    return deleteItemById( cart );
	}

  /// XXX @param itemid Will be ignored...
	public static boolean deleteItemById(Integer itemid, ShoppingcartId cart){
    return deleteItemById( cart );
  }

	public static boolean deleteItemById(ShoppingcartId cart){
    Session ses  = HibernateSessionFactory.getSession();
    Shoppingcart sc = new ShoppingcartDAO().findById( cart );
    
    if( sc == null )
      return false;

    Transaction tx = ses.beginTransaction();
    boolean b = true;
    
    try{
      ses.delete(sc);
      tx.commit();
    }catch( Exception e ){
      tx.rollback();
      e.printStackTrace();
      b = false;
    } finally{
      ses.close();
    }
		return b;
	}

  /// @param itemid Will be ignored.... 
	public static boolean modifyItemNumber(Integer itemid, ShoppingcartId cart, Integer num){
		return modifyItemNumber(cart, num);
	}

  /// What should I do ??????... confused with order_item ???
	public static boolean modifyItemNumber(ShoppingcartId cart, Integer num){
		return false;
  }


  /// .... Confused with order ?
	public static Integer getTotalPrice(ShoppingcartId cart){
    
		return 0;
	}
    

  public static void main(String []args){
    ShoppingCartBussiness scb  = new ShoppingCartBussiness();
    ShoppingcartId si = new ShoppingcartId( 1, 2 );
    //System.out.println( scb.addItem(si) );
    System.out.println( scb.deleteItemById(si) );
  }
}


