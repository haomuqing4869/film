package com.zxl.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * (TMoviehall)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:25:31
 */

public class TMoviehall implements Serializable {
    private static final long serialVersionUID = -49296119683942920L;
    /**
     * 影厅id
     */
    private Integer moviehallid;
    /**
     * 影厅名
     */
    private String moviehallname;
    /**
     * 排
     */
    private Integer rows;
    /**
     * 列
     */
    private Integer cols;

    public Integer getMoviehallid() {
        return moviehallid;
    }

    public void setMoviehallid(Integer moviehallid) {
        this.moviehallid = moviehallid;
    }

    public String getMoviehallname() {
        return moviehallname;
    }

    public void setMoviehallname(String moviehallname) {
        this.moviehallname = moviehallname;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    @Override
    public String toString() {
        return "TMoviehall{" +
                "moviehallid=" + moviehallid +
                ", moviehallname='" + moviehallname + '\'' +
                ", rows=" + rows +
                ", cols=" + cols +
                '}';
    }
}