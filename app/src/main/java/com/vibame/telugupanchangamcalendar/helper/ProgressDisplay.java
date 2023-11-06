package com.vibame.telugupanchangamcalendar.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.vibame.telugupanchangamcalendar.R;


public class ProgressDisplay {

    public static ProgressBar mProgressBar;
    private TextView mLoadingText;
    CardView custom_progress_layout;

    @SuppressLint({"UseCompatLoadingForDrawables", "MissingInflatedId"})
    public ProgressDisplay(Activity activity) {
        try {
            ViewGroup layout = (ViewGroup) activity.findViewById(android.R.id.content).getRootView();

            // Inflate the custom layout
            View customView = LayoutInflater.from(activity).inflate(R.layout.custom_progress_layout, layout, false);
            layout.addView(customView);


            ImageView gifImageView = customView.findViewById(R.id.gifImageView);



            mProgressBar = customView.findViewById(R.id.customProgressBar);
            custom_progress_layout = customView.findViewById(R.id.custom_progress_layout);


            // Load the GIF using Glide
            Glide.with(activity)
                    .asGif()
                    .load(R.drawable.progress) // Replace with your GIF resource
                    .placeholder(R.drawable.progress) // Replace with your placeholder image
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(gifImageView);

            hideProgress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProgress() {
        if (mProgressBar.getVisibility() == View.GONE) {
            mProgressBar.setVisibility(View.VISIBLE);
            custom_progress_layout.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        custom_progress_layout.setVisibility(View.GONE);
    }
}