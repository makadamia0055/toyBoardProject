package com.ppl.toyboard.root.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserDTO {
	private String us_id;
	private String us_pw;
	private String us_nickname;
}
