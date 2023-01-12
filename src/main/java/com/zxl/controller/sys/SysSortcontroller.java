package com.zxl.controller.sys;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TSort;
import com.zxl.entity.TUserinfo;
import com.zxl.service.TSortService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysSort")
public class SysSortcontroller {
    @Autowired
    private TSortService tSortService;

    @RequestMapping("findAll")
    public String findALl(Integer page , Integer pageSize, ModelMap modelMap){
        List<TSort> all = tSortService.findAll(page,pageSize, null);
        Integer count = tSortService.count();
        PageInfo<TSort> pageInfo=new PageInfo<>(all);
        Page page1=new Page(pageSize,page,count);
        modelMap.addAttribute("sorts",pageInfo);
        modelMap.addAttribute("pages",page1);
        return "sysSort";
    }
    @RequestMapping("/add")
    public String add(TSort tSort){
        tSortService.insert(tSort);
        return "redirect:/sysSort/findAll?page=1&pageSize=5";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        tSortService.deleteById(id);

        return "redirect:/sysSort/findAll?page=1&pageSize=5";
    }
    @RequestMapping("/toedit")
    public String toedit(Integer id,String sorts,ModelMap modelMap){
        TSort sort = new TSort();
        sort.setId(id);
        sort.setSorts(sorts);
        modelMap.addAttribute("sort",sort);
        return "sysSort_edit";
    }

    @RequestMapping("/edit")
    public String edit(TSort tSort){
        tSortService.update(tSort);
        return "redirect:/sysSort/findAll?page=1&pageSize=5";
    }
}
