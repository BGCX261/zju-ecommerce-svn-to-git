package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.StoreRecord;
import com.ecommerce.hiBean.StoreRecordId;

/**
 * A data access object (DAO) providing persistence and search support for
 * StoreRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.StoreRecord
 * @author MyEclipse Persistence Tools
 */

public class StoreRecordDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StoreRecordDAO.class);

	// property constants

	public void save(StoreRecord transientInstance) {
		log.debug("saving StoreRecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StoreRecord persistentInstance) {
		log.debug("deleting StoreRecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StoreRecord findById(StoreRecordId id) {
		log.debug("getting StoreRecord instance with id: " + id);
		try {
			StoreRecord instance = (StoreRecord) getSession().get(
					"com.ecommerce.hiBean.StoreRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StoreRecord instance) {
		log.debug("finding StoreRecord instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.StoreRecord").add(
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
		log.debug("finding StoreRecord instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StoreRecord as model where model."
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
		log.debug("finding all StoreRecord instances");
		try {
			String queryString = "from StoreRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StoreRecord merge(StoreRecord detachedInstance) {
		log.debug("merging StoreRecord instance");
		try {
			StoreRecord result = (StoreRecord) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StoreRecord instance) {
		log.debug("attaching dirty StoreRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StoreRecord instance) {
		log.debug("attaching clean StoreRecord instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
