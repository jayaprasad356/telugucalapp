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
import com.vibame.telugupanchangamcalendar.VideosActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Thidhilu;
import com.vibame.telugupanchangamcalendar.model.VideoTab;

import java.util.ArrayList;


public class ThidhiluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Thidhilu> thidhilus;

    public ThidhiluAdapter(Activity activity, ArrayList<Thidhilu> thidhilus) {
        this.activity = activity;
        this.thidhilus = thidhilus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.thidhilu_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Thidhilu thidhilu = thidhilus.get(position);


        holder.tvName.setText(thidhilu.getName());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, VideosActivity.class);
//                intent.putExtra(Constant.VIDEO_CATEGORY_ID,videoTab.getId());
//                intent.putExtra(Constant.NAME,videoTab.getName());
//                activity.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount()
    {
        return thidhilus.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName,tvDay,tvDate;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvDate = itemView.findViewById(R.id.tvDate);


        }
    }
}
