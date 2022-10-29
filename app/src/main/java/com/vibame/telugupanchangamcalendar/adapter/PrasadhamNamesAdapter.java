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
import com.vibame.telugupanchangamcalendar.model.PrasadhamNames;

public class PrasadhamNamesAdapter extends RecyclerView.Adapter<PrasadhamNamesAdapter.ViewHolder> {
    Activity activity;
    PrasadhamNames[] prasadhamNames;

    public PrasadhamNamesAdapter(PrasadhamNames[] prasadhamNames, Activity activity) {
        this.prasadhamNames = prasadhamNames;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.prasadham_names_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(prasadhamNames[position].getTitle());
        holder.description.setText(prasadhamNames[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return prasadhamNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tvTitle1);
            this.description = (TextView) itemView.findViewById(R.id.tvTitle2);
        }
    }
}
