package com.yuqiyu.chapter4.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuqiyu.chapter4.entity.book.BookEntity;
import com.yuqiyu.chapter4.jpa.book.BookJPA;

import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * book：恒宇少年
 * Date：2017/4/4
 * Time：15:36
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookJPA bookJPA;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public List<BookEntity> list(){
        return bookJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public BookEntity save(BookEntity entity)
    {
        return bookJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<BookEntity> delete(Long id)
    {
        bookJPA.deleteById(id);
        return bookJPA.findAll();
    }

}
