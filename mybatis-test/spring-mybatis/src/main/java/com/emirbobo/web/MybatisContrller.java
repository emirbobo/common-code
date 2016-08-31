package com.emirbobo.web;

import com.emirbobo.web.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xijingbo on 2016-08-29.
 */
@Controller
public class MybatisContrller {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void add() {
        userMapper.insertOrUpdate("zhang-"+System.currentTimeMillis());
    }
    @RequestMapping(value = "/")
    public String home() {
        System.out.println("hello world");
        return "Hello World!";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
