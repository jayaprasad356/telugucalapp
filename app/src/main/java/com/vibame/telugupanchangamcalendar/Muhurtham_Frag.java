package com.vibame.telugupanchangamcalendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Muhurtham_Frag extends Fragment implements View.OnClickListener {

    private Context context;
    private RecyclerView recyclerView;
    private List<Object> viewitems = new ArrayList<>();
    private TextView monthName;
    ImageButton previousMonth,nextMonth;
    Button vivaha,namakarna,gruha,vahana;
    String monthData,getBtnName;
    GregorianCalendar cal_month;
    private int currentMonth;
    MuhurthamAdapter muhurthamAdapter;
    Boolean jsonload = false;
    private JSONObject obj;

    String[] month = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};
    String[] monthE = {"January", "February", "March", "Aprial", "May", "June", "July", "August", "September", "October", "November", "December"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muhurtham_frag,container,false);
        //context = container.getContext();

        monthName = view.findViewById(R.id.tv_month);
        previousMonth =  view.findViewById(R.id.ib_prev);
        nextMonth =  view.findViewById(R.id.Ib_next);
        vivaha =  view.findViewById(R.id.vivahaBtn);
        namakarna =  view.findViewById(R.id.namakarBtn);
        gruha =  view.findViewById(R.id.gruhaBtn);
        vahana =  view.findViewById(R.id.vahanaBtn);


        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        currentMonth = cal_month.get(GregorianCalendar.MONTH);

        monthName.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));
        monthData = monthE[currentMonth] + "_" + cal_month.get(GregorianCalendar.YEAR);
        //getMonthName = monthE[currentMonth];


        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/sree.ttf");
        monthName.setTypeface(typeface);
        vivaha.setTypeface(typeface);
        namakarna.setTypeface(typeface);
        gruha.setTypeface(typeface);
        vahana.setTypeface(typeface);

        recyclerView = view.findViewById(R.id.mrecyclerId);
        muhurthamAdapter = new MuhurthamAdapter(getActivity(),viewitems);
        recyclerView.setAdapter(muhurthamAdapter);
        recyclerView.setHasFixedSize(true);

        getBtnName = "Namakaran";
        viewitems.clear();
        getJsonfileToRead(getBtnName,monthData);
        //Log.d("addItemsFromJSON", "onCreateView: Muhurtham_Frag");

        vivaha.setOnClickListener(this);
        namakarna.setOnClickListener(this);
        gruha.setOnClickListener(this);
        vahana.setOnClickListener(this);


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
                        clearRecyclerView();
                    }
                }
            }
        });
        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cal_month.get(GregorianCalendar.YEAR) <2024)
                {
                    if(currentMonth == 11 && cal_month.get(GregorianCalendar.YEAR) == 2023)
                    {
                        Toast.makeText(getContext(),"ప్రదర్శించడానికి డేటా లేదు",Toast.LENGTH_SHORT).show();

                    }else
                    {
                        setNextMonth();
                        clearRecyclerView();
                    }
                }
            }
        });

        return view;
    }

    private void clearRecyclerView() {

        recyclerView.getRecycledViewPool().clear();
        recyclerView.scrollToPosition(0);
        muhurthamAdapter.notifyDataSetChanged();

        viewitems.clear();
        getJsonfileToRead(getBtnName,monthData);
    }

    private void getJsonfileToRead(String zodiacName,String monthYearName)
    {
        try {
            if(jsonload == false)
            {
                obj = new JSONObject(loadJSONFromRaw());
                jsonload = true;
            }

            JSONArray muhurthNameArr = obj.getJSONArray(zodiacName);

            // implement for loop for getting users list data
            for (int i = 0; i < muhurthNameArr.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject itemobj = muhurthNameArr.getJSONObject(i);
                JSONArray muhurthamArr = itemobj.getJSONArray(monthYearName);



                for (int j = 0; j < muhurthamArr.length()+1; j++)
                {
                    String starName = muhurthamArr.getJSONObject(j).getString("starName");
                    String startTime = muhurthamArr.getJSONObject(j).getString("startTime");
                    String endTime = muhurthamArr.getJSONObject(j).getString("endTime");

                    MuhurthamList muhurthamList = new MuhurthamList(starName,startTime,endTime);
                    viewitems.add(muhurthamList);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.muhurthams);
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

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.vivahaBtn:
                getBtnName = "Vivaha";
                allbtnTextColorChange();
                vivaha.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.namakarBtn:
                getBtnName = "Namakaran";
                allbtnTextColorChange();
                namakarna.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.gruhaBtn:
                getBtnName = "Gruha";
                allbtnTextColorChange();
                gruha.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.vahanaBtn:

                getBtnName = "Vahana";
                allbtnTextColorChange();
                vahana.setTextColor(Color.parseColor("#FFFFFF"));

                break;
        }

    }

    private void allbtnTextColorChange() {

        vivaha.setTextColor(Color.parseColor("#0E2830"));
        namakarna.setTextColor(Color.parseColor("#0E2830"));
        gruha.setTextColor(Color.parseColor("#0E2830"));
        vahana.setTextColor(Color.parseColor("#0E2830"));
        clearRecyclerView();
    }
}
