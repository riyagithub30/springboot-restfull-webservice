package com.springboot.rest.webservice.restfulwebservice.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Component
public class User {
	
	private int id;
	
	@Size(min = 2 , message = "Name should contain 2 charecters")
	@JsonProperty("user_name") //@JsonPropery annotation for customize REST API Response , json response will contain username instead of name
	private String name;
	
	@Past(message = "Birth date should be in past")
	@JsonProperty("birth_date") //JSOn response will have birth_date as response instead of birth_date
	private LocalDate birthDate;
	
	public User(){
		
	}
	
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
