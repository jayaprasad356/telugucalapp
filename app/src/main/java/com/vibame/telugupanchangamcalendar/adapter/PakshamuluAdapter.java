package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Pakshamulu;

import java.util.ArrayList;

public class PakshamuluAdapter extends RecyclerView.Adapter<PakshamuluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Pakshamulu> pakshamulus;

    public PakshamuluAdapter(Activity activity, ArrayList<Pakshamulu> pakshamulus) {
        this.pakshamulus = pakshamulus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.pakshamulu_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(pakshamulus.get(position).getTitle());
        holder.description.setText(pakshamulus.get(position).getDescription());
        Glide.with(activity).load(pakshamulus.get(0).getImageUrl());

    }


    @Override
    public int getItemCount() {
        return pakshamulus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
        }
    }
}
