package com.cai.blog.mapper;

import com.cai.blog.entity.Leave;
import com.cai.blog.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by caiyl on 2018/2/8.
 */
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    int getLeaveId();
}
