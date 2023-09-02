package com.ppl.toyboard.root.dataAccess;

import java.util.List;

import com.ppl.toyboard.root.entity.User;

public interface UserDA {

	User getUser(String user);
	
	void insertUser(User user);

	List<User> getAllUser();
	
	void deleteAllUser();

	int countAllUser();

	boolean isNickNameDuplicated(String us_nickname);


}
