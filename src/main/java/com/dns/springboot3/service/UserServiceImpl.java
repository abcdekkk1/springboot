package com.dns.springboot3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.springboot3.entities.User;
import com.dns.springboot3.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepository;  

	  @Override  
	  public List<User> getAllUser() {  
	    return (List<User>) userRepository.findAll();  
	  }  

	  @Override  
	  public void saveUser(User user) {  
	    userRepository.save(user);  
	  }

	@Override
	public void deleteUser(Long id) {
		
		userRepository.delete(id);
	}

	@Override
	public Optional<User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}  

//	  @Override  
//	  public void deleteUser(Long id) {  
//	    userRepository.delete(id);  
//	  }  

//	  @Override  
//	  public Optional<User> findUserById(Long id) {  
//	    return userRepository.findOne(id); 
//	  }  
}
