package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.MonthData;
import com.vibame.telugupanchangamcalendar.model.Pakshamulu;

public class PakshamuluAdapter extends RecyclerView.Adapter<PakshamuluAdapter.ViewHolder> {
    Activity activity;
    Pakshamulu[] pakshamulus;

    public PakshamuluAdapter(Pakshamulu[] pakshamulus, Activity activity) {
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
        holder.title.setText(pakshamulus[position].getTitle());
        holder.description.setText(pakshamulus[position].getDescription());

    }


    @Override
    public int getItemCount() {
        return pakshamulus.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tv_title);
            this.description = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
