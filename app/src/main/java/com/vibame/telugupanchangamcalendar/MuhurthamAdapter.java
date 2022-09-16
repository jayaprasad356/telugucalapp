package com.vibame.telugupanchangamcalendar;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MuhurthamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;
    Typeface typeface;

    public MuhurthamAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{

        private TextView starName,startTime,endTime;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);

            starName = (TextView) itemView.findViewById(R.id.starNames);
            startTime = (TextView) itemView.findViewById(R.id.startTime);
            endTime = (TextView) itemView.findViewById(R.id.endTime);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.muhurth_list,parent,false);
                typeface = Typeface.createFromAsset(parent.getContext().getAssets(),"fonts/sree.ttf");
                return new itemViewHolder(layoutView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType)
        {
            case TYPE:
            default:

                itemViewHolder itemViewHolder = (MuhurthamAdapter.itemViewHolder)holder;
                MuhurthamList muhurthamList = (MuhurthamList) listRecyclerItem.get(position);

                itemViewHolder.starName.setText(muhurthamList.getStarName());
                itemViewHolder.startTime.setText(muhurthamList.getStartTime());
                itemViewHolder.endTime.setText(muhurthamList.getEndTime());

                itemViewHolder.starName.setTypeface(typeface);
                itemViewHolder.startTime.setTypeface(typeface);
                itemViewHolder.endTime.setTypeface(typeface);
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
