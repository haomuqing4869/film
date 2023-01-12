package com.zxl.controller.sys;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TMovieorder;
import com.zxl.service.TMovieorderService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/sysOrder")
public class SysOrderController {
    @Autowired
    private TMovieorderService tMovieorderService;


    @RequestMapping("findAll")
    public String findAll(Integer page, Integer pageSize, ModelMap modelMap) {
        List<TMovieorder> tMovieorders = tMovieorderService.findAll(page, pageSize);
        Integer count = tMovieorderService.count();
        Page page1 = new Page();
        page1.setPageSize(pageSize);
        page1.setPage(page);
        page1.setCount(count);
        PageInfo<TMovieorder> pageInfo = new PageInfo<>(tMovieorders);
        modelMap.addAttribute("pages", page1);
        modelMap.addAttribute("orders", pageInfo);
        return "sysorder";
    }

    @RequestMapping("/findSome")
    public String findSome(ModelMap modelMap, Integer page, Integer pageSize, Integer orderid,String userName) {
        List<TMovieorder> tMovieorders = tMovieorderService.findSome(page, pageSize, orderid,userName);
        PageInfo<TMovieorder> pageInfo=new PageInfo<>(tMovieorders);
        modelMap.addAttribute("orders", pageInfo);
        return "sysorder";
    }

    @RequestMapping("/ticketing")
    public String ticketing(Integer id) {
        TMovieorder tMovieorder = new TMovieorder();
        tMovieorder.setStatus(2);
        tMovieorder.setOrderid(id);
        tMovieorderService.update(tMovieorder);
        return "redirect:/sysOrder/findAll?page=1&pageSize=8";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        tMovieorderService.deleteById(id);
        return "redirect:/sysOrder/findAll?page=1&pageSize=8";
    }

    @RequestMapping("/details")
    public String details(Integer id, ModelMap modelMap) {
        TMovieorder details = tMovieorderService.details(id);
        modelMap.addAttribute("details", details);
        return "sys_details";
    }
}
