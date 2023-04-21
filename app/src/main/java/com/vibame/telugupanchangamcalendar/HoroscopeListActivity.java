package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.helper.Constant;

import java.util.Objects;

public class HoroscopeListActivity extends AppCompatActivity {

    TextView tvHoroscopeTitle,tvMesha,tvVrushaba,tvMithuna,tvKarkataka,tvSimha,tvKanya,tvTula,tvVrushchika,tvDhanu,tvMakara,tvKumbha,tvMeena;
    LinearLayout llmesha,llvrushaba, llmithuna, llkarkataka, llsimha, llkanya, lltula, llvrushchika, lldhanu, llmakara, llkumbha, llmeena;
    String value;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope_list);
        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);

        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE));
        value = getIntent().getStringExtra("value").toString();



        llmesha = findViewById(R.id.llmesha);
        llvrushaba = findViewById(R.id.llvrusha);
        llmithuna = findViewById(R.id.llmithuna);
        llkarkataka = findViewById(R.id.llkarka);
        llsimha = findViewById(R.id.llsimha);
        llkanya = findViewById(R.id.llkanya);
        lltula = findViewById(R.id.lltula);
        llvrushchika = findViewById(R.id.llvrushchika);
        lldhanu = findViewById(R.id.lldhanu);
        llmakara = findViewById(R.id.llmakara);
        llkumbha = findViewById(R.id.llkumbha);
        llmeena = findViewById(R.id.llmeena);

        tvMesha = findViewById(R.id.tvMesha);
        tvVrushaba = findViewById(R.id.tvVrusha);
        tvMithuna = findViewById(R.id.tvMithuna);
        tvKarkataka = findViewById(R.id.tvKarka);
        tvSimha = findViewById(R.id.tvSimha);
        tvKanya = findViewById(R.id.tvKanya);
        tvTula = findViewById(R.id.tvTula);
        tvVrushchika = findViewById(R.id.tvVrushchika);
        tvDhanu = findViewById(R.id.tvDhanu);
        tvMakara = findViewById(R.id.tvMakara);
        tvKumbha = findViewById(R.id.tvKumbha);
        tvMeena = findViewById(R.id.tvMeena);



        llmesha.setOnClickListener(v -> {

            String Name = tvMesha.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }



        });

        llvrushaba.setOnClickListener(v -> {

            String Name = tvVrushaba.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llmithuna.setOnClickListener(v -> {

            String Name = tvMithuna.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llkarkataka.setOnClickListener(v -> {

            String Name = tvKarkataka.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llsimha.setOnClickListener(v -> {

            String Name = tvSimha.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llkanya.setOnClickListener(v -> {

            String Name = tvKanya.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        lltula.setOnClickListener(v -> {

            String Name = tvTula.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llvrushchika.setOnClickListener(v -> {

            String Name = tvVrushchika.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        lldhanu.setOnClickListener(view -> {

            String Name = tvDhanu.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });



        llmakara.setOnClickListener(v -> {

            String Name = tvMakara.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llkumbha.setOnClickListener(v -> {

            String Name = tvKumbha.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });


        llmeena.setOnClickListener(v -> {

            String Name = tvMeena.getText().toString();

            if (Objects.equals(value, "1")){
                Intent intent = new Intent(HoroscopeListActivity.this, DailyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "2")){
                Intent intent = new Intent(HoroscopeListActivity.this, WeeklyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "3")){
                Intent intent = new Intent(HoroscopeListActivity.this, MontliHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

            else if (Objects.equals(value, "4")){
                Intent intent = new Intent(HoroscopeListActivity.this, YearlyHoroscopeActivity.class);
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                intent.putExtra("Name", Name);
                startActivity(intent);
            }

        });







    }
}