package com.yuqiyu.chapter30;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.yuqiyu.chapter30.controller","com.yuqiyu.chapter30.jpa","com.yuqiyu.chapter30.mapper"})
public class Chapter30Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter30Application.class, args);
	}
}
