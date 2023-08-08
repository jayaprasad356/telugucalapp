package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.YearlyHoroscopeAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Festival;
import com.vibame.telugupanchangamcalendar.model.YearlyHoroscope;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class YearlyHoroscopeActivity extends AppCompatActivity {


    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;
    YearlyHoroscopeAdapter adapter;
    String rasi;


    TextView tvMainTitle ,tvMainDescription;
    TextView tvjanma_nama_nakshathram_title1,janma_nama_nakshathram_description1;
    TextView tvjanma_nama_nakshathram_title2,janma_nama_nakshathram_description2;
    TextView tvjanma_nama_nakshathram_title3,janma_nama_nakshathram_description3;
    TextView tvjanma_nama_nakshathram_title4,janma_nama_nakshathram_description4;
    TextView tvtext1,tvtext2,tvtext3,tvtext4;
   TextView graha_dhashakalamu,tvjanma_nama_nakshathram;
    TextView tvTitle,tvDescription;



    RecyclerView recycler_view;
    ImageView shareWhatsapp, share;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_horoscope);

        activity = this;
        session = new Session(activity);


        share=findViewById(R.id.iv_share);
        shareWhatsapp=findViewById(R.id.iv_share_whatsapp);
        tvMainTitle = findViewById(R.id.tvMainTitle);
        tvMainDescription = findViewById(R.id.tvMainDescription);
        tvjanma_nama_nakshathram = findViewById(R.id.tvjanma_nama_nakshathram);
        tvjanma_nama_nakshathram_title1 = findViewById(R.id.tvjanma_nama_nakshathram_title1);
        janma_nama_nakshathram_description1 = findViewById(R.id.janma_nama_nakshathram_description1);
        tvjanma_nama_nakshathram_title2 = findViewById(R.id.tvjanma_nama_nakshathram_title2);
        janma_nama_nakshathram_description2 = findViewById(R.id.janma_nama_nakshathram_description2);
        tvjanma_nama_nakshathram_title3 = findViewById(R.id.tvjanma_nama_nakshathram_title3);
        janma_nama_nakshathram_description3 = findViewById(R.id.janma_nama_nakshathram_description3);
        tvjanma_nama_nakshathram_title4 = findViewById(R.id.tvjanma_nama_nakshathram_title4);
        janma_nama_nakshathram_description4 = findViewById(R.id.janma_nama_nakshathram_description4);
        tvtext1 = findViewById(R.id.tvtext1);
        tvtext2 = findViewById(R.id.tvtext2);
        tvtext3 = findViewById(R.id.tvtext3);
        tvtext4 = findViewById(R.id.tvtext4);
      graha_dhashakalamu = findViewById(R.id.graha_dhashakalamu);
        recycler_view = findViewById(R.id.recycler_view);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recycler_view.setLayoutManager(linearLayoutManager);



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





        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);


        horoscope();
        horoscopeVarient();

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
    }

    private void horoscopeVarient() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TYPE, "Yearly");
        params.put(Constant.RASI, rasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Yearlyhoroscope", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(0);
                        JSONArray files = jsonarray2.getJSONArray(Constant.YEARLY_HOROSCOPE_VARIANT);
                        Gson g = new Gson();
                        ArrayList<YearlyHoroscope> yearlyHoroscopes = new ArrayList<>();
                        for (int i = 0; i < files.length(); i++) {
                            JSONObject jsonObject1 = files.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Log.d("Varine", jsonObject1.toString());
                                YearlyHoroscope group = g.fromJson(jsonObject1.toString(), YearlyHoroscope.class);
                                yearlyHoroscopes.add(group);
                            } else {
                                break;
                            }
                        }
                        adapter = new YearlyHoroscopeAdapter(activity, yearlyHoroscopes);
                        recycler_view.setAdapter(adapter);


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_LIST, params, true);


    }


    private void horoscope() {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TYPE, "Yearly");
        params.put(Constant.RASI, rasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Yearlyhoroscope", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(0);
                        JSONArray files = jsonarray2.getJSONArray(Constant.YEARLY_HOROSCOPE_VARIANT);

                        Gson g = new Gson();





                        tvMainTitle.setText(jsonArray.getJSONObject(0).getString("main_title"));
                        tvMainDescription.setText(jsonArray.getJSONObject(0).getString("main_description"));
                        tvjanma_nama_nakshathram.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram"));
                        tvjanma_nama_nakshathram_title1.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_title1")+" : ");
                        janma_nama_nakshathram_description1.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_description1") );
                        tvjanma_nama_nakshathram_title2.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_title2")+" : ");
                        janma_nama_nakshathram_description2.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_description2"));
                        tvjanma_nama_nakshathram_title3.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_title3")+" : ");
                        janma_nama_nakshathram_description3.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_description3"));
                        tvjanma_nama_nakshathram_title4.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_title4")+" : ");
                        janma_nama_nakshathram_description4.setText(jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_description4"));


                        if (jsonArray.getJSONObject(0).getString("janma_nama_nakshathram_title4").equals("")){
                            tvjanma_nama_nakshathram_title4.setVisibility(View.GONE);
                            janma_nama_nakshathram_description4.setVisibility(View.GONE);
                        }

                        tvtext1.setText(jsonArray.getJSONObject(0).getString("adhayam"));
                        tvtext2.setText(jsonArray.getJSONObject(0).getString("vyayam"));
                        tvtext3.setText(jsonArray.getJSONObject(0).getString("rajapujyam"));
                        tvtext4.setText(jsonArray.getJSONObject(0).getString("aavamanam"));

                      graha_dhashakalamu.setText(jsonArray.getJSONObject(0).getString("graha_dhashakalamu"));

                        tvTitle.setText(jsonArray.getJSONObject(0).getString("title"));
                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));



//                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));
//                        tvRaasi.setText(jsonArray.getJSONObject(0).getString("title"));
//                        tvtext1.setText(jsonArray.getJSONObject(0).getString("adhayam"));
//                        tvtext2.setText(jsonArray.getJSONObject(0).getString("vyayam"));
//                        tvtext3.setText(jsonArray.getJSONObject(0).getString("rajapujyam"));
//                        tvtext4.setText(jsonArray.getJSONObject(0).getString("aavamanam"));


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_LIST, params, true);


    }
    private void convertLayoutToPDFAndShareWhatsapp() {
        // Get the RelativeLayout and ScrollView from the XML layout
        ScrollView scrollView = findViewById(R.id.scroll_view);

        // Measure the full content height of the ScrollView
        int totalHeight = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            totalHeight += scrollView.getChildAt(i).getHeight();
        }

        // Define the bitmap dimensions for higher resolution
        int width = scrollView.getWidth() * 2; // This will double the width of the bitmap
        int height = ( totalHeight) * 2; // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        Bitmap combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas combinedCanvas = new Canvas(combinedBitmap);
        combinedCanvas.scale(2f, 2f); // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE);



        // Draw the ScrollView content
        scrollView.draw(combinedCanvas);

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
        ScrollView scrollView = findViewById(R.id.scroll_view);

        // Measure the full content height of the ScrollView
        int totalHeight = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            totalHeight += scrollView.getChildAt(i).getHeight();
        }

        // Define the bitmap dimensions for higher resolution
        int width = scrollView.getWidth() * 2; // This will double the width of the bitmap
        int height = ( totalHeight) * 2; // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        Bitmap combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas combinedCanvas = new Canvas(combinedBitmap);
        combinedCanvas.scale(2f, 2f); // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE);



        // Draw the ScrollView content
        scrollView.draw(combinedCanvas);


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