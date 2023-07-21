package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

import java.util.ArrayList;

public class TeluguYearsAdapter extends RecyclerView.Adapter<TeluguYearsAdapter.ViewHolder> {
    Activity activity;
    ArrayList<TeluguYear> teluguYears;

    public TeluguYearsAdapter(Activity activity, ArrayList<TeluguYear> teluguYears) {
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



        // holder.title  background tint white

        holder.title.setBackgroundTintList(activity.getResources().getColorStateList(R.color.white));

        holder.title.setText(teluguYears.get(position).getTitle());
        holder.description.setText(teluguYears.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return teluguYears.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tvTeluguyearName);
            this.description = itemView.findViewById(R.id.tvteluguYears);
        }
    }
}
