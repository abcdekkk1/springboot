package com.example.demo2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.entity.UserRole;



@Repository
@Transactional
public class RoleDAO {

	@Autowired
	private EntityManager entityManager;
	public List<String> getRoleNames(Long userId){
		String sql = "Select ur.appRole.roleName from "+ UserRole.class.getName() + "ur"+"Where ur.appUser.userId = :userId";
		Query query = this.entityManager.createQuery(sql,String.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
