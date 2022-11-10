package com.vibame.telugupanchangamcalendar.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vibame.telugupanchangamcalendar.R;


public class PrivacyPolicyFragment extends Fragment {



    public PrivacyPolicyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_privacy_policy, container, false);

        WebView webView = root.findViewById(R.id.web);


        // loading http://www.google.com url in the WebView.
        webView.loadUrl("http://vibame.com/Privacy%20Policy.html");

        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());


        return root;
    }
}