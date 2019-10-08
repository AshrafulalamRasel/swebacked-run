package com.example.swerun.swerun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class SweRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweRunApplication.class, args);
	}

}
