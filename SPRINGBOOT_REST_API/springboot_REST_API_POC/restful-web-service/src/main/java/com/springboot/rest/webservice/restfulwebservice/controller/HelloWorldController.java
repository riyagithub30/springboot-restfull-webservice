package com.springboot.rest.webservice.restfulwebservice.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//MessageSource autowire or constructor injection is required for invoking messages.properties files - i18n
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource){
		this.messageSource = messageSource;
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/hello-world-v1")
	public String sendMsg1()
	{
		return "Hello World!!!!!";
	}
	
	@GetMapping("/hello-world")
	public String sendMsg()
	{
		return "Hello World!!!!!";
	}
	
	//api end point for i18n - response in different language - content negotiation
	@GetMapping("/hello-world-i18n")
	public String showMessage()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "defaultMessage", locale );
		
		//return "Hello World!!!! i18n";
	}

}
