package com.codingapi;

import com.codingapi.push.server.utils.BeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerPushApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerPushApplication.class, args);
	}


	@Bean
	public BeanUtil springUtil() {
		return new BeanUtil();
	}


}
