package com.cai.blog.web;

import com.cai.blog.entity.UserEntity;
import com.cai.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
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
        List<UserEntity> list = userMapper.queryAllByMap(map);
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
    String postUser(@ModelAttribute UserEntity user){
        userMapper.insert(user);
        return "0";
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserEntity getUser(@PathVariable Long id){
        return userMapper.queryById(id);
    };

    /**
     * 修改
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    String putUser(@PathVariable Long id, @ModelAttribute UserEntity user){
        return "0";
    };

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Long id){
        userMapper.delete(id);
        return "0";
    };
}
