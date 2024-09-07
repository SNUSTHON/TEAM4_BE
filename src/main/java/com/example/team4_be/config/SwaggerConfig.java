package com.example.team4_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
			.title("윤슬 API Document")
			.version("1.0")
			.description(
				"환영합니다! [윤슬](https://example.com)는 가족간의 소통을 위해 만들어진 플랫폼입니다. 이 API 문서는 윤슬의 API를 사용하는 방법을 설명합니다.\n")
			.contact(new io.swagger.v3.oas.models.info.Contact().email("wnddms12345@gmail.com"));


		return new OpenAPI()
			.addServersItem(new Server().url("http://localhost:8080"))
			.addServersItem(new Server().url("http://10.50.34.123:8080"))
			.addServersItem(new Server().url("http://10.50.33.214:8080"))
			.components(new Components())
			.info(info);
	}
}
