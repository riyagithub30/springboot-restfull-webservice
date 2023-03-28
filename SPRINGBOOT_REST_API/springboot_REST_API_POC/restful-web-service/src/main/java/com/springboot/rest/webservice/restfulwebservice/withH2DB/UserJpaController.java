package com.springboot.rest.webservice.restfulwebservice.withH2DB;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservice.restfulwebservice.ExceptionHandling.UserNotFoundException;
import com.springboot.rest.webservice.restfulwebservice.jpa.UserDetailsJpaRepository;

@RestController
public class UserJpaController {
	
	private UserDetailsJpaRepository userDetailsJpaRepository;
	
	public UserJpaController(UserDetailsJpaRepository userDetailsJpaRepository){
		this.userDetailsJpaRepository = userDetailsJpaRepository;
	}
	
	
	@GetMapping("/jpa/userdetails")
	public List<UserDetails> getAllUserDetails()
	{
		return userDetailsJpaRepository.findAll();
	}
	
	@GetMapping("/jpa/userdetails/{id}")
	public UserDetails getUserDetailById(@PathVariable("id") int id){
		
		Optional<UserDetails> userDetails = userDetailsJpaRepository.findById(id);
		
		if(userDetails.isPresent())
			return userDetails.get();
		
		else
			throw new UserNotFoundException("Id not found" + id);
	
	}
	
	@PostMapping("/jpa/save")
	public String saveUserDetails(@RequestBody UserDetails userDetails){
		
		userDetailsJpaRepository.save(userDetails);
		
		return "Data Saved Successfully!!";
		
	}
	
	@DeleteMapping("/jpa/deleteUserDetails/{id}")
	public void deleteUserDetails(@PathVariable int id){
		
		Optional<UserDetails> userDetails = userDetailsJpaRepository.findById(id);
		if(userDetails.isPresent())
			userDetailsJpaRepository.deleteById(id);
		
		else
			throw new UserNotFoundException("Id not present !!" + id);
		
		
	}
	
	

}
