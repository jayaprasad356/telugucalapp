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

public class WeeklyHoroscopeActivity extends AppCompatActivity {


    TextView tvHoroscopeTitle,tvRaasi,tvDescription,tvDate;

    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;
    String rasi;
    ImageView shareWhatsapp, share;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_horoscope);

        activity = this;
        session = new Session(activity);


        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        share=findViewById(R.id.iv_share);
        shareWhatsapp=findViewById(R.id.iv_share_whatsapp);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE)+" - "+getIntent().getStringExtra("Name"));
        raasi = getIntent().getStringExtra("Name");



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


        tvRaasi = findViewById(R.id.tvRaasi);
        tvDescription = findViewById(R.id.tvDescription);
        tvDate = findViewById(R.id.tvDate);

        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        tvDate.setText(year+" - "+ raasi);

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
        params.put(Constant.TYPE,"Weekly");
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
                       // tvDate.setText("("+jsonArray.getJSONObject(0).getString("week")+")");




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
        LinearLayout relativeLayout = findViewById(R.id.ll_weekly_horse);


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
        LinearLayout relativeLayout = findViewById(R.id.ll_weekly_horse);


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