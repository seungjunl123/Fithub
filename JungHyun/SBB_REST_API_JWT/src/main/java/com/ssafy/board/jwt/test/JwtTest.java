package com.ssafy.board.jwt.test;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

//main를 만들고 테스트 용도로만 확인 해볼것
public class JwtTest {
	public static void main(String[] args) throws InterruptedException {
		Map<String, String> headers = new HashMap<>();
		headers.put("typ", "JWT");
		
		String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
		
		
		//JWT 3가지 파트 헤더 / 페이로드 / 서명
		String token = Jwts.builder() //JWT를 만들 수 있는 빌더 인스턴스야
		.header()      //빌더 헤더 객체가 되었다.
		.add("name", "yang").add(headers).and() //and() 메서드를 JWT 빌더로 돌아간다.
		.subject("ssafy").expiration(new Date(System.currentTimeMillis()+3000))
		.signWith(secretKey).compact();
		
		System.out.println(token);
		
		Thread.sleep(4000);
		
		Jws<Claims> jwsClaims =  Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
		
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
		
	}
}
