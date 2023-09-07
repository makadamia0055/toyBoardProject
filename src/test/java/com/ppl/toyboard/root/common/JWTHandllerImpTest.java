package com.ppl.toyboard.root.common;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppl.toyboard.root.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

class JWTHandllerImpTest {
	private static Key key;
	private static String encodedKey;
	private static JWTHandller jwtHandler;
	
	@BeforeAll
	static void jwtHandler초기화() {
		jwtHandler = new JWTHandllerImp();
	}
	
	
	@BeforeAll
	static void 시크릿키만들기() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

	}
	
	@Test
	void GPTTestCase() {
		
	        // Create a JWT
	        String jwt = Jwts.builder()
	            .setSubject("user123")
	            .claim("role", "admin")
	            .signWith(key)
	            .compact();

	        // Parse the JWT
	        Claims claims = Jwts.parserBuilder()
	            .setSigningKey(Base64.getDecoder().decode(encodedKey))
	            .build()
	            .parseClaimsJws(jwt)
	            .getBody();

	        String subject = claims.getSubject();
	        String role = (String) claims.get("role");

	        System.out.println("Subject: " + subject);
	        System.out.println("Role: " + role);
	}
	
	
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
		
		JwtParser jwtSubject = Jwts.parserBuilder().setSigningKey(Base64.getDecoder().decode(encodedKey))
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
	@Test 
	void JWTHandlerTest() {
		UserVO user = new UserVO("mak123", "mak123", "mak123", 0);
		Claims claim = jwtHandler.setClaims(user);
		String token = jwtHandler.createToken(claim, Date.from(Instant.now().plus(Duration.ofHours(1))));
		Claims parseClaim = jwtHandler.getClaims(token);
		assertEquals(claim, parseClaim);
		
		UserVO user2 = new UserVO("asd123", "asd123", null, 0);
		Claims claim2 = jwtHandler.setClaims(user2);
		assertNotEquals(parseClaim, claim2);
		
	}

}
