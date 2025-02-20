package com.app.security;

import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.app.entities.Staff;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Value(value="${jwt.token.expiration.millis}")
	public long jwtExpiration;
	@Value(value="${jwt.token.secret}")
	public String jwtSecret;
	private Key jwtKey;
	
	@PostConstruct
	public void init() {
		jwtKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}
	
	public String createToken(Authentication auth) {
		Staff user = (Staff)auth.getPrincipal();
		String subject = "" + user.getStaffId(); //user.getUsername();	// user email
		String token = Jwts.builder()
			.setSubject(subject)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
			.signWith(jwtKey , SignatureAlgorithm.HS256)
			.compact();
		return token;
	}
	
	public String validateToken(String token) {
		JwtParser parser = Jwts.parserBuilder().setSigningKey(jwtKey).build();
		Claims claims = parser
							.parseClaimsJws(token)
							.getBody();
		String custId = claims.getSubject();
		return custId;
	}
}
