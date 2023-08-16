package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;

public class MontliHoroscopeActivity extends AppCompatActivity {

    TextView tvHoroscopeTitle,tvRaasi,tvDescription,tvDate;

    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;
    String rasi;
    ImageView shareWhatsapp, share;


    FloatingActionButton mAddFab, mAddAlarmFab, mAddPersonFab;
    TextView addAlarmActionText, addPersonActionText;
    Boolean isAllFabsVisible;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montli_horoscope);


        activity = this;
        session = new Session(activity);



        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = findViewById(R.id.add_fab);

        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        mAddPersonFab = findViewById(R.id.add_person_fab);

        // Also register the action name text, of all the FABs.
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        addPersonActionText = findViewById(R.id.add_person_action_text);

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab.setVisibility(View.GONE);
        mAddPersonFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        addPersonActionText.setVisibility(View.GONE);

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false;

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show();
                mAddPersonFab.show();
                addAlarmActionText.setVisibility(View.VISIBLE);
                addPersonActionText.setVisibility(View.VISIBLE);

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = true;
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide();
                mAddPersonFab.hide();
                addAlarmActionText.setVisibility(View.GONE);
                addPersonActionText.setVisibility(View.GONE);

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = false;
            }
        });
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddPersonFab.setOnClickListener(
                view ->

                        convertLayoutAndShare()
        );

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab.setOnClickListener(
                view -> convertLayoutToPDFAndShareWhatsapp()

        );



        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        share=findViewById(R.id.iv_share);
        shareWhatsapp=findViewById(R.id.iv_share_whatsapp);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE)+" - "+getIntent().getStringExtra("Name"));
        raasi = getIntent().getStringExtra("Name");


        tvRaasi = findViewById(R.id.tvRaasi);
        tvDescription = findViewById(R.id.tvDescription);
        tvDate = findViewById(R.id.tvDate);

        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);


        if (raasi.equals("మేషరాశి")) {
            rasi = "Mesham";
        } else if (raasi.equals("వృషభరాశి")) {
            rasi = "Vrushabham";
        } else if (raasi.equals("మిథునరాశి")) {
            rasi = "Midhunam";
        } else if (raasi.equals("కర్కాటకరాశి")) {
            rasi = "Karkatakam";
        } else if (raasi.equals("సింహరాశి")) {
            rasi = "Simham";
        } else if (raasi.equals("కన్యారాశి")) {
            rasi = "Kanya";
        } else if (raasi.equals("తులారాశి")) {
            rasi = "Thula";
        } else if (raasi.equals("వృశ్చిక రాశి")) {
            rasi = "Vruschikam";
        } else if (raasi.equals("ధనూరాశి")) {
            rasi = "Dhanussu";
        } else if (raasi.equals("మకరరాశి")) {
            rasi = "Makaram";
        } else if (raasi.equals("కుంభరాశి")) {
            rasi = "Kumbham";
        } else if (raasi.equals("మీనరాశి")) {
            rasi = "Meenam";
        }


        shareWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertLayoutToPDFAndShareWhatsapp();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertLayoutAndShare();
            }
        });


        horoscope();


    }

    private void horoscope() {



        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.TYPE,"Monthly");
        params.put(Constant.RASI,rasi);



        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("dailyhoroscope",response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();



                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));
                        tvRaasi.setText(jsonArray.getJSONObject(0).getString("title"));
                    //    tvDate.setText("("+jsonArray.getJSONObject(0).getString("month")+")");


                        String apiMonth ;
                        apiMonth = jsonArray.getJSONObject(0).getString("month")+" - "+ year ;
                        String Month;


                        if (apiMonth == "January") {

                            Month = "జనవరి";

                        }

                        else if (apiMonth == "February") {

                            Month = "ఫిబ్రవరి";

                        }
                        else if (apiMonth == "March") {

                            Month = "మార్చి";

                        }
                        else if (apiMonth == "April") {

                            Month = "ఏప్రిల్";

                        }
                        else if (apiMonth == "May") {

                            Month = "మే";

                        }
                        else if (apiMonth == "June") {

                            Month = "జూన్";

                        }
                        else if (apiMonth == "July") {

                            Month = "జూలై";

                        }
                        else if (apiMonth == "August") {

                            Month = "ఆగస్టు";

                        }
                        else if (apiMonth == "September") {

                            Month = "సెప్టెంబర్";

                        }
                        else if (apiMonth == "October") {

                            Month = "అక్టోబర్";

                        }
                        else if (apiMonth == "November") {

                            Month = "నవంబర్";

                        }
                        else if (apiMonth == "December") {

                            Month = "డిసెంబర్";

                        }
                        else {

                            Month = "డిసెంబర్";

                        }



                        tvDate.setText( Month +" - "+ year);




                    }else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.HOROSCOPE_LIST,params,true);



    }
    private void convertLayoutToPDFAndShareWhatsapp() {
        // Get the RelativeLayout and ScrollView from the XML layout
        LinearLayout relativeLayout = findViewById(R.id.ll_monthly_horse);


        // Define the bitmap dimensions for higher resolution
        int width = relativeLayout.getWidth() * 2; // This will double the width of the bitmap
        int height = (relativeLayout.getHeight()) * 2; // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        Bitmap combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas combinedCanvas = new Canvas(combinedBitmap);
        combinedCanvas.scale(2f, 2f); // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE);

        // Draw the RelativeLayout (toolbar)
        relativeLayout.draw(combinedCanvas);

        // Translate the canvas to the ScrollView position
        combinedCanvas.translate(0, relativeLayout.getHeight());

        // Draw the ScrollView content

        try {
            // Save the Bitmap to a file
            File imageFile = new File(getExternalCacheDir(), "image.png");
            OutputStream outputStream = new FileOutputStream(imageFile);

            // Use higher compression quality for better clarity
            combinedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.flush();
            outputStream.close();

            // Convert the bitmap to PDF
            PdfDocument pdfDocument = new PdfDocument();
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(combinedBitmap.getWidth(), combinedBitmap.getHeight(), 1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
            Canvas pdfCanvas = page.getCanvas();
            pdfCanvas.drawBitmap(combinedBitmap, 0, 0, null);
            pdfDocument.finishPage(page);

            // Save the PDF to a file
            File pdfFile = new File(getExternalCacheDir(), "layout.pdf");
            OutputStream pdfOutputStream = new FileOutputStream(pdfFile);
            pdfDocument.writeTo(pdfOutputStream);
            pdfDocument.close();

            // Share the PDF using WhatsApp
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/pdf");
            shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", pdfFile));
            shareIntent.setPackage("com.whatsapp");
            startActivity(Intent.createChooser(shareIntent, "Share PDF via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convertLayoutAndShare() {
        // Get the RelativeLayout and ScrollView from the XML layout
        LinearLayout relativeLayout = findViewById(R.id.ll_monthly_horse);


        // Define the bitmap dimensions for higher resolution
        int width = relativeLayout.getWidth() * 2; // This will double the width of the bitmap
        int height = (relativeLayout.getHeight()) * 2; // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        Bitmap combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas combinedCanvas = new Canvas(combinedBitmap);
        combinedCanvas.scale(2f, 2f); // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE);

        // Draw the RelativeLayout (toolbar)
        relativeLayout.draw(combinedCanvas);

        // Translate the canvas to the ScrollView position
        combinedCanvas.translate(0, relativeLayout.getHeight());

        // Draw the ScrollView content

        try {
            // Save the Bitmap to a file
            File imageFile = new File(getExternalCacheDir(), "image.png");
            OutputStream outputStream = new FileOutputStream(imageFile);

            // Use higher compression quality for better clarity
            combinedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.flush();
            outputStream.close();

            // Convert the bitmap to PDF
            PdfDocument pdfDocument = new PdfDocument();
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(combinedBitmap.getWidth(), combinedBitmap.getHeight(), 1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
            Canvas pdfCanvas = page.getCanvas();
            pdfCanvas.drawBitmap(combinedBitmap, 0, 0, null);
            pdfDocument.finishPage(page);

            // Save the PDF to a file
            File pdfFile = new File(getExternalCacheDir(), "layout.pdf");
            OutputStream pdfOutputStream = new FileOutputStream(pdfFile);
            pdfDocument.writeTo(pdfOutputStream);
            pdfDocument.close();


            // Content you want to share

            // Create a sharing Intent
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("application/pdf");
            sharingIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", pdfFile));
            // Start the sharing activity
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}