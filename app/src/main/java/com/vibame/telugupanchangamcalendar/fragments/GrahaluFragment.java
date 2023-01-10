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
import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;


public class GrahaluFragment extends Fragment {
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    GrahaluAdapter grahaluAdapter;

    public GrahaluFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_grahalu, container, false);
        activity = getActivity();
        recyclerView = root.findViewById(R.id.recyclerView);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        grahaluList();
        return root;
    }

    private void grahaluList()
    {
        if (databaseHelper.getGrahaluList().size() !=0){
            grahaluAdapter = new GrahaluAdapter(activity, databaseHelper.getGrahaluList(),databaseHelper.getGrahaluList().size(),"frag");
            recyclerView.setAdapter(grahaluAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }

    }
}