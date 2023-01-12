package com.zxl.service.impl;


import com.github.pagehelper.PageHelper;
import com.zxl.entity.TUserinfo;
import com.zxl.dao.TUserinfoDao;
import com.zxl.service.TUserinfoService;
import com.zxl.utils.BCPassward;
import com.zxl.utils.DateUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("tUserinfoService")
public class TUserinfoServiceImpl implements TUserinfoService {
    @Resource
    private TUserinfoDao tUserinfoDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TUserinfo tUserinfo = tUserinfoDao.findbyUsername(s);
        User user=new User(tUserinfo.getUserName(),tUserinfo.getPassword(),getAuthority(tUserinfo.getUsertype()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(String s){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority(s));
        return list;
    }

    @Override
    public TUserinfo findUserByname(String name) {
        return tUserinfoDao.findbyUsername(name);
    }

    @Override
    public void update(TUserinfo tUserinfo) {
        TUserinfo userinfo = tUserinfoDao.findbyUsername(tUserinfo.getUserName());
        if(userinfo.getPassword().equals(tUserinfo.getPassword())){
            System.out.println(userinfo.getPassword().equals(tUserinfo.getPassword()));
            tUserinfo.setPassword(userinfo.getPassword());
        }else {
            tUserinfo.setPassword(BCPassward.setPassword(tUserinfo.getPassword()));
        }
        tUserinfoDao.update(tUserinfo);
    }

    @Override
    public List<TUserinfo> findall() {
        return tUserinfoDao.findall();
    }

    @Override
    public List<TUserinfo> findall(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return tUserinfoDao.findall();
    }

    @Override
    public Integer count() {
        return tUserinfoDao.count();
    }

    @Override
    public void insert(TUserinfo tUserinfo) {
        tUserinfoDao.insert(tUserinfo);
    }

    @Override
    public void deleteById(String name) {
        tUserinfoDao.deleteCommentByuser(name);
        tUserinfoDao.deleteOrderByuser(name);
        tUserinfoDao.deleteById(name);
    }

    @Override
    public void registered(TUserinfo tUserinfo) {
        tUserinfo.setPassword(BCPassward.setPassword(tUserinfo.getPassword()));
        tUserinfo.setRegtime(DateUtils.getDate(new Date()));
        tUserinfoDao.registered(tUserinfo);
    }
}