package com.xianfeng92.beautylayoutmanager.TanTan;

import java.util.ArrayList;
import java.util.List;

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

    public static List<SwipeCardEntity> initDatas() {
        List<SwipeCardEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg", "我是"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg", "Demo"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg", "多种type"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg", "多种type"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg", "多种type"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg", "多种type"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg", "多种type"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg", "多种type"));
        return datas;
    }
}
