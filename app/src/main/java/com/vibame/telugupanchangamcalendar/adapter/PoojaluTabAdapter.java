package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.PoojaluTab;
import com.vibame.telugupanchangamcalendar.model.YearTab;

import java.util.ArrayList;


public class PoojaluTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<PoojaluTab> poojaluTabs;

    public PoojaluTabAdapter(Activity activity, ArrayList<PoojaluTab> poojaluTabs) {
        this.activity = activity;
        this.poojaluTabs = poojaluTabs;
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
        final PoojaluTab poojaluTab = poojaluTabs.get(position);
        holder.tvTitle.setText(poojaluTab.getTitle());
        holder.tvDescription.setText(poojaluTab.getDescription());


    }

    @Override
    public int getItemCount()
    {
        return poojaluTabs.size();
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
