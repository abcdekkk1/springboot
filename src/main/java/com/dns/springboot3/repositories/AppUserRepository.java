package com.dns.springboot3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dns.springboot3.entities.AppUser;

@Repository
@Transactional
public class AppUserRepository {
	@Autowired
	private EntityManager entityManager;
	public AppUser findUserAccount(String userName) {
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
 
            return (AppUser) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
