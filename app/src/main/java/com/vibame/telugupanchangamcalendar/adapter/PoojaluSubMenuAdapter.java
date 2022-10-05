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
import com.vibame.telugupanchangamcalendar.model.Poojalu;
import com.vibame.telugupanchangamcalendar.model.PoojaluSubMenu;

import java.util.ArrayList;


public class PoojaluSubMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<PoojaluSubMenu> poojaluSubMenus;

    public PoojaluSubMenuAdapter(Activity activity, ArrayList<PoojaluSubMenu> poojaluSubMenus) {
        this.activity = activity;
        this.poojaluSubMenus = poojaluSubMenus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.poojalu_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final PoojaluSubMenu poojaluSubMenu = poojaluSubMenus.get(position);
        holder.tvName.setText(poojaluSubMenu.getName());
        Glide.with(activity).load(poojaluSubMenu.getImage()).placeholder(R.drawable.logo).into(holder.imgPoojalu);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PoojaluTabActivity.class);
                intent.putExtra(Constant.SUBCATEGORY_ID,poojaluSubMenu.getId());
                intent.putExtra(Constant.TITLE,poojaluSubMenu.getName());
                activity.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount()
    {
        return poojaluSubMenus.size();
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
