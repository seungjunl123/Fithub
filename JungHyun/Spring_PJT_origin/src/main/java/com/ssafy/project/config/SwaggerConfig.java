package com.ssafy.project.config;

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
	              .info(new Info().title("SSAFIT Spring Project")
	              .description("1팀 오승준, 이정현")
	              .version("v0.0.1")
	              .license(new License().name("SSAFY").url("https://www.ssafy.com")));
	  }
}
