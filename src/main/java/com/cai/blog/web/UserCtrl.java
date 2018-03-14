package com.cai.blog.web;

import com.cai.blog.common.Result;
import com.cai.blog.entity.Role;
import com.cai.blog.entity.User;
import com.cai.blog.entity.UserRole;
import com.cai.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/user")
public class UserCtrl {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getUserList(@RequestParam(value = "rows", defaultValue = "1000", required = false) Integer rows,
                                 @RequestParam(value = "page", defaultValue = "1", required = false) Integer page){

        Map<String, String> map = new HashMap<String, String>();
        List<User> list = userMapper.queryAllByMap(map);
        int count = userMapper.queryAllCountByMap(map);

        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("page",page);
        retMap.put("records",count);
        retMap.put("rows",list);
        retMap.put("total",(int) (count/rows+1));


        return retMap;
    }





    /**
     * 保存
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    String postUser(@ModelAttribute User user){
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));

        if (Objects.nonNull(userMapper.queryByUserName(user.getUserName()))) {
            return Result.FAILED_CODE;
        }
        userMapper.insert(user);
        return Result.SUCCESS_CODE;
    }

    /**
     * 保存角色
     * @param roleCodeList
     * @return
     */
    @RequestMapping(value = "/{userName}", method = RequestMethod.POST)
    String postUser(@PathVariable String userName,@RequestBody List<String> roleCodeList ){
        userMapper.deleteUserRole(userName);
        List<UserRole> userRoleList = new ArrayList<UserRole>();
        for (String roleCode : roleCodeList) {
            UserRole role = new UserRole();
            role.setUserName(userName);
            role.setRoleCode(roleCode);
            userRoleList.add(role);
        }

        if (!userRoleList.isEmpty()) {
            userMapper.addUserRoleBatch(userRoleList);
        }

        return Result.SUCCESS_CODE;
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable String id){
        return userMapper.getOne(id);
    };

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping(value = "/",method=RequestMethod.PUT)
    String putUser( @ModelAttribute User user){
        userMapper.update(user);
        return Result.SUCCESS_CODE;
    };

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable String id){
        userMapper.delete(id);
        return Result.SUCCESS_CODE;
    };

    /**
     * 查询可以供该用户配置的角色
     * @param userName
     * @return
     */
    @RequestMapping(value = "/candidateRole/{userName}", method = RequestMethod.GET)
    List<Role> getCandidateRole(@PathVariable String userName){
        return userMapper.getCandidateRole(userName);
    };
    /**
     * 查询用户已经配置的角色
     * @param userName
     * @return
     */
    @RequestMapping(value = "/userRole/{userName}", method = RequestMethod.GET)
    List<Role> getUserRole(@PathVariable String userName){
        return userMapper.getUserRole(userName);
    };
}
