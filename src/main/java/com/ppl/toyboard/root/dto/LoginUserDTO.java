package com.ppl.toyboard.root.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {
	private String us_id;
	private String us_pw;
	

	
//	LoginUserDTO(String us_id, String us_pw){
//		this.us_id = us_id;
//		this.us_pw = us_pw;
//	}
}
