package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;

import java.util.ArrayList;

public class NakshatharaluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Nakshatharalu> nakshatharalus;
    Session session;
    DatabaseHelper databaseHelper;

    public NakshatharaluAdapter(Activity activity, ArrayList<Nakshatharalu> nakshatharalus) {
        this.activity = activity;
        this.nakshatharalus = nakshatharalus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.nakshatharalu_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Nakshatharalu nakshatharalu = nakshatharalus.get(position);
        holder.tvName.setText(nakshatharalu.getName());
        Glide.with(activity).load(nakshatharalu.getImage()).placeholder(R.drawable.logo).into(holder.imgGrahalu);

    }

    @Override
    public int getItemCount()
    {
        return nakshatharalus.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        ImageView imgGrahalu;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgGrahalu = itemView.findViewById(R.id.imgGrahalu);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
