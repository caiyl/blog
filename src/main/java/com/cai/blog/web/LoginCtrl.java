package com.cai.blog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiyl on 2017/3/31.
 */
@RestController
public class LoginCtrl {

    @RequestMapping("/login")
    @ResponseBody
    public String hello(){
        return "Hello! login!";
    }
}
