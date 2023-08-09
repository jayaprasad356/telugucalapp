package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.Notification;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;


public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Notification> notifications;

    public NotificationAdapter(Activity activity, ArrayList<Notification> notifications) {
        this.activity = activity;
        this.notifications = notifications;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.notification_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Notification notification = notifications.get(position);


        holder.tvTitle.setText(notification.getTitle());
        holder.tv_discription.setText(notification.getDescription());
        holder.date.setText(notification.getDate());
        holder.time.setText(notification.getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notification.getLink()!=null && !notification.getLink().isEmpty()){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(notification.getLink()));
                    activity.startActivity(browserIntent);
                }
            }
        });


    }

    @Override
    public int getItemCount()
    {
        return notifications.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView id;
        final TextView tv_discription;
        final TextView date;
        final TextView time;
        final TextView tvTitle;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            tv_discription = itemView.findViewById(R.id.tv_discription);
            date = itemView.findViewById(R.id.tv_date);
            time = itemView.findViewById(R.id.tv_time);
            tvTitle = itemView.findViewById(R.id.tv_title);

        }
    }
}
