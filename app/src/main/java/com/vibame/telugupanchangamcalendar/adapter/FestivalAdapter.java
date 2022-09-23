package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Festival;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FestivalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Festival> festivals;

    public FestivalAdapter(Activity activity, ArrayList<Festival> festivals) {
        this.activity = activity;
        this.festivals = festivals;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.festival_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Festival festival = festivals.get(position);
        String strCurrentDate = "Wed, 18 Apr 2012 07:55:29 +0000";
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date newDate = null;
        try {
            newDate = format.parse(festival.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("dd,MMMM");
        String date = format.format(newDate);
        holder.tvFestival.setText(festival.getFestival());
        holder.tvDate.setText(date);
    }

    @Override
    public int getItemCount()
    {
        return festivals.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvFestival,tvDate;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvFestival = itemView.findViewById(R.id.tvFestival);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}
