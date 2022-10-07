package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Grahalu;
import com.vibame.telugupanchangamcalendar.model.GrahaluTab;
import com.vibame.telugupanchangamcalendar.model.PoojaluTab;

import java.util.ArrayList;


public class GrahaluTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<GrahaluTab> grahaluTabs;

    public GrahaluTabAdapter(Activity activity, ArrayList<GrahaluTab> grahaluTabs) {
        this.activity = activity;
        this.grahaluTabs = grahaluTabs;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.year_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final GrahaluTab grahaluTab = grahaluTabs.get(position);
        holder.tvTitle.setText(grahaluTab.getSub_title());
        holder.tvDescription.setText(grahaluTab.getSub_description());


    }

    @Override
    public int getItemCount()
    {
        return grahaluTabs.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle,tvDescription;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
