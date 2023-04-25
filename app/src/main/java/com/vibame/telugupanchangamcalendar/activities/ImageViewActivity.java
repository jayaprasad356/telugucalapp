package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.artjimlop.altex.AltexImageDownloader;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;

import org.json.JSONObject;

import java.util.HashMap;

public class ImageViewActivity extends AppCompatActivity {
String imageurl,imageId;
ImageView ivImage;
FloatingActionButton FABDownload;
Activity activity;
ImageView ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Intent intent = getIntent();
        activity=this;


        // Accessing the data using key and value
        imageurl = intent.getStringExtra(Constant.IMAGE);
        imageId=intent.getStringExtra(Constant.ID);
        ivImage=findViewById(R.id.ivImage);
        FABDownload=findViewById(R.id.FABDownload);
        ibBack=findViewById(R.id.imgBack);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Glide.with(this).load(imageurl).into(ivImage);
        FABDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AltexImageDownloader.writeToDisk(activity,imageurl , "IMAGES");
                Toast.makeText(activity, "Image Donloading...", Toast.LENGTH_SHORT).show();
                downloadCountApi(imageId);
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