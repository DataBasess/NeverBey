package com.epro.infrastructure.hibernate4.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epro.infrastructure.hibernate4.dao.GenericDao;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 */
@Service
@Transactional
public class GenericServiceHibernate implements GenericService {
	
	@Autowired
	private GenericDao genericDao;

	public void save(Object transientObject) {
		genericDao.save(transientObject);
	}

	public <T> T get(Class<T> entityClass, Serializable id) {
		return genericDao.get(entityClass, id);
	}

	public <T> T load(Class<T> entityClass, Serializable id) {
		return genericDao.load(entityClass, id);
	}

	public void remove(Object persistentObject) {
		genericDao.remove(persistentObject);
	}

	public void remove(Serializable id) {
		genericDao.remove(id);
	}

	public void saveOrUpdate(Object transientObject) {
		genericDao.saveOrUpdate(transientObject);
	}

	public void update(Object transientObject) {
		genericDao.update(transientObject);
	}
	
//	public <T> T getByNamedQuery(String queryName, String paramName, Object value) {
//		return genericDao.getByNamedQuery(queryName, paramName, value);
//	}
	
	public Integer getMaxValue(DetachedCriteria criteria, String propertyName) {
		return genericDao.getMaxValue(criteria, propertyName);
	}

	public <T> List<T> findByCriteria(DetachedCriteria criteria) {
		return genericDao.findByCriteria(criteria);
	}

	public <T> List<T> findAll(Class<T> entityClass) {
		return genericDao.findAll(entityClass);
	}

	public <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return genericDao.findByCriteria(criteria, firstResult, maxResults);
	}

	public long countByCriteria(DetachedCriteria criteria){
		return genericDao.countByCriteria(criteria);
	}
	
	public long countDistinctByCriteria(DetachedCriteria criteria,String id){
		return genericDao.countDistinctByCriteria(criteria,id);
	}
	// add by dear
    public List<?> find(String queryString, Object... values) {
       return genericDao.find(queryString, values);
    }
	// add by dear
    public List<?> findByNamedParam(String queryString,String paramName,Object value) {
       return  genericDao.findByNamedParam(queryString, paramName, value);
    }
    
 // add by dear
    public List<?> findByNamedParam(String queryString,String[] paramName,Object[] value) {
       return  genericDao.findByNamedParam(queryString, paramName, value);
    }

	public <T> List<T> findByCriteria(Class<T> T, Criterion... criterion) {
		return genericDao.findByCriteria(T, criterion);
	}

	public <T> List<T> findByNamedQuery(String queryName) {
		return genericDao.findByNamedQuery(queryName);
	}

	public <T> List<T> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value) {
		return genericDao.findByNamedQueryAndNamedParam(queryName, paramName, value);
	}

	public <T> List<T> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
		return genericDao.findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	public <T> List<T> removeAll(Class<T> entityClass) {
		return genericDao.removeAll(entityClass);
	}

	public String getMaxValueString(DetachedCriteria criteria,String propertyName) {
		return genericDao.getMaxValueString(criteria, propertyName);
	}

	@Override
	public <T> void removeAll(List<T> entityClass) {
		 genericDao.removeAll(entityClass);
		// TODO Auto-generated method stub
		
	}

	public Date getMaxValueDate(DetachedCriteria criteria,String propertyName) {
		return genericDao.getMaxValueDate(criteria, propertyName);
	}

	@Override
	public <T> List<T> queryHibernateBySQL(StringBuilder SQL, Map<String, Object> mapParameter, Class<T> className) {
		// TODO Auto-generated method stub
		return genericDao.queryHibernateBySQL(SQL, mapParameter, className);
	}

	@Override
	public <T> void mergeAndRemove(List<T> list) {
		// TODO Auto-generated method stub
		for(T entity : list) {
			genericDao.mergeAndRemove(entity);
		}
	}
	
}
