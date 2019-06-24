package com.dns.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.dns.springboot3"})
@EnableJpaRepositories(basePackages="com.dns.springboot3.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.dns.springboot3.entities")
public class SpringBoot3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3Application.class, args);
	}

}
