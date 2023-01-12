package com.zxl.dao;

import com.zxl.entity.TMovie;
import com.zxl.entity.TSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TMovie)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-05 10:25:25
 */
public interface TMovieDao {

    /**
     * 通过ID查询单条数据
     *
     * @param movieid 主键
     * @return 实例对象
     */
    TMovie queryById(Integer movieid);

    /**
     *
     * @return 所有数据
     */
    List<TMovie> findall();

    /**
     * 查询数据的总条数
     */
    Integer findCount();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tMovie 实例对象
     * @return 对象列表
     */
    List<TMovie> queryAll(TMovie tMovie);

    /**
     * 新增数据
     *
     * @param tMovie 实例对象
     * @return 影响行数
     */
    int insert(TMovie tMovie);

    /**
     * 修改数据
     *
     * @param tMovie 实例对象
     * @return 影响行数
     */
    int update(TMovie tMovie);




    /**
     * 通过主键删除数据
     *
     * @param movieid 主键
     * @return 影响行数
     */
    int deleteById(Integer movieid);
    /**
     * 通过电影类型来查询电影
     */
    List<TMovie> findBySort(Integer sid);

    List<TMovie> findByname(String name);

    List<TSort> countHit();

    List<TMovie> findSome(TMovie tMovie);

    /**
     * 查询点击量前十的电影
     */
    List<TMovie> tMovieTop();

    /**
     * 通过类型来查询电影数据
     */
    List<TMovie> findmoviesBySort(Integer id);

    /**
     * 根据类型查询该类型的TOp10
     */

    List<TMovie> findTopBySort(@Param("id") Integer id,@Param("start") Integer start,@Param("limit") Integer limit);

    /**
     * 根据类型来计算count
     */

    Integer countBysort(Integer id);

}