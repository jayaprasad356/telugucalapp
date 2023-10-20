package com.vibame.telugupanchangamcalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.onesignal.OneSignal;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView panchang,festival,horoscope,muhurth,share;
    Button panchangB,festivalB,horoscopeB,muhurthB;
    ViewPager2 viewPager;
    PagerViewAdapter pagerViewAdapter;
    private FrameLayout adContainerView;
    private AdView adView;
    private Boolean showAd = false;
    private InterstitialAd mInterstitialAd;
    private int seconds = 90;
    public static Button moreB,shareB,moreappB,rateB;
    private static final String ONESIGNAL_APP_ID = "e7672179-5724-406f-99d6-4a4c44351a13";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        createNotificationChannel();

        // Enable verbose OneSignal logging to debug issues if needed.
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
//
//        // OneSignal Initialization
//        OneSignal.initWithContext(this);
//        OneSignal.setAppId(ONESIGNAL_APP_ID);


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        adContainerView = findViewById(R.id.ad_view_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.adaptive_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        //Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        // Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        timer();

        panchang = (TextView)findViewById(R.id.panchang);
        festival = (TextView)findViewById(R.id.festival);
        muhurth = (TextView)findViewById(R.id.muhurth);
        horoscope = (TextView)findViewById(R.id.horoscope);
        share = (TextView)findViewById(R.id.holidays);
        panchangB = (Button) findViewById(R.id.panchangB);
        festivalB = (Button)findViewById(R.id.festivalB);
        muhurthB = (Button)findViewById(R.id.muhurthB);
        horoscopeB = (Button)findViewById(R.id.horoscopeB);
        moreB = (Button)findViewById(R.id.more);
        viewPager = findViewById(R.id.fragment_container);

        Calendar calendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,07);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);

        if(now.after(calendar))
        {
            calendar.add(Calendar.DATE,1);
        }

        Intent intent = new Intent(MainActivity.this,Notification_Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/sree.ttf");
        panchang.setTypeface(typeface);
        festival.setTypeface(typeface);
        horoscope.setTypeface(typeface);
        muhurth.setTypeface(typeface);
        share.setTypeface(typeface);

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager(),getLifecycle());

        // add Fragments in your ViewPagerFragmentAdapter class
        pagerViewAdapter.addFragment(new Panchang_Frag());
        pagerViewAdapter.addFragment(new Festival_Frag());
        pagerViewAdapter.addFragment(new Muhurtham_Frag());
        pagerViewAdapter.addFragment(new Horoscope_Frag());

        viewPager.setOffscreenPageLimit(4);
        viewPager.setUserInputEnabled(false);;

        viewPager.setAdapter(pagerViewAdapter);

        panchangB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(0);
            }
        });
        festivalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(1);
            }
        });
        muhurthB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(2);
            }
        });
        horoscopeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(3);
            }
        });
        moreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("test", "onClick:moreB ");
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.more_dialog);

                moreappB = (Button) dialog.findViewById(R.id.moreappsB);
                rateB = (Button) dialog.findViewById(R.id.rateB);
                shareB = (Button) dialog.findViewById(R.id.shareB);

                moreappB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=8247170330950867863"));
                        //startActivity(browserIntent);
                        Toast.makeText(MainActivity.this, "More Apps", Toast.LENGTH_SHORT).show();
                    }
                });

                rateB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.vibame.telugupanchangamcalendar"));
                        //startActivity(browserIntent);
                        //Toast.makeText(MainActivity.this, "Rate this App", Toast.LENGTH_SHORT).show();
                    }
                });

                shareB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.app_icon);
                        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) && (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED))
                        {
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                        }
                        else
                        {
                            Intent share1 = new Intent(Intent.ACTION_SEND);
                            share1.setType("image/jpeg");
                            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                            String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                                    b, "Telugu Calendar", null);
                            Uri imageUri1 =  Uri.parse(path);
                            share1.putExtra(Intent.EXTRA_STREAM, imageUri1);
                            share1.putExtra(Intent.EXTRA_TEXT, "తెలుగు క్యాలెండర్ పంచాంగం I use it regularly and love it Please download the app-- `    " + "https://play.google.com/store/apps/details?id=com.vibame.telugupanchangamcalendar");
                            startActivity(Intent.createChooser(share1, "Share Image using"));
                        }

                    }
                });

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(true);
                dialog.show();
            }
        });



        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(
            int position,
            float positionOffset,
            @Px int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                onChangeTab(position);

            }

            @Override
            public void onPageScrollStateChanged(@ViewPager2.ScrollState int state) {

            }
        });


    }
    private void onChangeTab(int position)
    {

        //panchang.setTextSize(16);
        panchang.setTextColor(getResources().getColor(R.color.colorWhite));

        //festival.setTextSize(16);
        festival.setTextColor(getResources().getColor(R.color.colorWhite));

        //muhurth.setTextSize(16);
        muhurth.setTextColor(getResources().getColor(R.color.colorWhite));

        //horoscope.setTextSize(16);
        horoscope.setTextColor(getResources().getColor(R.color.colorWhite));

        if(position == 0)
        {
            //panchang.setTextSize(18);
            panchang.setTextColor(getResources().getColor(R.color.colorBlack));
        }
        if(position == 1)
        {
            viewPager.setOffscreenPageLimit(1);
            //Festival_Frag.recyclerView.scrollToPosition(Festival_Frag.currentMonth);
            //Festival_Frag.setRecyclerView();
            //festival.setTextSize(18);
            festival.setTextColor(getResources().getColor(R.color.colorBlack));
        }
        if(position == 2)
        {
            //muhurth.setTextSize(18);
            muhurth.setTextColor(getResources().getColor(R.color.colorBlack));
        }
        if(position == 3)
        {
            //horoscope.setTextSize(18);
            horoscope.setTextColor(getResources().getColor(R.color.colorBlack));
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "TeluguCalendarPancangam";
            String description = "Channel for TeluguCalendarPancangam";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("vibamecalendar", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @SuppressLint("MissingPermission")
    private void loadBanner() {
        AdRequest adRequest =
                new AdRequest.Builder().build();

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    private void timer()
    {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(seconds>0)
                {
                    seconds--;
                    handler.postDelayed(this,1000);

                }else
                {
                    if(showAd == false)
                    {
                        loadInter();
                    }
                }
            }
        });

    }

    private void loadInter()
    {

        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when fullscreen content is dismissed.
                showAd = false;
                seconds = 90;
                timer();
                //Log.d("TAG", "The ad was dismissed.");
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when fullscreen content failed to show.
                //Log.d("TAG", "The ad failed to show.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when fullscreen content is shown.
                // Make sure to set your reference to null so you don't
                // show it a second time.
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                mInterstitialAd = null;
                //Log.d("TAG", "The ad was shown.");
            }
        });
        showAd = true;
    }



    public void onBackPressed()
    {
        finish();
        System.exit(0);
    }
    public void onStop()
    {
        super.onStop();
        if(showAd == false)
        {
            //Log.d("Test", "Home button pressed!");
            this.finish();
            System.exit(0);
        }

    }
}