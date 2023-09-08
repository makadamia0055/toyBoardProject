package com.ppl.toyboard.root.common;

import com.ppl.toyboard.root.dto.JwtDTO;

public interface AuthHandler {

	void registerRefreshTokenID(String us_id, String refreshToken);

	JwtDTO checkRefreshToken(JwtDTO jwtDto);

	JwtDTO checkAccessToken(JwtDTO jwtDto);


	

}
