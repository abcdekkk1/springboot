package com.dns.springboot3.service;

import java.util.List;
import java.util.Optional;

import com.dns.springboot3.entities.User;

public interface UserService {
	List<User> getAllUser();  

	  void saveUser(User user);  

	  void deleteUser(Long id);  

	  Optional<User> findUserById(Long id);
}
