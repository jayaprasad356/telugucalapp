package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramData;

import java.util.ArrayList;

public class KukutaAdapter extends RecyclerView.Adapter<KukutaAdapter.ViewHolder> {
    Activity activity;
    ArrayList<KukutaSasthramData> kukutaSasthramData;

    public KukutaAdapter(Activity activity, ArrayList<KukutaSasthramData> kukutaSasthramData) {
        this.activity = activity;
        this.kukutaSasthramData = kukutaSasthramData;

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
        holder.title.setText(kukutaSasthramData.get(position).getTitle());
        holder.description.setText(kukutaSasthramData.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return kukutaSasthramData.size();
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
