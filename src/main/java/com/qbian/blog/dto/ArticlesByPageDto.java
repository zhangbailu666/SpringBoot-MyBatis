package com.qbian.blog.dto;

import com.qbian.common.dto.Page;

/**
 * Created by Qbian on 2017/3/27.
 */
public class ArticlesByPageDto extends Page {
    private Integer delFlag;

    private String categoryId;

    public ArticlesByPageDto(int pageIndex, int pageSize, Integer delFlag, String categoryId) {
        super(pageIndex, pageSize);
        this.delFlag = delFlag;
        this.categoryId = categoryId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
