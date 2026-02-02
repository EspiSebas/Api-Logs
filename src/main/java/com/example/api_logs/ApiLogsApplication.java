package com.example.api_logs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiLogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLogsApplication.class, args);
	}

}
