package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.ChildBirth;
import com.vibame.telugupanchangamcalendar.model.YearlyHoroscope;

import java.util.ArrayList;

public class ChildBirthAdapter extends RecyclerView.Adapter<ChildBirthAdapter.ViewHolder> {
    Activity activity;
    ArrayList<ChildBirth> childBirths;

    public ChildBirthAdapter(Activity activity, ArrayList<ChildBirth> childBirths) {
        this.childBirths = childBirths;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.childbirth_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sub_title.setText(childBirths.get(position).getSub_title());
        holder.sub_description.setText(childBirths.get(position).getSub_description());
        holder.tvDate.setText(childBirths.get(position).getDate_month());

    }


    @Override
    public int getItemCount() {
        return childBirths.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sub_title,sub_description,tvDate;

        public ViewHolder(View itemView) {
            super(itemView);

            this.sub_title = (TextView) itemView.findViewById(R.id.sub_title);
            this.sub_description = (TextView) itemView.findViewById(R.id.sub_description);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
