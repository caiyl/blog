package com.cai.blog.mapper;

import com.cai.blog.entity.UserEntity;

import java.util.List;

/**
 * Created by caiyl on 2017/10/2.
 */
public interface UserMapper2 {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}
