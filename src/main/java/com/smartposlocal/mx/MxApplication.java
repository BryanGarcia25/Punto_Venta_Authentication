package com.smartposlocal.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.smartposlocal.mx.config.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class MxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxApplication.class, args);
	}

}
