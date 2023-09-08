package com.ppl.toyboard.root.service;

import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.dto.RegisterUserDTO;
import com.ppl.toyboard.root.dto.UserVerifyResponseDTO;
import com.ppl.toyboard.root.vo.UserVO;

public interface UserService {

	
	boolean insertUser(RegisterUserDTO user);

	UserVO getUser(UserVO user);

	void deleteAllUser();
	
	int countAllUser();

	UserVO getUserById(String us_id);

	UserVerifyResponseDTO checkUser(LoginUserDTO user);
}
