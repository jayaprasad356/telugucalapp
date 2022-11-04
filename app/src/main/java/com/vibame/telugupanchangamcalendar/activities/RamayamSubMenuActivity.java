package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;
import com.vibame.telugupanchangamcalendar.model.RamayanamSubMenu;

import java.util.ArrayList;

public class RamayamSubMenuActivity extends AppCompatActivity {


    TextView tvHead;
    String Tittle;
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamSubMenuAdapter ramayanamSubMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayam_sub_menu);



        tvHead = findViewById(R.id.tvHead);

        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);
        tvHead.setText(Tittle);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        menu_list();
    }

    private void menu_list() {


        ArrayList<RamayanamSubMenu> ramayanamSubMenus = new ArrayList<>();



        RamayanamSubMenu rings1 = new RamayanamSubMenu("Ramayanam Import","dkjlfakjl;asjkl;fajkl;afsjklafsjklafjklafjkla\n" +
                "        fjkladfsjkladfsjkladfsjkladfsjkladfsjklafsjklafsjkl;afsjklaf\n" +
                "        jkl;afsljk;afklj;afjkl;fajklasjkljklafsjkl;afkljafjklf\n" +
                "        adjklafkjladsfjklafjkladsfjkladfjkl;");
        RamayanamSubMenu rings2 = new RamayanamSubMenu("Ramayanam Import","dkjlfakjl;asjkl;fajkl;afsjklafsjklafjklafjkla\n" +
                "        fjkladfsjkladfsjkladfsjkladfsjkladfsjklafsjklafsjkl;afsjklaf\n" +
                "        jkl;afsljk;afklj;afjkl;fajklasjkljklafsjkl;afkljafjklf\n" +
                "        adjklafkjladsfjklafjkladsfjkladfjkl;");
        RamayanamSubMenu rings3 = new RamayanamSubMenu("Ramayanam Import","dkjlfakjl;asjkl;fajkl;afsjklafsjklafjklafjkla\n" +
                "        fjkladfsjkladfsjkladfsjkladfsjkladfsjklafsjklafsjkl;afsjklaf\n" +
                "        jkl;afsljk;afklj;afjkl;fajklasjkljklafsjkl;afkljafjklf\n" +
                "        adjklafkjladsfjklafjkladsfjkladfjkl;");



        ramayanamSubMenus.add(rings1);
        ramayanamSubMenus.add(rings2);
        ramayanamSubMenus.add(rings3);




        ramayanamSubMenuAdapter = new RamayanamSubMenuAdapter(this,ramayanamSubMenus);
        RecyclerView.setAdapter(ramayanamSubMenuAdapter);



    }
}