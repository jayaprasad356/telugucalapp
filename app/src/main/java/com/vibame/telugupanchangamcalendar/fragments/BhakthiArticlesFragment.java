package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.NetiArticlesActivity;
import com.vibame.telugupanchangamcalendar.activities.OldArticlesActivity;


public class BhakthiArticlesFragment extends Fragment {


    CardView cardNewArticles,cardOldArticles;


    public BhakthiArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bhakthi_articles, container, false);


        cardOldArticles = root.findViewById(R.id.cardOldArticles);
        cardNewArticles = root.findViewById(R.id.cardNewArticles);


        cardNewArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NetiArticlesActivity.class);
                startActivity(intent);
            }
        });
        cardOldArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OldArticlesActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }
}