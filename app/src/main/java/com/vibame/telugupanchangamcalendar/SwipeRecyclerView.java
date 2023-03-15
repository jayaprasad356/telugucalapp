package com.vibame.telugupanchangamcalendar;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeRecyclerView extends RecyclerView {

    public SwipeRecyclerView(Context context) {
        super(context);
        init();
    }

    public SwipeRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwipeRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // create and attach ItemTouchHelper to RecyclerView
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if (listener != null) {
                    listener.onSwipe(viewHolder.getAdapterPosition(), direction);
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(this);
    }

    private SwipeListener listener;

    public void setSwipeListener(SwipeListener listener) {
        this.listener = listener;
    }

    public interface SwipeListener {
        void onSwipe(int position, int direction);


    }
}
