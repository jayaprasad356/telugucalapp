package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.SakunaluData;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class TeluguYearsAdapter extends RecyclerView.Adapter<TeluguYearsAdapter.ViewHolder> {
    Activity activity;
    TeluguYear[] teluguYears;

    public TeluguYearsAdapter(TeluguYear[] teluguYears, Activity activity) {
        this.teluguYears = teluguYears;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.telugu_year_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(teluguYears[position].getTitle());
        holder.description.setText(teluguYears[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return teluguYears.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tvTeluguyearName);
            this.description = (TextView) itemView.findViewById(R.id.tvteluguYears);
        }
    }
}
