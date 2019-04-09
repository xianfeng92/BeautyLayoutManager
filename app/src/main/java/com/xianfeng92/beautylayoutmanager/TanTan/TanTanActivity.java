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

