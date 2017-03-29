package com.qbian.common.dto;

/**
 * Created by Qbian on 2017/3/27.
 */
public class Page {
    /**
     * 当前页
     */
    private int pageIndex;

    /**
     * 返回状态
     */
    private int pageSize;

    /**
     * 返回状态
     */
    private int total;

    public Page(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
