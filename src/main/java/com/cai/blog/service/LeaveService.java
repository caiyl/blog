package com.cai.blog.service;

import com.cai.blog.entity.Leave;

/**
 * Created by caiyl on 2018/3/5.
 */
public interface LeaveService {
    void addLeave(Leave leave);
    Integer getLeaveId();

    void applyLeave(Leave leave);

    void todoList(String userName);
}
