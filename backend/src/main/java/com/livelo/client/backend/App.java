package com.livelo.client.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = "com.livelo.client.core.domain")
@ComponentScan(basePackages = "com.livelo.client")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
