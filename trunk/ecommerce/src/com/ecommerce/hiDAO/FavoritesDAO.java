package com.ecommerce.hiDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.hiBean.Favorites;
import com.ecommerce.hiBean.FavoritesId;
import com.ecommerce.hiBean.Item;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorites entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ecommerce.hiDAO.Favorites
 * @author MyEclipse Persistence Tools
 */

public class FavoritesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FavoritesDAO.class);
	// property constants
	public static final String ITEM_URL = "itemUrl";

	public void save(Favorites transientInstance) {
		log.debug("saving Favorites instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Favorites persistentInstance) {
		log.debug("deleting Favorites instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Favorites findById(FavoritesId id) {
		log.debug("getting Favorites instance with id: " + id);
		try {
			Favorites instance = (Favorites) getSession().get(
					"com.ecommerce.hiBean.Favorites", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Favorites instance) {
		log.debug("finding Favorites instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ecommerce.hiBean.Favorites").add(
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
		log.debug("finding Favorites instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Favorites as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemUrl(Object itemUrl) {
		return findByProperty(ITEM_URL, itemUrl);
	}

	public List findAll() {
		log.debug("finding all Favorites instances");
		try {
			String queryString = "from Favorites";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Favorites merge(Favorites detachedInstance) {
		log.debug("merging Favorites instance");
		try {
			Favorites result = (Favorites) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Favorites instance) {
		log.debug("attaching dirty Favorites instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Favorites instance) {
		log.debug("attaching clean Favorites instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	public List<Item> getItemsByUserId(Integer userId){
		String hql = "select item from Favorites as f where f.users.userId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, userId);
		return query.list();
	}
	
	public List findByNameAlike(String  name) {
		log.debug("finding Item instance by example");
		try {
			String hql = "from Favorites as a where a.item.itemName like '%"+name+"%'";
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	public static void main(String[] args){
		FavoritesDAO fd = new FavoritesDAO();
		List<Item> items = fd.getItemsByUserId(111);
		for(int i=0;i<items.size();i++){
			System.out.println(items.get(i).getItemName());
		}
	}
	
}
