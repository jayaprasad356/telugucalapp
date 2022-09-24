package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.MuhurthamTab;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;

import java.util.ArrayList;


public class MuhurthamTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<MuhurthamTab> muhurthamTabs;

    public MuhurthamTabAdapter(Activity activity, ArrayList<MuhurthamTab> muhurthamTabs) {
        this.activity = activity;
        this.muhurthamTabs = muhurthamTabs;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.muhurtham_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final MuhurthamTab muhurthamTab = muhurthamTabs.get(position);
        holder.tvTitle.setText(muhurthamTab.getTitle());
        holder.tvContent.setText(muhurthamTab.getDescription());


    }

    @Override
    public int getItemCount()
    {
        return muhurthamTabs.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle,tvContent;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
