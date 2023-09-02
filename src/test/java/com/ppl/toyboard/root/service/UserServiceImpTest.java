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

import com.ppl.toyboard.root.dto.RegisterUserDTO;
import com.ppl.toyboard.root.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
class UserServiceImpTest {

	@Autowired
	private UserService loginService;
	
	private RegisterUserDTO user2;

	
	@BeforeEach
	void insertDefaultUser() {
		RegisterUserDTO user1 = RegisterUserDTO.builder()
				.us_id("abc123")
				.us_pw("abc123pw")
				.us_nickname("abc123name")
				.build();
	
		
		loginService.insertUser(user1);
		
	}
	@BeforeEach
	void 테스트객체생성() {
		this.user2 = RegisterUserDTO.builder()
				.us_id("mak123")
				.us_pw("mak123pw")
				.us_nickname("mak123name")
				.build();
		
	}
	@AfterEach
	void deleteAllUser() {
		loginService.deleteAllUser();
	}
	
	@Test
	void testInsertUser() {
		//given
		assertNull(loginService.getUser(new UserVO(user2.getUs_id(), null, null, 0)));
		//when
		loginService.insertUser(user2);
		//then
		assertEquals(user2.getUs_id(), loginService.getUser(new UserVO(user2.getUs_id(), null, null, 0)).getUs_id());
	}

	@Test
	void testGetUser() {
		//given
		UserVO user = new UserVO("abc123", null, null, 1);
		
		//when
		UserVO findUser = loginService.getUser(user);
		//then
		assertEquals(user.getUs_id(), findUser.getUs_id());
	}
	@Test
	void turncateUserVO() {
		//given
		UserVO user = new UserVO("abc123", null, null, 1);
		
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
