package com.zxl.controller;

import com.zxl.entity.TUserinfo;
import com.zxl.service.TUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TUserinfoService tUserinfoService;
    @RequestMapping("/find")
    public String findme(ModelMap modelMap){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        TUserinfo userByname = tUserinfoService.findUserByname(name);
        modelMap.addAttribute("me",userByname);
        return "user";
    }
    @RequestMapping("/update")
    public String updaste(TUserinfo tUserinfo){
        System.out.println(tUserinfo);
        tUserinfoService.update(tUserinfo);
        return "redirect:/user/find";
    }

    @RequestMapping("/registered")
    public String registered(TUserinfo tUserinfo){
        System.out.println(tUserinfo);
        tUserinfoService.registered(tUserinfo);
        return "redirect:/login";
    }
}
