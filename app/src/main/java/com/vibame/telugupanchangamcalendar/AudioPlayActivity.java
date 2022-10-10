package com.vibame.telugupanchangamcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class AudioPlayActivity extends AppCompatActivity {

    public static MediaPlayer hfmPlayer;
    MediaPlayer  bellPlayer, shankPlayer;
    private ImageButton playIcon, forward, backward, loopBtn, shankhBtn;
    private SeekBar mSeekBar;
    private ViewPager2 viewPager2;
    private TextView totTime, curTime;
    private int count = 1;
    private int setcount = 0;
    private int seekForwardTime = 10 * 1000; // default 5 second
    private int seekBackwardTime = 10 * 1000; // default 5 second

    private String timer;
    private TextView lyricsText;
    private Boolean isPlaying = false;
    Boolean jsonload = false;
    private JSONObject obj;
    private JSONObject splandata;
    private String lyricsData;
    SharedPreferences sharedpreferences;
    String[] chalisatime = {"0:00","0:23","0:55","1:17","1:44","2:06","2:30","2:53","3:18","3:40","4:06","4:28","4:54","5:16",
            "5:42","6:04","6:29","6:52","7:17","7:39","8:04","8:26","9:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);


        curTime = findViewById(R.id.currentState);
        totTime =  findViewById(R.id.totalValue);
        mSeekBar =  findViewById(R.id.mySeekbar);
        playIcon =  findViewById(R.id.playBtn);
        loopBtn =  findViewById(R.id.loopBtn);
        forward =  findViewById(R.id.forward);
        backward =  findViewById(R.id.backward);
//        viewPager2 = findViewById(R.id.viewPager2);
//        lyricsText =  findViewById(R.id.chalisaLyrics);

        loadRequest();

        sharedpreferences = AudioPlayActivity.this.getSharedPreferences("BBR", Context.MODE_PRIVATE);
        String languName = sharedpreferences.getString("yes","");

        //getJsonfileToRead(languName);

        hfmPlayer = new MediaPlayer();
        bellPlayer = new MediaPlayer();
        shankPlayer = new MediaPlayer();
        initPlayer();

        curTime.setText("00:00");



        // adding the adapter to viewPager2
        // to show the views in recyclerview
     //   viewPager2.setAdapter(viewPager2Adapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

        playIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                play();
            }
        });


        forward.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                forwardSong();
            }
        });


        backward.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rewindSong();
            }
        });






        initPlayer();
    }

    private void initPlayer() {

        if (hfmPlayer != null && hfmPlayer.isPlaying()) {
            hfmPlayer.reset();
        }
        hfmPlayer = MediaPlayer.create(AudioPlayActivity.this,R.raw.chalisa); // create and load mediaplayer with song resources
        hfmPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                String totalTime = createTimeLabel(hfmPlayer.getDuration());
                totTime.setText(totalTime);
                mSeekBar.setMax(hfmPlayer.getDuration());
                //playIcon.setBackgroundResource(R.drawable.b_play);
            }
        });

        hfmPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mSeekBar.setProgress(0);
                playIcon.setBackgroundResource(R.drawable.b_play);
                curTime.setText("00:00");
                try {
                    lyricsData = splandata.getString("D1");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                lyricsText.setText(lyricsData);
                if (count < setcount) {
                    hfmPlayer.start();
                    playIcon.setBackgroundResource(R.drawable.b_pause);
                    count++;
                }
                else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    hfmPlayer.seekTo(progress);
                    mSeekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                if(!hfmPlayer.isPlaying())
                {
                    hfmPlayer.seekTo(0);
                    mSeekBar.setProgress(0);
                }

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (hfmPlayer != null) {
                    try {
//                        Log.i("Thread ", "Thread Called");
                        // create new message to send to handler
                        if (hfmPlayer.isPlaying()) {
                            Message msg = new Message();
                            msg.what = hfmPlayer.getCurrentPosition();
                            handler.sendMessage(msg);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            Log.i("handler ", "handler called");
            int current_position = msg.what;
            mSeekBar.setProgress(current_position);
            String cTime = createTimeLabel(current_position);
            for (int i = 0; i < chalisatime.length; i++)
            {

            }
            curTime.setText(cTime);
        }
    };


    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;


    }

    private void play() {

        if (hfmPlayer != null && !hfmPlayer.isPlaying()) {
            hfmPlayer.start();
            playIcon.setBackgroundResource(R.drawable.b_pause);
        } else {
            pause();
        }
    }


    private void pause() {
        if (hfmPlayer.isPlaying()) {
            hfmPlayer.pause();
            playIcon.setBackgroundResource(R.drawable.b_play);

        }
    }

    private void loadRequest()
    {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(AudioPlayActivity.this,"ca-app-pub-8009469144357385/6343281335", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.

                        Log.d("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("TAG", loadAdError.getMessage());
                        //mInterstitialAd = null;
                    }
                });
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if(AudioPlayActivity.this == null)
                return;

        }
    }


    public void forwardSong() {
        if (hfmPlayer != null) {
            int currentPosition = hfmPlayer.getCurrentPosition();
            if (currentPosition + seekForwardTime <= hfmPlayer.getDuration()) {
                hfmPlayer.seekTo(currentPosition + seekForwardTime);
            } else {
                hfmPlayer.seekTo(hfmPlayer.getDuration());
            }
        }
    }


    public void rewindSong() {
        if (hfmPlayer != null) {
            int currentPosition = hfmPlayer.getCurrentPosition();
            if (currentPosition - seekBackwardTime >= 0) {
                hfmPlayer.seekTo(currentPosition - seekBackwardTime);
            } else {
                hfmPlayer.seekTo(0);
            }
        }
    }




}