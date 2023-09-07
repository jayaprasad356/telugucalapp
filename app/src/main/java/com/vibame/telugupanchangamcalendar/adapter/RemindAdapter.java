package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Abdhikam;
import com.vibame.telugupanchangamcalendar.model.Reminder;

import java.util.ArrayList;

public class RemindAdapter extends RecyclerView.Adapter<RemindAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Reminder> reminders;

    public RemindAdapter(Activity activity, ArrayList<Reminder> reminders) {
        this.reminders = reminders;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.reminder_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tvTitle.setText(reminders.get(position).getTitle());
        holder.tvDate.setText(reminders.get(position).getDate());
        holder.tvTime.setText(reminders.get(position).getTime());


    }


    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvDate,tvTime;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }
}
