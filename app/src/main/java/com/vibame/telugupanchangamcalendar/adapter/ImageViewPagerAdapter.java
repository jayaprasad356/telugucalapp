package com.vibame.telugupanchangamcalendar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;

import java.util.List;

public class ImageViewPagerAdapter extends PagerAdapter {

    private List<String> images;
    private Context context;

    public ImageViewPagerAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = new ImageView(context);
            Glide.with(context).load(R.drawable.app_icon).into(imageView); // use a default image
            if (images.size() > position && images.get(position) != null) {
                Glide.with(context).load(images.get(position)).into(imageView); // load the image if it exists
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView) object);
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

    }
