package com.cai.blog.mapper;

import com.cai.blog.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by caiyl on 2017/10/2.
 * 注解版
 */
public interface UserMapper {

    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userNameCN", column = "user_name_cn"),
            @Result(property = "password",  column = "password"),
            @Result(property = "userSex",  column = "user_sex")

    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id" ),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userNameCN",  column = "user_name_cn" ),
            @Result(property = "password",  column = "password" ),
            @Result(property = "userSex",  column = "user_sex" ),
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO t_user(id,user_name,user_name_cn,password,user_sex) " +
            "VALUES(#{id}, #{userName}, #{userNameCN}, #{password}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE t_user SET user_name=#{userName},user_name_cn=#{userNameCN},password=#{password},user_sex=#{userSex} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}
