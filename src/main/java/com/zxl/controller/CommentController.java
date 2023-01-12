package com.zxl.controller;

import com.zxl.entity.TComment;
import com.zxl.service.TCommentService;
import com.zxl.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private TCommentService tCommentService;

    @RequestMapping("/save")
    public String save(TComment tComment){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        tComment.setUserobj(name);
        Date date=new Date();
        String date1 = DateUtils.getDate(date);
        tComment.setCommenttime(date1);
        tCommentService.insert(tComment);
        Integer movieobj = tComment.getMovieobj();
        System.out.println(movieobj);
        String id=String.valueOf(movieobj);
        return "redirect:/movies/findById?id="+id;
    }
}
