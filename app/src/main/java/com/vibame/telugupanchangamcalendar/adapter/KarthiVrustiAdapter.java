package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.ChildBirth;
import com.vibame.telugupanchangamcalendar.model.KarthiVrusti;

import java.util.ArrayList;

public class KarthiVrustiAdapter extends RecyclerView.Adapter<KarthiVrustiAdapter.ViewHolder> {
    Activity activity;
    ArrayList<KarthiVrusti> karthiVrustis;

    public KarthiVrustiAdapter(Activity activity, ArrayList<KarthiVrusti> karthiVrustis) {
        this.karthiVrustis = karthiVrustis;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.karthi_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.sub_title1.setText(karthiVrustis.get(position).getKarthi());
        holder.sub_title2.setText(karthiVrustis.get(position).getNakshathram());
        holder.sub_title3.setText(karthiVrustis.get(position).getPravesham());
        holder.sub_title4.setText(karthiVrustis.get(position).getRashi());
        holder.sub_title5.setText(karthiVrustis.get(position).getGanam());
        holder.sub_title6.setText(karthiVrustis.get(position).getKarthi_result());
      holder.tvDate.setText(karthiVrustis.get(position).getDate_month());



    }


    @Override
    public int getItemCount() {
        return karthiVrustis.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sub_title1,sub_title2,sub_title3,sub_title4,sub_title5,sub_title6,tvDate;

        public ViewHolder(View itemView) {
            super(itemView);

            this.sub_title1 = (TextView) itemView.findViewById(R.id.sub_title1);
            this.sub_title2 = (TextView) itemView.findViewById(R.id.sub_title2);
            this.sub_title3 = (TextView) itemView.findViewById(R.id.sub_title3);
            this.sub_title4 = (TextView) itemView.findViewById(R.id.sub_title4);
            this.sub_title5 = (TextView) itemView.findViewById(R.id.sub_title5);
            this.sub_title6 = (TextView) itemView.findViewById(R.id.sub_title6);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);

        }
    }
}
