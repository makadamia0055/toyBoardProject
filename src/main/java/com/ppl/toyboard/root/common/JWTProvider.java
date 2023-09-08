package com.ppl.toyboard.root.common;

import java.util.Date;

import com.ppl.toyboard.root.dto.JwtDTO;

import io.jsonwebtoken.Claims;

public interface JWTProvider {

	Claims setClaims(String us_id);

	String createToken(Claims claims, Date expireDate);

	Claims getClaims(String token);

	Date getExpireDateAccessToken();

	Date getExpireDateRefreshToken();

	JwtDTO createJwt(Claims claims);


}
