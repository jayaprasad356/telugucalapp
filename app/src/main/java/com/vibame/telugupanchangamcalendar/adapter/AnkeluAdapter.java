package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.AnkeluData;

import java.util.ArrayList;

public class AnkeluAdapter extends RecyclerView.Adapter<AnkeluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<AnkeluData> ankeluData;

    public AnkeluAdapter(Activity activity, ArrayList<AnkeluData> ankeluData) {
        this.ankeluData = ankeluData;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.ankelu_views, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title1.setText(ankeluData.get(position).getTitle1());
        holder.title2.setText(ankeluData.get(position).getTitle2());

    }


    @Override
    public int getItemCount() {
        return ankeluData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title1,title2;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title1 = (TextView) itemView.findViewById(R.id.tvTitle1);
            this.title2 = (TextView) itemView.findViewById(R.id.tvTitle2);
        }
    }
}
