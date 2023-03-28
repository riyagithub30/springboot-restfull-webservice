package com.springboot.rest.webservice.restfulwebservice.filtering;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean showCustomResponseProperties()
	{
		return new SomeBean("value1","value2","value3");
	}
	
	//Filter out the specific field applies on List also
	@GetMapping("/filtering-list")
	public List<SomeBean> showCustomResponseListProperties()
	{
		List<SomeBean> someBeanList = new ArrayList<SomeBean>();
		someBeanList.add(new SomeBean("value1","value2","value3"));
		someBeanList.add(new SomeBean("value4","value5","value6"));
		someBeanList.add(new SomeBean("value7","value8","value9"));
		
		return someBeanList;
	}

}
