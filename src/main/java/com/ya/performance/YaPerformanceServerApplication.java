package com.ya.performance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
