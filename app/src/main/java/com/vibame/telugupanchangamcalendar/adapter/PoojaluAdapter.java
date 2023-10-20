package com.vibame.telugupanchangamcalendar.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.PoojaluSubMenuActivity;
import com.vibame.telugupanchangamcalendar.activities.PoojaluTabActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Poojalu;

import java.util.ArrayList;


public class PoojaluAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<Poojalu> poojalus;
    Session session;
    DatabaseHelper databaseHelper;
    int count;
    String type;

    public PoojaluAdapter(Activity activity, ArrayList<Poojalu> poojalus, int coumt, String type) {
        this.activity = activity;
        this.poojalus = poojalus;
        this.count = coumt;
        this.type = type;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.round_recyculer_view, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, @SuppressLint("RecyclerView") int position) {
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Poojalu poojalu = poojalus.get(position);

        if (type.equals("home")) {
            if (position == 3) {
                holder.tvName.setText("More");
                holder.imgPoojalu.setImageDrawable(activity.getDrawable(R.drawable.more_rightward));
            }else {
                if (poojalu.getName().equals("Less")){
                    holder.tvName.setText(poojalu.getName());
                    holder.imgPoojalu.setImageDrawable(activity.getDrawable(R.drawable.more_rightward));
                }else {
                    holder.tvName.setText(poojalu.getName());
                    Glide.with(activity).load(poojalu.getImage()).placeholder(R.drawable.logo).into(holder.imgPoojalu);
                }
            }
        }else {
            if (poojalu.getName().equals("Less")){
                holder.tvName.setText(poojalu.getName());
                holder.imgPoojalu.setImageDrawable(activity.getDrawable(R.drawable.upload));
            }else {
                holder.tvName.setText(poojalu.getName());
                Glide.with(activity).load(poojalu.getImage()).placeholder(R.drawable.logo).into(holder.imgPoojalu);
            }
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 3 && count == 4) {
                    count = poojalus.size();
                    type="finish";
                    notifyDataSetChanged();
                } else {
                    if (poojalu.getName().equals("Less")){
                        count=4;
                        type="home";
                        notifyDataSetChanged();

                    }else {
                        session.setData(Constant.POOJALU_ID, poojalu.getId());
                        if (databaseHelper.getPoojaluTabList(poojalu.getId(), "0").size() != 0) {


                            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
                            boolean isConnected = false;

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                Network network = connectivityManager.getActiveNetwork();
                                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                                if (capabilities != null) {
                                    isConnected = capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                                }
                            } else {
                                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                                if (networkInfo != null) {
                                    isConnected = networkInfo.isConnected() || networkInfo.isConnectedOrConnecting();
                                }
                            }

                            if (isConnected) {
                                Intent intent = new Intent(activity, PoojaluTabActivity.class);
                                intent.putExtra(Constant.SUBCATEGORY_ID, "0");
                                intent.putExtra(Constant.TITLE, poojalu.getName());
                                activity.startActivity(intent);
                            } else {

                                Toast.makeText(activity, "మీ ఇంటర్నెట్ ని ఒకసారి చెక్ చేయండి !", Toast.LENGTH_SHORT).show();

                            }




                        } else {


                            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
                            boolean isConnected = false;

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                Network network = connectivityManager.getActiveNetwork();
                                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                                if (capabilities != null) {
                                    isConnected = capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                                }
                            } else {
                                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                                if (networkInfo != null) {
                                    isConnected = networkInfo.isConnected() || networkInfo.isConnectedOrConnecting();
                                }
                            }

                            if (isConnected) {
                                Intent intent = new Intent(activity, PoojaluSubMenuActivity.class);
                                intent.putExtra(Constant.TITLE, poojalu.getName());
                                intent.putExtra(Constant.ID, poojalu.getId());
                                activity.startActivity(intent);
                            } else {
                                Toast.makeText(activity, "మీ ఇంటర్నెట్ ని ఒకసారి చెక్ చేయండి !", Toast.LENGTH_SHORT).show();
                            }



                        }
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return count;
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        ImageView imgPoojalu;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgPoojalu = itemView.findViewById(R.id.image);
            tvName = itemView.findViewById(R.id.tvTitle);
        }
    }
}
