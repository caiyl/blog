package com.cai.blog.web;

import com.cai.blog.entity.Role;
import com.cai.blog.entity.User;
import com.cai.blog.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/role")
public class RoleCtrl {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getList(@RequestParam(value = "rows", defaultValue = "1000", required = false) Integer rows,
                                 @RequestParam(value = "page", defaultValue = "1", required = false) Integer page){

        Map<String, String> map = new HashMap<String, String>();
        List<Role> list = roleMapper.queryAllByMap(map);
        int count = roleMapper.queryAllCountByMap(map);

        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("page",page);
        retMap.put("records",count);
        retMap.put("rows",list);
        retMap.put("total",(int) (count/rows+1));


        return retMap;
    }





    /**
     * 保存
     * @param role
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    String save(@ModelAttribute Role role){
        role.setId(UUID.randomUUID().toString().replaceAll("-",""));
        roleMapper.insert(role);
        return "0";
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role get(@PathVariable String id){
        return roleMapper.getOne(id);
    };

    /**
     * 修改
     * @param role
     * @return
     */
    @RequestMapping(value = "/",method=RequestMethod.PUT)
    String update( @ModelAttribute Role role){
        roleMapper.update(role);
        return "0";
    };

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String delete(@PathVariable String id){
        roleMapper.delete(id);
        return "0";
    };
}
