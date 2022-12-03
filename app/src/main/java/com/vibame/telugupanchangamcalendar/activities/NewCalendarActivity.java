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
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.vibame.telugupanchangamcalendar.AudioLiveActivity;
import com.vibame.telugupanchangamcalendar.BuildConfig;
import com.vibame.telugupanchangamcalendar.CustomScrollView;
import com.vibame.telugupanchangamcalendar.GowriPanchangamActivity;
import com.vibame.telugupanchangamcalendar.ImageTabActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.RahukalamActivity;
import com.vibame.telugupanchangamcalendar.SakunaluActivity;
import com.vibame.telugupanchangamcalendar.ThidhiluActivity;
import com.vibame.telugupanchangamcalendar.VideoLiveActivity;
import com.vibame.telugupanchangamcalendar.VideoTabActivity;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter;
import com.vibame.telugupanchangamcalendar.fragments.TeluguSamskruthamFragment;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class NewCalendarActivity extends AppCompatActivity {

    private Boolean panelcchange = true;

    ImageView imgLeft,imgRight;
    TextView tvMonthYear;
    String month_year;
    int monthcount = 0;
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
    Calendar c = Calendar.getInstance();
    DatabaseHelper databaseHelper;
    Activity activity;
    RecyclerView recyclerView;
    FestivalAdapter festivalAdapter;
    String MonthYear = "";
    String[] montharray = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};


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
    CardView cardNewArticles,cardOldArticles;
    LinearLayout llAudiolive,llVideolive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calendar);
        activity = NewCalendarActivity.this;
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);


        rvGrahaluStars = findViewById(R.id.rvGrahaluStars);
        rvPoojaluNomulu = findViewById(R.id.rvPoojaluNomulu);


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



        llAudiolive = findViewById(R.id.llAudiolive);
        llVideolive = findViewById(R.id.llVideolive);
        llAudiolive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AudioLiveActivity.class);
                startActivity(intent);
            }
        });
        llVideolive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, VideoLiveActivity.class);
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




        imgLeft = findViewById(R.id.imgLeft);
        imgRight = findViewById(R.id.imgRight);
        tvMonthYear = findViewById(R.id.tvMonthYear);
        recyclerView = findViewById(R.id.recyclerView);
        cal.add(Calendar.MONTH, monthcount);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        month_year = dateFormat.format(cal.getTime());
        tvMonthYear.setText(setTeluguMonth(month_year));

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date dateFormat = null;
                try {
                    dateFormat = df.parse(month_year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.setTime(dateFormat);
                c.add(Calendar.MONTH, -1);

                month_year = df.format(c.getTime());
                tvMonthYear.setText(setTeluguMonth(month_year));
                festivalList(getMonthNum(),getYearNum());

            }
        });
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date dateFormat = null;
                try {
                    dateFormat = df.parse(month_year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.setTime(dateFormat);
                c.add(Calendar.MONTH, 1);
                month_year = df.format(c.getTime());
                tvMonthYear.setText(setTeluguMonth(month_year));
                festivalList(getMonthNum(), getYearNum());

            }
        });
        festivalList(getMonthNum(), getYearNum());








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




    private String setTeluguMonth(String month_year)
    {
        int index = month_year.indexOf(' ');
        String month = month_year.substring(0, index);
        int p = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December").indexOf(month);
        String teluguMonth = montharray[p];
        return teluguMonth;
    }

    private String getMonthNum() {
        Date newDate = null;
        try {
            newDate = df.parse(""+month_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("MM");
        String date = format.format(newDate);
        return date;
    }
    private String getYearNum() {
        Date newDate = null;
        try {
            newDate = df.parse(""+month_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String date = format.format(newDate);
        return date;
    }


    private void festivalList(String monthNum, String yearNum)
    {
        if (databaseHelper.getmodelFestivalList(monthNum,yearNum).size() !=0){
            festivalAdapter = new FestivalAdapter(activity, databaseHelper.getmodelFestivalList(monthNum,yearNum));
            recyclerView.setAdapter(festivalAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }


    }

    private void poojaluList() {
        if (databaseHelper.getPoojaluList().size() != 0) {
            poojaluAdapter = new PoojaluAdapter(activity, databaseHelper.getPoojaluList());
            rvPoojaluNomulu.setAdapter(poojaluAdapter);

        } else {
            rvPoojaluNomulu.setVisibility(View.GONE);

        }


    }
    private void grahaluList() {


        if (databaseHelper.getGrahaluList().size() != 0) {
            grahaluAdapter = new GrahaluAdapter(activity, databaseHelper.getGrahaluList());
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




}