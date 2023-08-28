package com.ppl.toyboard.root.common;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

class JWTHandllerImpTest {

	@Test
	void JWT만드는테스트() {
		// given
		String issuer = "ppl";
		String subject = "Auth";
		String audience = "testUser1";
		Date experedAt = Date.from(Instant.now().plus(Duration.ofDays(1L)));
		Date notBeforeAt = Date.from(Instant.now());
		Date issuedAt= Date.from(Instant.now());
		String jwtId = UUID.randomUUID().toString();
		
		//when
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		String jws = Jwts.builder()
				.setIssuer(issuer)
				.setSubject(subject)
				.setAudience(audience)
				.setExpiration(experedAt)
				.setNotBefore(notBeforeAt)
				.setIssuedAt(issuedAt)
				.setId(jwtId)
				.signWith(key)
				.compact();
		
		// peak
		System.out.println(jws);
	}
	@Test
	public void 만든JWT파싱테스트() {
		//given
		String jws = "eyJpc3MiOiJwcGwiLCJzdWIiOiJBdXRoIiwiYXVkIjoidGVzdFVzZXIxIiwiZXhwIjoxNjkzMjk5NjMwLCJuYmYiOjE2OTMyMTMyMzAsImlhdCI6MTY5MzIxMzIzMCwianRpIjoiNzA3MjQ2YTMtMmEyNC00MWE5LTgxNGItZTdlYThiMjVmM2ZlIn0";
		
				
		//when
		JwtParser jwtSubject = Jwts.parserBuilder().setSigningKey(Base64.getDecoder().decode())
				.build();
		Claims parseClaimsJws = jwtSubject.parseClaimsJws(jws).getBody();
		
		//then
		assertEquals("ppl", parseClaimsJws.getIssuer());
		assertEquals("Auth", parseClaimsJws.getSubject());
		assertEquals("testUser1", parseClaimsJws.getAudience());
		assertDoesNotThrow(()-> parseClaimsJws.getExpiration().toInstant().getEpochSecond());
		assertDoesNotThrow(()->parseClaimsJws.getNotBefore().toInstant().getEpochSecond());
		assertDoesNotThrow(()->parseClaimsJws.getIssuedAt().toInstant().getEpochSecond());
		assertDoesNotThrow(()->UUID.fromString(parseClaimsJws.getId()));
		
	}

}
