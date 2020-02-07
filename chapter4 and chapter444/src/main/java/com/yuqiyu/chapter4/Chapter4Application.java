package com.yuqiyu.chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//同一个配置文件的多数据源切换
@SpringBootApplication
//@EnableJpaRepositories("com.yuqiyu.chapter4.jpa")
//防止The bean 'XXXX' could not be registered...  
//basePackages里面的包要满足以上条件
//1.在当前运行类的包或其子包下
//2.包或其1层子包里面包含jpa类和使用jpa类(当前为controller类包)

@ComponentScan(basePackages= {"com.yuqiyu.chapter4.jpa","com.yuqiyu.chapter4.controller"})
public class Chapter4Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter4Application.class, args);
	}
}
