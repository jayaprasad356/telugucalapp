package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.NavaGrahalu;

import java.util.ArrayList;

public class NavaGrahaluAdapter extends RecyclerView.Adapter<NavaGrahaluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<NavaGrahalu> navaGrahalus;

    public NavaGrahaluAdapter(Activity activity, ArrayList<NavaGrahalu> navaGrahalus) {
        this.navaGrahalus = navaGrahalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.nava_grahalu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(navaGrahalus.get(position).getTitle().trim());
        holder.description.setText(navaGrahalus.get(position).getDescription().trim());

    }


    @Override
    public int getItemCount() {
        return navaGrahalus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.RashiName);
            this.description = itemView.findViewById(R.id.RashiTime);
        }
    }
}
