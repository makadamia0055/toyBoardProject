package com.ppl.toyboard.root.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserVerifyResponseDTO {
	private boolean isVaild;
	private String us_nickname;
	private int user_Auth;
	
	@Builder
	public UserVerifyResponseDTO(boolean isVaild, String us_nickname, int user_Auth) {
		this.isVaild = isVaild;
		this.us_nickname = us_nickname;
		this.user_Auth = user_Auth;
	}
	
}
