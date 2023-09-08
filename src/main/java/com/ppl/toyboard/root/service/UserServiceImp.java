package com.ppl.toyboard.root.service;

import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.dataAccess.UserDA;
import com.ppl.toyboard.root.dto.LoginUserDTO;
import com.ppl.toyboard.root.dto.RegisterUserDTO;
import com.ppl.toyboard.root.dto.UserVerifyResponseDTO;
import com.ppl.toyboard.root.entity.User;
import com.ppl.toyboard.root.vo.UserVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

	private UserDA loginDA;

	@Override
	public boolean insertUser(RegisterUserDTO userDTO) {
		// validation 코드 필요
		// 아이디 체크
		if (loginDA.getUser(userDTO.getUs_id()) != null) {
			System.out.println("이미 가입된 회원 아이디");
			return false;
		}
		// 닉네임 중복 체크(모든 엔티티를 가져와서 하는 것보다 그냥 JPQL로 처리하는게 좋을 듯)
		if (loginDA.isNickNameDuplicated(userDTO.getUs_nickname())) {
			System.out.println("닉네임 중복으로 가입 실패");
			return false;
		}
		User user = User.builder().us_id(userDTO.getUs_id()).us_pw(userDTO.getUs_pw())
				.us_nickname(userDTO.getUs_nickname()).us_auth(0).build();
		loginDA.insertUser(user);
		return true;
	}

	@Override
	public UserVO getUser(UserVO user) {
		User dbUser = loginDA.getUser(user.getUs_id());
		if (dbUser == null) {
			return null;
		}
		return new UserVO(dbUser.getUs_id(), dbUser.getUs_pw(), dbUser.getUs_nickname(), dbUser.getUs_auth());
	}

	@Override
	public UserVO getUserById(String us_id) {
		User dbUser = loginDA.getUser(us_id);
		if (dbUser == null) {
			return null;
		}
		return new UserVO(dbUser.getUs_id(), dbUser.getUs_pw(), dbUser.getUs_nickname(), dbUser.getUs_auth());
	}

	
	  @Override 
	  public UserVerifyResponseDTO checkUser(LoginUserDTO user) { 
		  User dbUser = loginDA.getUser(user.getUs_id()); 
		  if(dbUser==null||!dbUser.getUs_id().equals(user.getUs_id())||!dbUser.getUs_pw().equals(user.getUs_pw())) {
			  System.out.println("로그인 시도 실패"); 
			  return UserVerifyResponseDTO.builder() 
					 .isVaild(false) 
					 .build(); 
			  }
		  System.out.println(dbUser.getUs_nickname() + " 유저 로그인 성공"); 
		  return UserVerifyResponseDTO.builder() 
				  .isVaild(true)
				  .us_nickname(dbUser.getUs_nickname()) 
				  .user_Auth(dbUser.getUs_auth())
				  .build(); 
		  }
	 

	@Override
	public void deleteAllUser() {
		loginDA.deleteAllUser();

	}

	@Override
	public int countAllUser() {
		return loginDA.countAllUser();
	}

}
