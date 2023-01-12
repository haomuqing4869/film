package com.zxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.zxl.dao.TMovieorderDao;
import com.zxl.entity.TSchedule;
import com.zxl.dao.TScheduleDao;
import com.zxl.service.TMovieService;
import com.zxl.service.TScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TSchedule)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:25:42
 */
@Service("tScheduleService")
public class TScheduleServiceImpl implements TScheduleService {
    @Resource
    private TScheduleDao tScheduleDao;
    @Autowired
    private TMovieService tMovieService;
    @Autowired
    private TMovieorderDao tMovieorderDao;


    /**
     * 通过ID查询单条数据
     *
     * @param scheduleid 主键
     * @return 实例对象
     */
    @Override
    public TSchedule queryById(Integer scheduleid) {
        return this.tScheduleDao.queryById(scheduleid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TSchedule> queryAllByLimit(int offset, int limit) {
        return this.tScheduleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public TSchedule insert(TSchedule tSchedule) {
        String scheduledate = tSchedule.getScheduledate();
        String[] s = scheduledate.split(" ");
        tSchedule.setScheduledate(s[0]);
        tSchedule.setScheduletime(s[1]);
        this.tScheduleDao.insert(tSchedule);
        return tSchedule;
    }

    /**
     * 修改数据
     *
     * @param tSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public TSchedule update(TSchedule tSchedule) {
        this.tScheduleDao.update(tSchedule);
        return this.queryById(tSchedule.getScheduleid());
    }

    /**
     * 通过主键删除数据
     *
     * @param scheduleid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer scheduleid) {
        tMovieorderDao.deleteBySid(scheduleid);
        return this.tScheduleDao.deleteById(scheduleid) > 0;
    }

    @Override
    public List<TSchedule> findBymoveID(Integer id) {
        return tScheduleDao.findBymovieID(id);
    }

    @Override
    public void deleteByMid(Integer mid) {
        List<TSchedule> byMid = tMovieService.findByMid(mid);
        for (TSchedule tSchedule : byMid) {
            tMovieorderDao.deleteBySid(tSchedule.getScheduleid());
        }
        tScheduleDao.deleteByMid(mid);
    }

    @Override
    public List<TSchedule> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return tScheduleDao.findAll();
    }

    @Override
    public Integer count() {
        return tScheduleDao.count();
    }
}