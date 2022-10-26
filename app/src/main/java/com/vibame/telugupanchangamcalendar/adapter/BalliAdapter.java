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

import java.util.ArrayList;

public class BalliAdapter extends RecyclerView.Adapter<BalliAdapter.ViewHolder> {
    Activity activity;
    ArrayList<BalliData> balliData;


    public BalliAdapter(ArrayList<BalliData> balliData, Activity activity) {
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
        holder.title.setText(balliData.get(position).getTitle());
        holder.description.setText(balliData.get(position).getDescription());
        holder.subTitle1.setText(balliData.get(position).getSubtitle1());
        holder.subTitle2.setText(balliData.get(position).getSubtitle2());
        holder.subDesc1a.setText(balliData.get(position).getSubdescription1a());
        holder.subDesc2a.setText(balliData.get(position).getSubdescription2a());
        holder.subDesc1b.setText(balliData.get(position).getSubdescription1b());
        holder.subDesc2b.setText(balliData.get(position).getSubdescription2b());
    }


    @Override
    public int getItemCount() {
        return balliData.size();
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
