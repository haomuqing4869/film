package com.zxl.entity;

import java.util.Arrays;

public class Msm {

    private Integer movieId;

    private String movieName;

    private Double price;

    private String scheduleTime;

    private String  scheduleDate;

    private Integer movieHallId;

    private String movieHallName;

    private String [] rc;

    private String cols;

    private  String rowsIndex;

    private Integer scheduleId;


    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getCols() {
        return cols;
    }

    public void setCols(String cols) {
        this.cols = cols;
    }

    public String getRowsIndex() {
        return rowsIndex;
    }

    public void setRowsIndex(String rowsIndex) {
        this.rowsIndex = rowsIndex;
    }

    public String[] getRc() {
        return rc;
    }

    public void setRc(String[] rc) {
        this.rc = rc;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getMovieHallId() {
        return movieHallId;
    }

    public void setMovieHallId(Integer movieHallId) {
        this.movieHallId = movieHallId;
    }

    public String getMovieHallName() {
        return movieHallName;
    }

    public void setMovieHallName(String movieHallName) {
        this.movieHallName = movieHallName;
    }

    @Override
    public String toString() {
        return "Msm{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", price=" + price +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", scheduleDate='" + scheduleDate + '\'' +
                ", movieHallId=" + movieHallId +
                ", movieHallName='" + movieHallName + '\'' +
                ", rc=" + Arrays.toString(rc) +
                ", cols='" + cols + '\'' +
                ", rowsIndex='" + rowsIndex + '\'' +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
