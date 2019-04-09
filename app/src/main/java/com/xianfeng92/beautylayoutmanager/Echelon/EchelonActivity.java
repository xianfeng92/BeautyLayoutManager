package com.xianfeng92.beautylayoutmanager.Echelon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.xianfeng92.beautylayoutmanager.EchelonLayoutManager.EchelonLayoutManager;
import com.xianfeng92.beautylayoutmanager.R;
import com.xianfeng92.beautylayoutmanager.StatusBar.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class EchelonActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EchelonLayoutManager mLayoutManager;
    List<EchelonCardEntity> mDatas;
    private EchelonAdapter echelonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.echelon_layout);
        StatusBarUtil.setStatusBarAndNavigationBarTranslucent(this);
        mRecyclerView = findViewById(R.id.recyclerView);
        mDatas = getDatas();
        init();
    }

    private void init() {
        mLayoutManager = new EchelonLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        echelonAdapter = new EchelonAdapter(R.layout.echelon_item,mDatas);
        mRecyclerView.setAdapter(echelonAdapter);
    }

    public List<EchelonCardEntity> getDatas() {
        List<EchelonCardEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg","科比","依楼听风雨，淡看江湖路"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg","詹姆斯", "明月几时有？把酒问青天"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg", "欧文","恰同学少年，风华正茂"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg", "哈登","夜来风雨声，花落知多少"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg", "恩比德","但愿人长久，千里共婵娟"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg", "字母歌","故人西辞黄鹤楼，烟花三月下扬州"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg", "韦德","问君能有几多愁？恰似一江春水向东流"));
        datas.add(new EchelonCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg", "姚明","寂寞空庭春欲晚，梨花满地不开门"));
        return datas;
    }
}
