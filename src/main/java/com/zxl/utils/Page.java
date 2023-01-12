package com.zxl.utils;
public class Page {
    //页容量
    private Integer pageSize;
    //当前页
    private Integer page;
    //数据总条数
    private Integer count;
    //页数
    private Integer total;
    //首页
    private Integer fristpage;
    //尾页
    private Integer lastpage;
    //
    private Integer[] pageInfo;

    public Page(Integer pageSize, Integer page, Integer count) {
        this.pageSize = pageSize;
        this.page = page;
        this.count = count;
    }

    public Page() {
    }

    public Integer getFristpage() {
        return fristpage;
    }

    public void setFristpage(Integer fristpage) {
        this.fristpage = fristpage;
    }

    public Integer getLastpage() {
        return lastpage;
    }

    public void setLastpage(Integer lastpage) {
        this.lastpage = lastpage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        if (page>=this.getTotal()){
            this.page = this.getTotal();
        }else if (page<=0){
            this.page=0;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page=page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        if (count % pageSize == 0) {
            total = count / pageSize;
        } else {
            total = count / pageSize + 1;
        }
        return total;
    }

    public void setTotal(Integer total) {
        if (count % pageSize == 0) {
            this.total = count / pageSize;
        } else {
            this.total = count / pageSize + 1;
        }
    }

    public Integer[] getPageInfo() {
        if (this.getTotal() < 5) {
            pageInfo = new Integer[this.getTotal()];
            for (int i = 0; i < pageInfo.length; i++) {
                pageInfo[i] = i;
            }
        } else if (page >= 0 && page < 4) {
            pageInfo = new Integer[5];
            for (int i = 0; i < pageInfo.length; i++) {
                pageInfo[i] = i;
            }
        } else if (this.getTotal()-page>2){
            pageInfo = new Integer[5];
            int j=0;
            for (int i = page - 2; i < page + 3; i++) {
                pageInfo[j] = i;
                j++;
            }
        }else {
            pageInfo = new Integer[5];
            int j=0;
            for (int i = total-4; i <=total; i++) {
                pageInfo[j] = i;
                j++;
            }
        }
            return pageInfo;
    }
}