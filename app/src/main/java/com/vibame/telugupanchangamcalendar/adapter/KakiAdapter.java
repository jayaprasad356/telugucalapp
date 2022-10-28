package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.KakiData;

import java.util.ArrayList;

public class KakiAdapter extends RecyclerView.Adapter<KakiAdapter.ViewHolder> {
    Activity activity;
    ArrayList<KakiData> kakiData;

    public KakiAdapter(Activity activity, ArrayList<KakiData> kakiData) {
        this.activity = activity;
        this.kakiData = kakiData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.sakunalu_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(kakiData.get(position).getTitle());
        holder.description.setText(kakiData.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return kakiData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
        }
    }
}
