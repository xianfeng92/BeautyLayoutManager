package com.xianfeng92.beautylayoutmanager.CardLayoutManager;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created By zhongxianfeng on 19-4-8
 * github: https://github.com/xianfeng92
 */
public class CardLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = "CardLayoutManager";

    private RecyclerView recyclerView;
    private ItemTouchHelper touchHelper;

    public CardLayoutManager(RecyclerView recyclerView, ItemTouchHelper touchHelper){
        this.recyclerView = recyclerView;
        this.touchHelper = touchHelper;
    }

    /*
    * This is actually the only required override to get your LayoutManager to compile.
    * The implementation is pretty straightforward, just return a new instance of the RecyclerView.LayoutParams
    * that you want applied by default to all the child views returned from the Recycler.
    * These parameters will be applied to each child before they return from getViewForPosition().
     * */
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /*
    * This method will be called when the view needs to do an initial layout,
    * and again whenever the adapter data set changes (or the entire adapter is swapped out).
    * */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d(TAG, "onLayoutChildren: called with: recycler=["+recycler+"], state=["+state+"]");
       //Clear all attached views into the recycle pool
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount < 1){
            return;
        }
        int bottomPosition;
        if (itemCount < CardConfig.DEFAULT_SHOW_ITEM_COUNT){
            bottomPosition = 0;
        }else {
            bottomPosition = itemCount - CardConfig.DEFAULT_SHOW_ITEM_COUNT;
        }
        //从可见的最底层View开始layout，依次层叠上去
        for(int position = bottomPosition; position < itemCount; position ++){
            View view = recycler.getViewForPosition(position);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
            //我们在布局时，将 childView 居中处理
            layoutDecoratedWithMargins(view,widthSpace/2,heightSpace/2,
                    widthSpace/2+getDecoratedMeasuredWidth(view),heightSpace/2+getDecoratedMeasuredHeight(view));

            /**
             * TopView 的 Scale 为1，translationY 0
             * top-1View的Scale慢慢变化至1，translation也慢慢恢复0
             * top-2View的Scale慢慢变化至 top-1View的Scale，translation 也慢慢变化只top-1View的translation
             * top-3View的Scale要变化，translation 不动
             */
            // level 为层级。假设 itemCount 为6，则最后一个TopView（5）是第0层，即当前在屏幕中全部显示出来的itemView
            int level = itemCount - position - 1;
            // level < mShowCount - 1
            if (level > 0) {
                //每一层都需要 X 方向的缩小
                view.setScaleX(1 - CardConfig.DEFAULT_SCALE * level);
                //前N层，依次向下位移和Y方向的缩小
                if (level < CardConfig.DEFAULT_SHOW_ITEM_COUNT - 1) {
                    view.setTranslationY(CardConfig.DEFAULT_TRANSLATE_Y * level);
                    view.setScaleY(1 - CardConfig.DEFAULT_SCALE * level);
                } else {//第N层在 向下位移和Y方向的缩小的成都与 N-1层保持一致
                    view.setTranslationY(CardConfig.DEFAULT_TRANSLATE_Y * (level - 1));
                    view.setScaleY(1 - CardConfig.DEFAULT_SCALE * (level - 1));
                }
            }else{
                // 给顶层 TopView 设置Listener 来处理滑动中的一些事件
                view.setOnTouchListener(mOnTouchListener);
            }
        }
    }

    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(v);
            // 把触摸事件交给 mItemTouchHelper,让其处理卡片滑动事件
            if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                touchHelper.startSwipe(childViewHolder);
            }
            return false;
        }
    };

}
