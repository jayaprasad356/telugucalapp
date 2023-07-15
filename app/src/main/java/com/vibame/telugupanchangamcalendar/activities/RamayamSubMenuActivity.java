package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;
import com.vibame.telugupanchangamcalendar.model.RamayanamSubMenu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class RamayamSubMenuActivity extends AppCompatActivity {


    TextView tvHead;
    String Tittle;
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamSubMenuAdapter ramayanamSubMenuAdapter;
    Activity activity;
    Session session;
    String menu;
    RelativeLayout relativeLayout;
    int TotalSize, FIRST_SIZE;
    String left = "0", right = "0";


    private final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (e1.getX() < e2.getX()) {
                    // Swipe right
                    onSwipeRight();
                } else {
                    // Swipe left

                }
                return true;
            }
            return false;
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayam_sub_menu);

        activity = RamayamSubMenuActivity.this;
        session = new Session(activity);


        relativeLayout = findViewById(R.id.slider);
        tvHead = findViewById(R.id.tvHead);

        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);


        TotalSize = Integer.parseInt(session.getData(Constant.TOTAL_SIZE));


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        menu = session.getData(Constant.MENU_ID);


        menu_list(menu);
    }

    private void menu_list(String menu_id) {
        Map<String, String> params = new HashMap<>();
        params.put(session.getData(Constant.SUBMENU), "1");
        params.put(Constant.ID, session.getData(Constant.ID));
        params.put(Constant.MENU_ID, menu_id);
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("submeny", session.getData(Constant.SUBMENU));
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<RamayanamSubMenu> ramayanamSubMenus = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                RamayanamSubMenu group = g.fromJson(jsonObject1.toString(), RamayanamSubMenu.class);
                                ramayanamSubMenus.add(group);
                            } else {
                                break;
                            }
                        }

                        left = "0";
                        right = "0";

                        FIRST_SIZE = Integer.parseInt(jsonArray.getJSONObject(0).getString("id"));


                        //    Toast.makeText(activity, ""+Integer.parseInt(jsonArray.getJSONObject(0).getString("id")), Toast.LENGTH_SHORT).show();

                        ramayanamSubMenuAdapter = new RamayanamSubMenuAdapter(this, ramayanamSubMenus);
                        RecyclerView.setAdapter(ramayanamSubMenuAdapter);

                        if (session.getData(Constant.SUBMENU).equals("shivapuranam_menu")) {

                            tvHead.setText(jsonArray.getJSONObject(0).getString(Constant.TITLE));

                        } else {

                            tvHead.setText(jsonArray.getJSONObject(0).getString(Constant.MENU_NAME));
                        }

                    } else {

                        left = "1";
                        right = "1";

                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.MAHA_PURANALU_URL, params, true);

    }

    @SuppressLint("ResourceType")
    public void next() {
        String menu_next = menu;


        if (right.equals("1")) {
            activity.findViewById(R.id.ibArrowleft).setVisibility(View.GONE);
        }
        else {
            activity.findViewById(R.id.ibArrowleft).setVisibility(View.VISIBLE);
        }


        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));


        int menuValue = Integer.parseInt(menu_next);
        menuValue++;
        String menu_id = String.valueOf(menuValue);
        menu = menu_id;


        String total = String.valueOf(TotalSize + 1);

        if (menu_id.equals(total)) {
            activity.findViewById(R.id.ibArrow).setVisibility(View.GONE);

        } else {
            activity.findViewById(R.id.ibArrow).setVisibility(View.VISIBLE);
            menu_list(menu_id);
        }


    }

    @SuppressLint("ResourceType")
    public void previous() {

        String menu_next = menu;


        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));


        int menuValue = Integer.parseInt(menu_next);
        menuValue--;
        String menu_id = String.valueOf(menuValue);
        menu = menu_id;


        if (left.equals("1")) {
            activity.findViewById(R.id.ibArrowleft).setVisibility(View.GONE);
        }
        else {
            activity.findViewById(R.id.ibArrowleft).setVisibility(View.VISIBLE);
        }


        if (FIRST_SIZE == Integer.parseInt("1")) {

//
            activity.findViewById(R.id.ibArrowleft).setVisibility(View.GONE);


        } else {
//            Toast.makeText(activity, ""+menu_id, Toast.LENGTH_SHORT).show();
            menu_list(menu_id);

        }
    }


    private void onSwipeRight() {
        next();


    }


}