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
import com.vibame.telugupanchangamcalendar.activities.GrahaluTabActivity;
import com.vibame.telugupanchangamcalendar.activities.PoojaluTabActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.GrahaluSubMenu;
import com.vibame.telugupanchangamcalendar.model.PoojaluSubMenu;

import java.util.ArrayList;


public class GrahaluSubMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<GrahaluSubMenu> grahaluSubMenus;

    public GrahaluSubMenuAdapter(Activity activity, ArrayList<GrahaluSubMenu> grahaluSubMenus) {
        this.activity = activity;
        this.grahaluSubMenus = grahaluSubMenus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.grahalu_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final GrahaluSubMenu grahaluSubMenu = grahaluSubMenus.get(position);
        holder.tvName.setText(grahaluSubMenu.getName());
        Glide.with(activity).load(grahaluSubMenu.getImage()).placeholder(R.drawable.logo).into(holder.imgGrahalu);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, GrahaluTabActivity.class);
                intent.putExtra(Constant.SUBCATEGORY_ID,grahaluSubMenu.getId());
                intent.putExtra(Constant.TITLE,grahaluSubMenu.getName());
                activity.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount()
    {
        return grahaluSubMenus.size();
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
