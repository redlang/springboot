package com.heyu.chapter28;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//同一个配置文件的多数据源切换
@SpringBootApplication

public class Chapter28Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter28Application.class, args);
	}
}
