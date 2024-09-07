package com.example.team4_be.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")  // 모든 경로에 대해 CORS 설정을 적용
			.allowedOrigins("http://localhost:5173", "http://localhost:3000","http://10.50.33.250:5173") // 허용할 도메인
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 허용할 HTTP 메서드
			.allowCredentials(true)  // 자격 증명(쿠키 등) 허용
			.allowedHeaders("*")     // 허용할 헤더
			.exposedHeaders("Authorization");  // 노출할 헤더(예: Authorization)
	}
}
