package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.RamayanamSubMenu;

import java.util.ArrayList;


public class RamayanamSubMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<RamayanamSubMenu> ramayanamSubMenus;
    Session session;
    private boolean isFirstItem = true;


    public RamayanamSubMenuAdapter(Activity activity, ArrayList<RamayanamSubMenu> ramayanamSubMenus) {
        this.activity = activity;
        this.ramayanamSubMenus = ramayanamSubMenus;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.month_views, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final RamayanamSubMenu ramayanamSubMenu  = ramayanamSubMenus.get(position);


        session = new Session(activity);

        holder.tvTitle.setVisibility(View.GONE);

        holder.tvTitle.setText(ramayanamSubMenu.getTitle());
        holder.tvDescription.setText(ramayanamSubMenu.getDescription());












//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, RamyanamMenuActivity.class);
//                intent.putExtra(Constant.RAMAYAM_MENU,ramayanamMenu.getTitle());
//                activity.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount()
    {
        return ramayanamSubMenus.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle,tvDescription;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);


        }
    }
}
