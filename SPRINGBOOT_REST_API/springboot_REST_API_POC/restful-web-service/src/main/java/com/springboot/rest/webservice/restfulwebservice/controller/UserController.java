package com.springboot.rest.webservice.restfulwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.webservice.restfulwebservice.ExceptionHandling.UserNotFoundException;
import com.springboot.rest.webservice.restfulwebservice.model.User;
import com.springboot.rest.webservice.restfulwebservice.serviceWithoutDB.UserDaoService;

@RestController
public class UserController {
	
	//Constructor Injection
	private UserDaoService service;	
	public UserController(UserDaoService service){
		this.service = service;
	}
    
	//GET
	@GetMapping("/users")
	public List<User> retriveAll(){
		return service.findAll();
	}
	
	//GET
	@GetMapping("/users/{id}")
	public User findOneUser(@PathVariable("id") int id){
	    User userData = service.findOne(id);
	    
	    if(userData == null)
	       throw new UserNotFoundException("id - Not found" + id);
	    	
	    return userData;
		//return service.findOne(id);
	}
	
	//POST - for adding/create a resource - without sending the response code
	//@PostMapping("/users")
	public void saveUser(@RequestBody User user){
	  service.save1(user);	
	}
	
	//POST - create/add a resource - and return the response code using ResponseEntity
	@PostMapping("/users")
	public ResponseEntity<User> saveUser2(@Valid @RequestBody User user){
		User savedData = service.save(user);	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				       .path("{id}")
				       .buildAndExpand(savedData.getId()) //it will replace the pathvariable id with the saved data id
				       .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//Delete user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id){
	    service.deleteById(id);
	    
	}
}
