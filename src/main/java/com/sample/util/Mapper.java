package com.sample.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

	ModelMapper m1 = new ModelMapper();
	   
	   public Mapper() {
		    m1.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);   
	   }
	   
	   public DTOEntity convertToDto(Object object, DTOEntity mapper) {
		      return m1.map(object, mapper.getClass());
	   }
	   
	   public Object convertToEntity(Object object, DTOEntity mapper) {
		      return m1.map(mapper, object.getClass());
	   } 
}
