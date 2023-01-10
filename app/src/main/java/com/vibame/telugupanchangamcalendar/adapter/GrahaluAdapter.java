package com.vibame.telugupanchangamcalendar.adapter;

import android.annotation.SuppressLint;
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
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Grahalu;

import java.util.ArrayList;


public class GrahaluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Grahalu> grahalus;
    Session session;
    DatabaseHelper databaseHelper;
    int count;
    String type;


    public GrahaluAdapter(Activity activity, ArrayList<Grahalu> grahalus, int coumt, String type) {
        this.activity = activity;
        this.grahalus = grahalus;
        this.count = coumt;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.round_recyculer_view, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, @SuppressLint("RecyclerView") int position) {
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Grahalu grahalu = grahalus.get(position);

        if (type.equals("home")) {
            if (position == 3) {
                holder.tvName.setText("More");
                holder.imgGrahalu.setImageDrawable(activity.getDrawable(R.drawable.more));
            } else {
                holder.tvName.setText(grahalu.getName());
                Glide.with(activity).load(grahalu.getImage()).placeholder(R.drawable.logo).into(holder.imgGrahalu);
            }
        } else {
            holder.tvName.setText(grahalu.getName());
            Glide.with(activity).load(grahalu.getImage()).placeholder(R.drawable.logo).into(holder.imgGrahalu);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 3 && count == 4) {
                    count = grahalus.size();
                    type = "finish";
                    notifyDataSetChanged();
                } else {
                    session.setData(Constant.GRAHALU_ID, grahalu.getId());
                    if (grahalu.getName().equals("Nakshatharalu")) {
                        Intent intent = new Intent(activity, NakshathraluActivity.class);
                        activity.startActivity(intent);

                    } else {
                        Intent intent = new Intent(activity, GrahaluSubMenuActivity.class);
                        intent.putExtra(Constant.TITLE, grahalu.getName());
                        intent.putExtra(Constant.ID, grahalu.getId());
                        activity.startActivity(intent);
                    }

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return count;
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        ImageView imgGrahalu;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgGrahalu = itemView.findViewById(R.id.image);
            tvName = itemView.findViewById(R.id.tvTitle);
        }
    }
}
