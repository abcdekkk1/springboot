package com.dns.springboot3.repositories;

import org.springframework.data.repository.CrudRepository;  
import org.springframework.stereotype.Repository;

import com.dns.springboot3.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}
