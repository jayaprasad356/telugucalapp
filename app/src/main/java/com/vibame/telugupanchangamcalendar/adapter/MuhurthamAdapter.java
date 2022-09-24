package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.MuhurthamtabActivity;
import com.vibame.telugupanchangamcalendar.model.Muhurtham;

import java.util.ArrayList;


public class MuhurthamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Muhurtham> muhurthams;

    public MuhurthamAdapter(Activity activity, ArrayList<Muhurtham> muhurthams) {
        this.activity = activity;
        this.muhurthams = muhurthams;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.muhurtham_list, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Muhurtham muhurtham = muhurthams.get(position);

        holder.tvMuhurtham.setText(muhurtham.getMuhurtham());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, MuhurthamtabActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return muhurthams.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvMuhurtham;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvMuhurtham = itemView.findViewById(R.id.tvtext);


        }
    }
}
