package com.ppl.toyboard.root.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.dto.RegisterUserDTO;
import com.ppl.toyboard.root.entity.User;
import com.ppl.toyboard.root.vo.UserVO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User toEntity(LoginUserDTO userDTO);
	
	User toEntity(RegisterUserDTO userDTO);
	  
	User toEntity(UserVO userVO);
	
}
