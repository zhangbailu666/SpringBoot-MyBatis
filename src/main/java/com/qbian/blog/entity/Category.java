package com.qbian.blog.entity;

import com.qbian.common.entity.BaseEntity;

/**
 * 类别实体
 * Created by Qbian on 2017/3/24.
 */
public class Category extends BaseEntity {
    private String name;
    private String introduction;
    private String preview;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", preview='" + preview + '\'' +
                '}' + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
