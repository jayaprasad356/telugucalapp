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
import com.vibame.telugupanchangamcalendar.model.ChildBirth;

import java.util.ArrayList;

public class AbdhikamAdapter extends RecyclerView.Adapter<AbdhikamAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Abdhikam> abdhikams;

    public AbdhikamAdapter(Activity activity, ArrayList<Abdhikam> abdhikams) {
        this.abdhikams = abdhikams;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.abdhikam_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDescription.setText(abdhikams.get(position).getDescription());
        holder.tvDate.setText(abdhikams.get(position).getDate_month());

    }


    @Override
    public int getItemCount() {
        return abdhikams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDescription,tvDate;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
