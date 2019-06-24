package com.dns.springboot3.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dns.springboot3.entities.AppRole;
import com.dns.springboot3.entities.UserRole;

@Repository
@Transactional
public class AppRoleRepository {
	@Autowired
	private EntityManager entityManager;
	public List<String> getRoleNames(Long userId){
		String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userId = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
	}
	

}
