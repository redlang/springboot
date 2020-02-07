package com.yuqiyu.chapter26.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/6/18
 * Time：19:26
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Component
public class PrintTask { 
	/**cron属性
	 * Seconds : 可出现", - * /"四个字符，有效范围为0-59的整数
Minutes : 可出现", - * /"四个字符，有效范围为0-59的整数
Hours : 可出现", - * /"四个字符，有效范围为0-23的整数
DayofMonth : 可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
Month : 可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
DayofWeek : 可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
Year : 可出现", - * /"四个字符，有效范围为1970-2099年
	 * @throws Exception
	 */
	//@Scheduled(cron = "0 10 * * * *")每小时的10分执行该方法
    public void cron() throws Exception
    {
        System.out.println("执行测试cron时间："+ new Date(System.currentTimeMillis()));
    }


    /**
     * 是上一个调用开始后再次调用的延时（不用等待上一次调用完成）
     */
    //@Scheduled(fixedRate = 1000 * 1)
    public void fixedRate() throws Exception
    {
        Thread.sleep(2000);
        System.out.println("执行测试fixedRate时间："+ new Date(System.currentTimeMillis()));
    }

    /**
     * 上一个调用完成后再次调用的延时调用
     */
    //@Scheduled(fixedDelay = 1000 * 1)
    public void fixedDelay() throws Exception
    {
        Thread.sleep(3000);
        System.out.println("执行测试fixedDelay时间："+ new Date(System.currentTimeMillis()));
    }

    /**
     * 第一次被调用前的延时，单位毫秒
     */
    @Scheduled(initialDelay = 1000 * 10,fixedDelay = 1000 * 2)
    public void initialDelay() throws Exception
    {
        System.out.println("执行测试initialDelay时间："+ new Date(System.currentTimeMillis()));
    }

}
