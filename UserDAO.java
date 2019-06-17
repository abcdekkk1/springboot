package com.example.demo2.dao;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.entity.AppUser;



@Repository
@Transactional
public class UserDAO {
	@Autowired
	private EntityManager entityManager;
	public AppUser findUserAccount(String userName) {
		try {
			String sql = "select e from " + AppUser.class.getName() +"e"+"Where e.userName= :userName";
			Query query = entityManager.createQuery(sql,AppUser.class);
			query.setParameter("userName", userName);
			return (AppUser)query.getSingleResult();
		} catch (NoResultException e) {
			return null;
			
		}
	}

}
