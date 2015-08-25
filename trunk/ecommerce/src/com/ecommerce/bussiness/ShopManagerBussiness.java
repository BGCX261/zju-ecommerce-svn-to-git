package com.ecommerce.bussiness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.db.HibernateSessionFactory;
import com.ecommerce.hiBean.Comments;
import com.ecommerce.hiBean.Orders;
import com.ecommerce.hiBean.StoreAdmin;
import com.ecommerce.hiBean.StoreRecord;
import com.ecommerce.hiDAO.OrdersDAO;
import com.ecommerce.hiDAO.StoreAdminDAO;


public class ShopManagerBussiness {

		public StoreAdmin managerLogin(StoreAdmin admin) {
				List<StoreAdmin> sa = new StoreAdminDAO().findByEmail(admin.getEmail());
				if (sa.size() == 1 && sa.get(0).getPwd().equals(admin.getPwd()))
						return sa.get(0);
				else
								return null;
		}  
		public boolean improveManagerInfo(StoreAdmin admin) {
				Session ses = HibernateSessionFactory.getSession();

				Transaction tx = ses.beginTransaction();
				try {
						ses.update(admin);
						tx.commit();
				} catch (Exception e) {
						tx.rollback();
						e.printStackTrace();
						return false;
				} finally {
						ses.close();
				}
				return true;
		}
		public boolean confirmOder(StoreAdmin admin,Orders order) {
				Session ses = HibernateSessionFactory.getSession();

				StoreAdmin sa = new StoreAdminDAO().findById(admin.getStoreAdminId());
				if (sa == null)
						return false;

				Orders o = new OrdersDAO().findById(order.getOrderId());
				if (o == null)
						return false;

				o.setOrderStatus("Succuss");

				long timeNow = Calendar.getInstance().getTimeInMillis();
				java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
				o.setSuccessTime(ts);
				Transaction tx = ses.beginTransaction();
				try {
						ses.save(o);
						tx.commit();
				} catch (Exception e) {
						tx.rollback();
						e.printStackTrace();
						return false;
				} finally {
						ses.close();
				}
				return true;
		}
		public List<Orders> queryOrderRecord(Integer storeid) {
				Session ses  = HibernateSessionFactory.getSession();
				Query q = ses.createQuery( "from StoreRecord where StoreRecordId = ?" );
				q.setParameter(0, storeid);
				List<StoreRecord> sr = q.list();
				List<Orders> o=new ArrayList<Orders>();
				for (int i = 0; i != sr.size(); ++i)
				{
						o.add(sr.get(i).getOrders());
				}
				ses.close();
				return o;
		}
		public List<Comments> queryCommentRecord(Integer storeid) {
				Session ses  = HibernateSessionFactory.getSession();
				Query q = ses.createQuery( "from Comments where storeId = ?" );
				q.setParameter(0, storeid);
				List<Comments> c = q.list();
				ses.close();
				return c;
		}
}
