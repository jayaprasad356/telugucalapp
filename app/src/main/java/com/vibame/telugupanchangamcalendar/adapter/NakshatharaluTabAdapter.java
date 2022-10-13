package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.GrahaluTab;
import com.vibame.telugupanchangamcalendar.model.NakTab;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;

import java.util.ArrayList;


public class NakshatharaluTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<NakTab> nakTabs;

    public NakshatharaluTabAdapter(Activity activity, ArrayList<NakTab> nakTabs) {
        this.activity = activity;
        this.nakTabs = nakTabs;
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
        final NakTab nakTab = nakTabs.get(position);
        holder.tvTitle.setText(nakTab.getSub_title());
        holder.tvDescription.setText(nakTab.getSub_description());


    }

    @Override
    public int getItemCount()
    {
        return nakTabs.size();
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
