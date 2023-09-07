package com.ppl.toyboard.root.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtDTO {
	private String accessToken;
	private String refreshToken;
	
	@Builder
	JwtDTO(String accessToken, String refreshToken){
		this.accessToken = accessToken;
		this.refreshToken= refreshToken;
	}
}
