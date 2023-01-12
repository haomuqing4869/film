package com.zxl.dao;

import com.zxl.entity.Msm;
import com.zxl.entity.TMovieorder;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * (TMovieorder)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-05 10:25:35
 */
public interface TMovieorderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    TMovieorder queryById(Integer orderid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TMovieorder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tMovieorder 实例对象
     * @return 对象列表
     */
    List<TMovieorder> queryAll(TMovieorder tMovieorder);

    /**
     * 新增数据
     *
     * @param tMovieorder 实例对象
     * @return 影响行数
     */
    int insert(TMovieorder tMovieorder);

    /**
     * 修改数据
     *
     * @param tMovieorder 实例对象
     * @return 影响行数
     */
    int update(TMovieorder tMovieorder);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 影响行数
     */
    int deleteById(Integer orderid);

    /**
     * 根据用户姓名来查询用户订单
     */
    List<TMovieorder> findByUsername(String name);

    /**
     * 根据用户名来查询订单总量
     */
    Integer count(String name);

    /**
     * 查询电影和档期信息
     */
    Msm findByid(Integer id);

    /**
     * 查询已经被购买了的票
     */
    List<Msm> findCr(Integer id);

    /**
     * 根据档期ID来删除订单
     */
    void deleteBySid(Integer id);

    List<TMovieorder> findAll();

    /**
     * 根究档期Id来删除
     */
    Integer countAll();

    TMovieorder details(Integer id);

    List<TMovieorder> findSome(@Param("orderid") Integer orderid,@Param("userName") String userName);
}