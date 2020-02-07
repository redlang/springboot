package com.yuqiyu.chapter444;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//多配置文件的手动切换
@SpringBootApplication
//@EnableJpaRepositories("com.yuqiyu.chapter444.jpa")
//防止The bean 'XXXX' could not be registered...  
//basePackages里面的包要满足以上条件
//1.在当前运行类的包或其子包下
//2.包或其1层子包里面包含jpa类和使用jpa类(当前为controller类包)
@ComponentScan(basePackages= {"com.yuqiyu.chapter444.jpa","com.yuqiyu.chapter444.controller"})
public class Chapter444Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter444Application.class, args);
	}
}
