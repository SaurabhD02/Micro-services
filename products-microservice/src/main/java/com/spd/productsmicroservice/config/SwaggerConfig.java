package com.spd.productsmicroservice.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI myCustomConfig() {
		return new OpenAPI().info(new Info().title("Products Microservice Documentation")
				.description("By Saurabh"))
				.servers(Arrays.asList(new Server().url("http://localhost:9091").description("local")));
	}

}
