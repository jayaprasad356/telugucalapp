package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Lagnalu;

import java.util.ArrayList;

public class LagnaluAdapter extends RecyclerView.Adapter<LagnaluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Lagnalu> lagnalus;

    public LagnaluAdapter(Activity activity, ArrayList<Lagnalu> lagnalus) {
        this.lagnalus = lagnalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.lagnalu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(lagnalus.get(position).getTitle());
        holder.description.setText(lagnalus.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return lagnalus.size();
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
