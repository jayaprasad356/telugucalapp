package com.vibame.telugupanchangamcalendar.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.MuhurthamAdapter;
import com.vibame.telugupanchangamcalendar.model.Muhurtham;

import java.util.ArrayList;

public class MuhurthamFragment extends Fragment {



    Activity activity;
    RecyclerView recyclerview;
    MuhurthamAdapter muhurthamAdapter;


    public MuhurthamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_muhurtham, container, false);
        activity = getActivity();

        recyclerview = root.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerview.setLayoutManager(linearLayoutManager);


        muhurthamlist();



        return root;

    }

    private void muhurthamlist() {

        ArrayList<Muhurtham> muhurthams = new ArrayList<>();

        Muhurtham muhurtham1 = new Muhurtham("1","Name Muhurtham");

        muhurthams.add(muhurtham1);

        muhurthamAdapter = new MuhurthamAdapter(activity,muhurthams);
        recyclerview.setAdapter(muhurthamAdapter);
    }
}