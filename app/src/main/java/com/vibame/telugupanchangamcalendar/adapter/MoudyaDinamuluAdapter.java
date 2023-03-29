package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Abdhikam;
import com.vibame.telugupanchangamcalendar.model.MoudyaDinamulu;

import java.util.ArrayList;

public class MoudyaDinamuluAdapter extends RecyclerView.Adapter<MoudyaDinamuluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<MoudyaDinamulu> moudyaDinamulus;

    public MoudyaDinamuluAdapter(Activity activity, ArrayList<MoudyaDinamulu> moudyaDinamulus) {
        this.moudyaDinamulus = moudyaDinamulus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.moudya_tab_layout, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDescription.setText(moudyaDinamulus.get(position).getDescription());
        holder.tvTitle.setText(moudyaDinamulus.get(position).getTitle());

    }


    @Override
    public int getItemCount() {
        return moudyaDinamulus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDescription,tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            this.tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
