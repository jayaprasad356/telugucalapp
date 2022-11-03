package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.MahaBharadhamMenu;

public class MahaBharathamMenuAdapter extends RecyclerView.Adapter<MahaBharathamMenuAdapter.ViewHolder> {
    Activity activity;
    MahaBharadhamMenu[] mahaBharadhamMenus;

    public MahaBharathamMenuAdapter(MahaBharadhamMenu[] mahaBharadhamMenus, Activity activity) {
        this.mahaBharadhamMenus = mahaBharadhamMenus;
        this.activity = activity;

    }

    @NonNull
    @Override
    public MahaBharathamMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.bharatham_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.description.setText(mahaBharadhamMenus[position].getDescription());
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mahaBharadhamMenus.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.description = itemView.findViewById(R.id.tvDescription);
        }

    }
}
