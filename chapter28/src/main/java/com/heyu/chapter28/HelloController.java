package com.heyu.chapter28;

import com.yuqiyu.chapter28.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义starter自动化配置HelloService
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/7/23
 * Time：11:42
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
public class HelloController
{
    //注入自定义starter内逻辑
    @Autowired
    HelloService helloService;

    /**
     * 测试访问地址/hello
     * @return 格式化字符串
     */
    @RequestMapping(value = "/hello")
    public String sayHello()
    {
        return helloService.sayHello();
    }
}