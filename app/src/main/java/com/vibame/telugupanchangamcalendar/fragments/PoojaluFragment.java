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
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class PoojaluFragment extends Fragment {
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    PoojaluAdapter poojaluAdapter;


    public PoojaluFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_poojalu, container, false);
        activity = getActivity();
        recyclerView = root.findViewById(R.id.recyclerView);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        poojaluList();

        return root;
    }
    private void poojaluList()
    {
        if (databaseHelper.getPoojaluList().size() !=0){
            poojaluAdapter = new PoojaluAdapter(activity, databaseHelper.getPoojaluList(),databaseHelper.getPoojaluList().size(),"fragment");
            recyclerView.setAdapter(poojaluAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }


    }
}