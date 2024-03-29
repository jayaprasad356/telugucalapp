package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class ArticleViewActivity extends AppCompatActivity {

    TextView tvHead,tvTitle,tvDescription;
    ImageView imgGod,imgBack;
    Activity activity;
    String Title,Decription,Image,Name;
    ImageButton btnWAShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_view);

        activity = ArticleViewActivity.this;

        tvDescription = findViewById(R.id.tvDescription);
        tvTitle = findViewById(R.id.tvTitle);
        tvHead = findViewById(R.id.tvHead);
        imgGod = findViewById(R.id.imgGod);
        imgBack = findViewById(R.id.imgBack);


        Title = getIntent().getStringExtra(Constant.TITLE);
        Decription = getIntent().getStringExtra(Constant.DESCRIPTION);
        Image = getIntent().getStringExtra(Constant.IMAGE);
        Name = getIntent().getStringExtra(Constant.NAME);


        tvHead.setText(Name);
        tvTitle.setText(Title);
        tvDescription.setText(Decription);
        Glide.with(activity).load(Image).into(imgGod);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });








    }
}