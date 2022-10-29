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
import com.vibame.telugupanchangamcalendar.model.Pushapalu;

public class NavaGrahaluAdapter extends RecyclerView.Adapter<NavaGrahaluAdapter.ViewHolder> {
    Activity activity;
    NavaGrahalu[] navaGrahalus;

    public NavaGrahaluAdapter(NavaGrahalu[] navaGrahalus, Activity activity) {
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
        holder.title.setText(navaGrahalus[position].getTitle());
        holder.description.setText(navaGrahalus[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return navaGrahalus.length;
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
