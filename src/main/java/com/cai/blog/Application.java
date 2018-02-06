package com.cai.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

	}
}
