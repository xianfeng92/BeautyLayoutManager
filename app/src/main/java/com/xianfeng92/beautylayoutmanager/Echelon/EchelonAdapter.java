package com.xianfeng92.beautylayoutmanager.Echelon;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xianfeng92.beautylayoutmanager.R;
import java.util.List;

/**
 * Created By zhongxianfeng on 19-4-9
 * github: https://github.com/xianfeng92
 */
public class EchelonAdapter extends BaseQuickAdapter<EchelonCardEntity, BaseViewHolder> {


    public EchelonAdapter(int layoutResId, @Nullable List<EchelonCardEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EchelonCardEntity item) {
        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.img_bg));
        TextView textView = helper.getView(R.id.tv_desc);
        textView.setText(item.getContent());
        TextView textView1 = helper.getView(R.id.tv_nickname);
        textView1.setText(item.getName());
    }
}
