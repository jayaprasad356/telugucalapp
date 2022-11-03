package com.vibame.telugupanchangamcalendar.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.AboutMahaBharathamActivity;
import com.vibame.telugupanchangamcalendar.activities.MahaBharadhamSukthuluActivity;
import com.vibame.telugupanchangamcalendar.model.MahaBharadhamMenu;

public class AboutMahaBharadhamAdapter extends RecyclerView.Adapter<AboutMahaBharadhamAdapter.ViewHolder> {
    Activity activity;
    MahaBharadhamMenu[] mahaBharadhamMenus;

    public AboutMahaBharadhamAdapter(MahaBharadhamMenu[] mahaBharadhamMenus, Activity activity) {
        this.mahaBharadhamMenus = mahaBharadhamMenus;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.bharatham_view, parent, false);
        return new ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.description.setText(mahaBharadhamMenus[position].getDescription());
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){
                    Toast.makeText(view.getContext(),"0",Toast.LENGTH_LONG).show();
                }else if (position>=1){
                    Toast.makeText(view.getContext(),"1",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(activity, MahaBharadhamSukthuluActivity.class);
                    activity.startActivity(intent);
                }

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
