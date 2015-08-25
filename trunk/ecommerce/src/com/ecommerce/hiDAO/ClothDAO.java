package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Cloth;

/**
 * A data access object (DAO) providing persistence and search support for Cloth
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Cloth
 * @author MyEclipse Persistence Tools
 */

public class ClothDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClothDAO.class);
	// property constants
	public static final String CLOTH_TYPE = "clothType";
	public static final String BRAND = "brand";
	public static final String CONSUMER = "consumer";
	public static final String CONSUMER_GENDER = "consumerGender";
	public static final String STYLE = "style";
	public static final String SIZE = "size";
	public static final String COLOR = "color";
	public static final String MATERIAL = "material";

	public void save(Cloth transientInstance) {
		log.debug("saving Cloth instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cloth persistentInstance) {
		log.debug("deleting Cloth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cloth findById(java.lang.Integer id) {
		log.debug("getting Cloth instance with id: " + id);
		try {
			Cloth instance = (Cloth) getSession().get(
					"com.ecommerce.hiBean.Cloth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cloth instance) {
		log.debug("finding Cloth instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Cloth").add(Example.create(instance))
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
		log.debug("finding Cloth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cloth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClothType(Object clothType) {
		return findByProperty(CLOTH_TYPE, clothType);
	}

	public List findByBrand(Object brand) {
		return findByProperty(BRAND, brand);
	}

	public List findByConsumer(Object consumer) {
		return findByProperty(CONSUMER, consumer);
	}

	public List findByConsumerGender(Object consumerGender) {
		return findByProperty(CONSUMER_GENDER, consumerGender);
	}

	public List findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	public List findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List findByColor(Object color) {
		return findByProperty(COLOR, color);
	}

	public List findByMaterial(Object material) {
		return findByProperty(MATERIAL, material);
	}

	public List findAll() {
		log.debug("finding all Cloth instances");
		try {
			String queryString = "from Cloth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cloth merge(Cloth detachedInstance) {
		log.debug("merging Cloth instance");
		try {
			Cloth result = (Cloth) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cloth instance) {
		log.debug("attaching dirty Cloth instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cloth instance) {
		log.debug("attaching clean Cloth instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
