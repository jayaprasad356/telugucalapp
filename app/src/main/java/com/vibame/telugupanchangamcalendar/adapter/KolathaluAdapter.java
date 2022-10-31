package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;

import java.util.ArrayList;

public class KolathaluAdapter extends RecyclerView.Adapter<KolathaluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Kolathalu> kolathalus;

    public KolathaluAdapter(Activity activity, ArrayList<Kolathalu> kolathalus) {
        this.kolathalus = kolathalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.kolathalu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(kolathalus.get(position).getTitle());
        holder.subtitle1.setText(kolathalus.get(position).getSubtitle1());
        holder.subdescription1.setText(kolathalus.get(position).getSubdescription1());
        holder.subtitle2.setText(kolathalus.get(position).getSubtitle2());
        holder.subdescription2.setText(kolathalus.get(position).getSubdescription2());
    }


    @Override
    public int getItemCount() {
        return kolathalus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle1,subdescription1,subtitle2,subdescription2;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.subtitle1 = itemView.findViewById(R.id.sub_title1);
            this.subdescription1 = itemView.findViewById(R.id.sub_description_1a);
            this.subtitle2 = itemView.findViewById(R.id.sub_title2);
            this.subdescription2 = itemView.findViewById(R.id.sub_description_2a);

        }
    }
}
