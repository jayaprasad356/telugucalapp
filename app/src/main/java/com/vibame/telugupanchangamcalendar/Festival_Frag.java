package com.vibame.telugupanchangamcalendar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Festival_Frag extends Fragment {

    static RecyclerView recyclerView;
    static List<FestivalMonths> festivalMonthsList;
    GregorianCalendar cal_month;
    static int currentMonth;
    private Context context;

    String[] month = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};
    String[] monthE = {"January", "February", "March", "Aprial", "May", "June", "July", "August", "September", "October", "November", "December"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.festival_frag,container,false);
        //context = container.getContext();


        recyclerView = view.findViewById(R.id.recyclerId);

        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        if(cal_month.get(GregorianCalendar.YEAR) == 2022)
        {
            currentMonth = cal_month.get(GregorianCalendar.MONTH);

        }else if(cal_month.get(GregorianCalendar.YEAR) == 2023)
        {
            currentMonth = cal_month.get(GregorianCalendar.MONTH)+12;
        }


        inintData();
        setRecyclerView();
        FestivalMonthsAdapter festivalMonthsAdapter = new FestivalMonthsAdapter(festivalMonthsList);
        recyclerView.setAdapter(festivalMonthsAdapter);
        recyclerView.scrollToPosition(currentMonth);
        recyclerView.setHasFixedSize(true);
        FestivalMonths festivalMonths = FestivalMonthsAdapter.fmList.get(currentMonth);
        festivalMonths.setExpandable(!festivalMonths.isExpandable());
        festivalMonths.setAdPlustxt("-");

        return view;
    }

    private void setRecyclerView() {



    }

    private void inintData() {

        //monthData = String.valueOf(getResources().getIdentifier("January_2020","string",getActivity().getPackageName()));

        festivalMonthsList = new ArrayList<>();

        festivalMonthsList.add(new FestivalMonths("జనవరి - 2022",  getString(R.string.January_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("ఫిబ్రవరి - 2022",getString(R.string.February_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("మార్చి - 2022",getString(R.string.March_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("ఏప్రిల్ - 2022",getString(R.string.Aprial_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("మే - 2022",getString(R.string.May_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("జూన్ - 2022",getString(R.string.June_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("జూలై - 2022",getString(R.string.July_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("ఆగస్టు - 2022", getString(R.string.August_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("సెప్టెంబర్ - 2022",getString(R.string.September_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("అక్టోబర్ - 2022",getString(R.string.October_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("నవంబర్ - 2022",getString(R.string.November_2022),"+"));
        festivalMonthsList.add(new FestivalMonths("డిసెంబర్ - 2022",getString(R.string.December_2022),"+"));

        festivalMonthsList.add(new FestivalMonths("జనవరి - 2023",  getString(R.string.January_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("ఫిబ్రవరి - 2023",getString(R.string.February_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("మార్చి - 2023",getString(R.string.March_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("ఏప్రిల్ - 2023",getString(R.string.Aprial_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("మే - 2023",getString(R.string.May_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("జూన్ - 2023",getString(R.string.June_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("జూలై - 2023",getString(R.string.July_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("ఆగస్టు - 2023", getString(R.string.August_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("సెప్టెంబర్ - 2023",getString(R.string.September_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("అక్టోబర్ - 2023",getString(R.string.October_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("నవంబర్ - 2023",getString(R.string.November_2023),"+"));
        festivalMonthsList.add(new FestivalMonths("డిసెంబర్ - 2023",getString(R.string.December_2023),"+"));
    }

}
