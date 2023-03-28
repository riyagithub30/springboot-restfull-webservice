package com.springboot.rest.webservice.restfulwebservice.vertioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VertioningPersonController {
	
//URI Vertioning
	
	@GetMapping("/v1/person")
	public PersonV1 getPersonFirstUriVersion()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonSecondUriVersion()
	{
		return new PersonV2(new Name("Bob" , "Charlie"));
	}

//Request Param Vertioning
    //api end point = http://localhsot:8080/person?version=1
	@GetMapping(path = "/person" , params = "version=1")
	public PersonV1 getPersonFirstRequestParamVersion()
	{
		return new PersonV1("Bob Charlie");
	}
	
	//api end point = http://localhost:8080/person?version=2
	@GetMapping(path="/person" , params = "version=2")
	public PersonV2 getPersonSecondRequestParamVersion()
	{
		return new PersonV2(new Name("Bob" , "Charlie"));
	}
}
