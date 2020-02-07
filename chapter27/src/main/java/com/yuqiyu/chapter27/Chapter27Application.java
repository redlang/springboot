package com.yuqiyu.chapter27;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
  *  在Spring内部中有多种方式实现监听如：
 * 1.@EventListener注解、
 * 2.实现ApplicationListener泛型接口、
 * 3.实现SmartApplicationListener
 *
 */
@SpringBootApplication
public class Chapter27Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter27Application.class, args);
	}
}
