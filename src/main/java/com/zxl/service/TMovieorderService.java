package com.zxl.service;

import com.zxl.entity.Msm;
import com.zxl.entity.TMovieorder;

import java.util.List;

/**
 * (TMovieorder)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:25:37
 */
public interface TMovieorderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    TMovieorder queryById(Integer orderid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TMovieorder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tMovieorder 实例对象
     * @return 实例对象
     */
    void insert(Msm msm);

    /**
     * 修改数据
     *
     * @param tMovieorder 实例对象
     * @return 实例对象
     */
    void update(TMovieorder tMovieorder);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderid);

    /**
     *
     * 根据用户名来查询用的订单信息
     */
    List<TMovieorder> findByUsername(String name,int page,int pagesize);

    /**
     * 根据用户名来查询订单总量
     */
    Integer count(String name);

    /**
     * 根据电影ID来查询电影和档期的信息
     */
    Msm findById(Integer id);

    List<TMovieorder> findAll(Integer page,Integer pageSize);

    /**
     * 查询订单总数
     */
    Integer count();

    /**
     * 详情页
     */
    TMovieorder details(Integer id);

    List<TMovieorder> findSome(Integer page, Integer pageSize, Integer orderid,String userName);
}