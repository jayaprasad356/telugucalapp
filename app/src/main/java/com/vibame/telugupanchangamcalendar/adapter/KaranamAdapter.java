package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Karanam;

import java.util.ArrayList;


public class KaranamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Karanam> karanams;

    public KaranamAdapter(Activity activity, ArrayList<Karanam> karanams) {
        this.activity = activity;
        this.karanams = karanams;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.karanam_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Karanam karanam = karanams.get(position);
        holder.tvDescription.setText(karanam.getDescription());

    }

    @Override
    public int getItemCount()
    {
        return karanams.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvDescription;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);


        }
    }
}
