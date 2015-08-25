package com.ecommerce.hiDAO;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.OrderItem;
import com.ecommerce.hiBean.OrderItemId;
import com.ecommerce.hiBean.Orders;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.OrderItem
 * @author MyEclipse Persistence Tools
 */

public class OrderItemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderItemDAO.class);

	// property constants

	public void save(OrderItem transientInstance) {
		log.debug("saving OrderItem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderItem persistentInstance) {
		log.debug("deleting OrderItem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderItem findById(OrderItemId id) {
		log.debug("getting OrderItem instance with id: " + id);
		try {
			OrderItem instance = (OrderItem) getSession().get(
					"com.ecommerce.hiBean.OrderItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderItem instance) {
		log.debug("finding OrderItem instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.OrderItem").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrderItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderItem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all OrderItem instances");
		try {
			String queryString = "from OrderItem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderItem merge(OrderItem detachedInstance) {
		log.debug("merging OrderItem instance");
		try {
			OrderItem result = (OrderItem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderItem instance) {
		log.debug("attaching dirty OrderItem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderItem instance) {
		log.debug("attaching clean OrderItem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findByOrder(Orders ord) {
		log.debug("finding all Orders instances");
		try {
			System.out.println("order id is:"+ord.getOrderId());
			String queryString = "from OrderItem where orderId='" + ord.getOrderId()+"'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}
