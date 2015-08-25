//  File: UserBussiness.java
//  Author: Mao Jianjun <justmao945@gmail.com>
//

package com.ecommerce.bussiness;
import java.util.List;
import java.util.Calendar;
import com.ecommerce.hiBean.*;

import com.ecommerce.hiDAO.UsersDAO;

import com.ecommerce.hiDAO.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import com.ecommerce.db.HibernateSessionFactory;


// Table users.
// +--------------+--------------+------+-----+---------+-------+
// Field        | Type         | Null | Key | Default | Extra |
// +--------------+--------------+------+-----+---------+-------+
// | userId       | int(11)      | NO   | PRI | NULL    |       |
// | userName     | varchar(50)  | YES  |     | NULL    |       |
// | userPwd      | varchar(30)  | YES  |     | NULL    |       |
// | email        | varchar(100) | NO   |     | NULL    |       |
// | phone        | varchar(20)  | NO   |     | NULL    |       |
// | address      | longtext     | NO   |     | NULL    |       |
// | bankCard     | varchar(30)  | YES  |     | NULL    |       |
// | bankName     | varchar(80)  | YES  |     | NULL    |       |
// | campus       | varchar(80)  | NO   |     | NULL    |       |
// | gender       | smallint(6)  | YES  |     | NULL    |       |
// | realName     | varchar(40)  | YES  |     | NULL    |       |
// | zhifubaoCard | varchar(50)  | YES  |     | NULL    |       |
// | accessDate   | datetime     | YES  |     | NULL    |       |
// | renren       | varchar(200) | YES  |     | NULL    |       |
// | weibo        | varchar(200) | YES  |     | NULL    |       |
// | douban       | varchar(200) | YES  |     | NULL    |       |
// +--------------+--------------+------+-----+---------+-------+

// 
//   Table orders.
// +-------------+-------------+------+-----+---------+-------+
// | Field       | Type        | Null | Key | Default | Extra |
// +-------------+-------------+------+-----+---------+-------+
// | orderId     | int(11)     | NO   | PRI | NULL    |       |
// | userId      | int(11)     | NO   | MUL | NULL    |       |
// | submintTime | datetime    | YES  |     | NULL    |       |
// | orderStatus | varchar(30) | YES  |     | NULL    |       |
// | successTime | datetime    | YES  |     | NULL    |       |
// | money       | float       | YES  |     | NULL    |       |
// +-------------+-------------+------+-----+---------+-------+
// 
//  Table comments.
// +-------------+----------+------+-----+---------+-------+
// | Field       | Type     | Null | Key | Default | Extra |
// +-------------+----------+------+-----+---------+-------+
// | userId      | int(11)  | NO   | PRI | NULL    |       |
// | storeId     | int(11)  | NO   | PRI | NULL    |       |
// | itemId      | int(11)  | NO   | PRI | NULL    |       |
// | comments    | longtext | YES  |     | NULL    |       |
// | points      | float    | YES  |     | NULL    |       |
// | commentTime | datetime | YES  |     | NULL    |       |
// +-------------+----------+------+-----+---------+-------+

 

public class UserBussiness {

  /// Need provide user.userName and user.userPwd.
  /// @return uid if success, or -1
  public static Users userLogin(Users user){
    List<Users> u = new UsersDAO().findByEmail(user.getEmail());
    System.out.println("email and password is:"+user.getEmail()+"  "+user.getUserPwd());
    System.out.println("users size is:"+u.size());
    if( u.size() == 1 && u.get(0).getUserPwd().equals(user.getUserPwd()) )
      return u.get(0);
    else
      return null;
  }
  

  /// Need user.userName
  // @return uid if success, or -1
  @SuppressWarnings("unchecked")
public static Users userRgister(Users user){
    Session ses  = HibernateSessionFactory.getSession();
    List<Users> u = new UsersDAO().findByEmail(user.getEmail());

    if ( u.size() > 0 ) // User exists.
      return null;

    Transaction tx = ses.beginTransaction();
    try{
      ses.save(user);
      tx.commit();
    }catch( Exception e ){
      tx.rollback();
      e.printStackTrace();
      return null;
    } finally{
      ses.close();
    }
    u = new UsersDAO().findByEmail( user.getEmail());
		return u.get(0);
  }


  /// Need user.userId.
  public static boolean improveUserInfo(Users user) {
    Session ses  = HibernateSessionFactory.getSession();

    Transaction tx = ses.beginTransaction();
    try{
      ses.update(user);
      tx.commit();
    }catch( Exception e ){
      tx.rollback();
      e.printStackTrace();
      return false;
    } finally{
      ses.close();
    }
	  return true;
  }


  /// Need user.userId, and order.orderId.
  public  static boolean confirmOrder(Users user,Orders order) {
	  Session ses  = HibernateSessionFactory.getSession();

    Users u = new UsersDAO().findById( user.getUserId() );
    if ( u == null ) // User not exists.
      return false;

    Orders o = new OrdersDAO().findById( order.getOrderId() );
    if( o == null  )
      return false;
    
    o.setOrderStatus( "succuss" ); /// FIXME..... what to fill????

    long timeNow = Calendar.getInstance().getTimeInMillis();
    java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
    o.setSuccessTime( ts );
    Transaction tx = ses.beginTransaction();
    try{
      ses.save(o);
      tx.commit();
    }catch( Exception e ){
      tx.rollback();
      e.printStackTrace();
      return false;
    } finally{
      ses.close();
    }
	  return true;
  }

  

  public static List<UserRecord> queryOrderRecord(Integer uid) {
    Session ses  = HibernateSessionFactory.getSession();
    Query q = ses.createQuery( "from UserRecord where sellerId = ?" );
	  q.setParameter(0, uid);
    List<UserRecord> o = q.list();
    ses.close();
	  return o;
  }


  public static List<Comments> queryCommentRecord(Integer uid) {
    Session ses  = HibernateSessionFactory.getSession();
    Query q = ses.createQuery( "from Comments where userId = ?" );
	  q.setParameter(0, uid);
    List<Comments> c = q.list();
    ses.close();
	  return c;
  }

  public static void main(String[] args){
	  List<UserRecord> os = UserBussiness.queryOrderRecord(2);
	  
	  String s="d";
  //  Users u = new Users("zhouqzju@136.com","512845","409","yuquan"); // F**K constructor??
   // u.setUserName( "bb" );  u.setUserPwd( "cc" );
    //System.out.println( UserBussiness.userLogin( u ) );
  //  u.setUserName("Donal");
   
   
  //  System.out.println( UserBussiness.userRgister(u).getUserId() );
   // System.out.println( UserBussiness.userLogin( u ).getUserId() );
 /*   u.setUserName("xx");
 //  System.out.println( UserBussiness.userRgister(u) );
    u.setUserId( 5 );
    System.out.println( UserBussiness.improveUserInfo( u ) );
    u.setUserId(2);
    Orders o = new Orders();
    o.setOrderId(1);
    System.out.println( UserBussiness.confirmOrder( u, o) );

   
    for( Orders ox : os ) System.out.println( ox.getOrderId() );
    os = UserBussiness.queryOrderRecord(2);
    for( Orders ox : os ) System.out.println( ox.getOrderId() );

    List<Comments> cs = UserBussiness.queryCommentRecord(1);
    for( Comments cx : cs ) System.out.println( cx.getItem().getItemId() );
    cs = UserBussiness.queryCommentRecord(0);
    for( Comments cx : cs ) System.out.println( cx.getItem().getItemId() );*/
  }
}


   


