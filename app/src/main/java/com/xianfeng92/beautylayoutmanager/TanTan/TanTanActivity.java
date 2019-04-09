package com.xianfeng92.beautylayoutmanager.TanTan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.xianfeng92.beautylayoutmanager.CardLayoutManager.CardItemTouchHelperCallback;
import com.xianfeng92.beautylayoutmanager.CardLayoutManager.CardLayoutManager;
import com.xianfeng92.beautylayoutmanager.CardLayoutManager.OnCardSwipeListener;
import com.xianfeng92.beautylayoutmanager.R;
import com.xianfeng92.beautylayoutmanager.StatusBar.StatusBarUtil;
import java.util.List;

public class TanTanActivity extends AppCompatActivity {

    RecyclerView mRecycleView;
    TanTanAdapter tanTanAdapter;
    private CardItemTouchHelperCallback cardItemTouchHelperCallback;
    private CardLayoutManager cardLayoutManager;
    private List<SwipeCardEntity> mDatas = SwipeCardEntity.initDatas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tantan_layout);
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,false);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        StatusBarUtil.setTranslucentNavigationBar(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this,0x55000000);
        }
        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        tanTanAdapter = new TanTanAdapter(R.layout.tantan_item,mDatas);
        mRecycleView.setAdapter(tanTanAdapter);
        cardItemTouchHelperCallback = new CardItemTouchHelperCallback(tanTanAdapter,mDatas);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(cardItemTouchHelperCallback);
        cardLayoutManager = new CardLayoutManager(mRecycleView,itemTouchHelper);
        mRecycleView.setLayoutManager(cardLayoutManager);
        itemTouchHelper.attachToRecyclerView(mRecycleView);
        cardItemTouchHelperCallback.setOnCardSwipeListener(new OnCardSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {

            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int direction) {

            }

            @Override
            public void onSwipedClear() {

            }
        });
    }
}

