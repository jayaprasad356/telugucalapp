package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.smarteist.autoimageslider.SliderView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.vibame.telugupanchangamcalendar.AudioLiveActivity;
import com.vibame.telugupanchangamcalendar.BuildConfig;
import com.vibame.telugupanchangamcalendar.GowriPanchangamActivity;
import com.vibame.telugupanchangamcalendar.ImageTabActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.RahukalamActivity;
import com.vibame.telugupanchangamcalendar.SakunaluActivity;
import com.vibame.telugupanchangamcalendar.ThidhiluActivity;
import com.vibame.telugupanchangamcalendar.VideoLiveActivity;
import com.vibame.telugupanchangamcalendar.VideoTabActivity;
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.SliderAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.SliderItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class NewCalendarActivity extends AppCompatActivity {

    private Boolean panelcchange = true;
    // Your Video URL
    String videoUrl = "";




    RecyclerView recyclerView;
    AudioLiveAdapter audioLiveAdapter;
    ImageView imgLeft,imgRight;
    SliderView sliderView;
    TextView tvMonthYear;
    String month_year;
    int monthcount = 0;
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
    Calendar c = Calendar.getInstance();
    DatabaseHelper databaseHelper;
    Activity activity;


    LinearLayout llNavaGrahalu, llNithyaParayana;
    LinearLayout llTeluguYear,llRashulu,llMonth,more;
    Activity sakunaActivity, kakiActivity, pilliActivity, balliActivity,kukuta_sasthram;
    LinearLayout sakunalu, kaki, pilli, balli,kukuta;
    RecyclerView rvPoojaluNomulu, rvGrahaluStars;
    GrahaluAdapter grahaluAdapter;
    PoojaluAdapter poojaluAdapter;
    CardView cardVideoTab, cardImageTab;
    LinearLayout llThidhi, llGowri, llRahukalam, llHora, llKaranam, llYogam;
    CardView mahaBharatham, ramayanam, bhagvathGeetha, bhagvatham, sethakamulu, sivaPuranam,cardShare,Rateus,cardFeedback,cardPrivacy;
    Session session;
    CardView cardNewArticles,cardOldArticles,cardSmartTools,cardVideolive;
    LinearLayout llAudiolive,llVideolive;
    TextView tvTile ;
    int[] images = {R.drawable.panchangam,R.drawable.fest_2,R.drawable.rasiphalalu_3,R.drawable.muhur_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calendar);
        activity = NewCalendarActivity.this;
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);


        // Video Live

        cardVideolive = findViewById(R.id.cardVideolive);
        cardVideolive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, VideoLiveActivity.class);
                startActivity(intent);
            }
        });



        //Audio Live
        databaseHelper = new DatabaseHelper(activity);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        audiolive();



        rvGrahaluStars = findViewById(R.id.rvGrahaluStars);
        rvPoojaluNomulu = findViewById(R.id.rvPoojaluNomulu);



        cardSmartTools = findViewById(R.id.cardSmartTools);
        cardSmartTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SmartToolsActivity.class);
                startActivity(intent);

            }
        });


        cardImageTab = findViewById(R.id.cardImageTab);
        cardVideoTab = findViewById(R.id.cardVideoTab);


        //Pochangam View
        llThidhi = findViewById(R.id.llThidhi);
        llGowri = findViewById(R.id.llGowri);
        llRahukalam = findViewById(R.id.llRahukalam);
        llHora = findViewById(R.id.llHora);
        llKaranam = findViewById(R.id.llKaranam);
        llYogam = findViewById(R.id.llYogam);

        llThidhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ThidhiluActivity.class);
                startActivity(intent);
            }
        });
        llGowri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, GowriPanchangamActivity.class);
                startActivity(intent);
            }
        });
        llRahukalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RahukalamActivity.class);
                startActivity(intent);
            }
        });
        llHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, HoraChakramActivity.class);
                startActivity(intent);
            }
        });
        llKaranam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, KaranamActivity.class);
                startActivity(intent);

            }
        });
        llYogam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, YogamActivity.class);
                startActivity(intent);

            }
        });



        sakunalu = findViewById(R.id.sakunalu);
        kaki = findViewById(R.id.kaki);
        pilli = findViewById(R.id.pilli_sasthram);
        balli = findViewById(R.id.balli);
        kukuta = findViewById(R.id.kukuta_sasthram);

        sakunaActivity = new SakunaluActivity();
        kakiActivity = new KakiActivity();
        pilliActivity = new PilliSasthramActivity();
        balliActivity = new BalliSasthramActivity();
        kukuta_sasthram = new KukutaSaathramActivity();


        loadSakunaSastharam(sakunalu, sakunaActivity);
        loadSakunaSastharam(kaki, kakiActivity);
        loadSakunaSastharam(pilli, pilliActivity);
        loadSakunaSastharam(balli, balliActivity);
        loadSakunaSastharam(kukuta, kukuta_sasthram);



        llTeluguYear = findViewById(R.id.llTeluguYear);
        llRashulu = findViewById(R.id.llRashulu);
        llMonth = findViewById(R.id.llMonth);
        more = findViewById(R.id.more);


        sliderView = findViewById(R.id.main_image);
        SliderAdapter adapter = new SliderAdapter(this);
        adapter.addItem(new SliderItem(images[0],"Panchangam"));
        adapter.addItem(new SliderItem(images[1],"Festivals"));
        adapter.addItem(new SliderItem(images[2],"Rasiphalalu"));
        adapter.addItem(new SliderItem(images[3],"Muhurthamulu"));
        sliderView.setSliderAdapter(adapter);

        llTeluguYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TeluguYearActivity.class);
                startActivity(intent);
            }
        });
        llRashulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RashuluActivity.class);
                startActivity(intent);
            }
        });
        llMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MonthActivity.class);
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            

                Intent intent = new Intent(activity,MoreTeluguSamskruthamActivity.class);
                startActivity(intent);


            }
        });





        mahaBharatham =findViewById(R.id.maha_bharatham);
        ramayanam =findViewById(R.id.ramayanam);
        bhagvathGeetha =findViewById(R.id.bhagvath_geetha);
        bhagvatham =findViewById(R.id.bhagvatham);
        sethakamulu =findViewById(R.id.sethakamulu);
        sivaPuranam =findViewById(R.id.shiva_puranam);


        ramayanam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"ramayanam");
                session.setData(Constant.MENU,"ramayanam_menu");
                session.setData(Constant.SUBMENU,"ramayanam_submenu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Ramayanam");
                startActivity(intent);

            }
        });
        mahaBharatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"mahabharatham");
                session.setData(Constant.MENU,"mahabharatham_menu");
                session.setData(Constant.SUBMENU,"mahabharatham_submenu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Maha Bharatham");
                startActivity(intent);

            }
        });
        bhagvathGeetha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"bhagawath_geetha");
                session.setData(Constant.MENU,"bhagawath_geetha_menu");
                session.setData(Constant.SUBMENU,"bhagawath_geetha_submenu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvath Geetha");
                startActivity(intent);

            }
        });
        bhagvatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"bhagawatham");
                session.setData(Constant.MENU,"bhagawatham_menu");
                session.setData(Constant.SUBMENU,"bhagawatham_submenu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvatham");
                startActivity(intent);

            }
        });
        sethakamulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"telugu_sethakamulu");
                session.setData(Constant.MENU,"telugu_sethakamulu_menu");
                session.setData(Constant.SUBMENU,"telugu_sethakamulu_submenu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Sethakamulu");
                startActivity(intent);

            }
        });
        sivaPuranam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"shivapuranam");
                session.setData(Constant.MENU,"");
                session.setData(Constant.SUBMENU,"shivapuranam_menu");
                Intent intent = new Intent(activity,RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Shiva Puranam");
                startActivity(intent);

            }
        });




        cardOldArticles = findViewById(R.id.cardOldArticles);
        cardNewArticles = findViewById(R.id.cardNewArticles);
        cardNewArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, NetiArticlesActivity.class);
                startActivity(intent);
            }
        });
        cardOldArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, OldArticlesActivity.class);
                startActivity(intent);
            }
        });




        rvGrahaluStars.setLayoutManager(new GridLayoutManager(activity, 4));
        rvPoojaluNomulu.setLayoutManager(new GridLayoutManager(activity, 4));


        grahaluList();
        poojaluList();


        cardImageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ImageTabActivity.class);
                startActivity(intent);
            }
        });
        cardVideoTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, VideoTabActivity.class);
                startActivity(intent);
            }
        });




        cardShare = findViewById(R.id.cardShare);
        Rateus = findViewById(R.id.Rateus);
        cardFeedback = findViewById(R.id.cardFeedback);
        cardPrivacy = findViewById(R.id.cardPrivacy);
        cardShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareCompat.IntentBuilder.from(activity)
                        .setType("text/plain")
                        .setChooserTitle("Chooser title")
                        .setText("http://play.google.com/store/apps/details?id=" + activity.getPackageName())
                        .startChooser();
            }
        });
        Rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,FeedBackActivity.class);
                startActivity(intent);
            }
        });
        cardPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });
















        SlidingUpPanelLayout layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        NestedScrollView myScrollView = (NestedScrollView) findViewById(R.id.myscrollView);
        myScrollView.setEnabled(false); // disable scrolling
        myScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //Log.d(String.valueOf(myScrollView.getScrollY()), "scrollY: ");


                if (myScrollView.getScrollY() == 0) {
                    layout.setTouchEnabled(true);

                } else {
                    layout.setTouchEnabled(false);
                }

            }
        });
        layout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {


                if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    myScrollView.setEnabled(true); // enable scrolling


                    //Log.d(String.valueOf(myScrollView.getScrollY()), "onPanelStateChanged: ");
                } else if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    myScrollView.setEnabled(false); // disable scrolling
                    //Log.d("COLLAPSED", "onPanelStateChanged: ");
                }

            }
        });


    }






    private void poojaluList() {
        if (databaseHelper.getPoojaluList().size() != 0) {
            poojaluAdapter = new PoojaluAdapter(activity, databaseHelper.getPoojaluList(),databaseHelper.getPoojaluList().size(),"new");
            rvPoojaluNomulu.setAdapter(poojaluAdapter);

        } else {
            rvPoojaluNomulu.setVisibility(View.GONE);

        }


    }
    private void grahaluList() {


        if (databaseHelper.getGrahaluList().size() != 0) {
            grahaluAdapter = new GrahaluAdapter(activity, databaseHelper.getGrahaluList(),databaseHelper.getGrahaluList().size(),"new");
            rvGrahaluStars.setAdapter(grahaluAdapter);

        } else {
            rvGrahaluStars.setVisibility(View.GONE);

        }
    }



    private void loadSakunaSastharam(LinearLayout linearLayout, Activity activity) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewCalendarActivity.this, activity.getClass());
                startActivity(intent);

            }
        });
    }



    private void audiolive() {
        Log.d("AUDIO_COUNT",databaseHelper.getAudiosCount() + "");



        if (databaseHelper.getAudioList().size() !=0){
            audioLiveAdapter = new AudioLiveAdapter(activity, databaseHelper.getAudioList());
            recyclerView.setAdapter(audioLiveAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }






}