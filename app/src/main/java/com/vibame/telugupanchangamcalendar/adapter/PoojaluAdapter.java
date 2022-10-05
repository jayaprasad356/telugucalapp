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
import com.vibame.telugupanchangamcalendar.activities.PoojaluSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.PoojaluTabActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Poojalu;
import com.vibame.telugupanchangamcalendar.model.YearTab;

import java.util.ArrayList;


public class PoojaluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Poojalu> poojalus;
    Session session;
    DatabaseHelper databaseHelper;

    public PoojaluAdapter(Activity activity, ArrayList<Poojalu> poojalus) {
        this.activity = activity;
        this.poojalus = poojalus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.poojalu_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Poojalu poojalu = poojalus.get(position);
        holder.tvName.setText(poojalu.getName());
        Glide.with(activity).load(poojalu.getImage()).placeholder(R.drawable.logo).into(holder.imgPoojalu);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setData(Constant.POOJALU_ID,poojalu.getId());
                if (databaseHelper.getPoojaluTabList(poojalu.getId(),"0").size() !=0){
                    Intent intent = new Intent(activity, PoojaluTabActivity.class);
                    intent.putExtra(Constant.SUBCATEGORY_ID,"0");
                    intent.putExtra(Constant.TITLE,poojalu.getName());
                    activity.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(activity, PoojaluSubMenuActivity.class);
                    intent.putExtra(Constant.TITLE,poojalu.getName());
                    intent.putExtra(Constant.ID,poojalu.getId());
                    activity.startActivity(intent);
                }

            }
        });



    }

    @Override
    public int getItemCount()
    {
        return poojalus.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        ImageView imgPoojalu;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgPoojalu = itemView.findViewById(R.id.imgPoojalu);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
