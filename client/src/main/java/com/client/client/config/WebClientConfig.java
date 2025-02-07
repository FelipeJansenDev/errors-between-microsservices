package com.client.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	RestClient restClient() {
		return  RestClient.create();
	}
}
