package com.ppl.toyboard.root.common;

import java.util.Date;

import com.ppl.toyboard.root.dto.JwtDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

public class AuthHandlerImp implements AuthHandler {
	private JWTHandller jwtHandler;
	private final long dayMillisSec = 24*60*60*1000L;
	
	//생각해보니 이 클래스는 서블릿 단에서 실행될 거니까 DI가 적용 안되는거 아닌가 싶음. 
	AuthHandlerImp(JWTHandller jwtHandler){
		this.jwtHandler = jwtHandler;
	}
	
	@Override
	public JwtDTO checkAccessToken(JwtDTO jwtDto) {
		try {
			Claims accessClaim = jwtHandler.getClaims(jwtDto.getAccessToken());
			
		}catch(MalformedJwtException e) {
			// 아직 예외처리 로직을 공부 안해서 
			e.printStackTrace();
		}catch(SignatureException e) {
			// 아직 예외처리 로직을 공부 안해서 
			e.printStackTrace();
		}catch(ExpiredJwtException e) {
			// 리프레쉬 토큰 다시 보내달라는 요청 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public JwtDTO checkRefreshToken(JwtDTO jwtDto) {
		try {
			String refreshToken = jwtDto.getRefreshToken();
			Claims refreshTokenClaims = jwtHandler.getClaims(refreshToken);
			
			// DB에 저장된 리프레쉬 토큰과 맞는지 확인.
			String dbRefreshTokenID = 
			// 리프레쉬 토큰 재발급 위한 기한 체크
			if(isRefreshTokenExpiringSoon(refreshTokenClaims.getExpiration()){
				// 리프레쉬 토큰 하루 미만으로 재발급 로직
			}
			
		}catch(MalformedJwtException e) {
			
		}catch(SignatureException e) {
			
		}catch(ExpiredJwtException e) {
			//토큰 만료된 경우
			
			// 생각해보니 위의 세경우 모두와 다른 케이스를 묶어 Exception으로 처리해도 되겠다고 생각
		}
	}
	public boolean isRefreshTokenExpiringSoon(Date expireDate) {
		if(expireDate.getTime()-System.currentTimeMillis()<dayMillisSec) {
			return true;
		}
		return false;
	}
	
}
