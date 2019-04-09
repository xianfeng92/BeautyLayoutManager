package com.xianfeng92.beautylayoutmanager.Carouse;


/**
 * Created By zhongxianfeng on 19-4-9
 * github: https://github.com/xianfeng92
 */
public class CarouseCardEntity {

    private int postition;
    private String url;
    private String name;
    private String content;

    public CarouseCardEntity(int postition, String url, String name, String content) {
        this.postition = postition;
        this.url = url;
        this.name = name;
        this.content = content;
    }

    public int getPostition() {
        return postition;
    }

    public CarouseCardEntity setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CarouseCardEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarouseCardEntity setName(String name) {
        this.name = name;
        return this;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
