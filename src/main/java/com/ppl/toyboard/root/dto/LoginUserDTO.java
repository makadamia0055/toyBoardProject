package com.ppl.toyboard.root.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginUserDTO {
	private String us_id;
	private String us_pw;
	
	@Builder
	LoginUserDTO(String us_id, String us_pw){
		this.us_id = us_id;
		this.us_pw = us_pw;
	}
}
