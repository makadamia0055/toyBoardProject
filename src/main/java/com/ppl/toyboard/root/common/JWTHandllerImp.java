package com.ppl.toyboard.root.common;

import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTHandllerImp implements JWTHandller {
	private Key key;
	private String encodedKey;
	
	public JWTHandllerImp() {
		setKey();
	}
	
	
	private void setKey() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
	}
	
	
	@Override
	public Claims setClaims(UserVO userVo){
		String issuer = "ppl";
		String subject = "Auth";
		String audience = userVo.getUs_id();
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
	
}
