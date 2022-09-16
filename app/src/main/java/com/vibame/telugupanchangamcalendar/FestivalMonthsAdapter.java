package com.vibame.telugupanchangamcalendar;

import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FestivalMonthsAdapter extends RecyclerView.Adapter<FestivalMonthsAdapter.FMVH> {
    static List<FestivalMonths> fmList;
    int arClickitem = Festival_Frag.currentMonth;
    Typeface typeface;
    private int seconds = 1;
    boolean isExpandable;

    String[] monthE = {"January", "February", "March", "Aprial", "May", "June", "July", "August", "September", "October", "November", "December"};


    public FestivalMonthsAdapter(List<FestivalMonths> fmList) {
        this.fmList = fmList;
    }

    @NonNull
    @Override
    public FMVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        typeface = Typeface.createFromAsset(parent.getContext().getAssets(),"fonts/sree.ttf");
        return new FMVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FMVH holder, int position) {

        FestivalMonths festivalMonths = fmList.get(position);

        holder.fmNames.setText(festivalMonths.getMonthNames());
        holder.fmListtext.setText(festivalMonths.getFestivalsList());
        holder.addplusTxt.setText(festivalMonths.getAdPlustxt());
        holder.fmNames.setTypeface(typeface);
        holder.fmListtext.setTypeface(typeface);
        boolean isExpandable = fmList.get(position).isExpandable();
        holder.expendableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return fmList.size();
    }

    public class FMVH extends RecyclerView.ViewHolder {

        TextView fmNames,fmListtext,addplusTxt;
        LinearLayout linearLayout;
        RelativeLayout expendableLayout;

        public FMVH(@NonNull View itemView) {
            super(itemView);

            fmNames = itemView.findViewById(R.id.month_name);
            fmListtext = itemView.findViewById(R.id.festivalList);
            addplusTxt = itemView.findViewById(R.id.addPlus);

            linearLayout = itemView.findViewById(R.id.linerlayoutId);
            expendableLayout = itemView.findViewById(R.id.expandableId);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Log.d(String.valueOf(arClickitem)+"----"+getAdapterPosition(), "onClick: clickNumber");

                    if(arClickitem != getAdapterPosition())
                    {
                        for (int x = 0; x < fmList.size(); x++)
                        {
                            if(arClickitem == x )
                            {
                                FestivalMonths festivalMonths = fmList.get(x);
                                festivalMonths.setExpandable(!festivalMonths.isExpandable());
                                notifyItemChanged(x);
                                festivalMonths.setAdPlustxt("+");
                                break;
                            }
                        }
                        final Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(seconds>0)
                                {
                                    seconds--;
                                    handler.postDelayed(this,700);

                                }else
                                {
                                    arClickitem = getAdapterPosition();
                                    FestivalMonths festivalMonths = fmList.get(arClickitem);
                                    festivalMonths.setExpandable(!festivalMonths.isExpandable());
                                    notifyItemChanged(arClickitem);
                                    Festival_Frag.recyclerView.scrollToPosition(arClickitem);
                                    festivalMonths.setAdPlustxt("-");
                                    seconds = 1;
                                }
                            }
                        });

                    }
                }
            });
        }
    }
}
