package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.ThidhiAdhi;

import java.util.ArrayList;

public class ThidhiAdhiAdapter extends RecyclerView.Adapter<ThidhiAdhiAdapter.ViewHolder> {
    Activity activity;
    ArrayList<ThidhiAdhi> thidhiAdhis;

    public ThidhiAdhiAdapter(Activity activity, ArrayList<ThidhiAdhi> thidhiAdhis) {
        this.thidhiAdhis = thidhiAdhis;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.thidhi_adhi_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(thidhiAdhis.get(position).getTitle());
        holder.description.setText(thidhiAdhis.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return thidhiAdhis.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tv_title);
            this.description = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
