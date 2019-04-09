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
import java.util.ArrayList;
import java.util.List;

public class TanTanActivity extends AppCompatActivity {

    RecyclerView mRecycleView;
    TanTanAdapter tanTanAdapter;
    private CardItemTouchHelperCallback cardItemTouchHelperCallback;
    private CardLayoutManager cardLayoutManager;
    private List<SwipeCardEntity> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tantan_layout);
        mDatas.addAll(getDatas());
        StatusBarUtil.setStatusBarAndNavigationBarTranslucent(this);
        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        tanTanAdapter = new TanTanAdapter(R.layout.tantan_item,mDatas);
        mRecycleView.setAdapter(tanTanAdapter);
        setCardItemTouchHelperCallback();
    }

    public static List<SwipeCardEntity> getDatas() {
        List<SwipeCardEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg", "起"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg", "一"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg", "个"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg", "名"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg", "字"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg", "好"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg", "难"));
        datas.add(new SwipeCardEntity(i++, "https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg", "呀"));
        return datas;
    }


    private void setCardItemTouchHelperCallback(){
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

