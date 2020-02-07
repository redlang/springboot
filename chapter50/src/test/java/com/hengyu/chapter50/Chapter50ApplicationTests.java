package com.hengyu.chapter50;

import com.hengyu.chapter50.service.UserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter50ApplicationTests {
	/**
	 * 使用@Rule注释激活ContiPerf，
	 * 通过@Test指定测试方法，
	 * @PerfTest指定调用次数和线程数量，
	 * @Required指定性能要求（每次执行的最长时间，平均时间，总时间等）。
	 */
	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	/**
	 * 用户业务逻辑注入
	 */
	@Autowired
	private UserService userService;

	/**
	 * 性能测试
	 * 10万次查询，100个线程同时操作findAll方法
	 */
	@Test
	@PerfTest(invocations = 100000, threads = 100)
	public void contextLoads() {
		userService.findAll();
	}

	/**
	 * 测试全部缓存
	 */
	@Test
	public void findAll() {
		userService.findAll();
	}


}
