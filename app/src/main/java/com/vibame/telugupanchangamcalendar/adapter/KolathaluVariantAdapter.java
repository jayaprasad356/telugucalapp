package com.vibame.telugupanchangamcalendar.adapter;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KolathaluVariantAdapter extends RecyclerView.Adapter<KolathaluVariantAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Kolathalu> kolathalus;

    public KolathaluVariantAdapter(Activity activity, ArrayList<Kolathalu> kolathalus) {
        this.kolathalus = kolathalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.kolathalu_variant, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//
//        holder.title.setText(kolathalus.get(position).getTitle());
        holder.subtitle1.setText(kolathalus.get(position).getSub_title());
        holder.subdescription1.setText(kolathalus.get(position).getSub_description());







    }






    @Override
    public int getItemCount() {
        return kolathalus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
           public TextView subtitle1;
        public TextView subdescription1;

        public ViewHolder(View itemView) {
            super(itemView);
            this.subtitle1 = itemView.findViewById(R.id.sub_title1);
            this.subdescription1 = itemView.findViewById(R.id.sub_description_1a);


        }
    }



}
