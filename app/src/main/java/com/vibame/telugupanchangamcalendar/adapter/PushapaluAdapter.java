package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Pushapalu;

import java.util.ArrayList;

public class PushapaluAdapter extends RecyclerView.Adapter<PushapaluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Pushapalu> pushapalus;

    public PushapaluAdapter(Activity activity, ArrayList<Pushapalu> pushapalus) {
        this.pushapalus = pushapalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.pushapalu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(pushapalus.get(position).getTitle());
        holder.description.setText(pushapalus.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return pushapalus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.description = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
