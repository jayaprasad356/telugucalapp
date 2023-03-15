package com.vibame.telugupanchangamcalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.NestedScrollView;

public class SwipeableScrollView extends NestedScrollView {

    private final GestureDetectorCompat gestureDetector;
    private SwipeListener swipeListener;

    public SwipeableScrollView(Context context) {
        this(context, null);
    }

    public SwipeableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        gestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (Math.abs(velocityX) > Math.abs(velocityY)) {
                    if (e1.getX() < e2.getX()) {
                        // Swipe right
                        if (swipeListener != null) {
                            swipeListener.onSwipeRight();
                        }
                    } else {
                        // Swipe left
                        if (swipeListener != null) {
                            swipeListener.onSwipeLeft();
                        }
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Allow touch events to pass through if a horizontal swipe is detected
        return !gestureDetector.onTouchEvent(ev) && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void setSwipeListener(SwipeListener listener) {
        swipeListener = listener;
    }

    public interface SwipeListener {
        void onSwipeLeft();
        void onSwipeRight();



    }



}
