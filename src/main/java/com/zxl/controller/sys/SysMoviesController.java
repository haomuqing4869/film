package com.zxl.controller.sys;


import com.github.pagehelper.PageInfo;
import com.zxl.entity.TMovie;
import com.zxl.entity.TMoviehall;
import com.zxl.entity.TSchedule;
import com.zxl.entity.TSort;
import com.zxl.service.TMovieService;
import com.zxl.service.TMoviehallService;
import com.zxl.service.TScheduleService;
import com.zxl.service.TSortService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/sysMovies")
public class SysMoviesController {
    @Autowired
    private TMovieService tMovieService;
    @Autowired
    private TSortService tSortService;
    @Autowired
    private TScheduleService tScheduleService;
    @Autowired
    private TMoviehallService tMoviehallService;

    @RequestMapping("/findAll")
    public String findAll(Integer page,Integer pageSize,ModelMap modelMap){
        List<TMovie> findall = tMovieService.findall(page, pageSize);
        PageInfo<TMovie> pageInfo=new PageInfo<>(findall);
        Integer count = tMovieService.findCount();
        Page page1=new Page(pageSize,page,count);

        List<TMoviehall> all = tMoviehallService.findAll(null);
        modelMap.addAttribute("movies",pageInfo);
        modelMap.addAttribute("pages",page1);
        modelMap.addAttribute("halls",all);
        return "sysmovie";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        tMovieService.deleteById(id);
        return "redirect:/sysMovies/findAll?page=1&pageSize=10";
    }
    @RequestMapping("/toAdd")
    public String toAdd(ModelMap modelMap){
        List<TSort> all = tSortService.findAll(null);
        modelMap.addAttribute("sorts",all);
        return "movie_add";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request,MultipartFile photo,TMovie tMovie) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/");

        path=path+"/static/image";
        String filename=photo.getOriginalFilename();
        String movieP="/static/image/"+filename;
        tMovie.setMoviephoto(movieP);
        System.out.println(tMovie);
        tMovieService.insert(tMovie);
        photo.transferTo(new File(path,filename));
        return "redirect:/sysMovies/findAll?page=1&pageSize=10";
    }
    @RequestMapping("/toEdit")
    public String toEdit(Integer id,ModelMap modelMap){
        TMovie tMovie = tMovieService.queryById(id);
        List<TSort> notByMid = tSortService.findNotByMid(id);
        modelMap.addAttribute("movie",tMovie);
        modelMap.addAttribute("sorts",notByMid);
        return "movie_edit";
    }
    @RequestMapping("/edit")
    public String edit(TMovie tMovie){
        tMovieService.updateMs(tMovie);
        return "redirect:/sysMovies/findAll?page=1&pageSize=10";
    }
    @RequestMapping("/putShelf")
    public String putShelf(TSchedule tSchedule){
        tScheduleService.insert(tSchedule);
        return "redirect:/sysSchedule/findAll?page=1&pageSize=8";
    }
    @RequestMapping("/show")
    public @ResponseBody
            List<TMovie> show(){
        List<TMovie> findall = tMovieService.findall();

        return findall;
    }
    @RequestMapping("/sortHit")
    public @ResponseBody
    List<TSort> sortHit(){
        List<TSort> tSorts = tMovieService.countHit();
        return tSorts;
    }

    @RequestMapping("/findSome")
    public String findSome(TMovie tMovie,ModelMap modelMap,Integer page,Integer pageSize){
        List<TMovie> movies=tMovieService.findSome(tMovie,page,pageSize);
        PageInfo<TMovie> pageInfo=new PageInfo<>(movies);
        modelMap.addAttribute("movies",pageInfo);
        return "sysmovie";
    }

}
