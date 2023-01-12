package com.zxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.zxl.dao.TCommentDao;
import com.zxl.dao.TScheduleDao;
import com.zxl.dao.TSortDao;
import com.zxl.entity.TMovie;
import com.zxl.dao.TMovieDao;
import com.zxl.entity.TSchedule;
import com.zxl.entity.TSort;
import com.zxl.service.TMovieService;
import com.zxl.service.TScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TMovie)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:25:27
 */
@Service("tMovieService")
public class TMovieServiceImpl implements TMovieService {
    @Resource
    private TMovieDao tMovieDao;
    @Autowired
    private TScheduleDao tScheduleDao;
    @Autowired
    private TScheduleService tScheduleService;
    @Autowired
    private TSortDao tSortDao;
    @Autowired
    private TCommentDao tCommentDao;
    /**
     * 通过ID查询单条数据
     *
     * @param movieid 主键
     * @return 实例对象
     */
    @Override
    public TMovie queryById(Integer movieid) {
        return tMovieDao.queryById(movieid);
    }


    /**
     * 新增数据
     *
     * @param tMovie 实例对象
     * @return 实例对象
     */
    @Override
    public TMovie insert(TMovie tMovie) {
        this.tMovieDao.insert(tMovie);
        System.out.println(tMovie);
        Integer[] sortid = tMovie.getSortid();
        for (Integer integer : sortid) {
            tSortDao.insertm_s(tMovie.getMovieid(),integer);
        }
        return tMovie;
    }

    /**
     * 修改数据
     *
     * @param tMovie 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TMovie tMovie) {
        this.tMovieDao.update(tMovie);
    }

    @Override
    public void updateMs(TMovie tMovie) {
        Integer[] sortid = tMovie.getSortid();
        tSortDao.deleteByMid(tMovie.getMovieid());
        for (Integer integer : sortid) {
            tSortDao.insertm_s(tMovie.getMovieid(),integer);
        }
        this.tMovieDao.update(tMovie);
    }


    /**
     * 通过主键删除数据
     *
     * @param movieid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer movieid) {
        tScheduleService.deleteByMid(movieid);
        tSortDao.deleteByMid(movieid);
        tCommentDao.deleteByMid(movieid);
        return this.tMovieDao.deleteById(movieid) > 0;
    }

    @Override
    public List<TMovie> findall(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<TMovie> movies = tMovieDao.findall();
        return movies;

    }

    @Override
    public List<TMovie> findall() {
        return tMovieDao.findall();

    }

    @Override
    public Integer findCount() {
        return tMovieDao.findCount();
    }

    /**
     *
     * @param sid 分类的id
     * @return 电影
     */
    @Override
    public List<TMovie> findBySortID(Integer sid) {
        return tMovieDao.findBySort(sid);
    }

    @Override
    public List<TMovie> findBYname(String name,Integer page ,Integer pagesize) {
        name="%"+name+"%";
        PageHelper.startPage(page,pagesize);
        return tMovieDao.findByname(name);
    }

    @Override
    public List<TSchedule> findByMid(Integer mid) {
        return tScheduleDao.findBymovieID(mid);
    }

    @Override
    public List<TSort> countHit() {
        return tMovieDao.countHit();
    }

    @Override
    public List<TMovie> findSome(TMovie tMovie, Integer page, Integer pageSize) {
        TSchedule tSchedule=new TSchedule();
        tSchedule.setScheduleid(111);
        tMovie.setMoviename("%"+tMovie.getMoviename()+"%");
        tMovie.setDirector("%"+tMovie.getDirector()+"%");
        tMovie.setMainperformer("%"+tMovie.getMainperformer()+"%");
        PageHelper.startPage(page,pageSize);
        List<TMovie> some = tMovieDao.findSome(tMovie);
        for (TMovie movie : some) {
            movie.settSchedule(tSchedule);
        }
        return some;
    }

    @Override
    public List<TMovie> tMovieTop() {
        return tMovieDao.tMovieTop();
    }

    @Override
    public List<TMovie> findBysort(Integer id) {
        return tMovieDao.findmoviesBySort(id);
    }

    @Override
    public List<TMovie> findBysort(Integer id, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return tMovieDao.findmoviesBySort(id);
    }

    @Override
    public List<TMovie> findTopBysort(Integer id,Integer start, Integer limit) {
        return tMovieDao.findTopBySort(id,start,limit);
    }

    @Override
    public Integer countSort(Integer sid) {
        return tMovieDao.countBysort(sid);
    }
}