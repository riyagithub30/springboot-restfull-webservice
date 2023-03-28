package com.springboot.rest.webservice.restfulwebservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservice.restfulwebservice.withH2DB.UserDetails;

public interface UserDetailsJpaRepository extends JpaRepository<UserDetails, Integer>{

}
