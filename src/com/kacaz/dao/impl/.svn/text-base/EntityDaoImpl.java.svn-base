package com.kacaz.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.kacaz.dao.EntityDao;

//import com.kacaz.dao.EntityDao;

@Repository(value="entityDao")
public class EntityDaoImpl implements EntityDao {
	@Resource
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#save(E)
	 */
	@Override
	public <E> boolean save(E e) {
		try {
			getCurrentSession().save(e);
			return true;
		} catch (RuntimeException re) {
//			throw re;
//			getCurrentSession()
		}
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#delete(E)
	 */
	@Override
	public<E> void delete(E e) {
//		log.debug("deleting ActivityParticipantList instance");
		try {
			getCurrentSession().delete(e);
//			log.debug("delete successful");
		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#findById(java.lang.Integer, E)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <E> E findById(java.lang.Integer id,E e) {
//		log.debug("getting ActivityParticipantList instance with id: " + id);
		try {
			e = (E) getCurrentSession()
					.get(e.getClass().getSimpleName(), id);
			return e;
		} catch (RuntimeException re) {
//			log.error("get failed", re);
			throw re;
//			return 
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#findByExample(E)
	 */
	@Override
	public <E> List<E> findByExample(
			E e) {
//		log.debug("finding ActivityParticipantList instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<E> results = (List<E>) getCurrentSession()
					.createCriteria(e.getClass())
					.add(create(e)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
			return results;
		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#findByProperty(java.lang.String, java.lang.Object, E)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public <E> List findByProperty(String propertyName, Object value,E e ) {
//		log.debug("finding ActivityParticipantList instance with property: "
//				+ propertyName + ", value: " + value);
		try {
			String queryString = "from "+e.getClass().getSimpleName()+" as model where model."
					+ propertyName + "= '"+value+"'";
			System.out.println(value+"这是hql："+queryString);
			Query queryObject = getCurrentSession().createQuery(queryString);
			System.out.println("aaaa");
//			queryObject.setParameter(0, value);
		
			System.out.println("的发大水"+queryObject.getQueryString());
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#findAll(E)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public <E> List findAll(E e) {
//		log.debug("finding all ActivityParticipantList instances");
		try {
			String queryString = "from "+e.getClass().getSimpleName();
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kacaz.dao.impl.EntityDao#merge(E)
	 */
	@Override
	public <E> E merge(
			E e) {
//		log.debug("merging ActivityParticipantList instance");
		try {
			@SuppressWarnings("unchecked")
			E result = (E) getCurrentSession()
					.merge(e);
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}

	
	
//	
//	public static ActivityParticipantListDAO getFromApplicationContext(
//			ApplicationContext ctx) {
//		return (ActivityParticipantListDAO) ctx
//				.getBean("ActivityParticipantListDAO");
//	}
	
	
	
	
	
	
	
	
	

}
