package com.zxl.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (TSchedule)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:25:40
 */
public class TSchedule implements Serializable {
    private static final long serialVersionUID = 749252848775505201L;

    private Integer scheduleid;

    private Integer movieobj;

    private Integer hallobj;

    private String scheduledate;

    private String scheduletime;

    private List<TMoviehall> moviehalls;

    private TMovie tMovie;

    public TMovie gettMovie() {
        return tMovie;
    }

    public void settMovie(TMovie tMovie) {
        this.tMovie = tMovie;
    }

    public List<TMoviehall> getMoviehalls() {
        return moviehalls;
    }

    public void setMoviehalls(List<TMoviehall> moviehalls) {
        this.moviehalls = moviehalls;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getMovieobj() {
        return movieobj;
    }

    public void setMovieobj(Integer movieobj) {
        this.movieobj = movieobj;
    }

    public Integer getHallobj() {
        return hallobj;
    }

    public void setHallobj(Integer hallobj) {
        this.hallobj = hallobj;
    }

    public String getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(String scheduledate) {
        this.scheduledate = scheduledate;
    }

    public String getScheduletime() {
        return scheduletime;
    }

    public void setScheduletime(String scheduletime) {
        this.scheduletime = scheduletime;
    }

    @Override
    public String toString() {
        return "TSchedule{" +
                "scheduleid=" + scheduleid +
                ", movieobj=" + movieobj +
                ", hallobj=" + hallobj +
                ", scheduledate='" + scheduledate + '\'' +
                ", scheduletime='" + scheduletime + '\'' +
                ", moviehalls=" + moviehalls +
                '}';
    }
}