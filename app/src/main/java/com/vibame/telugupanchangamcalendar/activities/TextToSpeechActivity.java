package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;
    EditText edText;

    ImageView imgBack;
    Activity activity;
    String _voiceName = "en-us-x-sfg#male_1-local";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        activity = TextToSpeechActivity.this;


        btnSpeak = findViewById(R.id.btnSpeak);
        edText = findViewById(R.id.edText);
        imgBack = findViewById(R.id.imgBack);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });






        tts = new TextToSpeech(activity, this, "com.google.android.tts");
        tts.getVoices();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


               speakOut("" + edText.getText().toString());
            }

        });


    }


    @Override
    public void onDestroy() {
        // Don't forget to shutdown!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub

        if (status == TextToSpeech.SUCCESS)


        {



            int result = tts.setLanguage(Locale.UK);

            tts.getVoices();



            // tts.setPitch(5); // set pitch level

            // tts.setSpeechRate(2); // set speech speed rate

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {

            }

        } else {
            Log.e("TTS", "Initilization Failed");
        }

    }

    private void speakOut(String text) {

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}