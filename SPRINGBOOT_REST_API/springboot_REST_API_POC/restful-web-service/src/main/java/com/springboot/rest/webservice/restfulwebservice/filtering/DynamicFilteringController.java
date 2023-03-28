package com.springboot.rest.webservice.restfulwebservice.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	public SomeBeanDynamic showDynamicFiltering(){
		
		SomeBeanDynamic someBeanDynamic =new SomeBeanDynamic("value1","value2","value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanDynamic);
		//SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterExceptFilter("field1","field3");
		//SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		//FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter" , filter );
		//mappingJacksonValue.setFilters(filters );
		
		
		return someBeanDynamic;
	}

}
