package com.cjp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SSAFY_11th_Daejeon_4_JHSJ")
	              .description("대전 4반 오승준 이정현 1학기 최종 프로젝트")
	              .version("v0.0.1")
	              .license(new License().name("SSAFY").url("https://www.ssafy.com")));
	  }
}
