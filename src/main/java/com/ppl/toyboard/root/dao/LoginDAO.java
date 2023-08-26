package com.ppl.toyboard.root.dao;

import com.ppl.toyboard.root.vo.UserVO;

public interface LoginDAO {

	UserVO getUser(UserVO user);
	
	void insertUser(UserVO user);

}
