package com.cai.blog.mapper;

import com.cai.blog.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by caiyl on 2017/10/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper;

   /* @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new UserEntity("1", "zhangsan", "张三", "1", "1"));
        UserMapper.insert(new UserEntity("2", "lisi", "张三", "1", "1"));
        UserMapper.insert(new UserEntity("3", "wangwu", "王五", "1", "1"));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }*/

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(3l);
        System.out.println(user.toString());
        user.setUserNameCN("王五1");
        UserMapper.update(user);
        Assert.assertTrue(("王五1".equals(UserMapper.getOne(3l).getUserNameCN())));
    }
}