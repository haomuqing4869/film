package com.zxl.service;

import com.zxl.entity.TUserinfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TUserinfoService extends UserDetailsService{
    TUserinfo findUserByname(String name);

    void update(TUserinfo tUserinfo);

    List<TUserinfo> findall();

    List<TUserinfo> findall(Integer page, Integer pageSize);

    Integer count();

    void insert(TUserinfo tUserinfo);

    void deleteById(String name);

    void registered(TUserinfo tUserinfo);
}