package com.epro.infrastructure.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JQGridObjectMapper {
	
	public static  JQGridFilter map(String jsonString) {
		if (jsonString != null) {
			ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, JQGridFilter.class);
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
		}
		return null;
	}

}
