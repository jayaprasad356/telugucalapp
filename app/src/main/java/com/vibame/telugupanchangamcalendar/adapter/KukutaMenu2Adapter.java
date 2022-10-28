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
        holder.tvstar.setText(kukutaSasthramMenu2Data.get(position).getStar());
        holder.tvWinning.setText(kukutaSasthramMenu2Data.get(position).getLossing());
        holder.tvLossing.setText(kukutaSasthramMenu2Data.get(position).getWinning());

    }


    @Override
    public int getItemCount() {
        return kukutaSasthramMenu2Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, tvstar, tvLossing, tvWinning;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
            this.tvstar = itemView.findViewById(R.id.tvstar);
            this.tvLossing = itemView.findViewById(R.id.tvLossing);
            this.tvWinning = itemView.findViewById(R.id.tvWinning);
        }
    }
}
