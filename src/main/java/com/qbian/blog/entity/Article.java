package com.qbian.blog.entity;

import com.qbian.common.entity.BaseEntity;

/**
 * 文章实体类
 * Created by Qbian on 2017/3/24.
 */
public class Article extends BaseEntity {
    private String categoryId;
    private String name;
    private String preview;
    private String content;
    private int viewNum;

    @Override
    public String toString() {
        return "Article{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", preview='" + preview + '\'' +
                ", content='" + content + '\'' +
                ", viewNum=" + viewNum +
                '}';
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }
}
