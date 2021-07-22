package com.ya.performance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.ya.performance", "com.ya.performance.controller", "com.ya.performance.entities",
		"com.ya.performance.repository", "com.ya.performance.service", "com.ya.performance.exception","com.ya.performance.mail" })
public class YaPerformanceServerApplication implements CommandLineRunner {
		
	
	public static void main(String[] args) {
		SpringApplication.run(YaPerformanceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		runApp();
		
	}
	
	void runApp() {

	}

}
