package com.xianfeng92.beautylayoutmanager.TanTan;


/**
 * Created By zhongxianfeng on 19-4-9
 * github: https://github.com/xianfeng92
 */
public class SwipeCardEntity {
    private int postition;
    private String url;
    private String name;

    public SwipeCardEntity(int postition, String url, String name) {
        this.postition = postition;
        this.url = url;
        this.name = name;
    }

    public int getPostition() {
        return postition;
    }

    public SwipeCardEntity setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SwipeCardEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public SwipeCardEntity setName(String name) {
        this.name = name;
        return this;
    }
}
