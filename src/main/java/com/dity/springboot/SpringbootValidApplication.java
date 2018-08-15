package com.dity.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
@ServletComponentScan
public class SpringbootValidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootValidApplication.class, args);
	}


	/**
	 * 支持controller层方法入参的校验
	 * @return
	 */
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor(){
		return new MethodValidationPostProcessor();
	}
}
