package com.ppl.toyboard.root.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ppl.toyboard.root.entity.User;


@Repository
public class LoginDAOJpa implements LoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 */
	@Transactional
	@Override
	public User getUser(User user) {
		return (User) em.find(User.class, user.getUs_id());
	}
	/**
	 * 
	 */
	@Transactional
	@Override
	public void insertUser(User user) {
		em.persist(user);
	}
	@Transactional
	@Override
	public void deleteAllUser() {
		List<User> list = getAllUser();
		for(User tmp : list) {
			em.remove(tmp);
		}
	}
	@Transactional
	@Override
	public int countAllUser() {
		List<User> list = getAllUser();
		return list.size();
	}
	@Transactional
	@Override
	public List<User> getAllUser() {
		String jpql = "select u from UserVO u order by u.us_id desc";
		List<User> list = em.createQuery(jpql, User.class).getResultList();
		return list;
	}

}
