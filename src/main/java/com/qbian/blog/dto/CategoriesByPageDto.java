package com.qbian.blog.dto;

import com.qbian.common.dto.Page;

/**
 * Created by Qbian on 2017/3/27.
 */
public class CategoriesByPageDto extends Page{
    private Integer delFlag;

    public CategoriesByPageDto(int pageNo, int pageSize, Integer delFlag) {
        super(pageNo, pageSize);
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
