package com.hdy.fast.FastCopy;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.hdy.fast.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者：By hdy
 * 日期：On 2017/9/10
 * 时间：At 17:26
 */

public class adapter_recyclerview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private JSONArray jsonArray;
    private onItemClickListener onItemClickListener;
    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;
    public adapter_recyclerview(Context context, JSONArray jsonArray){
        this.context=context;
        this.jsonArray=jsonArray;
    }
    public interface onItemClickListener{
        void onItemClickPlayer(View view, int position);
        void onItemClickHead(View view, int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    public int getItemViewType(int position) {
        try {
            JSONObject jsonObject=jsonArray.getJSONObject(position);
            if(jsonObject.get("type").equals("1"))return TYPE_1;
            else return TYPE_2;
        } catch (JSONException e) {
            e.printStackTrace();
            return TYPE_2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_2:
                return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test1_1_cardview,parent,false));
            case TYPE_1:
                return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test1_1_cardview,parent,false));
            default:return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test1_1_cardview,parent,false));
        }
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {

        //一张图片的holder
        if(viewHolder instanceof MyViewHolder) {
            final MyViewHolder holder=(MyViewHolder)viewHolder;
            try {
                JSONObject jsonObject=jsonArray.getJSONObject(position);
                holder.name.setText(jsonObject.getString("name"));//初始化
                holder.detail.setText(jsonObject.getString("detail"));
                if(jsonObject.getString("music").equals("nomusic")){
                    holder.player.setVisibility(View.INVISIBLE);
                    holder.player.setClickable(false);
                }
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.loading);
                Glide.with(context)
                        .asBitmap()
                        .load(jsonObject.getString("head"))
                        .apply(options)
                        .into(new BitmapImageViewTarget(holder.head){
                            @Override
                            protected void setResource(Bitmap resource) {
                                RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                                roundedBitmapDrawable.setCircular(true);
                                holder.head.setImageDrawable(roundedBitmapDrawable);
                            }
                        });
                Glide.with(context)
                        .load(jsonObject.getString("img1"))
                        .apply(options)
                        .into(holder.pic);
            if (onItemClickListener != null) {//设置点击事件
                holder.player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onItemClickPlayer(holder.player, pos);
                    }
                });
                holder.head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onItemClickHead(holder.head,pos);
                    }
                });
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView player,pic,head;
        TextView name,detail;
        MyViewHolder(View itemView) {
            super(itemView);
            player= itemView.findViewById(R.id.test1_1_img_player);
            pic=itemView.findViewById(R.id.test1_1_img_detail);
            head=itemView.findViewById(R.id.test1_1_img_head);
            name=itemView.findViewById(R.id.test1_1_textview_title);
            detail=itemView.findViewById(R.id.test1_1_testview_detail);
        }
    }
}
