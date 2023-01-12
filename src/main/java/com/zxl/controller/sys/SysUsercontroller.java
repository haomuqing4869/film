package com.zxl.controller.sys;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TMovie;
import com.zxl.entity.TUserinfo;
import com.zxl.service.TUserinfoService;
import com.zxl.utils.BCPassward;
import com.zxl.utils.DateUtils;
import com.zxl.utils.Page;
import com.zxl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sysUser")
public class SysUsercontroller {
    @Autowired
    private TUserinfoService tUserinfoService;

    @RequestMapping("/findall")
    public String  findall(Integer page,Integer pageSize,ModelMap modelMap){
        List<TUserinfo> findall = tUserinfoService.findall(page,pageSize);
        Integer count=tUserinfoService.count();
        PageInfo<TUserinfo> pageInfo=new PageInfo<>(findall);
        Page page1=new Page(pageSize,page,count);
        modelMap.addAttribute("users",pageInfo);
        modelMap.addAttribute("pages",page1);
        return "sysUser";
    }
    @RequestMapping("/add")
    public String add(HttpServletRequest request, MultipartFile photo, TUserinfo tUserinfo) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/");
        System.out.println(path);
        path=path+"/static/image";
        String filename=photo.getOriginalFilename();
        String movieP="/static/image/"+filename;
        tUserinfo.setUserphoto(movieP);
        tUserinfo.setRegtime(DateUtils.getDate(new Date()));
        tUserinfo.setPassword(BCPassward.setPassword(tUserinfo.getPassword()));

        tUserinfoService.insert(tUserinfo);
        photo.transferTo(new File(path,filename));
        return "redirect:/sysUser/findall?page=1&pageSize=5";
    }
    @RequestMapping("/delete")
    public String delete(String name){
        tUserinfoService.deleteById(name);
        return "redirect:/sysUser/findall?page=1&pageSize=5";
    }
    @RequestMapping("/toedit")
    public String toedit(String name,ModelMap modelMap){
        TUserinfo userByname = tUserinfoService.findUserByname(name);
        modelMap.addAttribute("user",userByname);
        return "sysUser_edit";
    }
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, MultipartFile photo, TUserinfo tUserinfo) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/");
        path=path+"/static/image";
        String filename = photo.getOriginalFilename();
        if(filename != null&&filename != ""){
            System.out.println(filename);
            String movieP="/static/image/"+filename;
            photo.transferTo(new File(path,filename));
            tUserinfo.setUserphoto(movieP);
        }

        tUserinfo.setRegtime(DateUtils.getDate(new Date()));

        tUserinfoService.update(tUserinfo);

        return "redirect:/sysUser/findall?page=1&pageSize=5";
    }
}
