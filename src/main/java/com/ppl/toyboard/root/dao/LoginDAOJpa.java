package com.ppl.toyboard.root.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Lazy;
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
	@Transactional
	@Override
	public void deleteAllUser() {
		List<UserVO> list = getAllUser();
		for(UserVO tmp : list) {
			em.remove(tmp);
		}
	}
	@Transactional
	@Override
	public int countAllUser() {
		List<UserVO> list = getAllUser();
		return list.size();
	}
	@Transactional
	@Override
	public List<UserVO> getAllUser() {
		String jpql = "select u from UserVO u order by u.us_id desc";
		List<UserVO> list = em.createQuery(jpql, UserVO.class).getResultList();
		return list;
	}

}
