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
import android.widget.ImageButton;
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


    TextView tvHead, tvTitle;
    String Tittle;
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamSubMenuAdapter ramayanamSubMenuAdapter;
    Activity activity;
    Session session;
    String menu;
    RelativeLayout relativeLayout;
    int TotalSize, FIRST_SIZE;
    ImageButton ibArrowRight, ibArrowLeft;
    boolean right, left;


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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayam_sub_menu);

        activity = RamayamSubMenuActivity.this;
        session = new Session(activity);


        relativeLayout = findViewById(R.id.slider);
        tvHead = findViewById(R.id.tvHead);
        tvTitle = findViewById(R.id.tvTitle);
        ibArrowRight = findViewById(R.id.ibArrowRight);
        ibArrowLeft = findViewById(R.id.ibArrowleft);


        TotalSize = Integer.parseInt(session.getData(Constant.TOTAL_SIZE));


        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);

        menu = session.getData(Constant.MENU_ID);





        menu_list(menu);


//        show_arrow_left();
//        show_arrow_right();
//
//        view();
    }

//    private void view() {
//
//        if (left){
//
//            ibArrowLeft.setVisibility(View.VISIBLE);
//
//        }
//        else if (right){
//
//            ibArrowRight.setVisibility(View.VISIBLE);
//
//        }
//        else {
//
//            ibArrowLeft.setVisibility(View.GONE);
//            ibArrowRight.setVisibility(View.GONE);
//
//        }
//
//
//    }

//    private void show_arrow_right() {
//
//        String menu_next = menu;
//
//
//
//
//        int menuValue = Integer.parseInt(menu_next);
//        menuValue++;
//        String menu_id = String.valueOf(menuValue);
//        menu = menu_id;
//
//
//
//        String total = String.valueOf(TotalSize);
//
//        if (menu_id.equals(total)) {
//
//            right = false;
//
//        } else {
//
//            right = true;
//
//
//        }
//
//
//
//    }
//
//    private void show_arrow_left() {
//
//
//        if (FIRST_SIZE == Integer.parseInt("0")){
//
//            left = false;
//
//
//
//        }
//
//        else {
//
//            left = true;
//
//        }
//
//    }

    private void menu_list(String menu_id) {
        Map<String, String> params = new HashMap<>();
        params.put(session.getData(Constant.SUBMENU), "1");
        params.put(Constant.ID, session.getData(Constant.ID));
        params.put(Constant.MENU_ID, menu_id);
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("submeny", response);
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


                                if (menu.equals(session.getData(Constant.START_INDEX)))
                                    ibArrowLeft.setVisibility(View.GONE);
                                else
                                    ibArrowLeft.setVisibility(View.VISIBLE);

                                if (menu.equals(session.getData(Constant.END_INDEX)))
                                    ibArrowRight.setVisibility(View.GONE);
                                else
                                    ibArrowRight.setVisibility(View.VISIBLE);


                                ibArrowRight.setOnClickListener(view -> {

                                    next();

                                });

                                ibArrowLeft.setOnClickListener(view -> {

                                    previous();

                                });

                                RamayanamSubMenu group = g.fromJson(jsonObject1.toString(), RamayanamSubMenu.class);
                                ramayanamSubMenus.add(group);
                            } else {


                                break;
                            }
                        }

                        FIRST_SIZE = Integer.parseInt(jsonArray.getJSONObject(0).getString("id"));

                        tvTitle.setText(jsonArray.getJSONObject(0).getString(Constant.TITLE));
                        ramayanamSubMenuAdapter = new RamayanamSubMenuAdapter(this, ramayanamSubMenus);
                        RecyclerView.setAdapter(ramayanamSubMenuAdapter);

                        if (session.getData(Constant.SUBMENU).equals("shivapuranam_menu")) {

                            tvHead.setText(jsonArray.getJSONObject(0).getString(Constant.TITLE));

                        } else {

                            tvHead.setText(jsonArray.getJSONObject(0).getString(Constant.MENU_NAME));
                        }

                    } else {
//                        ibArrowLeft.setOnClickListener(view -> {
//
//                            ibArrowLeft.setVisibility(View.GONE);
//
//                        });
//
//                        ibArrowRight.setOnClickListener(view -> {
//
//                            ibArrowRight.setVisibility(View.GONE);
//
//                        });
//
//
//                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
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

        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));


        int menuValue = Integer.parseInt(menu_next);
        menuValue++;
        String menu_id = String.valueOf(menuValue);
        menu = menu_id;


        // String total = String.valueOf(TotalSize);
        menu_list(menu_id);


    }

    @SuppressLint("ResourceType")
    public void previous() {

        String menu_next = menu;


        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));


        int menuValue = Integer.parseInt(menu_next);
        menuValue--;
        String menu_id = String.valueOf(menuValue);
        menu = menu_id;


        menu_list(menu_id);

    }


    private void onSwipeRight() {
        next();


    }

}