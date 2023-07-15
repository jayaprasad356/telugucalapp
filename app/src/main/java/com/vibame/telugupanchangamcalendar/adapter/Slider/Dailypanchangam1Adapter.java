package com.vibame.telugupanchangamcalendar.adapter.Slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.vibame.telugupanchangamcalendar.Dailypanchangam1Activity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.DailyModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Dailypanchangam1Adapter extends PagerAdapter {
    private Context mContext;
    private List<DailyModel> mDailyModels;
    private static final int LOOP_COUNT = 1000; // Number of times to repeat the slides

    public Dailypanchangam1Adapter(Context context, List<DailyModel> dailyModels) {
        mContext = context;
        mDailyModels = dailyModels;
    }

    @Override
    public int getCount() {
        if (mDailyModels != null) {
            return mDailyModels.size() * LOOP_COUNT;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View slideLayout = inflater.inflate(R.layout.daily_layout, container, false);

        DailyModel dailyModel = mDailyModels.get(position % mDailyModels.size());

        TextView tvDate, tvDate1, tvtext1, tvtext2, tvtext3, tvtext4, tvtext5, tvtext6, tvSunrise, tvSunset, tvMoonRise, tvMoonset, tvFestival;
        TextView tvThithi, TVNakshathram, tvYogam, tvKaranam, tvAbhijithMuhurtham, tvBhramaMuhurtham, tvAmruthaKalam, tvRahukalam, tvYamagandam, tvDhurmuhurtham, tvVarjyam, tvGulika;
        TextView tvhc1, tvhc2, tvhc3, tvhc4, tvhc5, tvhc6, tvhc7, tvhc8, tvhc9, tvhc10, tvhc11, tvhc12;
        CardView arrowright, arrowleft, cal_card;
        ImageButton ivArrowRight, ivArrowLeft;



        tvDate = slideLayout.findViewById(R.id.tvDate);
        tvDate1 = slideLayout.findViewById(R.id.tvDate1);
        tvtext1 = slideLayout.findViewById(R.id.tvtext1);
        tvtext2 = slideLayout.findViewById(R.id.tvtext2);
        tvtext3 = slideLayout.findViewById(R.id.tvtext3);
        tvtext4 = slideLayout.findViewById(R.id.tvtext4);
        tvtext5 = slideLayout.findViewById(R.id.tvtext5);
        tvtext6 = slideLayout.findViewById(R.id.tvtext6);
        tvSunrise = slideLayout.findViewById(R.id.tvSunrise);
        tvSunset = slideLayout.findViewById(R.id.tvSunset);
        tvMoonRise = slideLayout.findViewById(R.id.tvMoonrise);
        tvMoonset = slideLayout.findViewById(R.id.tvMoonset);
        tvFestival = slideLayout.findViewById(R.id.tvFestival);
        tvThithi = slideLayout.findViewById(R.id.tvTithi);
        TVNakshathram = slideLayout.findViewById(R.id.tvNakshatra);
        tvYogam = slideLayout.findViewById(R.id.tvYoga);
        tvKaranam = slideLayout.findViewById(R.id.tvKarana);
        tvAbhijithMuhurtham = slideLayout.findViewById(R.id.tvAbhijitMuhurta);
        tvBhramaMuhurtham = slideLayout.findViewById(R.id.tvBrahmamuhurta);
        tvAmruthaKalam = slideLayout.findViewById(R.id.tvAmritakalam);
        tvRahukalam = slideLayout.findViewById(R.id.tvRahukalam);
        tvYamagandam = slideLayout.findViewById(R.id.tvYamagandam);
        tvDhurmuhurtham = slideLayout.findViewById(R.id.tvDurMuhurtham);
        tvVarjyam = slideLayout.findViewById(R.id.tvVarjyam);
        tvGulika = slideLayout.findViewById(R.id.tvGulikaKalam);
        tvhc1 = slideLayout.findViewById(R.id.tvhc1);
        tvhc2 = slideLayout.findViewById(R.id.tvhc2);
        tvhc3 = slideLayout.findViewById(R.id.tvhc3);
        tvhc4 = slideLayout.findViewById(R.id.tvhc4);
        tvhc5 = slideLayout.findViewById(R.id.tvhc5);
        tvhc6 = slideLayout.findViewById(R.id.tvhc6);
        tvhc7 = slideLayout.findViewById(R.id.tvhc7);
        tvhc8 = slideLayout.findViewById(R.id.tvhc8);
        tvhc9 = slideLayout.findViewById(R.id.tvhc9);
        tvhc10 = slideLayout.findViewById(R.id.tvhc10);
        tvhc11 = slideLayout.findViewById(R.id.tvhc11);
        tvhc12 = slideLayout.findViewById(R.id.tvhc12);



        Date date = new Date();

        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Format the date using the SimpleDateFormat object
        String formattedDate = dateFormat.format(date);


        tvDate.setText(dailyModel.getDate());
        tvDate1.setText(dailyModel.getDate());
        tvtext1.setText(dailyModel.getText1());
        tvtext2.setText(dailyModel.getText2());
        tvtext3.setText(dailyModel.getText3());
        tvtext4.setText(dailyModel.getText4());
        tvtext5.setText(dailyModel.getText5());
        tvtext6.setText(dailyModel.getText6());
        tvSunrise.setText(dailyModel.getSunrise());
        tvSunset.setText(dailyModel.getSunset());
        tvMoonRise.setText(dailyModel.getMoonrise());
        tvMoonset.setText(dailyModel.getMoonset());
        tvFestival.setText(dailyModel.getFestivals());
        tvThithi.setText(dailyModel.getThidhi());
        TVNakshathram.setText(dailyModel.getNakshatram());
        tvYogam.setText(dailyModel.getYogam());
        tvKaranam.setText(dailyModel.getKaranam());
        tvAbhijithMuhurtham.setText(dailyModel.getAbhijithMuhurtham());
        tvBhramaMuhurtham.setText(dailyModel.getBhramaMuhurtham());
        tvAmruthaKalam.setText(dailyModel.getAmruthaKalam());
        tvRahukalam.setText(dailyModel.getRahukalam());
        tvYamagandam.setText(dailyModel.getYamakandam());
        tvDhurmuhurtham.setText(dailyModel.getDhurmuhurtham());
        tvVarjyam.setText(dailyModel.getVarjyam());
        tvGulika.setText(dailyModel.getGulika());
        tvhc1.setText(dailyModel.getHc1());
        tvhc2.setText(dailyModel.getHc2());
        tvhc3.setText(dailyModel.getHc3());
        tvhc4.setText(dailyModel.getHc4());
        tvhc5.setText(dailyModel.getHc5());
        tvhc6.setText(dailyModel.getHc6());
        tvhc7.setText(dailyModel.getHc7());
        tvhc8.setText(dailyModel.getHc8());
        tvhc9.setText(dailyModel.getHc9());
        tvhc10.setText(dailyModel.getHc10());
        tvhc11.setText(dailyModel.getHc11());
        tvhc12.setText(dailyModel.getHc12());

        arrowleft = slideLayout.findViewById(R.id.arrowleft);
        arrowright = slideLayout.findViewById(R.id.arrowright);
        ivArrowLeft = slideLayout.findViewById(R.id.ivArrowLeft);
        ivArrowRight = slideLayout.findViewById(R.id.ivArrowRight);
        cal_card = slideLayout.findViewById(R.id.cal_card);

        // call the mViewPager in Dailypanchangam1Activity




        arrowleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // call fuction Dailypanchagam1 activty
                ((Dailypanchangam1Activity) mContext).previousDay();

            }
        });
        arrowright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call fuction Dailypanchagam1 activty
                ((Dailypanchangam1Activity) mContext).nextDay();

            }
        });
        ivArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call fuction Dailypanchagam1 activty
                ((Dailypanchangam1Activity) mContext).previousDay();

            }
        });
        ivArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call fuction Dailypanchagam1 activty
                ((Dailypanchangam1Activity) mContext).nextDay();

            }
        });

        cal_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call fuction Dailypanchagam1 activty
                ((Dailypanchangam1Activity) mContext).showCalendar();

            }
        });


        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setSlideList(List<DailyModel> dailyModels) {
        mDailyModels = dailyModels;
        notifyDataSetChanged();
    }

    public DailyModel getSlideModel(int position) {
        if (mDailyModels != null && !mDailyModels.isEmpty()) {
            int realPosition = position % mDailyModels.size();
            return mDailyModels.get(realPosition);
        }
        return null;
    }


}

