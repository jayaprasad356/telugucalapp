package com.vibame.telugupanchangamcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vibame.telugupanchangamcalendar.activities.CalendarNewActivity;
import com.vibame.telugupanchangamcalendar.activities.NewCalendarActivity;
import com.vibame.telugupanchangamcalendar.activities.RashuluActivity;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {
    Activity activity;
    DatabaseHelper databaseHelper;
    Session session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = SplashScreen.this;
        databaseHelper = new DatabaseHelper(activity);
        session = new Session(activity);


        if (ApiConfig.isConnected(activity)){
            getDatalist();

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
                        JSONArray setArray = object.getJSONArray(Constant.SETTINGS_LIST);
                        JSONArray setArraySakunaSasthram = object.getJSONArray(Constant.SAKUNA_SASTHRAM_LIST);
                        JSONArray setArrayTeluguSamkrutham= object.getJSONArray(Constant.TELUGU_SAMKRUTHAM_LIST);
                        String image = setArray.getJSONObject(0).getString(Constant.IMAGE);
                        session.setData(Constant.GODIMAGE,image);
                        String live_telecast_image = setArray.getJSONObject(0).getString(Constant.TELECAST_IMAGE);
                        session.setData(Constant.LIVE_TELECAST_IMAGE,live_telecast_image);
                        String imagetab = setArray.getJSONObject(0).getString(Constant.IMAGE_TAB);
                        session.setData(Constant.IMAGE_TAB,imagetab);
                        String videotab = setArray.getJSONObject(0).getString(Constant.VIDEO_TAB);
                        session.setData(Constant.VIDEO_TAB,videotab);
                        String gowri_image = setArray.getJSONObject(0).getString(Constant.GOWRI_IMAGE);
                        session.setData(Constant.GOWRI_IMAGE,gowri_image);
                        String chakram_image = setArray.getJSONObject(0).getString(Constant.CHAKRAM_IMAGE);
                        session.setData(Constant.CHAKRAM_IMAGE,chakram_image);
                        String thidhi_image = setArray.getJSONObject(0).getString(Constant.THIDHI_IMAGE);
                        session.setData(Constant.THIDHI_IMAGE,thidhi_image);
                        String karanam_image = setArray.getJSONObject(0).getString(Constant.KARANAM_IMAGE);
                        session.setData(Constant.KARANAM_IMAGE,karanam_image);
                        String rahukalam_image = setArray.getJSONObject(0).getString(Constant.RAHUKALAM_IMAGE);
                        session.setData(Constant.RAHUKALAM_IMAGE,rahukalam_image);
                        String yogam_image = setArray.getJSONObject(0).getString(Constant.YOGAM_IMAGE);
                        session.setData(Constant.YOGAM_IMAGE,yogam_image);
                        String neti_arti_image = setArray.getJSONObject(0).getString(Constant.NETI_ARTI_IMAGE);
                        session.setData(Constant.NETI_ARTI_IMAGE,neti_arti_image);
                        String old_arti_images = setArray.getJSONObject(0).getString(Constant.OLD_ARTI_IMAGES);
                        session.setData(Constant.OLD_ARTI_IMAGES,old_arti_images);


                        String sakunalu_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.SAKUNALU_IMAGE);
                        session.setData(Constant.SAKUNALU_IMAGE,sakunalu_image);
                        String balli_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.BALLI_IMAGE);
                        session.setData(Constant.BALLI_IMAGE,balli_image);
                        String kaki_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.KAKI_IMAGE);
                        session.setData(Constant.KAKI_IMAGE,kaki_image);
                        String kukuta_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.KUKUTA_IMAGE);
                        session.setData(Constant.KUKUTA_IMAGE,kukuta_image);
                        String sasthram_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.SASTHRAM_IMAGE);
                        session.setData(Constant.SASTHRAM_IMAGE,sasthram_image);
                        String pilli_image = setArraySakunaSasthram.getJSONObject(0).getString(Constant.PILLI_IMAGE);
                        session.setData(Constant.PILLI_IMAGE,pilli_image);


                        String TeluguYears = setArrayTeluguSamkrutham.getJSONObject(0).getString(Constant.IMAGE);
                        session.setData(Constant.TELUGUYEARS,TeluguYears);
                        String TeluguMonths = setArrayTeluguSamkrutham.getJSONObject(1).getString(Constant.IMAGE);
                        session.setData(Constant.TELUGUMONTHS,TeluguMonths);
                        String TeluguWeeks = setArrayTeluguSamkrutham.getJSONObject(2).getString(Constant.IMAGE);
                        session.setData(Constant.TELUGUWEEKS,TeluguWeeks);
                        String Ankelu = setArrayTeluguSamkrutham.getJSONObject(3).getString(Constant.IMAGE);
                        session.setData(Constant.ANKELU,Ankelu);
                        String Aksharalu = setArrayTeluguSamkrutham.getJSONObject(4).getString(Constant.IMAGE);
                        session.setData(Constant.AKSHARALU,Aksharalu);
                        String Guninthalu = setArrayTeluguSamkrutham.getJSONObject(5).getString(Constant.IMAGE);
                        session.setData(Constant.GUNINTHALU,Guninthalu);
                        String Rashulu = setArrayTeluguSamkrutham.getJSONObject(6).getString(Constant.IMAGE);
                        session.setData(Constant.RASHULU,Rashulu);
                        String kalalu = setArrayTeluguSamkrutham.getJSONObject(7).getString(Constant.IMAGE);
                        session.setData(Constant.KALALU,kalalu);
                        String Vruthulu = setArrayTeluguSamkrutham.getJSONObject(8).getString(Constant.IMAGE);
                        session.setData(Constant.VRUTHULU,Vruthulu);
                        String Navagrahalu = setArrayTeluguSamkrutham.getJSONObject(9).getString(Constant.IMAGE);
                        session.setData(Constant.NAVAGRAHALU,Navagrahalu);
                        String Ruthuvulu = setArrayTeluguSamkrutham.getJSONObject(10).getString(Constant.IMAGE);
                        session.setData(Constant.RUTHUVULU,Ruthuvulu);
                        String Kolathalu = setArrayTeluguSamkrutham.getJSONObject(11).getString(Constant.IMAGE);
                        session.setData(Constant.KOLATHALU,Kolathalu);
                        String Pakshamulu = setArrayTeluguSamkrutham.getJSONObject(12).getString(Constant.IMAGE);
                        session.setData(Constant.PAKSHAMULU,Pakshamulu);
                        String Lagnam = setArrayTeluguSamkrutham.getJSONObject(13).getString(Constant.IMAGE);
                        session.setData(Constant.LAGNAM,Lagnam);
                        String ThidhiAddhi = setArrayTeluguSamkrutham.getJSONObject(14).getString(Constant.IMAGE);
                        session.setData(Constant.THIDHIADDHI,ThidhiAddhi);
                        String Pushpalu = setArrayTeluguSamkrutham.getJSONObject(15).getString(Constant.IMAGE);
                        session.setData(Constant.PUSHPALU,Pushpalu);
                        String FruitNames = setArrayTeluguSamkrutham.getJSONObject(16).getString(Constant.IMAGE);
                        session.setData(Constant.FRUITNAMES,FruitNames);
                        String PrasadhamNames = setArrayTeluguSamkrutham.getJSONObject(17).getString(Constant.IMAGE);
                        session.setData(Constant.PRASADHAMNAMES,PrasadhamNames);
                        //Toast.makeText(activity, ""+image, Toast.LENGTH_SHORT).show();

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

                        Intent i = new Intent(activity, CalendarNewActivity.class);
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