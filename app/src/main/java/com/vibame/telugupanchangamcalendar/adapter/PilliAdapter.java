package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.PilliSasthramData;

import java.util.ArrayList;

public class PilliAdapter extends RecyclerView.Adapter<PilliAdapter.ViewHolder> {
    Activity activity;
    ArrayList<PilliSasthramData> pilliSasthramData;

    public PilliAdapter(Activity activity, ArrayList<PilliSasthramData> pilliSasthramData) {
        this.activity = activity;
        this.pilliSasthramData = pilliSasthramData;

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
        holder.title.setText(pilliSasthramData.get(position).getTitle());
        holder.description.setText(pilliSasthramData.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return pilliSasthramData.size();
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
