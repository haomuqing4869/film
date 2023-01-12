package com.zxl.entity;

import java.io.Serializable;

/**
 * (TSort)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:27:52
 */
public class TSort implements Serializable {
    private static final long serialVersionUID = -43408998428089381L;

    private Integer id;

    private String sorts;

    private Integer hit;

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    @Override
    public String toString() {
        return "TSort{" +
                "id=" + id +
                ", sorts='" + sorts + '\'' +
                '}';
    }
}