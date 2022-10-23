package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.SakunaluData;

public class SakunaluAdapter extends RecyclerView.Adapter<SakunaluAdapter.ViewHolder> {
    Activity activity;
    SakunaluData[] sakunaluListDatas;

    public SakunaluAdapter(SakunaluData[] sakunaluDatas, Activity activity) {
        this.sakunaluListDatas = sakunaluDatas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.sakunalu_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(sakunaluListDatas[position].getTitle());
        holder.description.setText(sakunaluListDatas[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return sakunaluListDatas.length;
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
