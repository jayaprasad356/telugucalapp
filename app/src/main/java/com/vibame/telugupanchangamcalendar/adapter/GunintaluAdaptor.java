package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Guninthalu;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramData;

import java.util.ArrayList;

public class GunintaluAdaptor extends RecyclerView.Adapter<GunintaluAdaptor.ViewHolder> {
    Activity activity;
    ArrayList<Guninthalu> guninthaluArrayList;

    public GunintaluAdaptor(Activity activity, ArrayList<Guninthalu> guninthaluArrayList) {
        this.activity = activity;
        this.guninthaluArrayList = guninthaluArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.gunintalulyt, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Guninthalu model = guninthaluArrayList.get(position);
        holder.Gunintam.setText(model.getGunintam());
    }


    @Override
    public int getItemCount() {
        return guninthaluArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Gunintam;

        public ViewHolder(View itemView) {
            super(itemView);
            Gunintam = itemView.findViewById(R.id.tvGunintam);
        }
    }
}
