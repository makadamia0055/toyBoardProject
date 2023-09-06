package com.ppl.toyboard.root.common;

import java.security.Key;
import java.util.Date;

import com.ppl.toyboard.root.vo.UserVO;

import io.jsonwebtoken.Claims;

public interface JWTHandller {

	Claims setClaims(UserVO userVo);

	String createToken(Claims claims, Date expireDate);

	Claims getClaims(String token);

}
