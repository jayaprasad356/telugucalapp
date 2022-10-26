package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramMenu2Data;

import java.util.ArrayList;

public class KukutaMenu2Adapter extends RecyclerView.Adapter<KukutaMenu2Adapter.ViewHolder> {
    Activity activity;
    ArrayList<KukutaSasthramMenu2Data> kukutaSasthramMenu2Data;

    public KukutaMenu2Adapter(Activity activity, ArrayList<KukutaSasthramMenu2Data> kukutaSasthramMenu2Data) {
        this.activity = activity;
        this.kukutaSasthramMenu2Data = kukutaSasthramMenu2Data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.hen_stars_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(kukutaSasthramMenu2Data.get(position).getTitle());
        holder.description.setText(kukutaSasthramMenu2Data.get(position).getDescription());
        holder.tv_title_star.setText(kukutaSasthramMenu2Data.get(position).getStar());
        holder.tv_title_Lossing.setText(kukutaSasthramMenu2Data.get(position).getLossing());
        holder.tv_title_winning.setText(kukutaSasthramMenu2Data.get(position).getWinning());
        holder.tv_describtion_star.setText(kukutaSasthramMenu2Data.get(position).getStar_des());
        holder.tv_describtion_winning.setText(kukutaSasthramMenu2Data.get(position).getWinning_des());
        holder.tv_describtion_Lossing.setText(kukutaSasthramMenu2Data.get(position).getLosing_des());

    }


    @Override
    public int getItemCount() {
        return kukutaSasthramMenu2Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, tv_title_star, tv_title_Lossing, tv_title_winning, tv_describtion_star, tv_describtion_winning, tv_describtion_Lossing;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
            this.tv_title_star = itemView.findViewById(R.id.tv_title_star);
            this.tv_title_Lossing = itemView.findViewById(R.id.tv_title_Lossing);
            this.tv_title_winning = itemView.findViewById(R.id.tv_title_winning);
            this.tv_describtion_star = itemView.findViewById(R.id.tv_describtion_star);
            this.tv_describtion_winning = itemView.findViewById(R.id.tv_describtion_winning);
            this.tv_describtion_Lossing = itemView.findViewById(R.id.tv_describtion_Lossing);
        }
    }
}
