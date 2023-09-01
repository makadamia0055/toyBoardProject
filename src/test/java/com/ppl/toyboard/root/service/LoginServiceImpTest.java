package com.ppl.toyboard.root.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ppl.toyboard.root.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
class LoginServiceImpTest {

	@Autowired
	private LoginService loginService;
	
	private UserVO user2;

	
	@BeforeEach
	void insertDefaultUser() {
		UserVO user1 = new UserVO("abc123", "abc123pw", "abc123name", 1);
	
		
		loginService.insertUser(user1);
		
	}
	@BeforeEach
	void 테스트객체생성() {
		this.user2 = new UserVO();
		user2.setUs_id("mak123id");
		user2.setUs_pw("mak123pw");
		user2.setUs_nickname("maknick");
		user2.setUs_auth(1);
	}
	@AfterEach
	void deleteAllUser() {
		loginService.deleteAllUser();
	}
	
	@Test
	void testInsertUser() {
		//given
		assertNull(loginService.getUser(user2));
		//when
		loginService.insertUser(user2);
		//then
		UserVO findUser = loginService.getUser(user2);
		assertEquals(user2.getUs_id(), findUser.getUs_id());
	}

	@Test
	void testGetUser() {
		//given
		UserVO user = new UserVO();
		user.setUs_id("abc123");
		//when
		UserVO findUser = loginService.getUser(user);
		//then
		assertEquals(user.getUs_id(), findUser.getUs_id());
	}
	@Test
	void turncateUserVO() {
		//given
		UserVO user = new UserVO();
		user.setUs_id("abc123");
		//when
		loginService.deleteAllUser();
		//then
		assertNull(loginService.getUser(user));
		assertEquals(0, loginService.countAllUser());
	}
	
	@Test
	void 카운트메서드테스트() {
		//given
		int cnt = loginService.countAllUser();
		
		//when
		loginService.insertUser(user2);
		
		//then
		assertEquals(cnt+1, loginService.countAllUser());
		
		loginService.deleteAllUser();
		assertEquals(0, loginService.countAllUser());
	}

}
