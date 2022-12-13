package com.vibame.telugupanchangamcalendar.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.vibame.telugupanchangamcalendar.HomeActivity;
import com.vibame.telugupanchangamcalendar.Panchang_Frag;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.RasiphaluluActivity;
import com.vibame.telugupanchangamcalendar.activities.FestivalActivity;
import com.vibame.telugupanchangamcalendar.activities.MuhurthamActivity;
import com.vibame.telugupanchangamcalendar.activities.PanchangamActivity;
import com.vibame.telugupanchangamcalendar.activities.RashuluActivity;
import com.vibame.telugupanchangamcalendar.fragments.FestivalFragment;
import com.vibame.telugupanchangamcalendar.fragments.MuhurthamFragment;
import com.vibame.telugupanchangamcalendar.fragments.PanchnagamListFragment;
import com.vibame.telugupanchangamcalendar.model.SliderItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdaptervh> {

    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<SliderItem>();
    private ArrayList<Array[]> slider = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapter.SliderAdaptervh onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdaptervh(inflate);
    }


    @Override
    public void onBindViewHolder(SliderAdapter.SliderAdaptervh viewHolder, final int position) {
        SliderItem sliderItem = mSliderItems.get(position);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);
        viewHolder.title.setText(sliderItem.getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    Intent intent = new Intent(context, PanchangamActivity.class);
                    context.startActivity(intent);
                }else if (position == 1){
                    Intent intent = new Intent(context, FestivalActivity.class);
                    context.startActivity(intent);

                }else if (position == 2){
                    Intent intent = new Intent(context, RasiphaluluActivity.class);
                    context.startActivity(intent);

                }else if (position == 3){
                    Intent intent = new Intent(context, MuhurthamActivity.class);
                    context.startActivity(intent);

                }
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdaptervh extends ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView title;

        public SliderAdaptervh(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.tvTitle);
            this.itemView = itemView;
        }
    }

}