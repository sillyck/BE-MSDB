package com.api.demo.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	//1234
	//HEX: 5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5
	//base64: WZRHGrsBESr8wYFZ9sx0tPURuZgG2lmzyvWpwXPKz8U=
	
	private static final String SECRET_KEY = "5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5";
	
	public String getToken(UserDetails user) {
		return getToken(new HashMap<>(), user);
	}

	private String getToken(Map<String, Object> extraClaims, UserDetails user) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
