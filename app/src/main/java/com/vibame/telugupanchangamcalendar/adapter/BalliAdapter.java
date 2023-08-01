package com.vibame.telugupanchangamcalendar.adapter;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.BalliData;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BalliAdapter extends RecyclerView.Adapter<BalliAdapter.ViewHolder> {
    Activity activity;
    ArrayList<BalliData> balliData;


    public BalliAdapter(Activity activity, ArrayList<BalliData> balliData) {
        this.balliData = balliData;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.balli_sasthram_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.title.setText(balliData.get(position).getTitle());
        holder.description.setText(balliData.get(position).getDescription());
        holder.subTitle1.setText(balliData.get(position).getSub_title1());
        holder.subTitle2.setText(balliData.get(position).getSub_title2());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.rcView.setLayoutManager(linearLayoutManager);



        String subtitle1 = balliData.get(position).getSub_title1();
        String subtitle2 = balliData.get(position).getSub_title2();


//        Toast.makeText(activity, ""+subtitle1, Toast.LENGTH_SHORT).show();
//        Toast.makeText(activity, ""+subtitle2, Toast.LENGTH_SHORT).show();

        if (subtitle1.isEmpty() && subtitle2.isEmpty()) {

            holder.subtitle.setVisibility(View.GONE);
            holder.rcView.setVisibility(View.GONE);
            // Both subtitle1 and subtitle2 are empty for the current position
            // Do something specific for this case, if needed
        } else {
            // Subtitles are not empty for the current position

            holder.subtitle.setVisibility(View.VISIBLE);
            variant(holder.rcView, position);

        }


    }



    private void variant(RecyclerView rcView, int position) {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.BALLI_SASTHRAM, "1");

        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(position);
                        JSONArray files = jsonarray2.getJSONArray(Constant.BALLI_SASTHRAM_VARIANT);

                        Log.d("ballivariant", jsonArray.toString());
                        Gson g = new Gson();
                        ArrayList<BalliData> balliData = new ArrayList<>();

                        for (int i = 0; i < files.length(); i++) {
                            JSONObject jsonObject1 = files.getJSONObject(i);
                            Log.d("Varine", jsonObject1.toString());

                            if (jsonObject1 != null) {
                                rcView.setVisibility(View.VISIBLE);
                                BalliData group = g.fromJson(jsonObject1.toString(), BalliData.class);
                                balliData.add(group);
                            } else {
                                break;
                            }
                        }
                        BalliVariantAdapter adapter = new BalliVariantAdapter(balliData, activity);
                        rcView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.SAKUNA_SASTHRAM_URL, params, true);



    }



    @Override
    public int getItemCount() {
        return balliData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, subTitle1, subTitle2;
        private  RecyclerView rcView;
        private LinearLayout subtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.description = itemView.findViewById(R.id.tv_desc);
            this.subTitle1 = itemView.findViewById(R.id.subtitle1);
            this.subTitle2 = itemView.findViewById(R.id.subtitle2);
            this.rcView = itemView.findViewById(R.id.recycler_view);
            this.subtitle = itemView.findViewById(R.id.subtitle);


        }
    }
}
