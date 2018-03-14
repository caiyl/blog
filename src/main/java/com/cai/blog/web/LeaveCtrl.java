package com.cai.blog.web;

import com.cai.blog.entity.Leave;
import com.cai.blog.entity.User;
import com.cai.blog.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caiyl on 2018/3/5.
 */
@RestController
@RequestMapping(value = "/leave")
public class LeaveCtrl {



    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String applyLeave(@ModelAttribute Leave leave,HttpServletRequest request){
        String ret = "1";
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            leave.setUserId(user.getUserName());
            leaveService.applyLeave(leave);
            ret = "0";
        }else{
            ret = "1";
        }

        return ret;
    }
    @RequestMapping(value = "/todoList", method = RequestMethod.GET)
    public String todoList(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            leaveService.todoList(user.getUserName());
        }else{
        }

        return "0";
    }
}
