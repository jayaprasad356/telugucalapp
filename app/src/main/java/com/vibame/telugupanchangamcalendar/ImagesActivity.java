package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_LIST_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ImagesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    ImageViewAdapter imageViewAdapter;
    Session session;
    EditText etSearch;
    String ImageCategoryId;
    String Title;
    TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);


        activity = ImagesActivity.this;
        session = new Session(activity);


        recyclerView = findViewById(R.id.recyclerView);
        etSearch = findViewById(R.id.etSearch);
        imgBack = findViewById(R.id.imgBack);
        tvTitle = findViewById(R.id.tvTitle);
        ImageCategoryId = getIntent().getStringExtra(Constant.IMAGE_CATEGORY_ID);
        Title = getIntent().getStringExtra(Constant.NAME);
        tvTitle.setText(Title);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")){
                    searchImage(editable.toString());

                }

            }
        });



        images();
    }

    private void searchImage(String s)
    {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.IMAGE_CATEGORY_ID,ImageCategoryId);
        params.put(Constant.IMAGE,s);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<ImagesView> imagesViews = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                ImagesView group = g.fromJson(jsonObject1.toString(),ImagesView.class);
                                imagesViews.add(group);
                            } else {
                                break;
                            }
                        }
                        imageViewAdapter = new ImageViewAdapter(activity,imagesViews);
                        recyclerView.setAdapter(imageViewAdapter);
                    }else {
                        ArrayList<ImagesView> imagesViews = new ArrayList<>();
                        imageViewAdapter = new ImageViewAdapter(activity,imagesViews);
                        recyclerView.setAdapter(imageViewAdapter);


                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.SEARCH_IMAGE_URL,params,true);


    }

    private void images() {


        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.IMAGE_CATEGORY_ID,ImageCategoryId);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<ImagesView> imagesViews = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                ImagesView group = g.fromJson(jsonObject1.toString(),ImagesView.class);
                                imagesViews.add(group);
                            } else {
                                break;
                            }
                        }
                        imageViewAdapter = new ImageViewAdapter(activity,imagesViews);
                        recyclerView.setAdapter(imageViewAdapter);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, IMAGE_LIST_URL,params,true);

    }
}