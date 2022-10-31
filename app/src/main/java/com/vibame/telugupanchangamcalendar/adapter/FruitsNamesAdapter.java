package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.FruitsNames;

import java.util.ArrayList;

public class FruitsNamesAdapter extends RecyclerView.Adapter<FruitsNamesAdapter.ViewHolder> {
    Activity activity;
    ArrayList<FruitsNames> fruitsNames;

    public FruitsNamesAdapter(Activity activity, ArrayList<FruitsNames> fruitsNames) {
        this.fruitsNames = fruitsNames;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fruits_names_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(fruitsNames.get(position).getTitle());
        holder.description.setText(fruitsNames.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return fruitsNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tvTitle1);
            this.description = itemView.findViewById(R.id.tvTitle2);
        }
    }
}
