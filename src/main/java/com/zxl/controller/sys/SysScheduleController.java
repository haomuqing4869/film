package com.zxl.controller.sys;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TSchedule;
import com.zxl.service.TScheduleService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysSchedule")
public class SysScheduleController {
    @Autowired
    private TScheduleService tScheduleService;


    @RequestMapping("/findAll")
    public String findAll(Integer page,Integer pageSize,ModelMap modelMap){
        List<TSchedule> all = tScheduleService.findAll(page,pageSize);
        Integer count = tScheduleService.count();
        Page page1 =new Page(pageSize,page,count);
        PageInfo<TSchedule> pageInfo=new PageInfo<>(all);
        modelMap.addAttribute("schedules",pageInfo);
        modelMap.addAttribute("pages",page1);
        return "sysSchedule";
    }
    @RequestMapping("/delete")
    public String add(Integer id){
        tScheduleService.deleteById(id);
        return "redirect:/sysSchedule/findAll?page=1&pageSize=8";
    }

}
