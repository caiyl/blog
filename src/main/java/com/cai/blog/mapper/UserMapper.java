package com.cai.blog.mapper;

import com.cai.blog.entity.Role;
import com.cai.blog.entity.User;
import com.cai.blog.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by caiyl on 2017/10/2.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User queryByUserName(String userName);

    List<Role> getCandidateRole(String userName);

    List<Role> getUserRole(String userName);

    void deleteUserRole(String userName);

    void addUserRoleBatch(List<UserRole> userRoleList);
}
