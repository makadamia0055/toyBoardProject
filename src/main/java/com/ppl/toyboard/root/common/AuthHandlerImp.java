package com.ppl.toyboard.root.common;

import java.util.Date;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.ppl.toyboard.root.dto.JwtDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthHandlerImp implements AuthHandler {
	private final long dayMillisSec = 24*60*60*1000L;
	private JWTProvider jwtProvider;
	private StringRedisTemplate redisTemplate;
	private final String REFRESH_TOKEN_KEY = "RFT";
	
	@Override
	public JwtDTO checkAccessToken(JwtDTO jwtDto) {
		try {
			Claims accessClaim = jwtProvider.getClaims(jwtDto.getAccessToken());
			String us_id = "";
			return null;
			
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
		return jwtDto;
	}
	@Override
	public JwtDTO checkRefreshToken(JwtDTO jwtDto) {
		try {
			String refreshToken = jwtDto.getRefreshToken();
			Claims refreshTokenClaims = jwtProvider.getClaims(refreshToken);
			//access토큰에서 인증정보 가져오기
			Claims accessTokenClaims = jwtProvider.getClaims(jwtDto.getAccessToken());
			String user_id = accessTokenClaims.getAudience();
			
			// DB에 저장된 리프레쉬 토큰과 맞는지 확인.
			if(!checkRefreshTokenID(refreshToken, user_id)) {
				throw new SignatureException("리프레쉬 토큰의 ID 불일치");
			}
			// 일단 리프레쉬 토큰과 엑세스 토큰 한번에 송신
			JwtDTO newJwt = jwtProvider.createJwt(accessTokenClaims);
			registerRefreshTokenID(user_id, newJwt.getRefreshToken());
			return newJwt;
		}catch(MalformedJwtException e) {
		}catch(SignatureException e) {
		}catch(ExpiredJwtException e) {
			//토큰 만료된 경우
			// 생각해보니 위의 세경우 모두와 다른 케이스를 묶어 Exception으로 처리해도 되겠다고 생각
		}
		return null;

	}
//  원래 리프레쉬 토큰 기한을 체크해서 오래되면 돌려주려고 했는데, 매 사용마다 갱신하면 그럴 필요가 없어짐.
//	public boolean isRefreshTokenExpiringSoon(Date expireDate) {
//		if(expireDate.getTime()-System.currentTimeMillis()<dayMillisSec) {
//			return true;
//		}
//		return false;
//	}
	@Override
	public void registerRefreshTokenID(String us_id, String refreshToken) {
		HashOperations<String, Object, Object> hashForRefreshToken = redisTemplate.opsForHash();
		String refreshTokenUUID = jwtProvider.getClaims(refreshToken).getId();
		hashForRefreshToken.put(REFRESH_TOKEN_KEY, us_id, refreshTokenUUID);
	}
	
	private boolean checkRefreshTokenID(String refreshToken, String us_id) {
		String refreshTokenUUID = jwtProvider.getClaims(refreshToken).getId();
		HashOperations<String, Object, Object> hashForRefreshToken = redisTemplate.opsForHash();
		String dbRefreshTokenUUID = (String) hashForRefreshToken.get(REFRESH_TOKEN_KEY, us_id);
		if(refreshTokenUUID.equals(dbRefreshTokenUUID)) {
			return true;
		}
		return false;
	}
	
}
