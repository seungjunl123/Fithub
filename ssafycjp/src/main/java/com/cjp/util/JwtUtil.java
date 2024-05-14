package com.cjp.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
	private SecretKey secretkey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	
	// 다양한 데이터를 맵으로 받아서 처리할 수 있지만 지금은 id만 받아서 사용해보겠다
	public String CreateToken(String id) {
		Date exp = new Date(System.currentTimeMillis()+1000*3600); // 1시간 유효
		return Jwts.builder().header().add("typ","JWT").and().claim("id", id)
				.expiration(exp).signWith(secretkey).compact();
	}
	
	// 실제 확인하는 용도는 아니고 유효기간이 지났다면 알아서 에러를 발생시키려고 함
	public Jws<Claims> validate(String token){
		return Jwts.parser().verifyWith(secretkey).build().parseSignedClaims(token);
	}
}
