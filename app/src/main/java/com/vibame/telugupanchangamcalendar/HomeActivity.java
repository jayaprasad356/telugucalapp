package com.vibame.telugupanchangamcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.vibame.telugupanchangamcalendar.fragments.BakthiGeethaluFragment;
import com.vibame.telugupanchangamcalendar.fragments.BakthiniFragment;
import com.vibame.telugupanchangamcalendar.fragments.BhakthiArticlesFragment;
import com.vibame.telugupanchangamcalendar.fragments.FestivalFragment;
import com.vibame.telugupanchangamcalendar.fragments.GrahaluFragment;
import com.vibame.telugupanchangamcalendar.fragments.HoroscopeFragment;
import com.vibame.telugupanchangamcalendar.fragments.MahaPuranaluFragment;
import com.vibame.telugupanchangamcalendar.fragments.MuhurthamFragment;
import com.vibame.telugupanchangamcalendar.fragments.PanchnagamListFragment;
import com.vibame.telugupanchangamcalendar.fragments.PoojaluFragment;
import com.vibame.telugupanchangamcalendar.fragments.PrivacyPolicyFragment;
import com.vibame.telugupanchangamcalendar.fragments.SakunaSasthramFragment;
import com.vibame.telugupanchangamcalendar.fragments.TeluguSamskruthamFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        activity = HomeActivity.this;
        ImageButton mButton = findViewById(R.id.toolbar);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //startActivity(new Intent(activity, AksharaluActivity.class));
              drawer.openDrawer(GravityCompat.START);

            }
        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new Panchang_Frag();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {

            case R.id.panchangam: {
                fragment = new Panchang_Frag();
                break;
            }
            case R.id.festivals: {
                fragment = new FestivalFragment();
                break;
            }
            case R.id.horoscope: {
                fragment = new HoroscopeFragment();
                break;
            }
            case R.id.muhurtham: {
                fragment = new MuhurthamFragment();
                break;
            }
            case R.id.poojalu: {
                fragment = new PoojaluFragment();
                break;
            }
            case R.id.grahalu: {
                fragment = new GrahaluFragment();
                break;
            }

            case R.id.bakyhigeethalu: {
                fragment = new BakthiGeethaluFragment();
                break;
            }

            case R.id.bakthini: {
                fragment = new BakthiniFragment();
                break;
            }

            case R.id.panchangamlist: {
                fragment = new PanchnagamListFragment();
                break;
            }
            case R.id.sakunasasthram: {
                fragment = new SakunaSasthramFragment();
                break;
            }

            case R.id.teluguSamskurtham: {
                fragment = new TeluguSamskruthamFragment();
                break;
            }
            case R.id.mahapuranalu: {
                fragment = new MahaPuranaluFragment();
                break;
            }

            case R.id.bhakthiArticles: {
                fragment = new BhakthiArticlesFragment();
                break;
            }



            case R.id.Rateus: {
                String url = "http://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            }

            case R.id.share: {
                ShareCompat.IntentBuilder.from(activity)
                        .setType("text/plain")
                        .setChooserTitle("Chooser title")
                        .setText("http://play.google.com/store/apps/details?id=" + activity.getPackageName())
                        .startChooser();
                break;
            }
            case R.id.PrivacyPolicy: {

                fragment = new PrivacyPolicyFragment();

                break;
            }


        }
        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}