package com.xianfeng92.beautylayoutmanager.TanTan;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xianfeng92.beautylayoutmanager.R;
import java.util.List;

/**
 * Created By zhongxianfeng on 19-2-2
 * github: https://github.com/xianfeng92
 */
public class TanTanAdapter extends BaseQuickAdapter<SwipeCardEntity, BaseViewHolder> {

    public TanTanAdapter(int layoutResId, List<SwipeCardEntity> mDatas){
        super(layoutResId,mDatas);
    }

    @Override
    protected void convert(BaseViewHolder helper, SwipeCardEntity item) {
        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.iv_avatar));
    }
}
