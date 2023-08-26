package com.ppl.toyboard.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ppl.toyboard.root.vo.UserVO;

@Repository
public class LoginDAOJpa implements LoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 */
	@Transactional
	@Override
	public UserVO getUser(UserVO user) {
		
		return (UserVO) em.find(UserVO.class, user.getUs_id());
	}
	/**
	 * 
	 */
	@Transactional
	@Override
	public void insertUser(UserVO user) {
		em.persist(user);
	}

}
