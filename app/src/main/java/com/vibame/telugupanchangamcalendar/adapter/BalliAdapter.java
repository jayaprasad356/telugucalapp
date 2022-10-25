package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.BalliData;

public class BalliAdapter extends RecyclerView.Adapter<BalliAdapter.ViewHolder> {
    Activity activity;
    BalliData[] balliData;

    public BalliAdapter(BalliData[] balliData, Activity activity) {
        this.balliData = balliData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.balli_sasthram_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(balliData[position].getTitle());
        holder.description.setText(balliData[position].getDescription());
        holder.subTitle1.setText(balliData[position].getSubTitle1());
        holder.subTitle2.setText(balliData[position].getSubTitle2());
        holder.subDesc1a.setText(balliData[position].getSubDesc1a());
        holder.subDesc2a.setText(balliData[position].getSubDesc2a());
        holder.subDesc1b.setText(balliData[position].getSubDesc1b());
        holder.subDesc2b.setText(balliData[position].getSubDesc2b());
    }


    @Override
    public int getItemCount() {
        return balliData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, subTitle1, subTitle2, subDesc1a, subDesc2a, subDesc1b, subDesc2b;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
            this.subTitle1 = itemView.findViewById(R.id.subtitle1);
            this.subTitle2 = itemView.findViewById(R.id.subtitle2);
            this.subDesc1a = itemView.findViewById(R.id.sub_description_1a);
            this.subDesc2a = itemView.findViewById(R.id.sub_description_2a);
            this.subDesc1b = itemView.findViewById(R.id.sub_description_1b);
            this.subDesc2b = itemView.findViewById(R.id.sub_description_2b);

        }
    }
}
