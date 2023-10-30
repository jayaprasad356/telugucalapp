package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class NewBakthiMusicActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Activity activity;
    AudioLiveAdapter audioLiveAdapter;
    DatabaseHelper databaseHelper ;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bakthi_music);

        activity = this;

        databaseHelper = new DatabaseHelper(activity);

        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);
        audiolist();

        audiolive();


    }

    private void audiolist() {
        HashMap<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Festivallise", response);
                        JSONArray jsonArray3 = jsonObject.getJSONArray(Constant.DATA);

                        for (int i = 0; i < jsonArray3.length(); i++) {
                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToAudio(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.IMAGE),jsonObject1.getString(Constant.LYRICS),jsonObject1.getString(Constant.AUDIO));


                            } else {
                                break;
                            }
                        }

                        audiolive();


                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.AUDIO_LIST_URL, params, true);
    }

    private void audiolive() {
        Log.d("AUDIO_COUNT", String.valueOf(databaseHelper.getAudiosCount()));
        if (databaseHelper.getAudioList().size() != 0) {
            audioLiveAdapter = new AudioLiveAdapter(activity, databaseHelper.getAudioList());
            recyclerView.setAdapter(audioLiveAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        } else {
            Toast.makeText(activity, "not", Toast.LENGTH_SHORT).show();

            recyclerView.setVisibility(View.GONE);
        }
    }





}