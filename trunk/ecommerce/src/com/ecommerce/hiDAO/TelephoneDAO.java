package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Telephone;

/**
 * A data access object (DAO) providing persistence and search support for
 * Telephone entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Telephone
 * @author MyEclipse Persistence Tools
 */

public class TelephoneDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TelephoneDAO.class);
	// property constants
	public static final String SCREEN_SIZE = "screenSize";
	public static final String COLOR = "color";
	public static final String SYSTEM = "system";
	public static final String PIXELS = "pixels";
	public static final String STYLE = "style";
	public static final String BRAND = "brand";
	public static final String MEMORY = "memory";
	public static final String VERSION = "version";

	public void save(Telephone transientInstance) {
		log.debug("saving Telephone instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Telephone persistentInstance) {
		log.debug("deleting Telephone instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Telephone findById(java.lang.Integer id) {
		log.debug("getting Telephone instance with id: " + id);
		try {
			Telephone instance = (Telephone) getSession().get(
					"com.ecommerce.hiBean.Telephone", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Telephone instance) {
		log.debug("finding Telephone instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Telephone").add(
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
		log.debug("finding Telephone instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Telephone as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScreenSize(Object screenSize) {
		return findByProperty(SCREEN_SIZE, screenSize);
	}

	public List findByColor(Object color) {
		return findByProperty(COLOR, color);
	}

	public List findBySystem(Object system) {
		return findByProperty(SYSTEM, system);
	}

	public List findByPixels(Object pixels) {
		return findByProperty(PIXELS, pixels);
	}

	public List findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	public List findByBrand(Object brand) {
		return findByProperty(BRAND, brand);
	}

	public List findByMemory(Object memory) {
		return findByProperty(MEMORY, memory);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		log.debug("finding all Telephone instances");
		try {
			String queryString = "from Telephone";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Telephone merge(Telephone detachedInstance) {
		log.debug("merging Telephone instance");
		try {
			Telephone result = (Telephone) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Telephone instance) {
		log.debug("attaching dirty Telephone instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Telephone instance) {
		log.debug("attaching clean Telephone instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
