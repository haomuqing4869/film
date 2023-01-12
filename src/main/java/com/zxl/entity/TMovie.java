package com.zxl.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * (TMovie)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:25:23
 */
public class TMovie implements Serializable {
    private static final long serialVersionUID = 203638591866512926L;
    /**
     * 电影id
     */
    private Integer movieid;
    /**
     * 电影
     */
    private String moviename;
    /**
     * 电影图片
     */
    private String moviephoto;

    private String director;

    private String mainperformer;
    /**
     * 时长
     */
    private String duration;

    private String area;

    private String releasedate;
    /**
     * 价钱
     */
    private String price;

    private String opera;

    /**
     * 点击量
     */
    private Integer hit;

    private List<TSort> sorts;

    private TSchedule tSchedule;

    public TSchedule gettSchedule() {
        return tSchedule;
    }

    public void settSchedule(TSchedule tSchedule) {
        this.tSchedule = tSchedule;
    }

    public Integer[] getSortid() {
        return sortid;
    }

    public void setSortid(Integer[] sortid) {
        this.sortid = sortid;
    }

    private Integer [] sortid;

    public List<TSort> getSorts() {
        return sorts;
    }

    public void setSorts(List<TSort> sorts) {
        this.sorts = sorts;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMoviephoto() {
        return moviephoto;
    }

    public void setMoviephoto(String moviephoto) {
        this.moviephoto = moviephoto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainperformer() {
        return mainperformer;
    }

    public void setMainperformer(String mainperformer) {
        this.mainperformer = mainperformer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "TMovie{" +
                "movieid=" + movieid +
                ", moviename='" + moviename + '\'' +
                ", moviephoto='" + moviephoto + '\'' +
                ", director='" + director + '\'' +
                ", mainperformer='" + mainperformer + '\'' +
                ", duration='" + duration + '\'' +
                ", area='" + area + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", price=" + price +
                ", opera='" + opera + '\'' +
                ", hit=" + hit +
                ", sorts=" + sorts +
                ", sortid=" + Arrays.toString(sortid) +
                '}';
    }
}