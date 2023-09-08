package com.ppl.toyboard.root.common;

import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.dto.JwtDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTProviderImp implements JWTProvider {
	private Key key;
	private String encodedKey;
	
	public JWTProviderImp() {
		setKey();
	}
	
	
	private void setKey() {
		// 서버 초기화하면 인증키 바꾼다
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
	}
	
	
	@Override
	public Claims setClaims(String us_id){
		String issuer = "ppl";
		String subject = "Auth";
		String audience = us_id;
		Date notBeforeAt = Date.from(Instant.now());
		Date issuedAt= Date.from(Instant.now());
		String jwtId = UUID.randomUUID().toString();
		
		Claims claims = Jwts.claims()
				.setIssuer(issuer)
				.setSubject(subject)
				.setAudience(audience)
				.setNotBefore(notBeforeAt)
				.setIssuedAt(issuedAt)
				.setId(jwtId);
		return claims;
	}
	
	
	@Override
	public String createToken(Claims claims, Date expireDate) {
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(expireDate)
				.signWith(key)
				.compact();
	}
	
	@Override
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	@Override
	public JwtDTO createJwt(Claims claims) {
        String accessToken = createToken(claims, getExpireDateAccessToken());
        String refreshToken = createToken((Claims) new HashMap<String, Object>(), getExpireDateRefreshToken());
        return JwtDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
	
	
	
	@Override
	public Date getExpireDateAccessToken() {
	        long expireTimeMils = 1000 * 60 * 60;
	        return new Date(System.currentTimeMillis() + expireTimeMils);
	}
	@Override
	public Date getExpireDateRefreshToken() {
	        long expireTimeMils = 1000L * 60 * 60 * 24 * 60;
	        return new Date(System.currentTimeMillis() + expireTimeMils);
	}
	
}
