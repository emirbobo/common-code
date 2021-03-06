package com.emirbobo.web;

import com.emirbobo.web.dao.UserMapper;
import com.emirbobo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.ServletContextPropertyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xijingbo on 2016-08-29.
 */
@Controller
public class MybatisContrller {

//    @Autowired
//    private  HttpServletRequest request;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void add() {
        userMapper.insertOrUpdate("zhang-"+System.currentTimeMillis());
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request,HttpServletResponse response) {
        System.out.println("Fetch All user");
        List users = userMapper.listAll();
        request.setAttribute("users",users);
        return "/list";
    }

    @RequestMapping(value = "/")
    public String home(HttpServletRequest request) {

        String agent = request.getHeader("user-agent");
        System.out.println("hello world " +agent);
        return "/index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
