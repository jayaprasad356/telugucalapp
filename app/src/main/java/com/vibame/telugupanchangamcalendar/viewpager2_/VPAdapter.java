package com.vibame.telugupanchangamcalendar.viewpager2_;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    int startPosition;

    public VPAdapter(ArrayList<ViewPagerItem> viewPagerItemArrayList) {
        this.viewPagerItemArrayList = viewPagerItemArrayList;
        this.startPosition = startPosition;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int adjustedPosition = (position + startPosition) % viewPagerItemArrayList.size();
        ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(adjustedPosition);

        holder.imageView.setImageResource(viewPagerItem.imageID);
        holder.tcHeading.setText(viewPagerItem.heading);
        holder.tvDesc.setText(viewPagerItem.description);


        holder.tvtext1.setText(viewPagerItem.getText1());
        holder.tvtext2.setText(viewPagerItem.getText2());
        holder.tvtext3.setText(viewPagerItem.getText3());
        holder.tvtext4.setText(viewPagerItem.getText4());
        holder.tvtext5.setText(viewPagerItem.getText5());
        holder.tvtext6.setText(viewPagerItem.getText6());
        holder.tvSunrise.setText(viewPagerItem.getSunrise());
        holder.tvSunset.setText(viewPagerItem.getSunset());
        holder.tvMoonRise.setText(viewPagerItem.getMoonrise());
        holder.tvMoonset.setText(viewPagerItem.getMoonset());
        holder.tvFestival.setText(viewPagerItem.getFestivals());
        holder.tvThithi.setText(viewPagerItem.getThidhi());
        holder.TVNakshathram.setText(viewPagerItem.getNakshatram());
        holder.tvYogam.setText(viewPagerItem.getYogam());
        holder.tvKaranam.setText(viewPagerItem.getKaranam());
        holder.tvAbhijithMuhurtham.setText(viewPagerItem.getAbhijithMuhurtham());
        holder.tvBhramaMuhurtham.setText(viewPagerItem.getBhramaMuhurtham());
        holder.tvAmruthaKalam.setText(viewPagerItem.getAmruthaKalam());
        holder.tvRahukalam.setText(viewPagerItem.getRahukalam());
        holder.tvYamagandam.setText(viewPagerItem.getYamakandam());
        holder.tvDhurmuhurtham.setText(viewPagerItem.getDhurmuhurtham());
        holder.tvVarjyam.setText(viewPagerItem.getVarjyam());
        holder.tvGulika.setText(viewPagerItem.getGulika());
        holder.tvhc1.setText(viewPagerItem.getHc1());
        holder.tvhc2.setText(viewPagerItem.getHc2());
        holder.tvhc3.setText(viewPagerItem.getHc3());
        holder.tvhc4.setText(viewPagerItem.getHc4());
        holder.tvhc5.setText(viewPagerItem.getHc5());
        holder.tvhc6.setText(viewPagerItem.getHc6());
        holder.tvhc7.setText(viewPagerItem.getHc7());
        holder.tvhc8.setText(viewPagerItem.getHc8());
        holder.tvhc9.setText(viewPagerItem.getHc9());
        holder.tvhc10.setText(viewPagerItem.getHc10());
        holder.tvhc11.setText(viewPagerItem.getHc11());
        holder.tvhc12.setText(viewPagerItem.getHc12());


    }

    @Override
    public int getItemCount() {
        return 1000;  // Total number of items
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tcHeading, tvDesc;
        TextView tvtext1,tvtext2,tvtext3,tvtext4,tvtext5,tvtext6,tvSunrise,tvSunset,tvMoonRise,tvMoonset,tvFestival,tvThithi,TVNakshathram,tvYogam,tvKaranam,tvAbhijithMuhurtham,tvBhramaMuhurtham,tvAmruthaKalam,tvRahukalam,tvYamagandam,tvDhurmuhurtham,tvVarjyam,tvGulika,tvhc1,tvhc2,tvhc3,tvhc4,tvhc5,tvhc6,tvhc7,tvhc8,tvhc9,tvhc10,tvhc11,tvhc12;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivimage);
            tcHeading = itemView.findViewById(R.id.tvHeading);
            tvDesc = itemView.findViewById(R.id.tvDesc);

            tvtext1 = itemView.findViewById(R.id.tvtext1);
            tvtext2 = itemView.findViewById(R.id.tvtext2);
            tvtext3 = itemView.findViewById(R.id.tvtext3);
            tvtext4 = itemView.findViewById(R.id.tvtext4);
            tvtext5 = itemView.findViewById(R.id.tvtext5);
            tvtext6 = itemView.findViewById(R.id.tvtext6);
            tvSunrise = itemView.findViewById(R.id.tvSunrise);
            tvSunset = itemView.findViewById(R.id.tvSunset);
            tvMoonRise = itemView.findViewById(R.id.tvMoonrise);
            tvMoonset = itemView.findViewById(R.id.tvMoonset);
            tvFestival = itemView.findViewById(R.id.tvFestival);
            tvThithi = itemView.findViewById(R.id.tvTithi);
            TVNakshathram = itemView.findViewById(R.id.tvNakshatra);
            tvYogam = itemView.findViewById(R.id.tvYoga);
            tvKaranam = itemView.findViewById(R.id.tvKarana);
            tvAbhijithMuhurtham = itemView.findViewById(R.id.tvAbhijitMuhurta);
            tvBhramaMuhurtham = itemView.findViewById(R.id.tvBrahmamuhurta);
            tvAmruthaKalam = itemView.findViewById(R.id.tvAmritakalam);
            tvRahukalam = itemView.findViewById(R.id.tvRahukalam);
            tvYamagandam = itemView.findViewById(R.id.tvYamagandam);
            tvDhurmuhurtham = itemView.findViewById(R.id.tvDurMuhurtham);
            tvVarjyam = itemView.findViewById(R.id.tvVarjyam);
            tvGulika = itemView.findViewById(R.id.tvGulikaKalam);
            tvhc1 = itemView.findViewById(R.id.tvhc1);
            tvhc2 = itemView.findViewById(R.id.tvhc2);
            tvhc3 = itemView.findViewById(R.id.tvhc3);
            tvhc4 = itemView.findViewById(R.id.tvhc4);
            tvhc5 = itemView.findViewById(R.id.tvhc5);
            tvhc6 = itemView.findViewById(R.id.tvhc6);
            tvhc7 = itemView.findViewById(R.id.tvhc7);
            tvhc8 = itemView.findViewById(R.id.tvhc8);
            tvhc9 = itemView.findViewById(R.id.tvhc9);
            tvhc10 = itemView.findViewById(R.id.tvhc10);
            tvhc11 = itemView.findViewById(R.id.tvhc11);
            tvhc12 = itemView.findViewById(R.id.tvhc12);

        }
    }
}
