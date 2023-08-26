package com.ppl.toyboard.root.service;

import com.ppl.toyboard.root.vo.UserVO;

public interface LoginService {

	boolean checkUserVO(UserVO user);
	
	void insertUser(UserVO user);

}
