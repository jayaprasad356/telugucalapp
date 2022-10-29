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
import com.vibame.telugupanchangamcalendar.model.WeekNames;

public class WeekNamesAdapter extends RecyclerView.Adapter<WeekNamesAdapter.ViewHolder> {
    Activity activity;
    WeekNames[] weekNames;

    public WeekNamesAdapter(WeekNames[] weekNames, Activity activity) {
        this.weekNames = weekNames;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.week_names_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(weekNames[position].getTitle());
        holder.description.setText(weekNames[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return weekNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tvTitle1);
            this.description = (TextView) itemView.findViewById(R.id.tvTitle2);
        }
    }
}
