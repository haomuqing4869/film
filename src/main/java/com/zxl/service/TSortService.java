package com.zxl.service;

import com.zxl.entity.TSort;

import java.util.List;

/**
 * (TSort)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:32:11
 */
public interface TSortService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSort queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TSort> queryAllByLimit(int offset, int limit);

    /**
     *
     * @param tSort 分类信息
     * @return 分类
     */
    List<TSort> findAll(Integer page,Integer pageSize,TSort tSort);


    List<TSort> findAll(TSort tSort);
    /**
     * 新增数据
     *
     * @param tSort 实例对象
     * @return 实例对象
     */
    TSort insert(TSort tSort);

    /**
     * 修改数据
     *
     * @param tSort 实例对象
     * @return 实例对象
     */
    TSort update(TSort tSort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过电影ID来查询不是这个电影类型的类型
     */
    List<TSort> findNotByMid(Integer mid);


    Integer count();

}