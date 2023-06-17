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

import java.util.ArrayList;


public class ImportantdaysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Festival> festivals;

    public ImportantdaysAdapter(Activity activity, ArrayList<Festival> festivals) {
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


        holder.tvDate.setText(festivals.get(position).getTitle());
        holder.tvFestival.setText(festivals.get(position).getDescription());



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
