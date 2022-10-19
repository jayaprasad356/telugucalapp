package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Thidhilu;

import java.util.ArrayList;


public class GowriAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Gowri> gowris;

    public GowriAdapter(Activity activity, ArrayList<Gowri> gowris) {
        this.activity = activity;
        this.gowris = gowris;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.gowri_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Gowri gowri = gowris.get(position);


        holder.tvtime.setText(gowri.getTime());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, VideosActivity.class);
//                intent.putExtra(Constant.VIDEO_CATEGORY_ID,videoTab.getId());
//                intent.putExtra(Constant.NAME,videoTab.getName());
//                activity.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount()
    {
        return gowris.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvtime,tvMorning,tvNight;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvtime = itemView.findViewById(R.id.tvtime);
            tvMorning = itemView.findViewById(R.id.tvMorning);
            tvNight = itemView.findViewById(R.id.tvNight);



        }
    }
}
