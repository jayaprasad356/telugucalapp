package com.vibame.telugupanchangamcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AudioPlayActivity extends AppCompatActivity {

    public static MediaPlayer hfmPlayer;
    MediaPlayer bellPlayer, shankPlayer;
    private ImageButton playIcon, forward, backward, shankhBtn, nextSong, previewSong;
    ImageView imgLoop;
    private SeekBar mSeekBar;
    private ViewPager2 viewPager2;
    private TextView totTime, curTime, tvTitle, tvTitle1;
    private int count = 1;
    private int setcount = 0;
    private int seekForwardTime = 10 * 1000; // default 5 second
    private int seekBackwardTime = 10 * 1000; // default 5 second
    String Title;
    private String timer;
    private TextView lyricsText;
    private Boolean isPlaying = false;
    Boolean jsonload = false;
    private JSONObject obj;
    private JSONObject splandata;
    private String lyricsData, Audio, Lyrics,Image;
    MediaPlayer mediaPlayer;
    ImageView imgBack;
    SharedPreferences sharedpreferences;
    TextView tvLyrics;
    boolean loop = false;
    String[] chalisatime = {"0:00", "0:23", "0:55", "1:17", "1:44", "2:06", "2:30", "2:53", "3:18", "3:40", "4:06", "4:28", "4:54", "5:16",
            "5:42", "6:04", "6:29", "6:52", "7:17", "7:39", "8:04", "8:26", "9:00"};
    ArrayList<String> audioList = new ArrayList<>();
    int audioID;
    Session session;
    ImageView ivSongImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        curTime = findViewById(R.id.currentState);
        totTime = findViewById(R.id.totalValue);
        mSeekBar = findViewById(R.id.mySeekbar);
        playIcon = findViewById(R.id.playBtn);
        imgLoop = findViewById(R.id.imgLoop);
        forward = findViewById(R.id.forward);
        backward = findViewById(R.id.backward);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle1 = findViewById(R.id.tvTitle1);
        imgBack = findViewById(R.id.imgBack);
        tvLyrics = findViewById(R.id.tvLyrics);
        nextSong = findViewById(R.id.nextSong);
        previewSong = findViewById(R.id.previewSong);
        ivSongImage     = findViewById(R.id.ivSongImage);
        session = new Session(this);
        session.setData(Constant.CURRENT_A_ID, "");

        audioList = getIntent().getStringArrayListExtra(Constant.AUDIO_LIST);
        audioID = getIntent().getIntExtra(Constant.ID, 0);
        Title = getIntent().getStringExtra(Constant.AUDIO_TITLE);
        Audio = audioList.get(audioID);
        Image = getIntent().getStringExtra(Constant.IMAGE);
        Glide.with(this).load(Image).into(ivSongImage);
        Lyrics = getIntent().getStringExtra(Constant.LYRICS);
        tvTitle.setText(Title);
        tvTitle1.setText(Title);
        tvLyrics.setText(Lyrics);
        tvLyrics.setMovementMethod(new ScrollingMovementMethod());

        sharedpreferences = AudioPlayActivity.this.getSharedPreferences("BBR", Context.MODE_PRIVATE);
        hfmPlayer = new MediaPlayer();
        bellPlayer = new MediaPlayer();
        shankPlayer = new MediaPlayer();
        initPlayer();
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_a_id = session.getData(Constant.CURRENT_A_ID);
                if (current_a_id.isEmpty()) {
                    int temp = audioID + 1;
                    Audio = audioList.get(temp);
                    session.setData(Constant.CURRENT_A_ID, String.valueOf(temp));

                } else {
                    int updated_id = Integer.parseInt(current_a_id) + 1;
                    session.setData(Constant.CURRENT_A_ID, String.valueOf(updated_id));
                    Audio = audioList.get(updated_id);

                }
                curTime.setText("00:00");
                playIcon.setBackgroundResource(R.drawable.b_play);
                initPlayer();

            }
        });
        previewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_a_id = session.getData(Constant.CURRENT_A_ID);
                if (current_a_id.isEmpty()) {
                    int temp = audioID - 1;
                    if (audioID == 0) {
                        Audio = audioList.get(0);
                        session.setData(Constant.CURRENT_A_ID,"");

                    } else {
                        Audio = audioList.get(temp);
                        session.setData(Constant.CURRENT_A_ID, String.valueOf(temp));
                    }
                } else {
                    int updated_id = Integer.parseInt(current_a_id) - 1; // subtract 1 to go to previous audio
                    session.setData(Constant.CURRENT_A_ID, String.valueOf(updated_id));
                    Audio = audioList.get(updated_id);

                }
                curTime.setText("00:00");
                playIcon.setBackgroundResource(R.drawable.b_play);
                initPlayer();
            }
        });

        curTime.setText("00:00");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forwardSong();
            }
        });


        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rewindSong();
            }
        });
        imgLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loop) {
                    imgLoop.setImageResource(R.drawable.ic_baseline_loop_24);
                    loop = false;
                } else {
                    imgLoop.setImageResource(R.drawable.ic_baseline_loop_select);
                    loop = true;
                }

            }
        });


        //playAudio();
    }

    private void playAudio() {

        String audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

        // initializing media player
        mediaPlayer = new MediaPlayer();

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepareAsync();
            // below line is use to prepare
            // and start our media player.


        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer player) {
                player.start();
            }

        });
        // below line is use to display a toast message.
        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (hfmPlayer != null && hfmPlayer.isPlaying()) {
            hfmPlayer.reset();
        }
    }

    private void initPlayer() {
        if (hfmPlayer != null && hfmPlayer.isPlaying()) {
            hfmPlayer.reset();
        }
        hfmPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            hfmPlayer.reset();
            hfmPlayer.setDataSource(Audio);
            hfmPlayer.prepareAsync();
            // below line is use to prepare
            // and start our media player.


        } catch (IOException e) {
            e.printStackTrace();
        }
        //hfmPlayer = MediaPlayer.create(AudioPlayActivity.this,R.raw.chalisa); // create and load mediaplayer with song resources
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
            public void onCompletion(MediaPlayer mp) {
                mSeekBar.setProgress(0);
                playIcon.setBackgroundResource(R.drawable.b_play);
                curTime.setText("00:00");
                try {
                    lyricsData = splandata.getString("D1");
                    lyricsText.setText(lyricsData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (count < setcount) {
                    hfmPlayer.start();
                    playIcon.setBackgroundResource(R.drawable.b_pause);
                    count++;
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                if (loop) {
                    play();
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
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!hfmPlayer.isPlaying()) {
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
            for (int i = 0; i < chalisatime.length; i++) {

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


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if (AudioPlayActivity.this == null)
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