package com.cai.blog.mapper;

import com.cai.blog.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by caiyl on 2017/10/2.
 */
@Mapper
public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);


    UserEntity queryById(Long id);

    List<UserEntity> queryAllByMap(Map<String,String> map);

    int queryAllCountByMap(Map<String, String> map);
}
