package com.ppl.toyboard.root.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ppl.toyboard.root.dao.LoginDAO;
import com.ppl.toyboard.root.dao.LoginDAOJpa;
import com.ppl.toyboard.root.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:/**/business-layer.xml")
class LoginServiceImpTest {

	LoginDAO loginDAO = new LoginDAOJpa();
	LoginService loginService = new LoginServiceImp(loginDAO);
	
	@Test
	void testInsertUser() {
		//given
		UserVO user = new UserVO();
		user.setUs_id("mak123id");
		user.setUs_pw("mak123pw");
		user.setUs_nickname("maknick");
		user.setUs_auth(1);
		//when
		loginService.insertUser(user);
		//then
		UserVO findUser = loginService.getUser(user);
		assertEquals(user.getUs_id(), findUser.getUs_id());
	}

	@Disabled
	void testGetUser() {
		//given
		UserVO user = new UserVO();
		user.setUs_id("abc123");
		//when
		UserVO findUser = loginService.getUser(user);
		//then
		assertEquals(user.getUs_id(), findUser.getUs_id());
	}

}
