package com.zxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.zxl.entity.TSort;
import com.zxl.dao.TSortDao;
import com.zxl.service.TSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TSort)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:32:11
 */
@Service("tSortService")
public class TSortServiceImpl implements TSortService {
    @Resource
    private TSortDao tSortDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TSort queryById(Integer id) {
        return this.tSortDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TSort> queryAllByLimit(int offset, int limit) {
        return this.tSortDao.queryAllByLimit(offset, limit);
    }

    /**
     *
     * @param tSort 分类信息
     * @return 分类
     */
    @Override
    public List<TSort> findAll(Integer page,Integer pageSize,TSort tSort) {
        PageHelper.startPage(page,pageSize);
        return tSortDao.queryAll(tSort);
    }
    @Override
    public List<TSort> findAll(TSort tSort) {
        return tSortDao.queryAll(tSort);
    }

    /**
     * 新增数据
     *
     * @param tSort 实例对象
     * @return 实例对象
     */
    @Override
    public TSort insert(TSort tSort) {
        this.tSortDao.insert(tSort);
        return tSort;
    }

    /**
     * 修改数据
     *
     * @param tSort 实例对象
     * @return 实例对象
     */
    @Override
    public TSort update(TSort tSort) {
        this.tSortDao.update(tSort);
        return this.queryById(tSort.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        tSortDao.deletems(id);
        return this.tSortDao.deleteById(id) > 0;
    }

    @Override
    public List<TSort> findNotByMid(Integer mid) {
        return tSortDao.findNotByMid(mid);
    }

    @Override
    public Integer count() {
        return tSortDao.count();
    }
}