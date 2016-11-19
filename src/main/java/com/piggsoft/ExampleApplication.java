package com.piggsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
}
