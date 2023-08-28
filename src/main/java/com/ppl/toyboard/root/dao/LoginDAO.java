package com.ppl.toyboard.root.dao;

import java.util.List;

import com.ppl.toyboard.root.vo.UserVO;

public interface LoginDAO {

	UserVO getUser(UserVO user);
	
	void insertUser(UserVO user);

	List<UserVO> getAllUser();
	
	void deleteAllUser();

	int countAllUser();

}
