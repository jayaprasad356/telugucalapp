package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GrahaluActivity extends AppCompatActivity {

    LinearLayout llRahu,llGuru,llBudha,llSukra,llShani,llRah,llKetu,llMangal,lllast;
    Activity activity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grahalu);

        activity = this;


        llRahu = findViewById(R.id.llRahu);
        llGuru = findViewById(R.id.llGuru);
        llBudha = findViewById(R.id.llBudha);
        llSukra = findViewById(R.id.llSukra);
        llShani = findViewById(R.id.llShani);
        llRah = findViewById(R.id.llRah);
        llKetu = findViewById(R.id.llKetu);
        llMangal = findViewById(R.id.llMangal);
        lllast = findViewById(R.id.lllast);



        llRahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();


            }
        });
        llGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});

        llBudha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});


        llSukra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});

        llShani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});

        llRah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});

        llKetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});

        llMangal.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                showdialog();

            }});

        lllast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialog();

            }});


    }




    private void showdialog() {

        Dialog dialog = new Dialog(activity);

        dialog.setContentView(R.layout.rashi_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

       TextView tvdescription = dialog.findViewById(R.id.tvdescription);
       ImageButton dialogDismiss_button = dialog.findViewById(R.id.dialogDismiss_button);



        dialogDismiss_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//                Toast.makeText(activity, "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }

    }
