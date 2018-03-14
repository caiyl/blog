package com.cai.blog.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by caiyl on 2018/2/8.
 */
public interface BaseMapper<T> {
    /**
     * 查找所有
     * @return
     */
    List<T> getAll();

    /**
     * 查找一个
     * @param id
     * @return
     */
    T getOne(String id);

    /**
     * 插入
     * @param entity
     */
    void insert(T entity);

    /**
     * 更新
     * @param entity
     */
    void update(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 根据map条件查找
     * @param map
     * @return
     */
    List<T> queryAllByMap(Map<String,String> map);

    /**
     * 根据map条件统计
     * @param map
     * @return
     */
    int queryAllCountByMap(Map<String, String> map);

}
