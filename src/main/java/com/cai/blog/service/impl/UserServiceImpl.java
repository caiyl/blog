package com.cai.blog.service.impl;

import com.cai.blog.entity.User;
import com.cai.blog.mapper.UserMapper;
import com.cai.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caiyl on 2018/3/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User isExists(User user) {
        return userMapper.queryByUserName(user.getUserName());
    }
}
