package com.ppl.toyboard.root.common;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppl.toyboard.root.dto.JwtDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

public class AuthHandlerImp implements AuthHandler {
	private JWTHandller jwtHandler;
	private final long dayMillisSec = 24*60*60*1000L;
	
	@Autowired
	AuthHandlerImp(JWTHandller jwtHandler){
		this.jwtHandler = jwtHandler;
	}
	
	@Override
	public String checkRefleshToken(String refleshToken) {
		try {
			// 토큰 만료된 경우
			Claims refreshTokenClaims = jwtHandler.getClaims(refleshToken);
			// 리프레쉬 토큰 재발급 위한 기한 체크
			if(refreshTokenClaims.getExpiration().getTime()-System.currentTimeMillis()<dayMillisSec){
				// 리프레쉬 토큰 하루 미만으로 재발급 로직
				refleshToken = refreshRefreshToken(refleshToken);	
			}
			return refleshToken;
			
		}catch(MalformedJwtException e) {
			
		}catch(SignatureException e) {
			
		}catch(ExpiredJwtException e) {
			
		}
	}
	
	
	@Override
	public JwtDTO checkAccessToken(JwtDTO jwtDto) {
		try {
			Claims accessClaim = jwtHandler.getClaims(jwtDto.getAccessToken());
			String refleshToken = checkRefleshToken(jwtDto.getRefreshToken());
			return JwtDTO.builder()
					.accessToken(jwtHandler.createToken(accessClaim, new Date()))
					.refreshToken(jwtDto.getRefreshToken())
					.build();
		}catch(MalformedJwtException e) {
			
		
		}catch(SignatureException e) {
			
		}catch(ExpiredJwtException e) {
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
