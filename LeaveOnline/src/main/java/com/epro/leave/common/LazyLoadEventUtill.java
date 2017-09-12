package com.epro.leave.common;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.epro.infrastructure.hibernate4.service.GenericService;
import com.epro.infrastructure.util.BeanUtils;
public class LazyLoadEventUtill {

	public static <E> LazyLoadEventResponse<E> generateLazyLoadEventResponseByCriteria(
			LazyLoadEventRequest lazyLoadEventRequest
			,DetachedCriteria criteria 
			,GenericService genericService) {

		LazyLoadEventResponse<E> lazyResponse = null;
		try {

			Integer totalRecords = (int)genericService.countByCriteria((DetachedCriteria)BeanUtils.cloneObject(criteria));
			DetachedCriteria criteriaFilter = criteriaFilters(lazyLoadEventRequest, criteria);
			
			if(BeanUtils.isNotNull(lazyLoadEventRequest.getSortField()) && lazyLoadEventRequest.getSortOrder() == 1) {
				criteriaFilter.addOrder(Order.asc(lazyLoadEventRequest.getSortField()));
			}else if(BeanUtils.isNotNull(lazyLoadEventRequest.getSortField()) && lazyLoadEventRequest.getSortOrder() == -1) {
				criteriaFilter.addOrder(Order.desc(lazyLoadEventRequest.getSortField()));
			}
			
			List<E> listOfData = genericService.findByCriteria(criteriaFilter,lazyLoadEventRequest.getFirst(),lazyLoadEventRequest.getRows());
			lazyResponse = new LazyLoadEventResponse<E>(totalRecords, listOfData);
		} catch (Exception e) {
			throw e;
		}
		return lazyResponse;
	}
	
public static DetachedCriteria criteriaFilters(LazyLoadEventRequest lazyLoadEventRequest,DetachedCriteria criteria){
		
		if(BeanUtils.isNotEmpty(lazyLoadEventRequest.getFilters())) {
			
			for(String key:lazyLoadEventRequest.getFilters().keySet()){
				
				FilterMetadata filterMetadata = lazyLoadEventRequest.getFilters().get(key);
				if(BeanUtils.isNotNull(filterMetadata.getValue())) {
					criteria.add(Restrictions.ilike(key,  "%"+filterMetadata.getValue().trim()+"%"));
					//criteria.add(Restrictions.sqlRestriction(" to_char("+key+") LIKE '%"+filterMetadata.getValue().trim()+"%' "));
				}
				
			}
		}
		return criteria;
	}
	
}
