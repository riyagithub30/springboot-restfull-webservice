package com.springboot.rest.webservice.restfulwebservice.serviceWithoutDB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.springboot.rest.webservice.restfulwebservice.model.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 0;
	
	static{
		users.add(new User(++userCount,"Riya Biswas",LocalDate.now().minusYears(29)));
		users.add(new User(++userCount,"Tom",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Jerry" , LocalDate.now().minusYears(20)));
	}
	
	//return all users
	public List<User> findAll(){
		return users;
	}

	//return specific user
	 public User findOne(int id){
		/*with Functional programming
		 * Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();*/
		 
		 User user = new User();
		 
		 for(User tempUser : users ){
			 if(tempUser.getId() == id){
				 user.setId(id);
				 user.setName(tempUser.getName());
				 user.setBirthDate(tempUser.getBirthDate());
				 
				 return user;
			 }
		 }
		 return null;
		 
	 }
	 
	 //create/save/add a user - simple
	 public void save1(User user){
		 user.setId(++userCount);
		 users.add(user);
	 }
	 
	 //create/add a user and return the response code uing ResponseEntity
	 public User save(User user){
		 user.setId(++userCount);
		 users.add(user);
		 return user;
	 }
	 
	 //Delete a user
	 public void deleteById(int id){
		 
		/* Predicate<? super User> predicate = user -> user.getId().equals(id);
		 users.removeIf(predicate);		*/
		 
		 for(User tempUser : users){
			 if(tempUser.getId() == id)
				 users.remove(tempUser);
		}
		 
	 }
}
