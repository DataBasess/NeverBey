package com.epro.infrastructure.hibernate4.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;
import com.epro.infrastructure.hibernate4.entity.AbstractEntityMobile;
import com.epro.infrastructure.hibernate4.entity.AbstractUserIDEntity;
import com.epro.infrastructure.security.entity.User;
import com.epro.infrastructure.util.BeanUtils;
import com.epro.infrastructure.util.SecurityContextUtils;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 */
@Repository
public class GenericDaoHibernate extends HibernateDaoSupport implements GenericDao  {
	
	@Autowired
	public GenericDaoHibernate(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}



	public <T> T get(Class<T> entityClass, Serializable id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    public <T> T load(Class<T> entityClass, Serializable id) {
        return (T) getHibernateTemplate().load(entityClass, id);
    }
	
	public void save(Object transientObject) {
		
		setObjectCreateUpdate(transientObject,"CREATE_UPDATE");  // set object Update by, Create by, Update Date, Create Date 
		
        getHibernateTemplate().save(transientObject);
    }

	public void update(Object transientObject) {
		System.err.println("1==>");
		setObjectCreateUpdate(transientObject,"UPDATE");  // set object Update by, Update Date
		System.err.println("2==>");
        getHibernateTemplate().update(transientObject);
        System.err.println("3==>");
        
    }

	public void saveOrUpdate(Object transientObject) {
		setObjectCreateUpdate(transientObject,"CREATE_UPDATE"); 
        getHibernateTemplate().saveOrUpdate(transientObject);
    }

	public void remove(Object persistentObject) {
        getHibernateTemplate().delete(persistentObject);
    }

	@SuppressWarnings("unchecked")
    public <T> T getByNamedQuery(String queryName, String paramName, Object value) {
       return (T) DataAccessUtils.uniqueResult(getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramName, value));
    }
	

	
	public Integer getMaxValue(DetachedCriteria criteria, String propertyName) {
    	criteria.setProjection(Projections.max(propertyName));
    	Integer object = (Integer) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
    	return object;
    }
	// add by dear
    public List<?> find(String queryString, Object... values) {
       return getHibernateTemplate().find(queryString, values);
    }
	// add by dear
    public List<?> findByNamedParam(String queryString,String paramName,Object value) {
       return  getHibernateTemplate().findByNamedParam(queryString, paramName, value);
    }
    
 // add by dear
    public List<?> findByNamedParam(String queryString,String[] paramName,Object[] value) {
       return  getHibernateTemplate().findByNamedParam(queryString, paramName, value);
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        return getHibernateTemplate().loadAll(entityClass);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findByCriteria(DetachedCriteria criteria) {
        return (List<T>) getHibernateTemplate().findByCriteria(criteria);
    }
    
   

    @SuppressWarnings("unchecked")
    public <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
        return (List<T>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
    }

    public Long countByCriteria(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        return DataAccessUtils.longResult(getHibernateTemplate().findByCriteria(criteria));
    }
    
    public Long countDistinctByCriteria(DetachedCriteria criteria,String id) {
        criteria.setProjection(Projections.countDistinct(id));
        return DataAccessUtils.longResult(getHibernateTemplate().findByCriteria(criteria));
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findByCriteria(Class<T> T , Criterion... criterion) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(T);
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQuery(String queryName) {
		return  (List<T>) getHibernateTemplate().findByNamedQuery(queryName);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value) {
		return (List<T>) getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramName, value);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
		return (List<T>) getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	public <T> List<T> removeAll(Class<T> entityClass) {
		List<T> rows = findAll(entityClass);
        getHibernateTemplate().deleteAll(rows);
        return rows;
	}

	public String getMaxValueString(DetachedCriteria criteria,String propertyName) {
		// TODO Auto-generated method stub
		
		criteria.setProjection(Projections.max(propertyName));
    	return (String) DataAccessUtils.singleResult(getHibernateTemplate().findByCriteria(criteria));
	}

	public <T> void removeAll(List<T> entityClass) {
		// TODO Auto-generated method stub
		getHibernateTemplate().deleteAll(entityClass);
	}
	
	private void setObjectCreateUpdate(Object entity,String action){
		String username= null;
		
		try {

			if(entity instanceof AbstractEntity || entity instanceof AbstractEntityMobile){
				if(entity instanceof AbstractEntityMobile){
						String userMobile =(String) PropertyUtils.getProperty(entity, "updatedBy");
						
						username =SecurityContextUtils.getPrincipal();
						if(BeanUtils.isNotEmpty(username)){
							PropertyUtils.setProperty(entity,"updatedBy", username);
						}
						if(BeanUtils.isNotEmpty(userMobile)){
							DetachedCriteria criteria = DetachedCriteria.forClass(com.epro.infrastructure.security.entity.User.class);
							criteria.add(Restrictions.eq("username",userMobile));
							criteria.add(Restrictions.eq("enabled",Boolean.TRUE));
							com.epro.infrastructure.security.entity.User user = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
							if(BeanUtils.isNotNull(user)){
								addPropertyVale(entity ,"employeeId",user.getEmployeeObjectemployeeId());
								addPropertyVale(entity ,"employeeName",user.getEmployeeObjectemployeeId().getEmployeeFullName());
							}
						}
						Date updatedDate =(Date) PropertyUtils.getProperty(entity, "updatedDate");
						if(BeanUtils.isNull(updatedDate)){
							addPropertyVale(entity ,"updatedDate",new Date());
						}else{
							addPropertyVale(entity ,"updatedDate",(Date) PropertyUtils.getProperty(entity, "updatedDate"));
						}
						if(action.equals("CREATE_UPDATE")){
							addPropertyVale(entity ,"createdDate",(Date) PropertyUtils.getProperty(entity, "updatedDate"));
							addPropertyVale(entity ,"createdBy",(String) PropertyUtils.getProperty(entity, "updatedBy"));
						}
					
				}else{
					username =SecurityContextUtils.getPrincipal();
					
					if(action.equals("CREATE_UPDATE")){
						if(BeanUtils.isNotEmpty(username)){
							addPropertyVale(entity ,"createdBy",username);
						}
						addPropertyVale(entity ,"createdDate",new Date());
					}//
					//action.equals("CREATE_UPDATE")
					if(BeanUtils.isNotEmpty(username)){
						addPropertyVale(entity ,"updatedBy",username);
					}
					addPropertyVale(entity ,"updatedDate",new Date());
					if(entity instanceof AbstractUserIDEntity && BeanUtils.isNotEmpty(username)){
						addPropertyVale(entity ,"userId",username);
					}
				}
		}else{
			//logger.debug("Not Class AbstractEntity..");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	private void addPropertyVale(Object entity, String prop, Object value) {
	    if (PropertyUtils.isWriteable(entity, prop)) {
	        try {
	            PropertyUtils.setProperty(entity, prop, value);
	        } catch (IllegalAccessException e) {
	            //logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (InvocationTargetException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	           // logger.warn("Add property ", e);
	        	e.printStackTrace();
	        }
	    }
	}

	public Date getMaxValueDate(DetachedCriteria criteria, String propertyName)
    {
    	try
    	{
	    	criteria.setProjection(Projections.max(propertyName));
	    	Object object = DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	    	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	    	
	    	return object==null?null:dt.parse(object.toString());
    	} 
    	catch (Exception e)
    	{
			e.printStackTrace();
			logger.debug(e);
			
			return null;
		}	
    }
    
	public Date getMinValueDate(DetachedCriteria criteria, String propertyName)
    {
    	try
    	{
	    	criteria.setProjection(Projections.min(propertyName));
	    	Object object = DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	    	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	    	
	    	return object==null?null:dt.parse(object.toString());
    	} 
    	catch (Exception e)
    	{
			logger.error(e.getMessage(),e);
			
			return null;
		}	
    }
    
    // create method by dear.
    public <T> List<T> queryHibernateBySQL(final StringBuilder SQL,final Map<String,Object> mapParameter,final Class<T> className) {
    	return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<T> doInHibernate(Session session)throws HibernateException {
			SQLQuery query = session.createSQLQuery(SQL.toString());
			
			for (String key : mapParameter.keySet()) {
				Object obj = mapParameter.get(key);
				if(obj instanceof Collection<?>){
					 query.setParameterList(key,(Collection<?>) obj);
				}else{
					 query.setParameter(key,obj);
				}
				
			}
			 query.setResultTransformer(Transformers.aliasToBean(className));
			return  query.list();
				}
			});	
    }
 // create method by dear.
    public List<Map<String,Object>> queryHibernateBySQLToMap(final StringBuilder SQL,final Map<String,Object> mapParameter) {
    	return getHibernateTemplate().execute(new HibernateCallback<List<Map<String,Object>>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Map<String,Object>> doInHibernate(Session session)throws HibernateException {
			SQLQuery query = session.createSQLQuery(SQL.toString());
			
			for (String key : mapParameter.keySet()) {
				Object obj = mapParameter.get(key);
				if(obj instanceof Collection<?>){
					 query.setParameterList(key,(Collection<?>) obj);
				}else{
					 query.setParameter(key,obj);
				}
				
			}
			 query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			return  query.list();
				}
			});	
    }
 // create method by dear.
   public Object queryHibernateBySQLToObject(final StringBuilder SQL,final Map<String,Object> mapParameter) {
    	return getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)throws HibernateException {
			SQLQuery query = session.createSQLQuery(SQL.toString());
			
			boolean isObjectOneRow = false;
			for (String key : mapParameter.keySet()) {
				Object obj = mapParameter.get(key);
				if(IS_OBJECT_ONE_ROW.equals(key) && ((obj instanceof String &&  "true".equals(obj)) || obj instanceof Boolean && (boolean)obj == true )){
					isObjectOneRow=true;
				}else{
					if(obj instanceof Collection<?>) query.setParameterList(key,(Collection<?>) obj);
					else query.setParameter(key,obj);
					
				}
			}
			 query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			 
			 if(isObjectOneRow) return  query.uniqueResult();
			 else return  query.list(); 
			 
				}
			});	
    }


public Integer getMinValue(DetachedCriteria criteria, String propertyName) {
	// TODO Auto-generated method stub
	criteria.setProjection(Projections.min(propertyName));
	Integer object = (Integer) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	return object;
}

public void flush() {
	// TODO Auto-generated method stub
	getHibernateTemplate().flush();
}



@Override
public void mergeAndRemove(Object entity) {
	// TODO Auto-generated method stub
	getHibernateTemplate().delete(getHibernateTemplate().merge(entity));
}
}
