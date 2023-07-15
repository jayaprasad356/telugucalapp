package com.vibame.telugupanchangamcalendar.adapter;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KolathaluAdapter extends RecyclerView.Adapter<KolathaluAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Kolathalu> kolathalus;

    public KolathaluAdapter(Activity activity, ArrayList<Kolathalu> kolathalus) {
        this.kolathalus = kolathalus;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.kolathalu_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String id = kolathalus.get(position).getId();
        String kolathalu_id = kolathalus.get(position).getKolathalu_id();


        holder.title.setText(kolathalus.get(position).getTitle());
//        holder.subtitle1.setText(kolathalus.get(position).getSub_title());
//        holder.subdescription1.setText(kolathalus.get(position).getSub_description());



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.rcView.setLayoutManager(linearLayoutManager);





        variant(holder.rcView, position);

    }

    private void variant(RecyclerView rcView, int position) {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.KOLATHALU, "1");

        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(position);
                        JSONArray files = jsonarray2.getJSONArray(Constant.KOLATHALU_VARIANT);

                        Log.d("variant", jsonArray.toString());
                        Gson g = new Gson();
                        ArrayList<Kolathalu> kolathalus = new ArrayList<>();

                        for (int i = 0; i < files.length(); i++) {
                            JSONObject jsonObject1 = files.getJSONObject(i);
                            Log.d("Varine", jsonObject1.toString());

                            if (jsonObject1 != null) {
                                Kolathalu group = g.fromJson(jsonObject1.toString(), Kolathalu.class);
                                kolathalus.add(group);
                            } else {
                                break;
                            }
                        }


                        KolathaluVariantAdapter adapter = new KolathaluVariantAdapter(activity, kolathalus);
                        rcView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.TELUGU_SAMKRUTHAM_URL, params, true);



    }





    @Override
    public int getItemCount() {
        return kolathalus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
       public  RecyclerView rcView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.rcView = itemView.findViewById(R.id.rcView);

//            this.subtitle1 = itemView.findViewById(R.id.sub_title1);
//            this.subdescription1 = itemView.findViewById(R.id.sub_description_1a);
//            this.card_view = itemView.findViewById(R.id.card_view);


        }
    }



}
