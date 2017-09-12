package com.epro.infrastructure.hibernate4.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 */

public interface GenericDao {
	
	final static String IS_OBJECT_ONE_ROW="IS_OBJECT_ONE_ROW";
	
	HibernateTemplate getHibernateTemplate();

    <T> T get(Class<T> entityClass, Serializable id);

    <T> T load(Class<T> entityClass, Serializable id);

    void save(Object transientObject);

    void update(Object transientObject);

    void saveOrUpdate(Object transientObject);

    void remove(Object persistentObject);

	void mergeAndRemove(Object entity);
    
    <T> T getByNamedQuery(String queryName, String paramName, Object value);
    
    Integer getMaxValue(DetachedCriteria criteria, String propertyName);
    
    String getMaxValueString(DetachedCriteria criteria, String propertyName);
    
    Date getMaxValueDate(DetachedCriteria criteria, String propertyName);
  
    <T> List<T> findAll(Class<T> entityClass);

    <T> List<T> findByCriteria(Class<T> T , Criterion... criterion);

    <T> List<T> findByCriteria(DetachedCriteria criteria);

    <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);
    
    List<?> find(String queryString, Object... values);
    
    List<?> findByNamedParam(String queryString,String paramName,Object value);
    
    List<?> findByNamedParam(String queryString,String[] paramName,Object[] value);
    
    <T> List<T> findByNamedQuery(String queryName);

    <T> List<T> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value);

    <T> List<T> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);

    <T> List<T> removeAll(Class<T> entityClass);
    
    <T> void removeAll(List<T> entityClass);

    Long countByCriteria(DetachedCriteria criteria);
    
    Long countDistinctByCriteria(DetachedCriteria criteria,String id);

	Date getMinValueDate(DetachedCriteria criteria, String propertyName);
	
	<T> List<T> queryHibernateBySQL(final StringBuilder SQL,final Map<String,Object> mapParameter,final Class<T> className);
	
	List<Map<String,Object>> queryHibernateBySQLToMap(final StringBuilder SQL,final Map<String,Object> mapParameter);
	
	Object queryHibernateBySQLToObject(final StringBuilder SQL,final Map<String,Object> mapParameter);

	Integer getMinValue(DetachedCriteria criteria, String propertyName);
	
	void flush();
}
