package com.cjp.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private static final String key = "SSAFY";
	private SecretKey secretkey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	// 만료 수명 1시간으로 설정 (1000*60*60)
	private static final long EXPIRATION_TIME = 1000*60*60;
	
	// JWT 생성
	public String createToken(String id) {
		return Jwts.builder()
				// 헤더 설정
//				.header().add("typ", "JWT").and()
				
				// 페이로드 설정 (JWT Claims)
				// 주제
				.subject(id)
				// 만료 시간 설정. 현재 시간 + 수명
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				// 발행 시간 설정
				.issuedAt(new Date())
				
				// 서명 알고리즘과 비밀 키 설정
				.signWith(secretkey)
				// JWT 문자열 생성
				.compact();
	}
	
	
//	public String CreateToken(String id) {
//		Date exp = new Date(System.currentTimeMillis()+1000*3600); // 1시간 유효
//		return Jwts.builder().header().add("typ","JWT").and().claim("id", id)
//				.expiration(exp).signWith(secretkey).compact();
//	}
	
//	public String createToken(String userId) {
//        return Jwts.builder()
//                .setSubject(userId)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
	
	
	// JWT 검증
	public boolean validate(String token) {
		try {
			Jwts.parser()
				.verifyWith(secretkey)
				// .keyLocator(keyLocator) // 동적으로 사용할 경우
				.build()
				.parse(token);
			// 유효한 토큰
			return true;
		} catch (Exception e) {
			// 유효하지 않은 토큰
			return false;
		}
	}
	
	
	// 토큰에서 정보 추출
	// 제대로 작동 되는지 확인 필요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String getIdFromToken(String token) {
		return Jwts.parser()
				.verifyWith(secretkey)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	
	// 실제 확인하는 용도는 아니고 유효기간이 지났다면 알아서 에러를 발생시키려고 함
//	public Jws<Claims> validate2(String token){
//		return Jwts.parser().verifyWith(secretkey).build().parseSignedClaims(token);
//	}
}
