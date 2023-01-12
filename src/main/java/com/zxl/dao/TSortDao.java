package com.zxl.dao;

import com.zxl.entity.TSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TSort)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-05 10:32:10
 */
public interface TSortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSort queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TSort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tSort 实例对象
     * @return 对象列表
     */
    List<TSort> queryAll(TSort tSort);

    /**
     * 新增数据
     *
     * @param tSort 实例对象
     * @return 影响行数
     */
    int insert(TSort tSort);

    /**
     * 修改数据
     *
     * @param tSort 实例对象
     * @return 影响行数
     */
    int update(TSort tSort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根究电影Id删除T_S的关联表的内容
     */
    void deleteByMid(Integer mid);

    /**
     * 插入电影和分类的关联信息
     */
    void insertm_s(@Param("mid") Integer mid,@Param("sid") Integer sid);

    /**
     * 根据电影id排除查询数据
     */

    List<TSort> findNotByMid(Integer mid);


    Integer[] findByMid(Integer movieid);

    /**
     * 通过电影Id来删除关联关系
     */
    void deletetByMid(Integer mid);

    Integer count();

    void deletems(Integer sid);

    List<TSort> findMS(Integer id);
}