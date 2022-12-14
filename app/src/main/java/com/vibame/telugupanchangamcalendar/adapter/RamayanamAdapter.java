package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.RamayamSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.RamyanamMenuActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import java.util.ArrayList;


public class RamayanamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Ramayanam> ramayanam;
    Session session;

    public RamayanamAdapter(ArrayList<Ramayanam> ramayanam, Activity activity) {
        this.activity = activity;
        this.ramayanam = ramayanam;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.ramayanam_view, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        session = new Session(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Ramayanam ramayanam1 = ramayanam.get(position);


        holder.tvTitle.setText(ramayanam1.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.ID,ramayanam1.getId());
                if (!session.getData(Constant.MENU).equals("")){
                    Intent intent = new Intent(activity, RamyanamMenuActivity.class);
                    intent.putExtra(Constant.RAMAYAM_MENU, ramayanam1.getTitle());
                    activity.startActivity(intent);

                }else {
                    Intent intent = new Intent(activity, RamayamSubMenuActivity.class);
                    intent.putExtra(Constant.RAMAYAM_MENU, ramayanam1.getTitle());
                    activity.startActivity(intent);
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return ramayanam.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);


        }
    }
}
