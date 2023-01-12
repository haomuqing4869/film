package com.zxl.entity;

import java.io.Serializable;

/**
 * (TMovieorder)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:25:35
 */
public class TMovieorder implements Serializable {
    private static final long serialVersionUID = -44922188597083044L;

    private Integer orderid;

    private Integer scheduleobj;

    private Integer rowsindex;

    private Integer cols;
    /**
     * 价钱
     */
    private Object price;

    private String userobj;
    /**
     * 下单时间
     */
    private String ordertime;

    private TMovie tMovie;

    private TSchedule tSchedule;

    private TMoviehall tMoviehall;

    private TUserinfo tUserinfo;



    /**
     * 订单状态
     * 0.待支付
     * 1.待出票
     * 2.已出票
     * 3.取消订单
     */

    private Integer status;

    private String statusStr;

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public TMoviehall gettMoviehall() {
        return tMoviehall;
    }

    public void settMoviehall(TMoviehall tMoviehall) {
        this.tMoviehall = tMoviehall;
    }

    public TMovie gettMovie() {
        return tMovie;
    }

    public void settMovie(TMovie tMovie) {
        this.tMovie = tMovie;
    }

    public TSchedule gettSchedule() {
        return tSchedule;
    }

    public void settSchedule(TSchedule tSchedule) {
        this.tSchedule = tSchedule;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getScheduleobj() {
        return scheduleobj;
    }

    public void setScheduleobj(Integer scheduleobj) {
        this.scheduleobj = scheduleobj;
    }

    public Integer getRowsindex() {
        return rowsindex;
    }

    public void setRowsindex(Integer rowsindex) {
        this.rowsindex = rowsindex;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public String getUserobj() {
        return userobj;
    }

    public void setUserobj(String userobj) {
        this.userobj = userobj;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (this.status==0){
            statusStr="待支付";
        }else if (this.status==1){
            statusStr="待出票";
        }else if(this.status==2){
            statusStr="已出票";
        }else {
            statusStr="已取消";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    @Override
    public String toString() {
        return "TMovieorder{" +
                "orderid=" + orderid +
                ", scheduleobj=" + scheduleobj +
                ", rowsindex=" + rowsindex +
                ", cols=" + cols +
                ", price=" + price +
                ", userobj='" + userobj + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", tMovie=" + tMovie +
                ", tSchedule=" + tSchedule +
                ", tMoviehall=" + tMoviehall +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                '}';
    }
}