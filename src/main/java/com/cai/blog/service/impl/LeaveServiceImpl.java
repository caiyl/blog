package com.cai.blog.service.impl;

import com.cai.blog.entity.Leave;
import com.cai.blog.mapper.LeaveMapper;
import com.cai.blog.service.LeaveService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by caiyl on 2018/3/5.
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public void addLeave(Leave leave) {
        Integer id = getLeaveId();
        leave.setId(id);
        leave.setApplyTime(new Date());
        leaveMapper.insert(leave);
    }

    @Override
    public Integer getLeaveId() {
        return leaveMapper.getLeaveId();
    }

    @Override
    public void applyLeave(Leave leave) {
        addLeave(leave);


        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(leave.getUserId());
        ProcessInstance processInstance = null;
        String businessKey = leave.getId().toString();

        //业务主键与流程实例id双向关联
        processInstance = runtimeService.startProcessInstanceByKey("leave", businessKey);
        leave.setProcessInstanceId(processInstance.getId());//
        leaveMapper.update(leave);

        System.out.println(processInstance.getId());

    }

    @Override
    public void todoList(String userName) {
//        taskService
        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateGroup("baoxiaozhuli");
        List<Task> taskList = taskQuery.list();
        for (Task task : taskList) {
            System.out.println("taskId:---->"+task.getId());
        }
    }
}
