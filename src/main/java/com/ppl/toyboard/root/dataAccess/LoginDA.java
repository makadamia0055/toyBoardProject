package com.ppl.toyboard.root.dataAccess;

import java.util.List;

import com.ppl.toyboard.root.entity.User;

public interface LoginDA {

	User getUser(User user);
	
	void insertUser(User user);

	List<User> getAllUser();
	
	void deleteAllUser();

	int countAllUser();

}
