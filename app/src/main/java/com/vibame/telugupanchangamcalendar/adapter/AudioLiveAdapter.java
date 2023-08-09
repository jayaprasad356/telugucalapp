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
import com.vibame.telugupanchangamcalendar.AudioPlayActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.ImageViewActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Audio;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, @SuppressLint("RecyclerView") int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Audio audio1 = audio.get(position);


        Glide.with(activity).load(audio1.getImage()).into(holder.image);


        holder.tvName.setText(audio1.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> audioList = new ArrayList<>();
                for (Audio audios : audio) {
                    audioList.add(audios.getAudio());
                }

                Intent intent = new Intent(activity, AudioPlayActivity.class);
                intent.putExtra(Constant.AUDIO_TITLE,audio1.getTitle());
                intent.putExtra(Constant.AUDIO,audio1.getAudio());
                intent.putExtra(Constant.LYRICS,audio1.getLyrics());
                intent.putExtra(Constant.ID,position);
                intent.putExtra(Constant.AUDIO_LIST,audioList);
                intent.putExtra(Constant.IMAGE,audio1.getImage());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {

        return audio.size();
//        if(audio.size() > limit){
//            return limit;
//        }
//        else
//        {
//
//        }

    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        final ImageView image;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            image = itemView.findViewById(R.id.image);

        }
    }
}
