package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.StoreItem;
import com.ecommerce.hiBean.StoreItemId;

/**
 * A data access object (DAO) providing persistence and search support for
 * StoreItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.StoreItem
 * @author MyEclipse Persistence Tools
 */

public class StoreItemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StoreItemDAO.class);

	// property constants

	public void save(StoreItem transientInstance) {
		log.debug("saving StoreItem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StoreItem persistentInstance) {
		log.debug("deleting StoreItem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StoreItem findById(StoreItemId id) {
		log.debug("getting StoreItem instance with id: " + id);
		try {
			StoreItem instance = (StoreItem) getSession().get(
					"com.ecommerce.hiBean.StoreItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StoreItem instance) {
		log.debug("finding StoreItem instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.StoreItem").add(
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
		log.debug("finding StoreItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StoreItem as model where model."
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
		log.debug("finding all StoreItem instances");
		try {
			String queryString = "from StoreItem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StoreItem merge(StoreItem detachedInstance) {
		log.debug("merging StoreItem instance");
		try {
			StoreItem result = (StoreItem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StoreItem instance) {
		log.debug("attaching dirty StoreItem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StoreItem instance) {
		log.debug("attaching clean StoreItem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
