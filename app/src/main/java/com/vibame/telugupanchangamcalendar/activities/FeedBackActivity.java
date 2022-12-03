package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.HomeActivity;
import com.vibame.telugupanchangamcalendar.R;

public class FeedBackActivity extends AppCompatActivity {


    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);



        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedBackActivity.this,"Feedback Submit Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FeedBackActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}