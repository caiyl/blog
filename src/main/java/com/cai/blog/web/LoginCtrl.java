package com.cai.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiyl on 2017/3/31.
 */
@RestController
public class LoginCtrl {

    @Autowired
    private Environment env;

    @RequestMapping("/login")
    @ResponseBody
    public String hello(){
        System.out.println(env.getProperty("host"));
        return "Hello! login!";
    }
}
