package com.ecommerce.hiDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Item;
//import com.sun.java_cup.internal.internal_error;

/**
 * A data access object (DAO) providing persistence and search support for Item
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Item
 * @author MyEclipse Persistence Tools
 */

public class ItemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ItemDAO.class);
	// property constants
	public static final String ITEM_NAME = "itemName";
	public static final String ITEM_TYPE = "itemType";
	public static final String PRICE = "price";
	public static final String ITEM_STATUS = "itemStatus";
	public static final String ITEM_POINT = "itemPoint";
	public static final String OWENER_ID = "owenerId";
	public static final String SELLER_STATUS = "sellerStatus";
	public static final String ITEM_URL = "itemUrl";
	public static final String DISCOUNT_PRICE = "discountPrice";
	public static final String LATE_SOLD_NUMBER = "lateSoldNumber";
	public static final String TAG1 = "tag1";
	public static final String TAG2 = "tag2";
	public static final String TAG3 = "tag3";
	public static final String TAG4 = "tag4";
	public static final String DESCRIPTION = "description";

	public void save(Item transientInstance) {
		log.debug("saving Item instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Item persistentInstance) {
		log.debug("deleting Item instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/*
	 * sortCond can only be sales,price,commentNumber,stockTime
	 */
	public List SortItem(ArrayList<Integer>itemID,String sortCond) 
	{
		List l=null;
		
		return l;
	}
	public Item findById(java.lang.Integer id) {
		log.debug("getting Item instance with id: " + id);
		try {
			Item instance = (Item) getSession().get("com.ecommerce.hiBean.Item",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Item instance) {
		log.debug("finding Item instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Item").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Item instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Item as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemName(Object itemName) {
		return findByProperty(ITEM_NAME, itemName);
	}

	public List findByItemType(Object itemType) {
		return findByProperty(ITEM_TYPE, itemType);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByItemStatus(Object itemStatus) {
		return findByProperty(ITEM_STATUS, itemStatus);
	}

	public List findByItemPoint(Object itemPoint) {
		return findByProperty(ITEM_POINT, itemPoint);
	}

	public List findByOwenerId(Object owenerId) {
		return findByProperty(OWENER_ID, owenerId);
	}

	public List findBySellerStatus(Object sellerStatus) {
		return findByProperty(SELLER_STATUS, sellerStatus);
	}

	public List findByItemUrl(Object itemUrl) {
		return findByProperty(ITEM_URL, itemUrl);
	}

	public List findByDiscountPrice(Object discountPrice) {
		return findByProperty(DISCOUNT_PRICE, discountPrice);
	}

	public List findByLateSoldNumber(Object lateSoldNumber) {
		return findByProperty(LATE_SOLD_NUMBER, lateSoldNumber);
	}

	public List findByTag1(Object tag1) {
		return findByProperty(TAG1, tag1);
	}

	public List findByTag2(Object tag2) {
		return findByProperty(TAG2, tag2);
	}

	public List findByTag3(Object tag3) {
		return findByProperty(TAG3, tag3);
	}

	public List findByTag4(Object tag4) {
		return findByProperty(TAG4, tag4);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Item instances");
		try {
			String queryString = "from Item";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Item merge(Item detachedInstance) {
		log.debug("merging Item instance");
		try {
			Item result = (Item) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Item instance) {
		log.debug("attaching dirty Item instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Item instance) {
		log.debug("attaching clean Item instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	

	
	//public List changeCond(String category,Condition condition){
		
	//}
	public List findLatestItems(){
		int itemNum = 10;
		Integer count = null;
		try {
			String hql = "select count(*) from Item as model";
			Query queryObject = getSession().createQuery(hql);
			//count = (Integer)queryObject.uniqueResult();
			//要修改，这么算总数会跪的
			count = findAll().size();
			System.out.println("the count of latest items is:" + count);
			hql =  "from Item as e order by e.itemId desc";
			queryObject = getSession().createQuery(hql);
			int c = count - 10;
			if(c < 0) c = 0;
			queryObject.setFirstResult(c); 
			queryObject.setMaxResults(count); 
			System.out.println("the number returned by dao is:" + queryObject.list().size());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByNameAlike(String  name) {
		log.debug("finding Item instance by example");
		try {
			String hql = "from Item as a where a.itemName like '%"+name+"%'";
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByNameAlikeCondition(String  name,String cond) {
		log.debug("finding Item instance by example");
		try {
			String hql = "from Item as a where a.itemName like '%"+name+"%' order by "+cond+"  desc";
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByNameAndCategory(String  name,String Category) {
		log.debug("finding Item instance by example");
		try {
			String hql = "from Item as a where a.itemName like '%"+name+"%' and a.itemType = '"+ 
			Category+"'";
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
