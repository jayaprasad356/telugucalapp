package com.vibame.telugupanchangamcalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.AksharaluModel;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class AksharaluAdaptor extends RecyclerView.Adapter<AksharaluAdaptor.RashuluViewHolder> {

    private ArrayList<AksharaluModel> aksharaluModelArrayList;
    private Context ctx;

    public AksharaluAdaptor(ArrayList<AksharaluModel> aksharaluModelArrayList, Context ctx) {
        this.aksharaluModelArrayList = aksharaluModelArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RashuluViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.aksharalulayout,parent,false);
        return new RashuluViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RashuluViewHolder holder, int position) {
        AksharaluModel model = aksharaluModelArrayList.get(position);
        holder.Topic.setText(model.getHeading());
        holder.Aksharam.setText(model.getTopic());
    }

    @Override
    public int getItemCount() {
        return aksharaluModelArrayList.size();
    }

    protected class RashuluViewHolder extends RecyclerView.ViewHolder {

        private TextView Topic;
        private TextView Aksharam;
        public RashuluViewHolder(@NonNull View itemView) {
            super(itemView);
            Topic = itemView.findViewById(R.id.tvHeading);
            Aksharam = itemView.findViewById(R.id.tvAksharalu);
        }
    }
}
