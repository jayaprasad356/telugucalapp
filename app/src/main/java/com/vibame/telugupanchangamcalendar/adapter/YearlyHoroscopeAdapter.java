package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.AnkeluData;
import com.vibame.telugupanchangamcalendar.model.YearlyHoroscope;

import java.util.ArrayList;

public class YearlyHoroscopeAdapter extends RecyclerView.Adapter<YearlyHoroscopeAdapter.ViewHolder> {
    Activity activity;
    ArrayList<YearlyHoroscope> yearlyHoroscopes;

    public YearlyHoroscopeAdapter(Activity activity, ArrayList<YearlyHoroscope> yearlyHoroscopes) {
        this.yearlyHoroscopes = yearlyHoroscopes;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.yearlyhoroscope, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(yearlyHoroscopes.get(position).getGraha_dhashakalamu_title()+" : ");
        holder.tvDescription.setText(yearlyHoroscopes.get(position).getGraha_dhashakalamu_description());

    }


    @Override
    public int getItemCount() {
        return yearlyHoroscopes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
