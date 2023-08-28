package com.ppl.toyboard.root.service;

import com.ppl.toyboard.root.vo.UserVO;

public interface LoginService {

	boolean checkUser(UserVO user);
	
	boolean insertUser(UserVO user);

	UserVO getUser(UserVO user);

	void deleteAllUser();
	
	int countAllUser();
}
