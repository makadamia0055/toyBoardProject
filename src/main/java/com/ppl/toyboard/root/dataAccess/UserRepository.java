package com.ppl.toyboard.root.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ppl.toyboard.root.entity.User;

@Transactional
@Repository
public class UserRepository implements UserDA {
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 */
	
	@Override // VO로 처리하다가 DTO 도입이후 매개변수 String으로 변경
	public User getUser(String user_id) {
		return (User) em.find(User.class, user_id);
	}
	/**
	 * 
	 */
	
	@Override
	public void insertUser(User user) {
		em.persist(user);
	}
	
	@Override
	public void deleteAllUser() {
		List<User> list = getAllUser();
		for(User tmp : list) {
			em.remove(tmp);
		}
	}
	
	@Override
	public int countAllUser() {
		List<User> list = getAllUser();
		return list.size();
	}
	
	@Override
	public List<User> getAllUser() {
		String jpql = "select u from User u order by u.us_id desc";
		List<User> list = em.createQuery(jpql, User.class).getResultList();
		return list;
	}
	@Override
	public boolean isNickNameDuplicated(String us_nickname) {
		String jpql = "select count(u) from User u where u.us_nickname = :nickname";
		if((long)em.createQuery(jpql).setParameter("nickname", us_nickname).getSingleResult()>0) {
			return true;
		}
		
		
		return false;
	}

}
