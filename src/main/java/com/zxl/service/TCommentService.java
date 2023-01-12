package com.zxl.service;

import com.zxl.entity.TComment;

import java.util.List;

/**
 * (TComment)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:18:02
 */
public interface TCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentid 主键
     * @return 实例对象
     */
    TComment queryById(Integer commentid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tComment 实例对象
     * @return 实例对象
     */
    TComment insert(TComment tComment);

    /**
     * 修改数据
     *
     * @param tComment 实例对象
     * @return 实例对象
     */
    TComment update(TComment tComment);

    /**
     * 通过主键删除数据
     *
     * @param commentid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentid);

    /**
     * 查询所有
     */
    List<TComment> findall(TComment tComment);

    List<TComment> findsysall(Integer page,Integer pageSize);

    /**
     * 汇总
     */
    Integer count();
}