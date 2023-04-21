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
import com.vibame.telugupanchangamcalendar.model.NetiData;
import com.vibame.telugupanchangamcalendar.model.OldData;

import java.util.ArrayList;

public class OldArticlesAdaptor extends RecyclerView.Adapter<OldArticlesAdaptor.ExploreItemHolder> {
    final Activity activity;
    ArrayList<OldData> oldData;

    public OldArticlesAdaptor(Activity activity, ArrayList<OldData> oldData) {
        this.activity = activity;
        this.oldData = oldData;
    }

    @NonNull
    @Override
    public OldArticlesAdaptor.ExploreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.articles_view_layout, parent, false);
        return new OldArticlesAdaptor.ExploreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OldArticlesAdaptor.ExploreItemHolder holderParent, int position) {
        final OldArticlesAdaptor.ExploreItemHolder holder = (OldArticlesAdaptor.ExploreItemHolder) holderParent;
        final OldData oldDatas = oldData.get(position);


        holder.tvTitle.setText(oldDatas.getTitle());
        Glide.with(activity).load(oldDatas.getImage()).into(holder.imgGod);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ArticleViewActivity.class);
                intent.putExtra(Constant.ID,oldDatas.getId());
                intent.putExtra(Constant.TITLE,oldDatas.getTitle());
                intent.putExtra(Constant.NAME,"పండుగలు విశిష్టత");
                intent.putExtra(Constant.DESCRIPTION,oldDatas.getDescription());
                intent.putExtra(Constant.IMAGE,oldDatas.getImage());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return oldData.size(); }

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
