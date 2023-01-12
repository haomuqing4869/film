package com.zxl.controller.sys;

import com.zxl.entity.TMoviehall;
import com.zxl.entity.TSort;
import com.zxl.service.TMoviehallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysHall")
public class SysMovieHallController {
    @Autowired
    private TMoviehallService tMoviehallService;

    @RequestMapping("/findAll")
    public String finAll(ModelMap modelMap){
        List<TMoviehall> all = tMoviehallService.findAll(null);
        modelMap.addAttribute("halls",all);
        return "sysMovieHall";
    }
    @RequestMapping("/add")
    public String add(TMoviehall tMoviehall){
        tMoviehallService.insert(tMoviehall);
        return "redirect:/sysHall/findAll";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        tMoviehallService.deleteById(id);
        return "redirect:/sysHall/findAll";
    }

    @RequestMapping("/toedit")
    public String toedit(Integer id,String name,Integer rows,Integer cols,ModelMap modelMap){
        TMoviehall tMoviehall = new TMoviehall();
        tMoviehall.setMoviehallid(id);
        tMoviehall.setMoviehallname(name);
        tMoviehall.setRows(rows);
        tMoviehall.setCols(cols);
        modelMap.addAttribute("tMoviehall",tMoviehall);
        return "sysMovieHall_edit";
    }

    @RequestMapping("/edit")
    public String edit(TMoviehall tMoviehall){
        tMoviehallService.update(tMoviehall);
        return "redirect:/sysHall/findAll";
    }
}
