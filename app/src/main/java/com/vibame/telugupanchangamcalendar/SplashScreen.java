package com.vibame.telugupanchangamcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vibame.telugupanchangamcalendar.activities.NewCalendarActivity;
import com.vibame.telugupanchangamcalendar.activities.RashuluActivity;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {
    Activity activity;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = SplashScreen.this;
        databaseHelper = new DatabaseHelper(activity);


        if (ApiConfig.isConnected(activity)){
            getDatalist();
        }else {
            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {
                    Intent i = new Intent(SplashScreen.this, RashuluActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 2000);

        }


    }
    private void getDatalist()
    {
        Map<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        databaseHelper.deleteDb(activity);
                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray = object.getJSONArray(Constant.PANCHANGAM_LIST);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPanchangam(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.DATE),jsonObject1.getString(Constant.SUNRISE),jsonObject1.getString(Constant.SUNSET),jsonObject1.getString(Constant.MOONRISE), jsonObject1.getString(Constant.MOONSET));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray2 = object.getJSONArray(Constant.PANCHANGAM_TAB_LIST);

                        for (int i = 0; i < jsonArray2.length(); i++) {
                            JSONObject jsonObject1 = jsonArray2.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPanchangamTab(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.PANCHANGAM_ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));


                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray3 = object.getJSONArray(Constant.FESTIVALS_LIST);

                        for (int i = 0; i < jsonArray3.length(); i++) {
                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToFestival(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.DATE),jsonObject1.getString(Constant.FESTIVAL));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray4 = object.getJSONArray(Constant.MUHURTHAM_LIST);

                        for (int i = 0; i < jsonArray4.length(); i++) {
                            JSONObject jsonObject1 = jsonArray4.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToMuhurtham(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MUHURTHAM));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray5 = object.getJSONArray(Constant.MUHURTHAM_TAB_LIST);

                        for (int i = 0; i < jsonArray5.length(); i++) {
                            JSONObject jsonObject1 = jsonArray5.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToMuhurthamTab(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MUHURTHAM_ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));

                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray6 = object.getJSONArray(Constant.POOJALU_LIST);

                        for (int i = 0; i < jsonArray6.length(); i++) {
                            JSONObject jsonObject1 = jsonArray6.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojalu(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.NAME),jsonObject1.getString(Constant.IMAGE));

                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray7 = object.getJSONArray(Constant.POOJALU_SUB_MENU_LIST);

                        for (int i = 0; i < jsonArray7.length(); i++) {
                            JSONObject jsonObject1 = jsonArray7.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojaluSubMenu(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.POOJALU_ID),jsonObject1.getString(Constant.NAME),jsonObject1.getString(Constant.IMAGE));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray8 = object.getJSONArray(Constant.POOJALU_TAB_LIST);

                        for (int i = 0; i < jsonArray8.length(); i++) {
                            JSONObject jsonObject1 = jsonArray8.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojaluTab(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.POOJALU_ID),jsonObject1.getString(Constant.SUBCATEGORY_ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION),jsonObject1.getString(Constant.SUB_TITLE),jsonObject1.getString(Constant.SUB_DESCRIPTION));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray9 = object.getJSONArray(Constant.GRAHALU_LIST);

                        for (int i = 0; i < jsonArray9.length(); i++) {
                            JSONObject jsonObject1 = jsonArray9.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahalu(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.NAME),jsonObject1.getString(Constant.IMAGE));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray10 = object.getJSONArray(Constant.GRAHALU_SUB_MENU_LIST);

                        for (int i = 0; i < jsonArray10.length(); i++) {
                            JSONObject jsonObject1 = jsonArray10.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahuluSubMenu(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.GRAHALU_ID),jsonObject1.getString(Constant.NAME),jsonObject1.getString(Constant.IMAGE));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray11 = object.getJSONArray(Constant.GRAHALU_TAB_LIST);

                        for (int i = 0; i < jsonArray11.length(); i++) {
                            JSONObject jsonObject1 = jsonArray11.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahaluTab(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.GRAHALU_ID),jsonObject1.getString(Constant.SUBCATEGORY_ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION),jsonObject1.getString(Constant.SUB_TITLE),jsonObject1.getString(Constant.SUB_DESCRIPTION));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray12 = object.getJSONArray(Constant.NAKSHATRALU_LIST);

                        for (int i = 0; i < jsonArray12.length(); i++) {
                            JSONObject jsonObject1 = jsonArray12.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToNakshatralu(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.NAME),jsonObject1.getString(Constant.IMAGE));
                            } else {
                                break;
                            }
                        }

                        JSONArray jsonArray13 = object.getJSONArray(Constant.VIDEO_LIST);

                        for (int i = 0; i < jsonArray13.length(); i++) {
                            JSONObject jsonObject1 = jsonArray13.getJSONObject(i);
                            if (jsonObject1 != null) {

                                databaseHelper.AddToVideo(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.LINK));
                            } else {
                                break;
                            }
                        }

                        JSONArray jsonArray14 = object.getJSONArray(Constant.AUDIO_LIST);
                        Log.d("AUDIO_LIST",jsonArray14.toString());


                        for (int i = 0; i < jsonArray14.length(); i++) {
                            JSONObject jsonObject1 = jsonArray14.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToAudio(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.IMAGE),jsonObject1.getString(Constant.LYRICS),jsonObject1.getString(Constant.AUDIO));
                            } else {
                                break;
                            }
                        }
                        JSONArray jsonArray15 = object.getJSONArray(Constant.NAKSHATRALU_TAB_LIST);

                        for (int i = 0; i < jsonArray15.length(); i++) {
                            JSONObject jsonObject1 = jsonArray15.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToNakshatharaluTab(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.NAKSHATRALU_ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION),jsonObject1.getString(Constant.SUB_TITLE),jsonObject1.getString(Constant.SUB_DESCRIPTION));
                            } else {
                                break;
                            }
                        }

                        Intent i = new Intent(activity, NewCalendarActivity.class);
                        startActivity(i);
                        finish();


                    }
                    else {


                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.ALLDATALIST_URL, params,true);


    }
}