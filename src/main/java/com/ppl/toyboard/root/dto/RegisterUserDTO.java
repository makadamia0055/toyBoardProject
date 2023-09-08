package com.ppl.toyboard.root.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RegisterUserDTO {
	private String us_id;
	private String us_pw;
	private String us_nickname;
	
	@Builder
	public RegisterUserDTO(String us_id, String us_pw, String us_nickname) {
		this.us_id = us_id;
		this.us_pw = us_pw;
		this.us_nickname = us_nickname;
	}
}
