package com.vibame.telugupanchangamcalendar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;

public class Horoscope_Frag extends Fragment implements View.OnClickListener {

    private ImageButton mesha,vrusha, mithun,karka,simha,kanya,thula,vruchika,dhanu,makara,kumba,mina;
    private TextView tmesha,tvrusha, tmithun,tkarka,tsimha,tkanya,tthula,tvruchika,tdhanu,tmakara,tkumba,tmina;
    private TextView monthName,rasipalText, horoscopeTxt;;
    ImageButton previousMonth,nextMonth;
    String monthData,getmonthData;
    ScrollView rasiScroll;
    ImageView horoscopeImg;
    ImageView closeImg;
    GregorianCalendar cal_month;
    private int currentMonth;
    Typeface typeface;
    Boolean jsonload = false;
    private JSONObject obj;

    String[] month = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};
    String[] monthE = {"January", "February", "March", "Aprial", "May", "June", "July", "August", "September", "October", "November", "December"};


    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.horoscope_frag,container,false);


        monthName = view.findViewById(R.id.tv_month);
        previousMonth =  view.findViewById(R.id.ib_prev);
        nextMonth =  view.findViewById(R.id.Ib_next);

        mesha = (ImageButton) view.findViewById(R.id.meshaRasi);
        vrusha = (ImageButton)view.findViewById(R.id.vrushabaRasi);
        mithun = (ImageButton)view.findViewById(R.id.midhunaRasi);
        karka = (ImageButton)view.findViewById(R.id.karkaRasi);
        simha = (ImageButton)view.findViewById(R.id.simhaRasi);
        kanya = (ImageButton)view.findViewById(R.id.kanyaRasi);
        thula = (ImageButton)view.findViewById(R.id.thulaRasi);
        vruchika = (ImageButton)view.findViewById(R.id.vruchiRasi);
        dhanu = (ImageButton)view.findViewById(R.id.dhanuRasi);
        makara = (ImageButton)view.findViewById(R.id.makaraRasi);
        kumba = (ImageButton)view.findViewById(R.id.kumbaRasi);
        mina = (ImageButton)view.findViewById(R.id.minaRasi);

        tmesha = (TextView) view.findViewById(R.id.meshaRasiT);
        tvrusha = (TextView)view.findViewById(R.id.vrushabaRasiT);
        tmithun = (TextView)view.findViewById(R.id.midhunaRasiT);
        tkarka = (TextView)view.findViewById(R.id.karkaRasiT);
        tsimha = (TextView)view.findViewById(R.id.simhaRasiT);
        tkanya = (TextView)view.findViewById(R.id.kanyaRasiT);
        tthula = (TextView)view.findViewById(R.id.thulaRasiT);
        tvruchika = (TextView)view.findViewById(R.id.vruchiRasiT);
        tdhanu = (TextView)view.findViewById(R.id.dhanuRasiT);
        tmakara = (TextView)view.findViewById(R.id.makaraRasiT);
        tkumba = (TextView)view.findViewById(R.id.kumbaRasiT);
        tmina = (TextView)view.findViewById(R.id.minaRasiT);


        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/sree.ttf");
        tmesha.setTypeface(typeface);
        tvrusha.setTypeface(typeface);
        tmithun.setTypeface(typeface);
        tkarka.setTypeface(typeface);
        tsimha.setTypeface(typeface);
        tkanya.setTypeface(typeface);
        tthula.setTypeface(typeface);
        tvruchika.setTypeface(typeface);
        tdhanu.setTypeface(typeface);
        tmakara.setTypeface(typeface);
        tkumba.setTypeface(typeface);
        tmina.setTypeface(typeface);
        monthName.setTypeface(typeface);


        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        currentMonth = cal_month.get(GregorianCalendar.MONTH);

        monthName.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));
        monthData = monthE[currentMonth] + "_" + cal_month.get(GregorianCalendar.YEAR);


        mesha.setOnClickListener(this);
        vrusha.setOnClickListener(this);
        mithun.setOnClickListener(this);
        karka.setOnClickListener(this);
        simha.setOnClickListener(this);
        kanya.setOnClickListener(this);
        thula.setOnClickListener(this);
        vruchika.setOnClickListener(this);
        dhanu.setOnClickListener(this);
        makara.setOnClickListener(this);
        kumba.setOnClickListener(this);
        mina.setOnClickListener(this);


        previousMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cal_month.get(GregorianCalendar.YEAR) >2020)
                {
                    if(currentMonth == 10 && cal_month.get(GregorianCalendar.YEAR) == 2021)
                    {
                        Toast.makeText(getContext(),"ప్రదర్శించడానికి డేటా లేదు",Toast.LENGTH_SHORT).show();

                    }else
                    {
                        setPreviousMonth();
                    }
                }
            }
        });
        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cal_month.get(GregorianCalendar.YEAR) <2023)
                {
                    if(currentMonth == 11 && cal_month.get(GregorianCalendar.YEAR) == 2022)
                    {
                        Toast.makeText(getContext(),"ప్రదర్శించడానికి డేటా లేదు",Toast.LENGTH_SHORT).show();

                    }else
                    {
                        setNextMonth();
                    }
                }
            }
        });

        return view;
    }

    public void onClick(View view)
    {
        ImageButton b = (ImageButton) view;
        String sendName = getResources().getResourceEntryName(b.getId());
        getJsonfileToRead(sendName);
        showHoroscopeDialog();


        switch (b.getId())
        {
            case R.id.meshaRasi:

                horoscopeImg.setBackgroundResource(R.drawable.mesha);
                horoscopeTxt.setText(month[currentMonth]+"- మేషరాశి ఫలితము");

                break;
            case R.id.vrushabaRasi:

                horoscopeImg.setBackgroundResource(R.drawable.vrusha);
                horoscopeTxt.setText(month[currentMonth]+"- వృషభరాశి ఫలితము");

                break;
            case R.id.midhunaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.mithun);
                horoscopeTxt.setText(month[currentMonth]+"- మిధునరాశి ఫలితము");

                break;
            case R.id.karkaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.karka);
                horoscopeTxt.setText(month[currentMonth]+"- కర్కాటకరాశి ఫలితము");

                break;
            case R.id.simhaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.simha);
                horoscopeTxt.setText(month[currentMonth]+"- సింహరాశి ఫలితము");

                break;
            case R.id.kanyaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.kanya);
                horoscopeTxt.setText(month[currentMonth]+"- కన్యరాశి ఫలితము");

                break;
            case R.id.thulaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.thula);
                horoscopeTxt.setText(month[currentMonth]+"- తులరాశి ఫలితము");

                break;
            case R.id.vruchiRasi:
                horoscopeImg.setBackgroundResource(R.drawable.vruchika);
                horoscopeTxt.setText(month[currentMonth]+"- వృశ్చికరాశి ఫలితము");

                break;
            case R.id.dhanuRasi:
                horoscopeImg.setBackgroundResource(R.drawable.dhanu);
                horoscopeTxt.setText(month[currentMonth]+"- ధనస్సురాశి ఫలితము");

                break;
            case R.id.makaraRasi:
                horoscopeImg.setBackgroundResource(R.drawable.makara);
                horoscopeTxt.setText(month[currentMonth]+"- మకరరాశి ఫలితము");

                break;
            case R.id.kumbaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.kumba);
                horoscopeTxt.setText(month[currentMonth]+"- కుంభరాశి ఫలితము");

                break;
            case R.id.minaRasi:
                horoscopeImg.setBackgroundResource(R.drawable.mina);
                horoscopeTxt.setText(month[currentMonth]+"- మీనరాశి ఫలితము");

                break;

        }
    }

    private void getJsonfileToRead(String zodiacName)
    {
        try {
            if(jsonload == false)
            {
                obj = new JSONObject(loadJSONFromRaw());
                jsonload = true;
            }

            JSONArray horoscopesArr = obj.getJSONArray(zodiacName);
            // implement for loop for getting users list data
            for (int i = 0; i < horoscopesArr.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject horoscopes = horoscopesArr.getJSONObject(i);
                // fetch email and name and store it in arraylist
                getmonthData = horoscopes.getString(monthE[currentMonth]);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.horoscope);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void showHoroscopeDialog()
    {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.horo_dialog);

        rasiScroll = (ScrollView) dialog.findViewById(R.id.rasiScroll);
        rasipalText = dialog.findViewById(R.id.rasipalText);
        horoscopeImg = (ImageView)dialog.findViewById(R.id.horoscopeImg);
        closeImg = (ImageView)dialog.findViewById(R.id.closeImg);
        horoscopeTxt = (TextView)dialog.findViewById(R.id.horoscopeTxt);

        horoscopeTxt.setTypeface(typeface);
        rasipalText.setTypeface(typeface);
        rasipalText.setText(null);
        rasipalText.setText("");
        rasipalText.setText(getmonthData);

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.show();
    }

    protected void setNextMonth()
    {
        currentMonth++;
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH))
        {
            currentMonth = 0;
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);

        }else
        {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) + 1);
        }
        monthData = monthE[currentMonth] + "_" + cal_month.get(GregorianCalendar.YEAR);
        monthName.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));

    }

    protected void setPreviousMonth()
    {
        currentMonth--;
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH))
        {
            currentMonth =11;
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);

        }else
        {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
        monthData = monthE[currentMonth] + "_" + cal_month.get(GregorianCalendar.YEAR);
        monthName.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));
    }
}
