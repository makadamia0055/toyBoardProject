package com.ppl.toyboard.root.common;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.Entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.entity.User;
import com.ppl.toyboard.root.mapStruct.UserMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:test-Business-layer.xml")
public class MapStructTest {
	
	
	@Test
	public void mapLoginDTOToEntity() {
		LoginUserDTO loginUserDto = new LoginUserDTO();
		loginUserDto.setUs_id("mak123");
		loginUserDto.setUs_pw("mak123Pw");
		
		User entityUser = UserMapper.INSTANCE.toEntity(loginUserDto);
		assertEquals("mak123", entityUser.getUs_id());
		assertEquals("mak123Pw", entityUser.getUs_pw());
		assertTrue(entityUser instanceof Entity);
	}
	
}
