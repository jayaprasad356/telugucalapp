package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.artjimlop.altex.AltexImageDownloader;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewPagerAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ImageViewActivity extends AppCompatActivity {
String image,imageUrl;
int imageId;
ImageView ivImage;
FloatingActionButton FABDownload;
Activity activity;
ImageView ibBack;
    ArrayList<String> imagesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Intent intent = getIntent();
        activity=this;

        image = intent.getStringExtra(Constant.IMAGE);
        imagesList= intent.getStringArrayListExtra(Constant.IMAGE_URL);
        imageId=intent.getIntExtra(Constant.ID,0);

        FABDownload=findViewById(R.id.FABDownload);
        ibBack=findViewById(R.id.imgBack);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(this, imagesList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(imageId);

        FABDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentImage = imagesList.get(viewPager.getCurrentItem());
                AltexImageDownloader.writeToDisk(activity, currentImage, "IMAGES");
                Toast.makeText(activity, "Image Downloading...", Toast.LENGTH_SHORT).show();
                downloadCountApi(String.valueOf(imageId));
            }
        });


    }

    private void downloadCountApi(String id)
    {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.IMAGE_ID,id);

        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("Image_download","yes");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.DOWNLOADIMAGECOUNT_URL,params,false);



    }
}