package com.ppl.toyboard.root.service;

import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.dto.RegisterUserDTO;
import com.ppl.toyboard.root.vo.UserVO;

public interface UserService {

	boolean checkUser(LoginUserDTO user);
	
	boolean insertUser(RegisterUserDTO user);

	UserVO getUser(UserVO user);

	void deleteAllUser();
	
	int countAllUser();
}
