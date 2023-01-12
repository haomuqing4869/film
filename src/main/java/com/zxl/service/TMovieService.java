package com.zxl.service;

import com.zxl.entity.TMovie;
import com.zxl.entity.TSchedule;
import com.zxl.entity.TSort;

import java.util.List;

/**
 * (TMovie)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 10:25:26
 */
public interface TMovieService {

    /**
     * 通过ID查询单条数据
     *
     * @param movieid 主键
     * @return 实例对象
     */
    TMovie queryById(Integer movieid);

    /**
     * 新增数据
     *
     * @param tMovie 实例对象
     * @return 实例对象
     */
    TMovie insert(TMovie tMovie);

    /**
     * 修改数据
     *
     * @param tMovie 实例对象
     * @return 实例对象
     */
    void update(TMovie tMovie);

    /**
     * 修改分类信息
     */
    void updateMs(TMovie tMovie);

    /**
     * 通过主键删除数据
     *
     * @param movieid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer movieid);

    /**
     *
     * @return 所有的电影
     */
    List<TMovie> findall(int page, int pageSize);


    /**
     *
     * @return 所有的电影
     */
    List<TMovie> findall();
    /**
     * 查询数据的总条数
     */
    Integer findCount();
    /**
     * 通过分类的Id来查询
     */
    List<TMovie> findBySortID(Integer sid);

    List<TMovie> findBYname(String name,Integer page,Integer pagesize);

    /**
     * 同过电影ID查询档期
     */
    List<TSchedule> findByMid(Integer mid);

    List<TSort> countHit();

    List<TMovie> findSome(TMovie tMovie, Integer page, Integer pageSize);

    List<TMovie> tMovieTop();

    List<TMovie> findBysort(Integer id);

    List<TMovie> findBysort(Integer id,Integer page,Integer pageSize);

    List<TMovie> findTopBysort(Integer id,Integer start,Integer limit);

    Integer countSort(Integer sid);
}