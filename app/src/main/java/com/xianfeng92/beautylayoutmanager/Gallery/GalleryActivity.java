package com.xianfeng92.beautylayoutmanager.Gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.xianfeng92.beautylayoutmanager.GalleryLayoutManager.GalleryLayoutManager;
import com.xianfeng92.beautylayoutmanager.R;
import com.xianfeng92.beautylayoutmanager.StatusBar.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    GalleryLayoutManager mGalleryLayoutManager;
    RecyclerView mRecycleView;
    GalleryAdapter mGalleryAdapter;
    List<GalleryCardEntity> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        StatusBarUtil.setStatusBarAndNavigationBarTranslucent(this);
        mRecycleView = findViewById(R.id.recyclerView);
        mGalleryLayoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        mGalleryLayoutManager.attach(mRecycleView);
        mGalleryLayoutManager.setOnItemSelectedListener(new GalleryLayoutManager.OnItemSelectedListener() {
            @Override
            public void onItemSelected(RecyclerView recyclerView, View item, int position) {

            }
        });
        mDatas.addAll(getDatas());
        mGalleryAdapter = new GalleryAdapter(R.layout.gallery_item,mDatas);
        mRecycleView.setAdapter(mGalleryAdapter);
    }


    public List<GalleryCardEntity> getDatas() {
        List<GalleryCardEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg","起","依楼听风雨，淡看江湖路"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg","名", "明月几时有？把酒问青天"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg", "字","恰同学少年，风华正茂"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg", "真","夜来风雨声，花落知多少"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg", "的","但愿人长久，千里共婵娟"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg", "好","故人西辞黄鹤楼，烟花三月下扬州"));
        datas.add(new GalleryCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg", "难","问君能有几多愁？恰似一江春水向东流"));
        datas.add(new GalleryCardEntity(i++, "https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg", "呀","寂寞空庭春欲晚，梨花满地不开门"));
        return datas;
    }
}
