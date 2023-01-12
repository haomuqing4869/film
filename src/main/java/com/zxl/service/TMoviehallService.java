package com.zxl.service;

import com.zxl.entity.TMovie;
import com.zxl.entity.TMoviehall;

import java.util.List;

/**
 * (TMoviehall)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:25:32
 */
public interface TMoviehallService {

    /**
     * 通过ID查询单条数据
     *
     * @param moviehallid 主键
     * @return 实例对象
     */
    TMoviehall queryById(Integer moviehallid);


    /**
     * 查询所有
     */
    List<TMoviehall> findAll(TMoviehall tMoviehall);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TMoviehall> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tMoviehall 实例对象
     * @return 实例对象
     */
    TMoviehall insert(TMoviehall tMoviehall);

    /**
     * 修改数据
     *
     * @param tMoviehall 实例对象
     * @return 实例对象
     */
    TMoviehall update(TMoviehall tMoviehall);

    /**
     * 通过主键删除数据
     *
     * @param moviehallid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer moviehallid);

}