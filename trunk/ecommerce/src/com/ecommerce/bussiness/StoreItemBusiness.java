package com.ecommerce.bussiness;

import com.ecommerce.hiBean.StoreItem;
import com.ecommerce.hiBean.StoreItemId;


import com.ecommerce.hiDAO.StoreItemDAO;


import org.hibernate.Session;
import org.hibernate.Transaction;



import com.ecommerce.db.HibernateSessionFactory;
public class StoreItemBusiness {
		public static  boolean modifyItem(StoreItem st){
			Session ses  = HibernateSessionFactory.getSession();
			StoreItem sc = new StoreItemDAO().findById( st.getId() );

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

		public static  boolean deleteItem(StoreItemId st){
			Session ses  = HibernateSessionFactory.getSession();
			StoreItem sc = new StoreItemDAO().findById(st);

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
		public static boolean addItem(StoreItem st){
			Session ses  = HibernateSessionFactory.getSession();
			
			Transaction tx = ses.beginTransaction();
			boolean b = true;

			try{
				    ses.saveOrUpdate(st.getItem());
					ses.save(st);
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

}
