package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.DailyModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class DailyPanchangamActivity extends AppCompatActivity implements SwipeableScrollView.SwipeListener {

    TextView tvDate, tvDate1, tvtext1, tvtext2, tvtext3, tvtext4, tvtext5, tvtext6, tvSunrise, tvSunset, tvMoonRise, tvMoonset, tvFestival;
    TextView tvThithi, TVNakshathram, tvYogam, tvKaranam, tvAbhijithMuhurtham, tvBhramaMuhurtham, tvAmruthaKalam, tvRahukalam, tvYamagandam, tvDhurmuhurtham, tvVarjyam, tvGulika;
    TextView tvhc1, tvhc2, tvhc3, tvhc4, tvhc5, tvhc6, tvhc7, tvhc8, tvhc9, tvhc10, tvhc11, tvhc12;
    CardView arrowright, arrowleft, cal_card;
    ImageButton ivArrowRight, ivArrowLeft;
    Activity activity;
    Session session;
    Calendar calendar;
    Calendar targetCalendar, startCalendar;
    String dateString;
    String currentMonth;
    String[] monthNames;
    int monthIndex;
    DatabaseHelper databaseHelper;


    private ConstraintLayout relativeLayout;
    private SwipeableScrollView scrollView;


    ImageView shareWhatsapp, share;
    LinearLayout llRefresh;

    private final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (e1.getX() < e2.getX()) {
                    // Swipe right
                    onSwipeRight();
                } else {
                    // Swipe left
                    onSwipeLeft();
                }
                return true;
            }
            return false;
        }
    });


    FloatingActionButton mAddFab, mAddAlarmFab, mAddPersonFab;

    // These are taken to make visible and invisible along with FABs
    TextView addAlarmActionText, addPersonActionText;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_panchangam);

        activity = this;
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        tvDate = findViewById(R.id.tvDate);
        tvDate1 = findViewById(R.id.tvDate1);
        arrowright = findViewById(R.id.arrowright);
        arrowleft = findViewById(R.id.arrowleft);
        ivArrowRight = findViewById(R.id.ivArrowRight);
        ivArrowLeft = findViewById(R.id.ivArrowLeft);
        relativeLayout = findViewById(R.id.slider);
        tvtext1 = findViewById(R.id.tvtext1);
        tvtext2 = findViewById(R.id.tvtext2);
        tvtext3 = findViewById(R.id.tvtext3);
        tvtext4 = findViewById(R.id.tvtext4);
        tvtext5 = findViewById(R.id.tvtext5);
        tvtext6 = findViewById(R.id.tvtext6);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvSunset = findViewById(R.id.tvSunset);
        tvMoonRise = findViewById(R.id.tvMoonrise);
        tvMoonset = findViewById(R.id.tvMoonset);
        tvFestival = findViewById(R.id.tvFestival);
        tvThithi = findViewById(R.id.tvTithi);
        TVNakshathram = findViewById(R.id.tvNakshatra);
        tvYogam = findViewById(R.id.tvYoga);
        tvKaranam = findViewById(R.id.tvKarana);
        tvAbhijithMuhurtham = findViewById(R.id.tvAbhijitMuhurta);
        tvBhramaMuhurtham = findViewById(R.id.tvBrahmamuhurta);
        tvAmruthaKalam = findViewById(R.id.tvAmritakalam);
        tvRahukalam = findViewById(R.id.tvRahukalam);
        tvYamagandam = findViewById(R.id.tvYamagandam);
        tvDhurmuhurtham = findViewById(R.id.tvDurMuhurtham);
        tvVarjyam = findViewById(R.id.tvVarjyam);
        tvGulika = findViewById(R.id.tvGulikaKalam);
        tvhc1 = findViewById(R.id.tvhc1);
        tvhc2 = findViewById(R.id.tvhc2);
        tvhc3 = findViewById(R.id.tvhc3);
        tvhc4 = findViewById(R.id.tvhc4);
        tvhc5 = findViewById(R.id.tvhc5);
        tvhc6 = findViewById(R.id.tvhc6);
        tvhc7 = findViewById(R.id.tvhc7);
        tvhc8 = findViewById(R.id.tvhc8);
        tvhc9 = findViewById(R.id.tvhc9);
        tvhc10 = findViewById(R.id.tvhc10);
        tvhc11 = findViewById(R.id.tvhc11);
        tvhc12 = findViewById(R.id.tvhc12);
        cal_card = findViewById(R.id.cal_card);
        shareWhatsapp = findViewById(R.id.shareWhatsapp);
        share = findViewById(R.id.share);
        llRefresh = findViewById(R.id.llRefresh);


        llRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DailyPanchangamActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_top_right, R.anim.slide_out_bottom_left);
                finish();
            }
        });

        shareWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convertLayoutToPDFAndShare();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertLayoutAndShare();
            }
        });


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

                view -> convertLayoutAndShare()

        );

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab.setOnClickListener(
                view ->
                        convertLayoutToPDFAndShare()


        );


        scrollView = findViewById(R.id.scroll_view);
        scrollView.setSwipeListener(this);


        targetCalendar = Calendar.getInstance();
        targetCalendar.set(Calendar.YEAR, 2024);
        targetCalendar.set(Calendar.MONTH, Calendar.APRIL);
        targetCalendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar = Calendar.getInstance();
        updateUI(calendar.getTime());

        int year = calendar.get(Calendar.YEAR);
        monthIndex = calendar.get(Calendar.MONTH);
        monthNames = new DateFormatSymbols().getMonths();
        currentMonth = monthNames[monthIndex];


        startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, Calendar.MARCH);
        startCalendar.set(Calendar.YEAR, 2023);
        startCalendar.set(Calendar.DAY_OF_MONTH, 22);


        cal_card.setOnClickListener(v -> {
            Intent intent = new Intent(activity, MontlyActivity.class);
            intent.putExtra("year", year);
            intent.putExtra("month", monthIndex);
            startActivity(intent);
        });


        arrowright.setOnClickListener(v -> {

            forward();

        });
        arrowleft.setOnClickListener(v -> {

            backward();


        });
        ivArrowLeft.setOnClickListener(v -> {
            backward();
        });
        ivArrowRight.setOnClickListener(v -> {
            forward();
        });


    }

    private void panchangamlist(String date) {


        ArrayList<DailyModel> dailyModels = databaseHelper.getDailyPanchangam(date);

        DailyModel dailyModel = dailyModels.get(0);


        tvtext1.setText(dailyModel.getText1());
        tvtext2.setText(dailyModel.getText2());
        tvtext3.setText(dailyModel.getText3());
        tvtext4.setText(dailyModel.getText4());
        tvtext5.setText(dailyModel.getText5());
        tvtext6.setText(dailyModel.getText6());
        tvSunrise.setText(dailyModel.getSunrise());
        tvSunset.setText(dailyModel.getSunset());
        tvMoonRise.setText(dailyModel.getMoonrise());
        tvMoonset.setText(dailyModel.getMoonset());
        tvFestival.setText(dailyModel.getFestivals());
        tvThithi.setText(dailyModel.getThidhi());
        TVNakshathram.setText(dailyModel.getNakshatram());
        tvYogam.setText(dailyModel.getYogam());
        tvKaranam.setText(dailyModel.getKaranam());
        tvAbhijithMuhurtham.setText(dailyModel.getAbhijithMuhurtham());
        tvBhramaMuhurtham.setText(dailyModel.getBhramaMuhurtham());
        tvAmruthaKalam.setText(dailyModel.getAmruthaKalam());
        tvRahukalam.setText(dailyModel.getRahukalam());
        tvYamagandam.setText(dailyModel.getYamakandam());
        tvDhurmuhurtham.setText(dailyModel.getDhurmuhurtham());
        tvVarjyam.setText(dailyModel.getVarjyam());
        tvGulika.setText(dailyModel.getGulika());
        tvhc1.setText(dailyModel.getHc1());
        tvhc2.setText(dailyModel.getHc2());
        tvhc3.setText(dailyModel.getHc3());
        tvhc4.setText(dailyModel.getHc4());
        tvhc5.setText(dailyModel.getHc5());
        tvhc6.setText(dailyModel.getHc6());
        tvhc7.setText(dailyModel.getHc7());
        tvhc8.setText(dailyModel.getHc8());
        tvhc9.setText(dailyModel.getHc9());
        tvhc10.setText(dailyModel.getHc10());
        tvhc11.setText(dailyModel.getHc11());
        tvhc12.setText(dailyModel.getHc12());


    }

    @SuppressLint("ResourceType")
    private void backward() {


        if (calendar.after(startCalendar)) {

            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));


            int year = calendar.get(Calendar.YEAR);
            monthIndex = calendar.get(Calendar.MONTH);
            monthNames = new DateFormatSymbols().getMonths();
            currentMonth = monthNames[monthIndex];
            // move the calendar one day back the date

            calendar.add(Calendar.DAY_OF_YEAR, -1);

            updateUI(calendar.getTime());

        }


//
//            arrowleft.setEnabled(false);
//            ivArrowLeft.setEnabled(false);


    }

    @SuppressLint("ResourceType")
    private void forward() {


        if (calendar.before(targetCalendar)) {
            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));
            // Move the calendar one day forward
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            int year = calendar.get(Calendar.YEAR);
            monthIndex = calendar.get(Calendar.MONTH);
            monthNames = new DateFormatSymbols().getMonths();
            currentMonth = monthNames[monthIndex];
            // Update your UI with the new date
            updateUI(calendar.getTime());


        }
    }


    private void updateUI(Date date) {
        // Format the date as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateString = dateFormat.format(date);

        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
        tvDate.setText(dateString.toString());
        tvDate1.setText(dateString.toString());

        String Date = dateFormat.format(date);


        panchangamlist(convertDateFormat(Date));

        arrowleft.setEnabled(true);
        ivArrowLeft.setEnabled(true);

    }

    public static String convertDateFormat(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null in case of any parsing errors
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void onSwipeLeft() {
        // Handle swipe left

        forward();
    }

    public void onSwipeRight() {
        // Handle swipe right
        backward();
    }


    @Override
    public void onBackPressed() {
        // Add your desired behavior here

        // Call super.onBackPressed() to allow the default back button behavior (finishing the activity)
        super.onBackPressed();
    }


    private void convertLayoutToPDFAndShare() {
        // Get the RelativeLayout and ScrollView from the XML layout
        RelativeLayout relativeLayout = findViewById(R.id.toolbar);
        SwipeableScrollView scrollView = findViewById(R.id.scroll_view);

        // Measure the full content height of the ScrollView
        int totalHeight = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            totalHeight += scrollView.getChildAt(i).getHeight();
        }

        // Define the bitmap dimensions for higher resolution
        int width = relativeLayout.getWidth() * 2; // This will double the width of the bitmap
        int height = (relativeLayout.getHeight() + totalHeight) * 2; // This will double the height of the bitmap

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
        RelativeLayout relativeLayout = findViewById(R.id.toolbar);
        SwipeableScrollView scrollView = findViewById(R.id.scroll_view);

        // Measure the full content height of the ScrollView
        int totalHeight = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            totalHeight += scrollView.getChildAt(i).getHeight();
        }

        // Define the bitmap dimensions for higher resolution
        int width = relativeLayout.getWidth() * 2; // This will double the width of the bitmap
        int height = (relativeLayout.getHeight() + totalHeight) * 2; // This will double the height of the bitmap

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


//    private void convertLayoutToImageAndShare() {
//        // Get the ScrollView from the XML layout
//        SwipeableScrollView scrollView = findViewById(R.id.scroll_view);
//
//        // Measure the full content height of the ScrollView
//        int totalHeight = 0;
//        for (int i = 0; i < scrollView.getChildCount(); i++) {
//            totalHeight += scrollView.getChildAt(i).getHeight();
//        }
//
//        // Create a bitmap for the full content of the ScrollView
//        Bitmap fullContentBitmap = Bitmap.createBitmap(scrollView.getWidth(), totalHeight, Bitmap.Config.ARGB_8888);
//        Canvas fullContentCanvas = new Canvas(fullContentBitmap);
//        scrollView.draw(fullContentCanvas);
//
//        try {
//            // Save the Bitmap to a file
//            File file = new File(getExternalCacheDir(), "image.png");
//            OutputStream outputStream = new FileOutputStream(file);
//            fullContentBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//            // Share the image using WhatsApp
//            Intent shareIntent = new Intent(Intent.ACTION_SEND);
//            shareIntent.setType("image/*");
//            shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file));
//            shareIntent.setPackage("com.whatsapp");
//            startActivity(Intent.createChooser(shareIntent, "Share image via"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void convertLayoutToImageAndShare() {
//// Get the RelativeLayout and ScrollView from the XML layout
//        RelativeLayout relativeLayout = findViewById(R.id.toolbar);
//        SwipeableScrollView scrollView = findViewById(R.id.scroll_view);
//
//// Measure the full content height of the ScrollView
//        int totalHeight = 0;
//        for (int i = 0; i < scrollView.getChildCount(); i++) {
//            totalHeight += scrollView.getChildAt(i).getHeight();
//        }
//
//// Define the bitmap dimensions for higher resolution
//        int width = relativeLayout.getWidth() * 2; // This will double the width of the bitmap
//        int height = (relativeLayout.getHeight() + totalHeight) * 2; // This will double the height of the bitmap
//
//// Create a bitmap with the desired dimensions and scale
//        Bitmap combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        Canvas combinedCanvas = new Canvas(combinedBitmap);
//        combinedCanvas.scale(2f, 2f); // This will scale the canvas by 2x
//
//// Draw a white background
//        combinedCanvas.drawColor(Color.WHITE);
//
//// Draw the RelativeLayout (toolbar)
//        relativeLayout.draw(combinedCanvas);
//
//// Translate the canvas to the ScrollView position
//        combinedCanvas.translate(0, relativeLayout.getHeight());
//
//// Draw the ScrollView content
//        scrollView.draw(combinedCanvas);
//
//        try {
//            // Save the Bitmap to a file
//            File file = new File(getExternalCacheDir(), "image.png");
//            OutputStream outputStream = new FileOutputStream(file);
//
//            // Use higher compression quality for better clarity
//            combinedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//
//            outputStream.flush();
//            outputStream.close();
//
//            // Share the image using WhatsApp
//            Intent shareIntent = new Intent(Intent.ACTION_SEND);
//            shareIntent.setType("image/*");
//            shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file));
//            shareIntent.setPackage("com.whatsapp");
//            startActivity(Intent.createChooser(shareIntent, "Share image via"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }