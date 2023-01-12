package com.zxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxl.entity.Msm;
import com.zxl.entity.TMovieorder;
import com.zxl.dao.TMovieorderDao;
import com.zxl.service.TMovieorderService;
import com.zxl.utils.DateUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TMovieorder)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:25:38
 */
@Service("tMovieorderService")
public class TMovieorderServiceImpl implements TMovieorderService {
    @Resource
    private TMovieorderDao tMovieorderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    @Override
    public TMovieorder queryById(Integer orderid) {
        return this.tMovieorderDao.queryById(orderid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TMovieorder> queryAllByLimit(int offset, int limit) {
        return this.tMovieorderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public void insert(Msm msm) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        TMovieorder tMovieorder=new TMovieorder();
        String[] rc = msm.getRc();
        for (int i = 0; i < rc.length; i++) {
            tMovieorder.setScheduleobj(msm.getScheduleId());
            String s = rc[i];
            String[] s1 = s.split("_");
            tMovieorder.setRowsindex(Integer.valueOf(s1[0]));
            tMovieorder.setCols(Integer.valueOf(s1[1]));
            tMovieorder.setPrice(msm.getPrice());
            tMovieorder.setUserobj(name);
            tMovieorder.setOrdertime(DateUtils.getDate(new Date()));
            tMovieorderDao.insert(tMovieorder);
        }
    }

    /**
     * 修改数据
     *
     * @param tMovieorder 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TMovieorder tMovieorder) {
        this.tMovieorderDao.update(tMovieorder);
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderid) {
        return this.tMovieorderDao.deleteById(orderid) > 0;
    }

    @Override
    public List<TMovieorder> findByUsername(String name,int page,int pagesize) {
        PageHelper.startPage(page,pagesize);
        return tMovieorderDao.findByUsername(name);
    }

    @Override
    public Integer count(String name) {
        return tMovieorderDao.count(name);
    }

    @Override
    public Msm findById(Integer id) {
        Msm byid = tMovieorderDao.findByid(id);
        List<Msm> cr = tMovieorderDao.findCr(id);
        String []rc=new String[cr.size()];
        for (int i = 0; i <cr.size(); i++) {
            rc[i]=cr.get(i).getRowsIndex()+"_"+cr.get(i).getCols();
        }
        byid.setRc(rc);
        return byid;
    }

    @Override
    public List<TMovieorder> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return tMovieorderDao.findAll();
    }

    @Override
    public Integer count() {
        return tMovieorderDao.countAll();
    }

    @Override
    public TMovieorder details(Integer id) {
        return tMovieorderDao.details(id);
    }


    @Override
    public List<TMovieorder> findSome(Integer page, Integer pageSize,Integer orderid,String userName) {
        userName="%"+userName+"%";
        PageHelper.startPage(page,pageSize);
        return tMovieorderDao.findSome(orderid,userName);
    }
}