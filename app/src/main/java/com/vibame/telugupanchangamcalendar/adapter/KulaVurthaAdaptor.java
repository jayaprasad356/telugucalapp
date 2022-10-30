package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.KulaVurthala;

import java.util.ArrayList;

public class KulaVurthaAdaptor extends RecyclerView.Adapter<KulaVurthaAdaptor.ViewHolder> {
    Activity activity;
    ArrayList<KulaVurthala> kulaVurthalaArrayList;

    public KulaVurthaAdaptor(Activity activity, ArrayList<KulaVurthala> kulaVurthalaArrayList) {
        this.activity = activity;
        this.kulaVurthalaArrayList = kulaVurthalaArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.kulavurthalyt, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KulaVurthala model = kulaVurthalaArrayList.get(position);
        holder.Occupation.setText(model.getTitle());
        holder.OccupationReference.setText(model.getDescription());
    }


    @Override
    public int getItemCount() {
        return kulaVurthalaArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Occupation,OccupationReference;

        public ViewHolder(View itemView) {
            super(itemView);
            Occupation = itemView.findViewById(R.id.tvOccupation);
            OccupationReference = itemView.findViewById(R.id.tvOccupationReference);
        }
    }
}
