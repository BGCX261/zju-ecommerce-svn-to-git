package com.ecommerce.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.hiBean.Administrator;
import com.ecommerce.db.HibernateSessionFactory;

public class hibernateTest {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Administrator stu = new Administrator("000","111","222","333","444","555");
		try {
			session.save(stu);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
