package com.xianfeng92.beautylayoutmanager.Carouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.xianfeng92.beautylayoutmanager.Carousellayoutmanager.CarouselLayoutManager;
import com.xianfeng92.beautylayoutmanager.Carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.xianfeng92.beautylayoutmanager.Carousellayoutmanager.CenterScrollListener;
import com.xianfeng92.beautylayoutmanager.R;
import com.xianfeng92.beautylayoutmanager.StatusBar.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;

public class CarouseActivtity extends AppCompatActivity {

    // vertical and cycle layout
    CarouselLayoutManager layoutManager;
    private RecyclerView mRecyclerView;
    List<CarouseCardEntity> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carouse_layout);
        StatusBarUtil.setStatusBarAndNavigationBarTranslucent(this);
        mDatas.addAll(getDatas());
        layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new CarouseAdapter(R.layout.carouse_item,mDatas));
        mRecyclerView.addOnScrollListener(new CenterScrollListener());
    }

    public List<CarouseCardEntity> getDatas() {
        List<CarouseCardEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg","科比","依楼听风雨，淡看江湖路"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg","詹姆斯", "明月几时有？把酒问青天"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg", "欧文","恰同学少年，风华正茂"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg", "哈登","夜来风雨声，花落知多少"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg", "恩比德","但愿人长久，千里共婵娟"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg", "字母歌","故人西辞黄鹤楼，烟花三月下扬州"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg", "韦德","问君能有几多愁？恰似一江春水向东流"));
        datas.add(new CarouseCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg", "姚明","寂寞空庭春欲晚，梨花满地不开门"));
        return datas;
    }
}
