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
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class PushapaluAdapter extends RecyclerView.Adapter<PushapaluAdapter.ViewHolder> {
    Activity activity;
    Pushapalu[] pushapalus;

    public PushapaluAdapter(Pushapalu[] pushapalus, Activity activity) {
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
        holder.title.setText(pushapalus[position].getTitle());
        holder.description.setText(pushapalus[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return pushapalus.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tvTeluguyearName);
            this.description = (TextView) itemView.findViewById(R.id.tvteluguYears);
        }
    }
}
