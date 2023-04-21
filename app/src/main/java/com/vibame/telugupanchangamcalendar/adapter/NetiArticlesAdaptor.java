package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.ArticleViewActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
import com.vibame.telugupanchangamcalendar.model.NetiData;

import java.util.ArrayList;

public class NetiArticlesAdaptor extends RecyclerView.Adapter<NetiArticlesAdaptor.ExploreItemHolder> {
    final Activity activity;
    ArrayList<NetiData> netiData;

    public NetiArticlesAdaptor(Activity activity, ArrayList<NetiData> netiData) {
        this.activity = activity;
        this.netiData = netiData;
    }

    @NonNull
    @Override
    public ExploreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.articles_view_layout, parent, false);
        return new NetiArticlesAdaptor.ExploreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreItemHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final NetiData netiDatas = netiData.get(position);


        holder.tvTitle.setText(netiDatas.getTitle());
        Glide.with(activity).load(netiDatas.getImage()).into(holder.imgGod);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ArticleViewActivity.class);
                intent.putExtra(Constant.ID,netiDatas.getId());
                intent.putExtra(Constant.TITLE,netiDatas.getTitle());
                intent.putExtra(Constant.NAME,"పుణ్యక్షేత్రాలు");
                intent.putExtra(Constant.DESCRIPTION,netiDatas.getDescription());
                intent.putExtra(Constant.IMAGE,netiDatas.getImage());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return netiData.size(); }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgGod;
        final TextView tvTitle;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgGod = itemView.findViewById(R.id.imgGod);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

}
