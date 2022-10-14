package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.GrahaluSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.NakshathraluActivity;
import com.vibame.telugupanchangamcalendar.activities.PoojaluSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.PoojaluTabActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Grahalu;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;
import com.vibame.telugupanchangamcalendar.model.Poojalu;

import java.util.ArrayList;


public class GrahaluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Grahalu> grahalus;
    Session session;
    DatabaseHelper databaseHelper;

    public GrahaluAdapter(Activity activity, ArrayList<Grahalu> grahalus) {
        this.activity = activity;
        this.grahalus = grahalus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.grahalu_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Grahalu grahalu = grahalus.get(position);
        holder.tvName.setText(grahalu.getName());
        Glide.with(activity).load(grahalu.getImage()).placeholder(R.drawable.logo).into(holder.imgGrahalu);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setData(Constant.GRAHALU_ID,grahalu.getId());
                if (grahalu.getName().equals("Nakshatharalu")){
                    Intent intent = new Intent(activity, NakshathraluActivity.class);
                    activity.startActivity(intent);

                }else {
                    Intent intent = new Intent(activity, GrahaluSubMenuActivity.class);
                    intent.putExtra(Constant.TITLE,grahalu.getName());
                    intent.putExtra(Constant.ID,grahalu.getId());
                    activity.startActivity(intent);
                }


            }
        });



    }

    @Override
    public int getItemCount()
    {
        return grahalus.size();
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