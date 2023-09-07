package com.vibame.telugupanchangamcalendar.viewpager2_;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DailyPage1Activity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    DatabaseHelper databaseHelper;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_page2);
        viewPager2 = findViewById(R.id.viewpager);

        activity = this;
        databaseHelper = new DatabaseHelper(activity);


        int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        String[] heading = {"Baked", "Grilled", "Dessert", "Italian", "Shakes"};
        String[] desc = {getString(R.string.a_desc),
                getString(R.string.b_desc),
                getString(R.string.c_desc),
                getString(R.string.d_desc)
                , getString(R.string.e_desc)};


        String[] text1 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] text2 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] text3 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] text4 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] text5 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] text6 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] sunrise = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] sunset = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] moonrise = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] moonset = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] festivals = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] thidhi = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] nakshatram = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] yogam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] karanam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] abhijithMuhurtham = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] bhramaMuhurtham = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] amruthaKalam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] gulikaKalam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] yamagandaKalam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] rahuKalam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] durmuhurtham = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] varjyam = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] yamaganda = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] rahu = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] gulika = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc1 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc2 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc3 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc4 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc5 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc6 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc7 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc8 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc9 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc10 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc11 = {"Demo", "Demo", "Demo", "Demo", "Demo"};
        String[] hc12 = {"Demo", "Demo", "Demo", "Demo", "Demo"};


        viewPagerItemArrayList = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {

            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i], heading[i], desc[i],text1[i],text2[i],text3[i],text4[i],text5[i],text6[i],sunrise[i],sunset[i],moonrise[i],moonset[i],festivals[i],thidhi[i],nakshatram[i],yogam[i],karanam[i],abhijithMuhurtham[i],bhramaMuhurtham[i],amruthaKalam[i],gulikaKalam[i],yamagandaKalam[i],rahuKalam[i],durmuhurtham[i],varjyam[i],yamaganda[i],rahu[i],gulika[i],hc1[i],hc2[i],hc3[i],hc4[i],hc5[i],hc6[i],hc7[i],hc8[i],hc9[i],hc10[i],hc11[i],hc12[i]);
            viewPagerItemArrayList.add(viewPagerItem);

        }

        VPAdapter vpAdapter = new VPAdapter(activity, viewPagerItemArrayList);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setCurrentItem(500, false);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        panchangamlist("20-08-2023");

    }


    private void panchangamlist(String date) {

        HashMap<String, String> params = new HashMap<>();
        params.put("date", date);
        ApiConfig.RequestToVolley((result, response) -> {

            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("DAILY_PANCHANGAM_LIST", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<ViewPagerItem> viewPagerItemArrayList = new ArrayList<>();



                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            if (jsonObject1 != null) {
                                ViewPagerItem group = g.fromJson(jsonObject1.toString(), ViewPagerItem.class);
                                viewPagerItemArrayList.add(group);
                            } else {
                                break;
                            }
                        }

                       VPAdapter adapter = new VPAdapter(activity,viewPagerItemArrayList);
                        viewPager2.setAdapter(adapter);
                        adapter.notifyDataSetChanged();







                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.DAILY_PANCHANGAM_LIST, params, true);




    }

}