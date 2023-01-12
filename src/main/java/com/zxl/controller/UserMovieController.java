package com.zxl.controller;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.TComment;
import com.zxl.entity.TMovie;
import com.zxl.entity.TSort;
import com.zxl.service.TCommentService;
import com.zxl.service.TMovieService;
import com.zxl.service.TSortService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class UserMovieController {
    @Autowired
    private TMovieService tMovieService;
    @Autowired
    private TSortService tSortService;
    @Autowired
    private TCommentService tCommentService;



    /**
     * 首页
     */

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        List<TMovie> movieList = new ArrayList<>();
        List<TMovie> movieList2 = new ArrayList<>();
        List<TMovie> movieList3 = new ArrayList<>();
        List<TMovie> movies = tMovieService.tMovieTop();
        List<TMovie> bysort1 = tMovieService.findBysort(1);
        for (int i = 0; i < 4; i++) {
            TMovie tMovie = bysort1.get(i);
            movieList.add(tMovie);
        }

        List<TMovie> bysort2 = tMovieService.findBysort(2);
        for (int i = 0; i < 8; i++) {
            TMovie tMovie = bysort2.get(i);
            movieList2.add(tMovie);
        }

        List<TMovie> findall = tMovieService.findall();
        for (int i = 0; i < 6; i++) {
            TMovie tMovie = findall.get(i);
            movieList3.add(tMovie);
        }


        List<TMovie> topBysortl = tMovieService.findTopBysort(1, 0, 5);
        List<TMovie> topBysortr = tMovieService.findTopBysort(1, 5, 5);
        List<TMovie> topBysortl1 = tMovieService.findTopBysort(2, 0, 5);
        List<TMovie> topBysortr1 = tMovieService.findTopBysort(2, 5, 5);

        modelMap.addAttribute("movies", movies);

        modelMap.addAttribute("comedy", movieList);
        modelMap.addAttribute("l", topBysortl);
        modelMap.addAttribute("r", topBysortr);

        modelMap.addAttribute("actions", movieList2);
        modelMap.addAttribute("l1", topBysortl1);
        modelMap.addAttribute("r1", topBysortr1);

        modelMap.addAttribute("all", movieList3);
        return "movies_home";
    }


    /**
     * 分类查询
     */
    @RequestMapping("/findBys")
    public String findByS(Integer sid,Integer page,Integer pageSize,ModelMap modelMap){
        List<TSort> all = tSortService.findAll(null);
        if (sid==0){
            List<TMovie> findall = tMovieService.findall(page, pageSize);
            PageInfo<TMovie> pageInfo=new PageInfo<>(findall);
            Integer count = tMovieService.findCount();
            Page page1=new Page(pageSize,page,count);
            modelMap.addAttribute("movies",pageInfo);
            modelMap.addAttribute("pages",page1);
        }else {
            List<TMovie> bysort = tMovieService.findBysort(sid, page, pageSize);
            Integer integer = tMovieService.countSort(sid);
            PageInfo<TMovie> pageInfo=new PageInfo<>(bysort);
            Page page1=new Page(pageSize,page,integer);
            modelMap.addAttribute("movies",pageInfo);
            modelMap.addAttribute("pages",page1);
        }
        modelMap.addAttribute("sortid",sid);
        modelMap.addAttribute("sorts",all);
        return "movies_more";
    }
    /**
     *
     * @param id 分类ID
     * @param modelMap　视图
     * @return　
     */
    @RequestMapping("/findBySort")
    public String findBySort(@RequestParam(value = "sid", required = true) Integer id, ModelMap modelMap) {
        List<TSort> all = tSortService.findAll(null);
        List<TMovie> bySortID = tMovieService.findBySortID(id);
        PageInfo pageInfo = new PageInfo(bySortID);
        modelMap.addAttribute("movies", pageInfo);
        modelMap.addAttribute("sorts", all);
        return "movie_list";
    }

    /**
     * @param id       电影ID
     * @param modelMap 视图
     * @return 点击的电影显示电影内容和评论信息
     */
    @RequestMapping("/findById")
    public String findById(@RequestParam(value = "id", required = true) Integer id, ModelMap modelMap) {
        TMovie tMovie = tMovieService.queryById(id);
        tMovie.setHit(tMovie.getHit() + 1);
        tMovieService.update(tMovie);
        TComment t = new TComment();
        t.setMovieobj(id);
        List<TComment> findall = tCommentService.findall(t);
        modelMap.addAttribute("movie", tMovie);
        modelMap.addAttribute("comments", findall);
        return "movie_detils";
    }

    /**
     * 电影名字模糊查询
     */
    @RequestMapping("/findByname")
    public String findByname(String name, ModelMap modelMap,
                             @RequestParam(value = "page", required = true) Integer page,
                             @RequestParam(value = "pagesize", required = true) Integer pagesize) {
        List<TMovie> movies = tMovieService.findBYname(name, page, pagesize);
        PageInfo pageInfo = new PageInfo(movies);
        modelMap.addAttribute("movies", pageInfo);
        return "movies_more";
    }

}
