package com.cai.blog.web;

import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping("/jscode2session/{code}")
    @ResponseBody
    public String jscode2session(@PathVariable String code){
        System.out.println("code:"+code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx442fbd38e3a66a7f&secret=2cd91ee9b11cbaaf70611c32aff7cbc8&js_code="+code+"&grant_type=authorization_code";



        return "Hello! login!";
    }

}
