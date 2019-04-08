package com.xianfeng92.beautylayoutmanager.CardLayoutManager;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import java.util.List;

/**
 * Created By zhongxianfeng on 19-4-8
 * github: https://github.com/xianfeng92
 */
public class CardItemTouchHelperCallback<T> extends ItemTouchHelper.Callback {

    private final RecyclerView.Adapter adapter;
    private List<T> dataList;
    private OnCardSwipeListener<T> onCardSwipeListener;

    public CardItemTouchHelperCallback(RecyclerView.Adapter adapter,List<T> dataList){
        this.adapter = adapter;
        this.dataList = dataList;
    }

    public CardItemTouchHelperCallback(RecyclerView.Adapter adapter, List<T> dataList,OnCardSwipeListener onCardSwipeListener){
        this(adapter,dataList);
        this.onCardSwipeListener = onCardSwipeListener;
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        View itemView = viewHolder.itemView;
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            float ratio = dX / getThreshold(recyclerView,viewHolder);
            // ratio 最大为 1 或 -1
            if (ratio > 1) {
                ratio = 1;
            } else if (ratio < -1) {
                ratio = -1;
            }
            itemView.setRotation(ratio * CardConfig.DEFAULT_ROTATE_DEGREE);
            int childCount = recyclerView.getChildCount();
            if (childCount < 1){
                return;
            }
            int bottomPosition;
            if (childCount < CardConfig.DEFAULT_SHOW_ITEM_COUNT){
                bottomPosition = 0;
            }else {
                bottomPosition = childCount - CardConfig.DEFAULT_SHOW_ITEM_COUNT;
            }
            for(int postion = bottomPosition ; postion < childCount; postion++){
                int index = childCount - postion - 1;
                View view = recyclerView.getChildAt(postion);
                view.setScaleX(1 - index * CardConfig.DEFAULT_SCALE + Math.abs(ratio) * CardConfig.DEFAULT_SCALE);
                view.setScaleY(1 - index * CardConfig.DEFAULT_SCALE + Math.abs(ratio) * CardConfig.DEFAULT_SCALE);
                view.setTranslationY((index - Math.abs(ratio)) * itemView.getMeasuredHeight() / CardConfig.DEFAULT_TRANSLATE_Y);
            }
            if (onCardSwipeListener != null) {
                if (ratio != 0) {
                    onCardSwipeListener.onSwiping(viewHolder, ratio, ratio < 0 ? CardConfig.SWIPING_LEFT : CardConfig.SWIPING_RIGHT);
                } else {
                    onCardSwipeListener.onSwiping(viewHolder, ratio, CardConfig.SWIPING_NONE);
                }
            }
        }
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        int swipeFlags = 0;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof CardLayoutManager) {
            // 对于 swipeFlags 只关心左右两个方向
            swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    //对于 dragFlags 配置的是 0,onMove直接返回 false
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // 移除之前设置的 onTouchListener, 否则触摸滑动会乱了
        viewHolder.itemView.setOnClickListener(null);
        int layoutPosition = viewHolder.getLayoutPosition();
        T remove = dataList.remove(layoutPosition);
        adapter.notifyDataSetChanged();
        // 卡片滑出后回调 onCardSwipeListener 监听器的 onSwiped
        if (onCardSwipeListener != null) {
            onCardSwipeListener.onSwiped(viewHolder, remove, i == ItemTouchHelper.LEFT ? CardConfig.SWIPED_LEFT : CardConfig.SWIPED_RIGHT);
        }
        // 当没有数据时回调 onCardSwipeListener 监听器的 onSwipedClear
        if (adapter.getItemCount() == 0) {
            if (onCardSwipeListener != null) {
                onCardSwipeListener.onSwipedClear();
            }
        }
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    public void setOnCardSwipeListener(OnCardSwipeListener onCardSwipeListener){
        this.onCardSwipeListener = onCardSwipeListener;
    }

    private <T> T checkIsNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    private float getThreshold(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return recyclerView.getWidth() * getSwipeThreshold(viewHolder);
    }
}
