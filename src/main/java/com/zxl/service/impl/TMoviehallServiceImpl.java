package com.zxl.service.impl;

import com.zxl.entity.TMovie;
import com.zxl.entity.TMoviehall;
import com.zxl.dao.TMoviehallDao;
import com.zxl.service.TMoviehallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TMoviehall)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:25:33
 */
@Service("tMoviehallService")
public class TMoviehallServiceImpl implements TMoviehallService {
    @Resource
    private TMoviehallDao tMoviehallDao;

    /**
     * 通过ID查询单条数据
     *
     * @param moviehallid 主键
     * @return 实例对象
     */
    @Override
    public TMoviehall queryById(Integer moviehallid) {
        return this.tMoviehallDao.queryById(moviehallid);
    }

    @Override
    public List<TMoviehall> findAll(TMoviehall tMoviehall) {
        return tMoviehallDao.queryAll(tMoviehall);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TMoviehall> queryAllByLimit(int offset, int limit) {
        return this.tMoviehallDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tMoviehall 实例对象
     * @return 实例对象
     */
    @Override
    public TMoviehall insert(TMoviehall tMoviehall) {
        this.tMoviehallDao.insert(tMoviehall);
        return tMoviehall;
    }

    /**
     * 修改数据
     *
     * @param tMoviehall 实例对象
     * @return 实例对象
     */
    @Override
    public TMoviehall update(TMoviehall tMoviehall) {
        this.tMoviehallDao.update(tMoviehall);
        return this.queryById(tMoviehall.getMoviehallid());
    }

    /**
     * 通过主键删除数据
     *
     * @param moviehallid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer moviehallid) {
        tMoviehallDao.deleteSC(moviehallid);
        return this.tMoviehallDao.deleteById(moviehallid) > 0;
    }


}