package com.cai.blog.web;

import com.cai.blog.entity.Leave;
import com.cai.blog.entity.User;
import com.cai.blog.mapper.UserMapper;
import com.cai.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caiyl on 2017/3/31.
 */
@RestController
@RequestMapping("/login")
public class LoginCtrl {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/loginState",method = RequestMethod.GET)
    public Object loginState(HttpServletRequest request){
        return request.getSession().getAttribute("user");
    }
    @ResponseBody
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "0";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String applyLeave(@ModelAttribute User user,HttpServletRequest request){

        User userDB = userService.isExists(user);
        if ((userDB != null && userDB.getPassword().equals(user.getPassword()))) {
            System.out.println("登录成功。。。");
            request.getSession().setAttribute("user",userDB);
            return "0";
        }else{
            System.out.println("登录失败。。。");
            return "1";
        }
    }


    @RequestMapping("/jscode2session/{code}")
    @ResponseBody
    public String jscode2session(@PathVariable String code){
        System.out.println("code:"+code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx442fbd38e3a66a7f&secret=2cd91ee9b11cbaaf70611c32aff7cbc8&js_code="+code+"&grant_type=authorization_code";



        return "Hello! login!";
    }

}
