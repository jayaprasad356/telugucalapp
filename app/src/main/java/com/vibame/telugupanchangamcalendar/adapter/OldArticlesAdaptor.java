package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
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

        Glide.with(activity).load(oldData.getClass()).into(holder.imgGod);
        holder.tvTitle.setText(oldData.get(position).getTvTitle());
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
