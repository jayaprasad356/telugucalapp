package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.BalliData;

import java.util.ArrayList;

public class BalliVariantAdapter extends RecyclerView.Adapter<BalliVariantAdapter.ViewHolder> {
    Activity activity;
    ArrayList<BalliData> balliData;


    public BalliVariantAdapter(ArrayList<BalliData> balliData, Activity activity) {
        this.balliData = balliData;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.balli_sasthram_variant, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.subDesc1a.setText(balliData.get(position).getSub_description1());
        holder.subDesc2a.setText(balliData.get(position).getSub_description2());

    }


    @Override
    public int getItemCount() {
        return balliData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  subDesc1a, subDesc2a;


        public ViewHolder(View itemView) {
            super(itemView);

            this.subDesc1a = itemView.findViewById(R.id.sub_description1);
            this.subDesc2a = itemView.findViewById(R.id.sub_description2);


        }
    }
}
