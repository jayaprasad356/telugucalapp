package com.vibame.telugupanchangamcalendar;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.PanchangamTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Panchang_Frag extends Fragment

{
    RecyclerView recyclerView;
    Activity activity;
    PanchangamTabAdapter panchangamTabAdapter;

    private static GregorianCalendar cal_month,cal_month_copy;
    private HwAdapter hwAdapter;
    private static int currentMonth;
    static String selectedGridDate;
    private java.util.Calendar cmonth;
    static int cutmonth;
    private GridView gridview;
    Uri bitmapUri;

    private WebView mywebView;
    private String loadXmlFile;
    private ArrayList<XmlRecords> records;
    private boolean changed;
    private int clickedDate;
    private String dateFormat;
    private Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    LinearLayout fl1;
    DatabaseHelper databaseHelper;

    private TextView goodtimeText,sunTxt,moonTxt,sunrise,sunset,moonrise,moonset;
    private TextView tv_month,tvFestivalInfo;
    private String[] month = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", " మే ", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};
    private String[] monthE = {"January", "February", "March", "Aprial", "May", "June", "July", "August", "September", "October", "November", "December"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.panchang_frag,container,false);

        activity = getActivity();

        databaseHelper = new DatabaseHelper(activity);
        recyclerView = view.findViewById(R.id.recyclerView);
        tvFestivalInfo = view.findViewById(R.id.tvFestivalInfo);
        fl1 = view.findViewById(R.id.fl1);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));

        HomeCollection.date_collection_arr=new ArrayList<HomeCollection>();

        //**********2019 Holidays **************



        HomeCollection.date_collection_arr.add( new HomeCollection("2021-11-04" ,"diwali","* నరక చతుర్ధశి (దీపావళి) *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2021-12-25" ,"maxres","*  క్రిస్టమస్  *"));


        HomeCollection.date_collection_arr.add( new HomeCollection("2022-01-01" ,"bhogi","* భోగి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-01-14" ,"pongal","* మకర సంక్రాంతి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-01-26" ,"republic","* రిపబ్లిక్ డే *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-03-01" ,"shivaratri","* మహాశివరాత్రి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-03-18" ,"holi","* హోలీ  పౌర్ణమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-02" ,"ugadi"," * ఉగాది పండుగ *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-10" ,"ramnavami","* శ్రీరామ నవమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-15" ,"friday","* గుడ్ ఫ్రైడే  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-05-01" ,"mayday"," * కార్మికుల దినొత్సవం   *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-05-03" ,"Idul Fitr"," * కార్మికుల దినొత్సవం   *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-07-10" ,"bakrid","* బక్రీద్  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-15" ,"independence","* స్వాతంత్య్ర దినోత్సవం *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-31" ,"varalaxmi","* వరలక్ష్మి వ్రతం   *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-18" ,"janmashtami","* శ్రీకృష్ణాష్టమి  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-09" ,"muharram","* మొహర్రం  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-09-05" ,"teachersday","* మొహర్రం  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-02" ,"gandhi","* గాంధీ జయంతి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-03" ,"astami","*  మహర్నవమి *\n* దుర్గాష్టమి  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-05" ,"durga","* విజయ దశమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-24" ,"diwali","* నరక చతుర్ధశి (దీపావళి) *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-12-25" ,"maxres","*  క్రిస్టమస్  *"));


        HomeCollection.date_collection_arr.add( new HomeCollection("2023-01-01" ,"bhogi","* భోగి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-01-14" ,"pongal","* మకర సంక్రాంతి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-01-26" ,"republic","* రిపబ్లిక్ డే *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-02-18" ,"shivaratri","* మహాశివరాత్రి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-03-07" ,"holi","* హోలీ  పౌర్ణమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-03-22" ,"ugadi"," * ఉగాది పండుగ *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-03-30" ,"ramnavami","* శ్రీరామ నవమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-04-07" ,"friday","* గుడ్ ఫ్రైడే  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-04-22" ,"idulfitr","* రంజాన్ *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-05-01" ,"mayday"," * కార్మికుల దినొత్సవం   *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-06-29" ,"bakrid","* బక్రీద్  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-07-29" ,"bakrid","* బక్రీద్  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-08-15" ,"independence","* స్వాతంత్య్ర దినోత్సవం *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-09-07" ,"janmashtami","* శ్రీకృష్ణాష్టమి  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-09-19" ,"ganesh","* వినాయక చవితి  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-09-05" ,"teachersday","* మొహర్రం  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-10-02" ,"gandhi","* గాంధీ జయంతి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-10-22" ,"astami","*  మహర్నవమి *\n* దుర్గాష్టమి  *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-10-24" ,"durga","* విజయ దశమి *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-11-12" ,"diwali","* నరక చతుర్ధశి (దీపావళి) *"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-12-25" ,"maxres","*  క్రిస్టమస్  *"));




        //***********Amavasya Punnami Dates***************

        HomeCollection.date_collection_arr.add( new HomeCollection("2021-11-19" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2021-11-04" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2021-12-19" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2021-12-04" ,"","Amayasya"));

        HomeCollection.date_collection_arr.add( new HomeCollection("2022-01-17" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-01-02" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-02-16" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-02-01" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-03-18" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-03-02" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-16" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-01" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-04-30" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-05-16" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-05-30" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-06-14" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-06-29" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-07-13" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-07-28" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-12" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-08-27" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-09-10" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-09-25" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-09" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-10-25" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-11-08" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-11-23" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-12-08" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2022-12-23" ,"","Amayasya"));

        HomeCollection.date_collection_arr.add( new HomeCollection("2023-01-06" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-01-21" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-02-05" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-02-20" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-03-07" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-03-21" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-04-06" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-04-20" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-05-05" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-05-19" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-06-04" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-06-18" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-07-03" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-07-17" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-08-01" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-08-31" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-08-16" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-09-29" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-09-14" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-10-28" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-10-14" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-11-27" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-11-13" ,"","Amayasya"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-12-26" ,"","Purnami"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2023-12-12" ,"","Amayasya"));


        mywebView = view.findViewById(R.id.mywebView);
        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new HwAdapter(getActivity(), cal_month,HomeCollection.date_collection_arr);
        currentMonth = cal_month.get(GregorianCalendar.MONTH);
        cutmonth = cal_month.get(GregorianCalendar.MONTH);

        TextView tv_week1 = view.findViewById(R.id.textView1);
        TextView tv_week2 = view.findViewById(R.id.TextView01);
        TextView tv_week3 = view.findViewById(R.id.TextView02);
        TextView tv_week4 = view.findViewById(R.id.TextView03);
        TextView tv_week5 = view.findViewById(R.id.TextView04);
        TextView tv_week6 = view.findViewById(R.id.TextView05);
        TextView tv_week7 = view.findViewById(R.id.TextView06);
        goodtimeText = view.findViewById(R.id.goodTimeText);
        sunTxt = view.findViewById(R.id.sunrise);
        moonTxt = view.findViewById(R.id.moonrise);
        sunrise = view.findViewById(R.id.sunriseT);
        sunset = view.findViewById(R.id.sunset);
        moonrise = view.findViewById(R.id.moonriseT);
        moonset = view.findViewById(R.id.moonset);


        tv_month = view.findViewById(R.id.tv_month);
        ImageButton previousMonth = view.findViewById(R.id.ib_prev);
        ImageButton nextMonth = view.findViewById(R.id.Ib_next);

        tv_month.setText(month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR));
        loadXmlFile = monthE[currentMonth]+"_"+calendar.get(Calendar.YEAR);
        if(cal_month.get(GregorianCalendar.YEAR) == 2021)
        {
            dateFormat = calendar.get(Calendar.DATE)+" - "+month[currentMonth]+" - "+calendar.get(Calendar.YEAR)+" - స్వస్తిశ్రీ ప్లవ" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth <3)
        {
            dateFormat = calendar.get(Calendar.DATE)+" - "+month[currentMonth]+" - "+calendar.get(Calendar.YEAR)+" - స్వస్తిశ్రీ ప్లవ" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth >3)
        {
            dateFormat = calendar.get(Calendar.DATE)+" - "+month[currentMonth]+" - "+calendar.get(Calendar.YEAR)+" - శుభకృతు" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth <3 && calendar.get(Calendar.DATE)<21)
        {
            dateFormat = calendar.get(Calendar.DATE)+" - "+month[currentMonth]+" - "+calendar.get(Calendar.YEAR)+" - శుభకృతు" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth >2)
        {
            dateFormat = calendar.get(Calendar.DATE)+" - "+month[currentMonth]+" - "+calendar.get(Calendar.YEAR)+" -  శోభకృతు" ;
        }


        clickedDate = (calendar.get(Calendar.DATE)-1);
        selectedGridDate = "";

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/sree.ttf");
        tv_week1.setTypeface(typeface);
        tv_week2.setTypeface(typeface);
        tv_week3.setTypeface(typeface);
        tv_week4.setTypeface(typeface);
        tv_week5.setTypeface(typeface);
        tv_week6.setTypeface(typeface);
        tv_week7.setTypeface(typeface);
        tv_month.setTypeface(typeface);
        goodtimeText.setTypeface(typeface);
        sunTxt.setTypeface(typeface);
        moonTxt.setTypeface(typeface);

        Typeface typefaceText = Typeface.createFromAsset(getActivity().getAssets(),"fonts/arlrb.TTF");
        sunrise.setTypeface(typefaceText);
        sunset.setTypeface(typefaceText);
        moonrise.setTypeface(typefaceText);
        moonset.setTypeface(typefaceText);

        gridview = (GridView) view.findViewById(R.id.gv_calendar);



        gridViewSet();
        parseXML();


        previousMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cal_month.get(GregorianCalendar.YEAR) >2020)
                {
                    if(currentMonth == 10 && cal_month.get(GregorianCalendar.YEAR) == 2021)
                    {
                        Toast.makeText(getContext(),"ప్రదర్శించడానికి డేటా లేదు", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        setPreviousMonth();
                        allFunc();
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
                        Toast.makeText(getContext(),"ప్రదర్శించడానికి డేటా లేదు", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        setNextMonth();
                        allFunc();

                    }
                }
            }
        });



        return view;
    }

    private void panchangamApi(String date)
    {

        Map<String, String> params = new HashMap<>();
        params.put(Constant.DATE,date);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {

                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray = object.getJSONArray(Constant.DATA);
                        JSONObject object2 = jsonArray.getJSONObject(0);
                        JSONArray jsonArray1 = object2.getJSONArray(Constant.TAB);

                        sunrise.setText(jsonArray.getJSONObject(0).getString(Constant.SUNRISE));
                        sunset.setText(jsonArray.getJSONObject(0).getString(Constant.SUNSET));
                        moonrise.setText(jsonArray.getJSONObject(0).getString(Constant.MOONRISE));
                        moonset.setText(jsonArray.getJSONObject(0).getString(Constant.MOONSET));
                        tvFestivalInfo.setText(jsonArray.getJSONObject(0).getString(Constant.INFO));
                        Gson g = new Gson();
                        ArrayList<PanchangamTab> panchangamTabs = new ArrayList<>();

                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                            if (jsonObject1 != null) {
                                PanchangamTab group = g.fromJson(jsonObject1.toString(), PanchangamTab.class);
                                panchangamTabs.add(group);
                            } else {
                                break;
                            }
                        }
                        panchangamTabAdapter = new PanchangamTabAdapter(activity, panchangamTabs);
                        recyclerView.setAdapter(panchangamTabAdapter);

                    }
                    else {
                        fl1.setVisibility(View.GONE);
                        sunrise.setText("-");
                        sunset.setText("-");
                        moonrise.setText("-");
                        moonset.setText("-");
                        ArrayList<PanchangamTab> panchangamTabs = new ArrayList<>();

                        panchangamTabAdapter = new PanchangamTabAdapter(activity, panchangamTabs);
                        recyclerView.setAdapter(panchangamTabAdapter);


                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.PANCHANGAM_URL, params,true);

    }

    private void allFunc()
    {
        refreshCalendar();
        gridViewSet();
        clickedDate = 0;
        selectedGridDate = HwAdapter.day_string.get(HwAdapter.firstDay -1);
        if(cal_month.get(GregorianCalendar.YEAR) == 2021)
        {
            dateFormat = 1+" - "+month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR)+" - స్వస్తిశ్రీ ప్లవ" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth <3)
        {
            dateFormat = 1+" - "+month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR)+" - స్వస్తిశ్రీ ప్లవ" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth >2)
        {
            dateFormat = 1+" - "+month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR)+" -  శుభకృతు" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth <3)
        {
            dateFormat = 1+" - "+month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR)+" -  శుభకృతు" ;

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth >2 )
        {
            dateFormat = 1+" - "+month[currentMonth]+" - "+cal_month.get(GregorianCalendar.YEAR)+" -  శోభకృతు" ;
        }
        hwAdapter.notifyDataSetChanged();
        loadXmlFile = monthE[currentMonth]+"_"+cal_month.get(GregorianCalendar.YEAR);
        parseXML();
    }

    private void gridViewSet()
    {
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedGridDate = HwAdapter.day_string.get(position);
                String[] separatedTime = HwAdapter.day_string.get(position).split("-");

                String cl_day = separatedTime[2].replaceFirst("^0*", "");
                String cl_month = separatedTime[1].replaceFirst("^0*", "");
                String cl_year = separatedTime[0].replaceFirst("^0*", "");

                clickedDate = (Integer.parseInt(cl_day)-1);


                if(cal_month.get(GregorianCalendar.YEAR) == 2021)
                {
                    dateFormat = cl_day+" - "+month[(Integer.parseInt(cl_month)-1)]+" - "+cl_year+" -  ప్లవ" ;

                }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth <3)
                {
                    dateFormat = cl_day+" - "+month[(Integer.parseInt(cl_month)-1)]+" - "+cl_year+" -  ప్లవ" ;

                }else if(cal_month.get(GregorianCalendar.YEAR) == 2022 && currentMonth >3)
                {
                    dateFormat = cl_day+" - "+month[(Integer.parseInt(cl_month)-1)]+" - "+cl_year+" -  శుభకృతు" ;

                }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth <3 && clickedDate<21)
                {
                    dateFormat = cl_day+" - "+month[(Integer.parseInt(cl_month)-1)]+" - "+cl_year+" -  శుభకృతు" ;

                }else if(cal_month.get(GregorianCalendar.YEAR) == 2023 && currentMonth >1 && clickedDate>20)
                {
                    dateFormat = cl_day+" - "+month[(Integer.parseInt(cl_month)-1)]+" - "+cl_year+" -  శోభకృతు" ;
                }
                ((HwAdapter) parent.getAdapter()).getPositionList(selectedGridDate, getActivity());
                hwAdapter.notifyDataSetChanged();
                if(loadXmlFile.equals(monthE[(Integer.parseInt(cl_month)-1)]+"_"+ Integer.parseInt(cl_year)))
                {
                    printRecords();

                }else
                {
                    loadXmlFile = monthE[(Integer.parseInt(cl_month)-1)]+"_"+ Integer.parseInt(cl_year);
                    parseXML();
                }
            }
        });
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
        tv_month.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));

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
        tv_month.setText(month[currentMonth]+" - "+(cal_month.get(GregorianCalendar.YEAR)));
    }

    public void refreshCalendar()
    {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
    }
    private void parseXML()
    {
        XmlPullParserFactory parserFactory;

        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = parserFactory.newPullParser();
            try
            {
                InputStream inputStream = getActivity().getAssets().open("Months/"+loadXmlFile+".xml");
                pullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
                pullParser.setInput(inputStream,null);
                processParser(pullParser);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    private void processParser(XmlPullParser pullParser) throws IOException, XmlPullParserException
    {
        records = new ArrayList<>();
        int eventType = pullParser.getEventType();

        XmlRecords currentRecord = null;

        while (eventType != XmlPullParser.END_DOCUMENT)
        {
            String eltName = null;
            switch (eventType)
            {
                case XmlPullParser.START_TAG:
                    eltName = pullParser.getName();

                    if("record".equals(eltName))
                    {
                        currentRecord = new XmlRecords();
                        records.add(currentRecord);

                    }else if(currentRecord != null)
                    {
                        if("date".equals(eltName))
                        {
                            currentRecord.Date = pullParser.nextText();

                        }else if("sunrise".equals(eltName))
                        {
                            currentRecord.Sunrise = pullParser.nextText();

                        }else if("sunset".equals(eltName))
                        {
                            currentRecord.Sunset = pullParser.nextText();

                        }else if("moonrise".equals(eltName))
                        {
                            currentRecord.Moonrise = pullParser.nextText();

                        }else if("moonset".equals(eltName))
                        {
                            currentRecord.Moonset = pullParser.nextText();

                        }else if("rutuvu".equals(eltName))
                        {
                            currentRecord.Ruthu = pullParser.nextText();

                        }else if("masam".equals(eltName))
                        {
                            currentRecord.Masam = pullParser.nextText();

                        }else if("paksham".equals(eltName))
                        {
                            currentRecord.Paksham = pullParser.nextText();

                        }else if("kalam".equals(eltName))
                        {
                            currentRecord.Kalam = pullParser.nextText();

                        }else if("thidi".equals(eltName))
                        {
                            currentRecord.Thidi = pullParser.nextText();

                        }else if("vaara".equals(eltName))
                        {
                            currentRecord.Week = pullParser.nextText();

                        }else if("nakshatra".equals(eltName))
                        {
                            currentRecord.Nakshatram = pullParser.nextText();

                        }else if("yogam".equals(eltName))
                        {
                            currentRecord.Yogam = pullParser.nextText();

                        }else if("karana".equals(eltName))
                        {
                            currentRecord.Karanam = pullParser.nextText();

                        }else if("rahu".equals(eltName))
                        {
                            currentRecord.Rahuv = pullParser.nextText();

                        }else if("yamag".equals(eltName))
                        {
                            currentRecord.Yama = pullParser.nextText();

                        }else if("varjyam".equals(eltName))
                        {
                            currentRecord.Varjyam = pullParser.nextText();

                        }else if("gulika".equals(eltName))
                        {
                            currentRecord.Gulika = pullParser.nextText();

                        }else if("dhurmuhu".equals(eltName))
                        {
                            currentRecord.Dhurmuhurth = pullParser.nextText();

                        }else if("festival".equals(eltName))
                        {
                            currentRecord.Festival = pullParser.nextText();

                        }
                    }
                    break;
            }
            eventType = pullParser.next();
        }
        printRecords();
    }

    private void printRecords()
    {
        String date  = (clickedDate + 1) + "" ;
        String strCurrentDate = loadXmlFile + "_"+date;
        SimpleDateFormat format = new SimpleDateFormat("MMMM_yyyy_dd");
        Date newDate = null;
        try {
            newDate = format.parse(strCurrentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("yyyy-MM-dd");
        String cadate = format.format(newDate);
        Log.d("CURRENTDATE",""+cadate);
        //panchangamApi(cadate);
        panchangamList(cadate);

        String festival;

        if(records.get(clickedDate).Festival == null)
        {
            festival = "";
        }else
        {
            festival = records.get(clickedDate).Festival;
        }
        String htmlData;

        if(!changed)
        {
            changed = true;
            htmlData = "<html><style type='text/css'>@font-face { font-family: sree; src: url('fonts/sree.ttf'); } body p {font-family: sree;}</style><head><meta name='viewport' user-scalable=no' /></head><body align='center' style='padding: 0' >" +
                    "<div style='color:#0F1970;text-align:center;font-size:19;font-family: sree;'>"+  dateFormat + "</div>" +

                    "<div style='font-weight:bold;text-align:left;margin-left:10px;line-height:1.5;font-size:15;font-family: sree;'>" +

                    "<span style='color:#006600'>"+
                    "<div style='width:20%;text-align:left;float:left'>" + "తిథి " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" +": &nbsp;"+ records.get(clickedDate).Thidi + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "వారము " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Week + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "నక్షత్రం " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Nakshatram + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "యోగం " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Yogam + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "కరణం " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Karanam + "</div>"+"</span>" +"<br>" +
                    "<span style='color:#d31d8c'>"+
                    "<div style='width:26%;text-align:left;float:left'>" + "రాహుకాలం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" +":&nbsp;"+ records.get(clickedDate).Rahuv + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "యమగండము" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Yama + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "వర్జ్యం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Varjyam + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "గుళికా " + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Gulika + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "దుర్ముహుర్తం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Dhurmuhurth + "</div>"+"</span>" +"<br>" +

                    "<div style='color:#0F1970;font-weight:bold;margin-top:7px;text-align:center;font-size:17;font-family: sree;'>" +
                    "* &nbsp; " +festival +"&nbsp; *" +"<br>"+ "</div>" +
                    "</body></html>";

        }else
        {
            changed = false;
            htmlData = "<html><style type='text/css'>@font-face { font-family: sree; src: url('fonts/sree.ttf'); } body p {font-family: sree;}</style><head><meta name='viewport' user-scalable=no' /></head><body align='center' style='padding: 0' >" +
                    "<div style='color:#0F1970;text-align:center;font-size:19;font-family: sree;'>"+  dateFormat+ "</div>" +

                    "<div style='font-weight:bold;text-align:left;margin-left:10px;line-height:1.5;font-size:15;font-family: sree;'>" +
                    "<span style='color:#006600'>"+
                    "<div style='width:20%;text-align:left;float:left'>" + "తిథి " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" +": &nbsp;"+ records.get(clickedDate).Thidi + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "వారము " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Week + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "నక్షత్రం" + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Nakshatram + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "యోగం " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Yogam + "</div>" +"<br>" +
                    "<div style='width:20%;text-align:left;float:left'>" + "కరణం " + "</div>" +
                    "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;"+records.get(clickedDate).Karanam + "</div>"+"</span>" +"<br>" +
                    "<span style='color:#d31d8c'>"+
                    "<div style='width:26%;text-align:left;float:left'>" + "రాహుకాలం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" +":&nbsp;"+ records.get(clickedDate).Rahuv + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "యమగండము" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Yama + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "వర్జ్యం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Varjyam + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "గుళికా " + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Gulika + "</div>" +"<br>" +
                    "<div style='width:26%;text-align:left;float:left'>" + "దుర్ముహుర్తం" + "</div>" +
                    "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;"+records.get(clickedDate).Dhurmuhurth + "</div>"+"</span>" +"<br>" +

                    "<div style='color:#0F1970;font-weight:bold;margin-top:7px;text-align:center;font-size:17;font-family: sree;'>" +
                    "* &nbsp;" +festival +"&nbsp; *" +"<br>"+ "</div>" +

                    "</body></html>";
        }
        mywebView.setBackgroundColor(Color.TRANSPARENT);
//        sunrise.setText(records.get(clickedDate).Sunrise);
//        sunset.setText(records.get(clickedDate).Sunset);
//        moonrise.setText(records.get(clickedDate).Moonrise);
//        moonset.setText(records.get(clickedDate).Moonset);
        goodtimeText.setText(records.get(clickedDate).Paksham+" * "+records.get(clickedDate).Masam+" * "+records.get(clickedDate).Ruthu+" * "+records.get(clickedDate).Kalam);
        //Log.d(String.valueOf(goodtimeText.getText()), "printRecords:goodtimeText ");
        Log.d("PANCHANGDATA",htmlData);
        mywebView.loadDataWithBaseURL("file:///android_asset/", htmlData,"text/html","utf-8",null);
    }

    private void panchangamList(String cadate)
    {
        if (databaseHelper.getmodelPanchangamList(cadate).size() !=0){
            fl1.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            sunrise.setText(databaseHelper.getmodelPanchangamList(cadate).get(0).getSunrise());
            sunset.setText(databaseHelper.getmodelPanchangamList(cadate).get(0).getSunset());
            moonrise.setText(databaseHelper.getmodelPanchangamList(cadate).get(0).getMoonrise());
            moonset.setText(databaseHelper.getmodelPanchangamList(cadate).get(0).getMoonset());
            tvFestivalInfo.setText(databaseHelper.getmodelPanchangamList(cadate).get(0).getInfo());

            if (databaseHelper.getmodelPanchangamTabList(databaseHelper.getmodelPanchangamList(cadate).get(0).getId()).size() !=0){
                panchangamTabAdapter = new PanchangamTabAdapter(activity, databaseHelper.getmodelPanchangamTabList(databaseHelper.getmodelPanchangamList(cadate).get(0).getId()));
                recyclerView.setAdapter(panchangamTabAdapter);

            }
            else {
                recyclerView.setVisibility(View.GONE);
            }


        }
        else {
            recyclerView.setVisibility(View.GONE);
            fl1.setVisibility(View.GONE);
            sunrise.setText("-");
            sunset.setText("-");
            moonrise.setText("-");
            moonset.setText("-");

        }


    }
}

