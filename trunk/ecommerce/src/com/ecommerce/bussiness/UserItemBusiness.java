package com.ecommerce.bussiness;


import javax.faces.component.UIColumn;

import com.ecommerce.hiBean.Item;
import com.ecommerce.hiBean.UserItem;
import com.ecommerce.hiBean.UserItemId;
import com.ecommerce.hiBean.Users;

import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.UserItemDAO;
import com.ecommerce.hiDAO.UsersDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ecommerce.db.HibernateSessionFactory;

public class UserItemBusiness {
		public  static boolean modifyItem(UserItem ut){
				Session ses  = HibernateSessionFactory.getSession();
				UserItem sc = new UserItemDAO().findById( ut.getId() );

				if( sc == null )
						return false;

				Transaction tx = ses.beginTransaction();
			

				try{
						ses.update(sc);
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
		public static  boolean deleteItem(UserItemId ut){
				Session ses  = HibernateSessionFactory.getSession();
				UserItem sc = new UserItemDAO().findById(ut);

				if( sc == null )
						return false;

				Transaction tx = ses.beginTransaction();
				

				try{
						ses.delete(sc);
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
		public static  boolean addItem(UserItem ut){
			  ItemDAO ido=new ItemDAO();
			Session ses1  = HibernateSessionFactory.getSession();			
			Transaction tx1 = ses1.beginTransaction();
		
			  try{
				  
					ses1.save(ut.getItem());
					tx1.commit();
			}catch( Exception e ){
					tx1.rollback();
					e.printStackTrace();
				    return false;
			} finally{
					ses1.close();
			}
			
		   Item it=(Item)ido.findByItemName(ut.getItem().getItemName()).get(0);
		   UserItemId uId=new UserItemId(ut.getUsers().getUserId(),it.getItemId(),1);
		   ut.setId(uId);
		   
		   
			    Session ses  = HibernateSessionFactory.getSession();		
				Transaction tx = ses.beginTransaction();
		

				try{
					  
						ses.save(ut);
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
		 public static void main(String[] args){
		      UsersDAO uDao=new UsersDAO();
		      Users users=uDao.findById(3);
		      Item it=new Item();
		      it.setItemName("game2");
		      UserItem ut=new UserItem();
		     ut.setUsers(users);
		     ut.setItem(it);
		      
		     System.out.println( UserItemBusiness.addItem(ut));
		 }
}
