package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class GrahaluActivity extends AppCompatActivity {

    LinearLayout llRahu, llGuru, llBudha, llSukra, llShani, llRah, llKetu, llMangal, lllast;
    Activity activity;
    ImageView imgBack;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grahalu);

        activity = this;

        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



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

                String name = "Rahuvu";
                apicall(name);
                //  showdialog();


            }
        });
        llGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "Gurudu";
                apicall(name);
                //  showdialog();

            }
        });

        llBudha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "Bhudhudu";
                apicall(name);
                //  showdialog();
            }
        });


        llSukra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = "Shani";
                apicall(name);
                //  showdialog();
            }
        });

        llShani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = "Suryudu";
                apicall(name);
                //  showdialog();

            }
        });

        llRah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = "Shukrudu";
                apicall(name);
                //  showdialog();
            }
        });

        llKetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "Kethuvu";
                apicall(name);
                //  showdialog();
            }
        });

        llMangal.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String name = "Kujudu";
                apicall(name);
                //  showdialog();
            }
        });

        lllast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "Chandhrudu";
                apicall(name);
                //  showdialog();

            }
        });


    }

    private void apicall(String name) {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.NAME, name);


        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {

                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);


                        String Title = jsonArray.getJSONObject(0).getString("title");
                        String Description = jsonArray.getJSONObject(0).getString("description");

                       showdialog(Title, Description);


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.NAVA_GRAHA_PRAVESHAM, params, true);


    }




    private void showdialog(String title, String description) {

        Dialog dialog = new Dialog(activity);

        dialog.setContentView(R.layout.rashi_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        TextView tvdescription = dialog.findViewById(R.id.tvdescription);
        TextView tvdate = dialog.findViewById(R.id.tvdate);
        ImageButton dialogDismiss_button = dialog.findViewById(R.id.dialogDismiss_button);


        tvdate.setText(title);
        tvdescription.setText(description);




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
