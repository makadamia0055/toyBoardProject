package com.ppl.toyboard.root.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticateUser {
	private String us_id;
	private String us_nickname;
	private int user_Auth;
}
