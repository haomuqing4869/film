package com.zxl.dao;

import com.zxl.entity.TSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TSchedule)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-05 10:25:41
 */
public interface TScheduleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scheduleid 主键
     * @return 实例对象
     */
    TSchedule queryById(Integer scheduleid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TSchedule> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tSchedule 实例对象
     * @return 对象列表
     */
    List<TSchedule> queryAll(TSchedule tSchedule);

    /**
     * 新增数据
     *
     * @param tSchedule 实例对象
     * @return 影响行数
     */
    int insert(TSchedule tSchedule);

    /**
     * 修改数据
     *
     * @param tSchedule 实例对象
     * @return 影响行数
     */
    int update(TSchedule tSchedule);

    /**
     * 通过主键删除数据
     *
     * @param scheduleid 主键
     * @return 影响行数
     */
    int deleteById(Integer scheduleid);


    /**
     * 通过电影ID来删除
     */
    void deleteByMid(Integer mid);
    /**
     * 通过电影的ID来查询档期
     */
    List<TSchedule> findBymovieID(Integer id);

    List<TSchedule> findAll();

    Integer count();

    TSchedule selectByMid(Integer id);
}