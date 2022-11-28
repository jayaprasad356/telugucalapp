package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.vibame.telugupanchangamcalendar.CustomScrollView;
import com.vibame.telugupanchangamcalendar.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class NewCalendarActivity extends AppCompatActivity {

    private Boolean panelcchange = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calendar);

        SlidingUpPanelLayout layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        CustomScrollView myScrollView = (CustomScrollView) findViewById(R.id.myscrollView);
        myScrollView.setEnableScrolling(false); // disable scrolling
        myScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //Log.d(String.valueOf(myScrollView.getScrollY()), "scrollY: ");
                if (myScrollView.getScrollY() == 0) {
                    layout.setTouchEnabled(true);

                } else {
                    layout.setTouchEnabled(false);
                }

            }
        });

        layout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

                if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    myScrollView.setEnableScrolling(true); // enable scrolling

                    //Log.d(String.valueOf(myScrollView.getScrollY()), "onPanelStateChanged: ");
                } else if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    myScrollView.setEnableScrolling(false); // disable scrolling
                    //Log.d("COLLAPSED", "onPanelStateChanged: ");
                }

            }
        });


    }
}