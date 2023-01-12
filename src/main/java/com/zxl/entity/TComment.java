package com.zxl.entity;

import java.io.Serializable;

/**
 * (TComment)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:18:01
 */
public class TComment implements Serializable {
    private static final long serialVersionUID = -67987860200491556L;
    /**
     * Ӱ
     */
    private Integer commentid;

    private Integer movieobj;
    /**
     * Ӱ
     */
    private String content;

    private String userobj;

    private String commenttime;

    private TMovie tMovie;

    public TMovie gettMovie() {
        return tMovie;
    }

    public void settMovie(TMovie tMovie) {
        this.tMovie = tMovie;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getMovieobj() {
        return movieobj;
    }

    public void setMovieobj(Integer movieobj) {
        this.movieobj = movieobj;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserobj() {
        return userobj;
    }

    public void setUserobj(String userobj) {
        this.userobj = userobj;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    @Override
    public String toString() {
        return "TComment{" +
                "commentid=" + commentid +
                ", movieobj=" + movieobj +
                ", content='" + content + '\'' +
                ", userobj='" + userobj + '\'' +
                ", commenttime='" + commenttime + '\'' +
                '}';
    }
}