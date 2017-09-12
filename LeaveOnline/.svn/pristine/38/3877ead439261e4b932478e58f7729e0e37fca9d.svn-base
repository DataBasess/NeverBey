package com.epro.infrastructure.hibernate4.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 */
public interface GenericService {
	
    <T> T get(Class<T> entityClass, Serializable id);

    <T> T load(Class<T> entityClass, Serializable id);

    void save(Object transientObject);

    void update(Object transientObject);

    void saveOrUpdate(Object transientObject);

    void remove(Object persistentObject);

    <T> void mergeAndRemove(List<T> list);
    
    void remove(Serializable id);
    
//    <T> T getByNamedQuery(String queryName, String paramName, Object value);
    
    Integer getMaxValue(DetachedCriteria criteria, String propertyName);
    
    String getMaxValueString(DetachedCriteria criteria, String propertyName);
    
    List<?> find(String queryString, Object... values);
    
    List<?> findByNamedParam(String queryString,String paramName,Object value);
    
    List<?> findByNamedParam(String queryString,String[] paramName,Object[] value);
    
    <T> List<T> findAll(Class<T> entityClass);

    <T> List<T> findByCriteria(Class<T> T , Criterion... criterion);

    <T> List<T> findByCriteria(DetachedCriteria criteria);

    <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);
    
    <T> List<T> findByNamedQuery(String queryName);
	
	<T> List<T> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value);
	
	<T> List<T> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);

    <T> List<T> removeAll(Class<T> entityClass);
    
    <T> void removeAll(List<T> entityClass);

    long countByCriteria(DetachedCriteria criteria);
    
    long countDistinctByCriteria(DetachedCriteria criteria,String id);
    
    Date getMaxValueDate(DetachedCriteria criteria, String propertyName);
    
    <T> List<T> queryHibernateBySQL(final StringBuilder SQL,final Map<String,Object> mapParameter,final Class<T> className);

}
