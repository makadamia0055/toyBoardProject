package com.ppl.toyboard.root.dao;

import java.util.List;

import com.ppl.toyboard.root.entity.User;

public interface LoginDAO {

	User getUser(User user);
	
	void insertUser(User user);

	List<User> getAllUser();
	
	void deleteAllUser();

	int countAllUser();

}
