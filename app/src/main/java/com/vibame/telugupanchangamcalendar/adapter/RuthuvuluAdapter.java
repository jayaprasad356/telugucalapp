package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Ruthuvulu;

import java.util.ArrayList;

public class RuthuvuluAdapter extends RecyclerView.Adapter<RuthuvuluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Ruthuvulu> ruthuvulus;

    public RuthuvuluAdapter(Activity activity, ArrayList<Ruthuvulu> ruthuvulus) {
        this.ruthuvulus = ruthuvulus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.ruthuvulu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(ruthuvulus.get(position).getTitle());
        holder.description.setText(ruthuvulus.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return ruthuvulus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.RashiName);
            this.description = (TextView) itemView.findViewById(R.id.RashiTime);
        }
    }
}
