package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.RamayamSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.RamyanamMenuActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import java.util.ArrayList;


public class RamayanamMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<RamayanamMenu> ramayanamMenus;
    Session session;


    public RamayanamMenuAdapter(ArrayList<RamayanamMenu> ramayanamMenus, Activity activity) {
        this.activity = activity;
        this.ramayanamMenus = ramayanamMenus;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.ramayanam_view2, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        session = new Session(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final RamayanamMenu ramayanamMenu = ramayanamMenus.get(position);


        holder.tvTitle.setText(ramayanamMenu.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.MENU_ID,ramayanamMenu.getId());
                Intent intent = new Intent(activity, RamayamSubMenuActivity.class);
                Log.d("RamayanamMenuAdapter", "onClick: "+ramayanamMenu.getTitle());
                intent.putExtra(Constant.RAMAYAM_MENU, ramayanamMenu.getTitle());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ramayanamMenus.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);


        }
    }
}
