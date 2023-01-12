package com.zxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.zxl.entity.TComment;
import com.zxl.dao.TCommentDao;
import com.zxl.service.TCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TComment)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 10:25:20
 */
@Service("tCommentService")
public class TCommentServiceImpl implements TCommentService {
    @Resource
    private TCommentDao tCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentid 主键
     * @return 实例对象
     */
    @Override
    public TComment queryById(Integer commentid) {
        return this.tCommentDao.queryById(commentid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TComment> queryAllByLimit(int offset, int limit) {
        return this.tCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tComment 实例对象
     * @return 实例对象
     */
    @Override
    public TComment insert(TComment tComment) {
        this.tCommentDao.insert(tComment);
        return tComment;
    }

    /**
     * 修改数据
     *
     * @param tComment 实例对象
     * @return 实例对象
     */
    @Override
    public TComment update(TComment tComment) {
        this.tCommentDao.update(tComment);
        return this.queryById(tComment.getCommentid());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentid) {
        return this.tCommentDao.deleteById(commentid) > 0;
    }

    @Override
    public List<TComment> findall(TComment tComment) {
        return tCommentDao.queryAll(tComment);
    }

    @Override
    public List<TComment> findsysall(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return tCommentDao.selectAll();
    }

    @Override
    public Integer count() {
        return tCommentDao.count();
    }
}