//  File: FavoriteBussiness.java
//  Author: Mao Jianjun <justmao945@gmail.com>
//


package com.ecommerce.bussiness;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ecommerce.db.HibernateSessionFactory;

import com.ecommerce.hiBean.*;
import com.ecommerce.hiDAO.*;
  
//  +----------+--------------+------+-----+---------+-------+
//  | Field    | Type         | Null | Key | Default | Extra |
//  +----------+--------------+------+-----+---------+-------+
//  | itemId   | int(11)      | NO   | PRI | NULL    |       |
//  | userId   | int(11)      | NO   | PRI | NULL    |       |
//  | item_url | varchar(200) | YES  |     | NULL    |       |
//  +----------+--------------+------+-----+---------+-------+

public class FavoriteBussiness {

  ///  Add an new  favorite item.
  /// XXX @param item Will be ignored.. as fav provides enough info.
	public static boolean  addItem(Item item, FavoritesId fav){
    return addItem( fav );
  }


	public static  boolean  addItem(FavoritesId fav){
    Session ses  = HibernateSessionFactory.getSession();
    Users user = new UsersDAO().findById( fav.getUserId() );
    
    if (  user == null )
      return false;

    Item  item = new ItemDAO().findById( fav.getItemId() );
    
    if ( item == null )
      return false;

    Favorites favs = new Favorites(fav, user, item, item.getItemUrl());
    Transaction tx = ses.beginTransaction();
    boolean b = true;

    try{
      ses.save(favs);
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

  /// XXX @param itemid Will be ignored...

  

  public static boolean deleteItemById(FavoritesId fid){
    Session ses  = HibernateSessionFactory.getSession();
    Favorites favs = ( new FavoritesDAO() ).findById( fid );
    
    if ( favs == null )
      return false;

    Transaction tx = ses.beginTransaction();
    boolean b = true;
    
    try{
      ses.delete(favs);
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

  public  static  void main(String []args){
    FavoriteBussiness fb = new FavoriteBussiness();
    Item it = new Item();
    FavoritesId fid = new FavoritesId(1, 2);
    Favorites f = new FavoritesDAO().findById( new FavoritesId(1,1) );
    System.out.println( f );
    //System.out.println("fid.getUserId() -> " + fid.getUserId() );
    //System.out.println( fb.deleteItemById( fid ) );
    //System.out.println( fb.addItem(it, fid) );
  }
}
