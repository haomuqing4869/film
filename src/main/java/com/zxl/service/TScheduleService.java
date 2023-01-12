package com.zxl.service;

import com.zxl.entity.TSchedule;

import java.util.List;

/**
 * (TSchedule)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:25:41
 */
public interface TScheduleService {

    /**
     * 通过ID查询单条数据
     *
     * @param scheduleid 主键
     * @return 实例对象
     */
    TSchedule queryById(Integer scheduleid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TSchedule> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tSchedule 实例对象
     * @return 实例对象
     */
    TSchedule insert(TSchedule tSchedule);

    /**
     * 修改数据
     *
     * @param tSchedule 实例对象
     * @return 实例对象
     */
    TSchedule update(TSchedule tSchedule);

    /**
     * 通过主键删除数据
     *
     * @param scheduleid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scheduleid);

    /**
     * 通过电影ID来查询放映厅
     */
    List<TSchedule> findBymoveID(Integer id);

    /**
     * 根据电影Id来删除档期
     */
    void deleteByMid(Integer mid);

    List<TSchedule> findAll(Integer page,Integer pageSize);

    Integer count();
}