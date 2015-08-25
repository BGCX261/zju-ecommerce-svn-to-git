package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Superadmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * Superadmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Superadmin
 * @author MyEclipse Persistence Tools
 */

public class SuperadminDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SuperadminDAO.class);
	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_PWD = "adminPwd";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";

	public void save(Superadmin transientInstance) {
		log.debug("saving Superadmin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Superadmin persistentInstance) {
		log.debug("deleting Superadmin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Superadmin findById(java.lang.Integer id) {
		log.debug("getting Superadmin instance with id: " + id);
		try {
			Superadmin instance = (Superadmin) getSession().get(
					"com.ecommerce.hiBean.Superadmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Superadmin instance) {
		log.debug("finding Superadmin instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Superadmin").add(
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
		log.debug("finding Superadmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Superadmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List findByAdminPwd(Object adminPwd) {
		return findByProperty(ADMIN_PWD, adminPwd);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Superadmin instances");
		try {
			String queryString = "from Superadmin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Superadmin merge(Superadmin detachedInstance) {
		log.debug("merging Superadmin instance");
		try {
			Superadmin result = (Superadmin) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Superadmin instance) {
		log.debug("attaching dirty Superadmin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Superadmin instance) {
		log.debug("attaching clean Superadmin instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
