package com.vibame.telugupanchangamcalendar.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

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

            mProgressBar = customView.findViewById(R.id.customProgressBar);
            mLoadingText = customView.findViewById(R.id.loadingText);
            custom_progress_layout = customView.findViewById(R.id.custom_progress_layout);


            hideProgress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProgress() {
        if (mProgressBar.getVisibility() == View.GONE) {
            mProgressBar.setVisibility(View.VISIBLE);
            mLoadingText.setVisibility(View.VISIBLE);
            custom_progress_layout.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mLoadingText.setVisibility(View.GONE);
        custom_progress_layout.setVisibility(View.GONE);
    }
}