package com.xianfeng92.beautylayoutmanager.Gallery;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xianfeng92.beautylayoutmanager.R;
import java.util.List;

/**
 * Created By zhongxianfeng on 19-4-10
 * github: https://github.com/xianfeng92
 */
public class GalleryAdapter extends BaseQuickAdapter<GalleryCardEntity, BaseViewHolder> {

    public GalleryAdapter(int layoutResId, @Nullable List<GalleryCardEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GalleryCardEntity item) {
        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.iv_avatar));
    }
}
