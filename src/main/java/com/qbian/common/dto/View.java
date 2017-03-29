package com.qbian.common.dto;

/**
 * Created by Qbian on 2017/3/23.
 */
public class View{
    private String name;
    private String id;
    private String preview;

    public View(String name, String id, String preview) {
        this.name = name;
        this.id = id;
        this.preview = preview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
