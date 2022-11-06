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
import com.vibame.telugupanchangamcalendar.model.NewData;

import java.util.ArrayList;

public class NewArticlesAdaptor extends RecyclerView.Adapter<NewArticlesAdaptor.ExploreItemHolder> {
    final Activity activity;
    ArrayList<NewData> newData;

    public NewArticlesAdaptor(Activity activity, ArrayList<NewData> newData) {
        this.activity = activity;
        this.newData = newData;
    }

    @NonNull
    @Override
    public ExploreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.articles_view_layout, parent, false);
        return new NewArticlesAdaptor.ExploreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreItemHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;

        Glide.with(activity).load(newData.getClass()).into(holder.imgGod);
        holder.tvTitle.setText(newData.get(position).gettvTitle());
    }

    @Override
    public int getItemCount() { return newData.size(); }

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
