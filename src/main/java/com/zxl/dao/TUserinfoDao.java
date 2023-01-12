package com.zxl.dao;

import com.zxl.entity.TUserinfo;

import java.util.List;


public interface TUserinfoDao {

    TUserinfo findbyUsername(String name);

    void update(TUserinfo tUserinfo);

    List<TUserinfo> findall();

    Integer count();

    void insert(TUserinfo tUserinfo);

    void deleteById(String name);

    void deleteCommentByuser(String name);

    void deleteOrderByuser(String name);

    void registered(TUserinfo tUserinfo);
}