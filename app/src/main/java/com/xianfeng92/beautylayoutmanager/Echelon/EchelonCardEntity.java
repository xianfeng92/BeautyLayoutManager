package com.xianfeng92.beautylayoutmanager.Echelon;


/**
 * Created By zhongxianfeng on 19-4-9
 * github: https://github.com/xianfeng92
 */
public class EchelonCardEntity {

    private int postition;
    private String url;
    private String name;
    private String content;

    public EchelonCardEntity(int postition, String url, String name, String content) {
        this.postition = postition;
        this.url = url;
        this.name = name;
        this.content = content;
    }

    public int getPostition() {
        return postition;
    }

    public EchelonCardEntity setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public EchelonCardEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public EchelonCardEntity setName(String name) {
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
