package com.zxl.controller.sys;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TComment;
import com.zxl.service.TCommentService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysComment")
public class SysCommentController {
    @Autowired
    private TCommentService tCommentService;

    @RequestMapping("/findAll")
    public String findAll(Integer page, Integer pageSize, ModelMap modelMap){
        List<TComment> findall = tCommentService.findsysall(page,pageSize);
        Integer count = tCommentService.count();
        Page page1=new Page(pageSize,page,count);
        PageInfo<TComment> pageInfo=new PageInfo<>(findall);
        modelMap.addAttribute("comments",pageInfo);
        modelMap.addAttribute("pages",page1);
        return "sysComment";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        tCommentService.deleteById(id);
        return "redirect:/sysComment/findAll?page=1&pageSize=8";
    }
}
