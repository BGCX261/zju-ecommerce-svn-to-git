package com.ecommerce.hiDAO;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Digital;

/**
 * A data access object (DAO) providing persistence and search support for
 * Digital entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Digital
 * @author MyEclipse Persistence Tools
 */

public class DigitalDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DigitalDAO.class);
	// property constants
	public static final String DIGITAL_TYPE = "digitalType";
	public static final String USED_TIME = "usedTime";
	public static final String ORIGIN_PRICE = "originPrice";

	public void save(Digital transientInstance) {
		log.debug("saving Digital instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Digital persistentInstance) {
		log.debug("deleting Digital instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Digital findById(java.lang.Integer id) {
		log.debug("getting Digital instance with id: " + id);
		try {
			Digital instance = (Digital) getSession().get(
					"com.ecommerce.hiBean.Digital", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Digital instance) {
		log.debug("finding Digital instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Digital")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Digital instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Digital as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDigitalType(Object digitalType) {
		return findByProperty(DIGITAL_TYPE, digitalType);
	}

	public List findByUsedTime(Object usedTime) {
		return findByProperty(USED_TIME, usedTime);
	}

	public List findByOriginPrice(Object originPrice) {
		return findByProperty(ORIGIN_PRICE, originPrice);
	}

	public List findAll() {
		log.debug("finding all Digital instances");
		try {
			String queryString = "from Digital";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Digital merge(Digital detachedInstance) {
		log.debug("merging Digital instance");
		try {
			Digital result = (Digital) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Digital instance) {
		log.debug("attaching dirty Digital instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Digital instance) {
		log.debug("attaching clean Digital instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
