package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.AudioPlayActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Audio;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;


public class AudioLiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Audio> audio;

    public AudioLiveAdapter(Activity activity, ArrayList<Audio> audio) {
        this.activity = activity;
        this.audio = audio;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.audio_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Audio audio1 = audio.get(position);


        holder.tvName.setText(audio1.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AudioPlayActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return audio.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);

        }
    }
}
