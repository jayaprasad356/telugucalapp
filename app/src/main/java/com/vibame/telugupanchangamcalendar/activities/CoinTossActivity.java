package com.vibame.telugupanchangamcalendar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ProgressDisplay;

import java.util.Random;

public class CoinTossActivity extends AppCompatActivity {
    private Button mBtnFlipCoin;
    public static final Random RANDOM = new Random();
    private ImageView coin,imgBtn;
    Activity activity;
    TextView tvProcess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=CoinTossActivity.this;
        setContentView(R.layout.activity_coin_toss);
        coin = findViewById(R.id.iv_coin);
        mBtnFlipCoin = findViewById(R.id.btn_flip_coin);
        tvProcess=findViewById(R.id.tvProcess);
        mBtnFlipCoin.setOnClickListener(v -> flipCoin());
        imgBtn=findViewById(R.id.imgBack);
        imgBtn.setOnClickListener(view -> onBackPressed());

    }

    private void flipCoin() {
        tvProcess.setVisibility(View.VISIBLE);
        ProgressDisplay m=new ProgressDisplay(activity);
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvProcess.setVisibility(View.GONE);
                coin.setImageResource(RANDOM.nextFloat() > 0.5f ? R.drawable.tails : R.drawable.heads);

                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator());
                fadeIn.setDuration(3000);
                fadeIn.setFillAfter(true);

                coin.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        coin.startAnimation(fadeOut);
    }
}