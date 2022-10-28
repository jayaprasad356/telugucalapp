package com.vibame.telugupanchangamcalendar.adapter;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class RashuluAdaptor extends RecyclerView.Adapter<RashuluAdaptor.RashuluViewHolder> {

    private ArrayList<RashuluModel> rashuluModelArrayList;
    private Context ctx;

    public RashuluAdaptor(ArrayList<RashuluModel> rashuluModelArrayList, Context ctx) {
        this.rashuluModelArrayList = rashuluModelArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RashuluViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.rashululayout,parent,false);
        return new RashuluViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RashuluViewHolder holder, int position) {
        RashuluModel model = rashuluModelArrayList.get(position);
        holder.RashiName.setText(model.getRashiNmae());
        holder.RashiTime.setText(model.getRashiTime());
    }

    @Override
    public int getItemCount() {
        return rashuluModelArrayList.size();
    }

    protected class RashuluViewHolder extends RecyclerView.ViewHolder {

        private TextView RashiName;
        private TextView RashiTime;
        public RashuluViewHolder(@NonNull View itemView) {
            super(itemView);
            RashiName = itemView.findViewById(R.id.RashiName);
            RashiTime = itemView.findViewById(R.id.RashiTime);
        }
    }
}
