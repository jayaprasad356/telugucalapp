package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vibame.telugupanchangamcalendar.R;

public class TrackerActivity extends AppCompatActivity {


    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);



        link = getIntent().getStringExtra("link");


        WebView webView = findViewById(R.id.web);


        // loading http://www.google.com url in the WebView.
        webView.loadUrl(link);

        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());
    }
}