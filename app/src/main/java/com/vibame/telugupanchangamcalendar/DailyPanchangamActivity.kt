package com.vibame.telugupanchangamcalendar

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.FileProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vibame.telugupanchangamcalendar.helper.ApiConfig
import com.vibame.telugupanchangamcalendar.helper.Constant
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper
import com.vibame.telugupanchangamcalendar.helper.Session
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DailyPanchangamActivity : AppCompatActivity(), SwipeableScrollView.SwipeListener {
    var tvDate: TextView? = null
    var tvDate1: TextView? = null
    var tvtext1: TextView? = null
    var tvtext2: TextView? = null
    var tvtext3: TextView? = null
    var tvtext4: TextView? = null
    var tvtext5: TextView? = null
    var tvtext6: TextView? = null
    var tvSunrise: TextView? = null
    var tvSunset: TextView? = null
    var tvMoonRise: TextView? = null
    var tvMoonset: TextView? = null
    var tvFestival: TextView? = null
    var tvThithi: TextView? = null
    var TVNakshathram: TextView? = null
    var tvYogam: TextView? = null
    var tvKaranam: TextView? = null
    var tvAbhijithMuhurtham: TextView? = null
    var tvBhramaMuhurtham: TextView? = null
    var tvAmruthaKalam: TextView? = null
    var tvRahukalam: TextView? = null
    var tvYamagandam: TextView? = null
    var tvDhurmuhurtham: TextView? = null
    var tvVarjyam: TextView? = null
    var tvGulika: TextView? = null
    var tvhc1: TextView? = null
    var tvhc2: TextView? = null
    var tvhc3: TextView? = null
    var tvhc4: TextView? = null
    var tvhc5: TextView? = null
    var tvhc6: TextView? = null
    var tvhc7: TextView? = null
    var tvhc8: TextView? = null
    var tvhc9: TextView? = null
    var tvhc10: TextView? = null
    var tvhc11: TextView? = null
    var tvhc12: TextView? = null
    var arrowright: CardView? = null
    var arrowleft: CardView? = null
    var cal_card: CardView? = null
    var ivArrowRight: ImageButton? = null
    var ivArrowLeft: ImageButton? = null
    var activity: Activity? = null
    var session: Session? = null
    var calendar: Calendar? = null
    var targetCalendar: Calendar? = null
    var startCalendar: Calendar? = null
    var dateString: String? = null
    var currentMonth: String? = null
    lateinit var monthNames: Array<String>
    var monthIndex = 0
    var databaseHelper: DatabaseHelper? = null
    private var relativeLayout: ConstraintLayout? = null
    private var scrollView: SwipeableScrollView? = null
    var shareWhatsapp: ImageView? = null
    var share: ImageView? = null
    var llRefresh: LinearLayout? = null

    //    private final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
    //        @Override
    //        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    //            if (Math.abs(velocityX) > Math.abs(velocityY)) {
    //                if (e1.getX() < e2.getX()) {
    //                    // Swipe right
    //                    onSwipeRight();
    //                } else {
    //                    // Swipe left
    //                    onSwipeLeft();
    //                }
    //                return true;
    //            }
    //            return false;
    //        }
    //    });
    var mAddFab: FloatingActionButton? = null
    var mAddAlarmFab: FloatingActionButton? = null
    var mAddPersonFab: FloatingActionButton? = null

    // These are taken to make visible and invisible along with FABs
    var addAlarmActionText: TextView? = null
    var addPersonActionText: TextView? = null

    // to check whether sub FAB buttons are visible or not.
    var isAllFabsVisible: Boolean? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_panchangam)
        activity = this
        session = Session(activity)
        databaseHelper = DatabaseHelper(activity)
        tvDate = findViewById(R.id.tvDate)
        tvDate1 = findViewById(R.id.tvDate1)
        arrowright = findViewById(R.id.arrowright)
        arrowleft = findViewById(R.id.arrowleft)
        ivArrowRight = findViewById(R.id.ivArrowRight)
        ivArrowLeft = findViewById(R.id.ivArrowLeft)
        relativeLayout = findViewById(R.id.slider)
        tvtext1 = findViewById(R.id.tvtext1)
        tvtext2 = findViewById(R.id.tvtext2)
        tvtext3 = findViewById(R.id.tvtext3)
        tvtext4 = findViewById(R.id.tvtext4)
        tvtext5 = findViewById(R.id.tvtext5)
        tvtext6 = findViewById(R.id.tvtext6)
        tvSunrise = findViewById(R.id.tvSunrise)
        tvSunset = findViewById(R.id.tvSunset)
        tvMoonRise = findViewById(R.id.tvMoonrise)
        tvMoonset = findViewById(R.id.tvMoonset)
        tvFestival = findViewById(R.id.tvFestival)
        tvThithi = findViewById(R.id.tvTithi)
        TVNakshathram = findViewById(R.id.tvNakshatra)
        tvYogam = findViewById(R.id.tvYoga)
        tvKaranam = findViewById(R.id.tvKarana)
        tvAbhijithMuhurtham = findViewById(R.id.tvAbhijitMuhurta)
        tvBhramaMuhurtham = findViewById(R.id.tvBrahmamuhurta)
        tvAmruthaKalam = findViewById(R.id.tvAmritakalam)
        tvRahukalam = findViewById(R.id.tvRahukalam)
        tvYamagandam = findViewById(R.id.tvYamagandam)
        tvDhurmuhurtham = findViewById(R.id.tvDurMuhurtham)
        tvVarjyam = findViewById(R.id.tvVarjyam)
        tvGulika = findViewById(R.id.tvGulikaKalam)
        tvhc1 = findViewById(R.id.tvhc1)
        tvhc2 = findViewById(R.id.tvhc2)
        tvhc3 = findViewById(R.id.tvhc3)
        tvhc4 = findViewById(R.id.tvhc4)
        tvhc5 = findViewById(R.id.tvhc5)
        tvhc6 = findViewById(R.id.tvhc6)
        tvhc7 = findViewById(R.id.tvhc7)
        tvhc8 = findViewById(R.id.tvhc8)
        tvhc9 = findViewById(R.id.tvhc9)
        tvhc10 = findViewById(R.id.tvhc10)
        tvhc11 = findViewById(R.id.tvhc11)
        tvhc12 = findViewById(R.id.tvhc12)
        cal_card = findViewById(R.id.cal_card)
        shareWhatsapp = findViewById(R.id.shareWhatsapp)
        share = findViewById(R.id.share)
        llRefresh = findViewById(R.id.llRefresh)
        llRefresh!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DailyPanchangamActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_top_right, R.anim.slide_out_bottom_left)
            finish()
        })
        shareWhatsapp!!.setOnClickListener(View.OnClickListener { convertLayoutToPDFAndShare() })
        share!!.setOnClickListener(View.OnClickListener { convertLayoutAndShare() })


        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = findViewById(R.id.add_fab)

        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab)
        mAddPersonFab = findViewById(R.id.add_person_fab)

        // Also register the action name text, of all the FABs.
        addAlarmActionText = findViewById(R.id.add_alarm_action_text)
        addPersonActionText = findViewById(R.id.add_person_action_text)

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab!!.setVisibility(View.GONE)
        mAddPersonFab!!.setVisibility(View.GONE)
        addAlarmActionText!!.setVisibility(View.GONE)
        addPersonActionText!!.setVisibility(View.GONE)

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab!!.setOnClickListener(View.OnClickListener { view: View? ->
            isAllFabsVisible = if (!isAllFabsVisible!!) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab!!.show()
                mAddPersonFab!!.show()
                addAlarmActionText!!.setVisibility(View.VISIBLE)
                addPersonActionText!!.setVisibility(View.VISIBLE)

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                true
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab!!.hide()
                mAddPersonFab!!.hide()
                addAlarmActionText!!.setVisibility(View.GONE)
                addPersonActionText!!.setVisibility(View.GONE)

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                false
            }
        })
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddPersonFab!!.setOnClickListener(
            View.OnClickListener { view: View? -> convertLayoutAndShare() }
        )

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab!!.setOnClickListener(
            View.OnClickListener { view: View? -> convertLayoutToPDFAndShare() }
        )
        scrollView = findViewById(R.id.scroll_view)
        scrollView!!.setSwipeListener(this)
        targetCalendar = Calendar.getInstance()
        targetCalendar!!.set(Calendar.YEAR, 2024)
        targetCalendar!!.set(Calendar.MONTH, Calendar.APRIL)
        targetCalendar!!.set(Calendar.DAY_OF_MONTH, 9)
        calendar = Calendar.getInstance()
        val year = calendar!!.get(Calendar.YEAR)
        monthIndex = calendar!!.get(Calendar.MONTH)
        monthNames = DateFormatSymbols().months
        currentMonth = monthNames[monthIndex]
        startCalendar = Calendar.getInstance()
        startCalendar!!.set(Calendar.MONTH, Calendar.MARCH)
        startCalendar!!.set(Calendar.YEAR, 2023)
        startCalendar!!.set(Calendar.DAY_OF_MONTH, 22)
        cal_card!!.setOnClickListener(View.OnClickListener { v: View? ->
            val intent = Intent(activity, MontlyActivity::class.java)
            intent.putExtra("year", year)
            intent.putExtra("month", monthIndex)
            startActivity(intent)
        })
        arrowright!!.setOnClickListener(View.OnClickListener { v: View? -> forward() })
        arrowleft!!.setOnClickListener(View.OnClickListener { v: View? -> backward() })
        ivArrowLeft!!.setOnClickListener(View.OnClickListener { v: View? -> backward() })
        ivArrowRight!!.setOnClickListener(View.OnClickListener { v: View? -> forward() })

        dailyPanchangam()

        updateUI(calendar!!.getTime())



    }

    private fun panchangamlist(date: String?) {
        val dailyModels = databaseHelper!!.getDailyPanchangam(date)
        val dailyModel = dailyModels[0]
        tvtext1!!.text = dailyModel.text1
        tvtext2!!.text = dailyModel.text2
        tvtext3!!.text = dailyModel.text3
        tvtext4!!.text = dailyModel.text4
        tvtext5!!.text = dailyModel.text5
        tvtext6!!.text = dailyModel.text6
        tvSunrise!!.text = dailyModel.sunrise
        tvSunset!!.text = dailyModel.sunset
        tvMoonRise!!.text = dailyModel.moonrise
        tvMoonset!!.text = dailyModel.moonset
        tvFestival!!.text = dailyModel.festivals
        tvThithi!!.text = dailyModel.thidhi
        TVNakshathram!!.text = dailyModel.nakshatram
        tvYogam!!.text = dailyModel.yogam
        tvKaranam!!.text = dailyModel.karanam
        tvAbhijithMuhurtham!!.text = dailyModel.abhijith_muhurtham
        tvBhramaMuhurtham!!.text = dailyModel.bhrama_muhurtham
        tvAmruthaKalam!!.text = dailyModel.amrutha_kalam
        tvRahukalam!!.text = dailyModel.rahukalam
        tvYamagandam!!.text = dailyModel.yamakandam
        tvDhurmuhurtham!!.text = dailyModel.dhurmuhurtham
        tvVarjyam!!.text = dailyModel.varjyam
        tvGulika!!.text = dailyModel.gulika
        tvhc1!!.text = dailyModel.hc1
        tvhc2!!.text = dailyModel.hc2
        tvhc3!!.text = dailyModel.hc3
        tvhc4!!.text = dailyModel.hc4
        tvhc5!!.text = dailyModel.hc5
        tvhc6!!.text = dailyModel.hc6
        tvhc7!!.text = dailyModel.hc7
        tvhc8!!.text = dailyModel.hc8
        tvhc9!!.text = dailyModel.hc9
        tvhc10!!.text = dailyModel.hc10
        tvhc11!!.text = dailyModel.hc11
        tvhc12!!.text = dailyModel.hc12
    }

    @SuppressLint("ResourceType")
    private fun backward() {
        if (calendar!!.after(startCalendar)) {
            relativeLayout!!.startAnimation(
                AnimationUtils.loadAnimation(
                    activity,
                    R.xml.slide_out_left
                )
            )
            val year = calendar!![Calendar.YEAR]
            monthIndex = calendar!![Calendar.MONTH]
            monthNames = DateFormatSymbols().months
            currentMonth = monthNames[monthIndex]
            // move the calendar one day back the date
            calendar!!.add(Calendar.DAY_OF_YEAR, -1)
            updateUI(calendar!!.time)
        }


//
//            arrowleft.setEnabled(false);
//            ivArrowLeft.setEnabled(false);
    }

    @SuppressLint("ResourceType")
    private fun forward() {
        if (calendar!!.before(targetCalendar)) {
            relativeLayout!!.startAnimation(
                AnimationUtils.loadAnimation(
                    activity,
                    R.xml.slide_in_right
                )
            )
            // Move the calendar one day forward
            calendar!!.add(Calendar.DAY_OF_YEAR, 1)
            val year = calendar!![Calendar.YEAR]
            monthIndex = calendar!![Calendar.MONTH]
            monthNames = DateFormatSymbols().months
            currentMonth = monthNames[monthIndex]
            // Update your UI with the new date
            updateUI(calendar!!.time)
        }
    }

    private fun updateUI(date: Date) {
        // Format the date as a string
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        dateString = dateFormat.format(date)

        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
        tvDate!!.text = dateString.toString()
        tvDate1!!.text = dateString.toString()
        val Date = dateFormat.format(date)
        if (databaseHelper!!.dailyPanchangam.size != 0) {
            panchangamlist(convertDateFormat(Date))
        }
        arrowleft!!.isEnabled = true
        ivArrowLeft!!.isEnabled = true
    }

    private fun dailyPanchangam() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley({ result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
//                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
//                        Gson g = new Gson();

                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper!!.AddToDailyPanchangam(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.DATE),
                                    jsonObject1.getString(Constant.TEXT1),
                                    jsonObject1.getString(Constant.TEXT2),
                                    jsonObject1.getString(Constant.TEXT3),
                                    jsonObject1.getString(Constant.TEXT4),
                                    jsonObject1.getString(Constant.TEXT5),
                                    jsonObject1.getString(Constant.TEXT6),
                                    jsonObject1.getString(Constant.SUNRISE),
                                    jsonObject1.getString(Constant.SUNSET),
                                    jsonObject1.getString(Constant.MOONRISE),
                                    jsonObject1.getString(Constant.MOONSET),
                                    jsonObject1.getString(Constant.FESTIVALS),
                                    jsonObject1.getString(Constant.THIDHI),
                                    jsonObject1.getString(Constant.NAKSHATRAM),
                                    jsonObject1.getString(Constant.YOGAM),
                                    jsonObject1.getString(Constant.KARANAM),
                                    jsonObject1.getString(Constant.ABHIJITH_MUHURTHAM),
                                    jsonObject1.getString(Constant.BHRAMA_MUHURTHAM),
                                    jsonObject1.getString(Constant.AMRUTHA_KALAM),
                                    jsonObject1.getString(Constant.RAHUKALAM),
                                    jsonObject1.getString(Constant.YAMAKANDAM),
                                    jsonObject1.getString(Constant.DHURMUHURTHAM),
                                    jsonObject1.getString(Constant.VARJYAM),
                                    jsonObject1.getString(Constant.GULIKA),
                                    jsonObject1.getString(Constant.HC1),
                                    jsonObject1.getString(Constant.HC2),
                                    jsonObject1.getString(Constant.HC3),
                                    jsonObject1.getString(Constant.HC4),
                                    jsonObject1.getString(Constant.HC5),
                                    jsonObject1.getString(Constant.HC6),
                                    jsonObject1.getString(Constant.HC7),
                                    jsonObject1.getString(Constant.HC8),
                                    jsonObject1.getString(Constant.HC9),
                                    jsonObject1.getString(Constant.HC10),
                                    jsonObject1.getString(Constant.HC11),
                                    jsonObject1.getString(Constant.HC12)
                                )


                            }
                        }

                        updateUI(calendar!!.getTime())




                    } else {
                        Toast.makeText(
                            activity,
                            jsonObject.getString(Constant.MESSAGE),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }, activity, Constant.DAILY_PANCHANGAM_LIST, params, true)
    }



    //    @Override
    //    public boolean onTouchEvent(MotionEvent event) {
    //        gestureDetector.onTouchEvent(event);
    //        return super.onTouchEvent(event);
    //    }
    override fun onSwipeLeft() {
        // Handle swipe left
//
//        forward();
    }

    override fun onSwipeRight() {
        // Handle swipe right
//        backward();
    }

    override fun onBackPressed() {
        // Add your desired behavior here

        // Call super.onBackPressed() to allow the default back button behavior (finishing the activity)
        super.onBackPressed()
    }

    private fun convertLayoutToPDFAndShare() {
        // Get the RelativeLayout and ScrollView from the XML layout
        val relativeLayout = findViewById<RelativeLayout>(R.id.toolbar)
        val scrollView = findViewById<SwipeableScrollView>(R.id.scroll_view)

        // Measure the full content height of the ScrollView
        var totalHeight = 0
        for (i in 0 until scrollView.childCount) {
            totalHeight += scrollView.getChildAt(i).height
        }

        // Define the bitmap dimensions for higher resolution
        val width = relativeLayout.width * 2 // This will double the width of the bitmap
        val height =
            (relativeLayout.height + totalHeight) * 2 // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        val combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val combinedCanvas = Canvas(combinedBitmap)
        combinedCanvas.scale(2f, 2f) // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE)

        // Draw the RelativeLayout (toolbar)
        relativeLayout.draw(combinedCanvas)

        // Translate the canvas to the ScrollView position
        combinedCanvas.translate(0f, relativeLayout.height.toFloat())

        // Draw the ScrollView content
        scrollView.draw(combinedCanvas)
        try {
            // Save the Bitmap to a file
            val imageFile = File(externalCacheDir, "image.png")
            val outputStream: OutputStream = FileOutputStream(imageFile)

            // Use higher compression quality for better clarity
            combinedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()

            // Convert the bitmap to PDF
            val pdfDocument = PdfDocument()
            val pageInfo = PageInfo.Builder(combinedBitmap.width, combinedBitmap.height, 1).create()
            val page = pdfDocument.startPage(pageInfo)
            val pdfCanvas = page.canvas
            pdfCanvas.drawBitmap(combinedBitmap, 0f, 0f, null)
            pdfDocument.finishPage(page)

            // Save the PDF to a file
            val pdfFile = File(externalCacheDir, "layout.pdf")
            val pdfOutputStream: OutputStream = FileOutputStream(pdfFile)
            pdfDocument.writeTo(pdfOutputStream)
            pdfDocument.close()

            // Share the PDF using WhatsApp
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "application/pdf"
            shareIntent.putExtra(
                Intent.EXTRA_STREAM,
                FileProvider.getUriForFile(this, "$packageName.fileprovider", pdfFile)
            )
            shareIntent.setPackage("com.whatsapp")
            startActivity(Intent.createChooser(shareIntent, "Share PDF via"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun convertLayoutAndShare() {
        // Get the RelativeLayout and ScrollView from the XML layout
        val relativeLayout = findViewById<RelativeLayout>(R.id.toolbar)
        val scrollView = findViewById<SwipeableScrollView>(R.id.scroll_view)

        // Measure the full content height of the ScrollView
        var totalHeight = 0
        for (i in 0 until scrollView.childCount) {
            totalHeight += scrollView.getChildAt(i).height
        }

        // Define the bitmap dimensions for higher resolution
        val width = relativeLayout.width * 2 // This will double the width of the bitmap
        val height =
            (relativeLayout.height + totalHeight) * 2 // This will double the height of the bitmap

        // Create a bitmap with the desired dimensions and scale
        val combinedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val combinedCanvas = Canvas(combinedBitmap)
        combinedCanvas.scale(2f, 2f) // This will scale the canvas by 2x

        // Draw a white background
        combinedCanvas.drawColor(Color.WHITE)

        // Draw the RelativeLayout (toolbar)
        relativeLayout.draw(combinedCanvas)

        // Translate the canvas to the ScrollView position
        combinedCanvas.translate(0f, relativeLayout.height.toFloat())

        // Draw the ScrollView content
        scrollView.draw(combinedCanvas)
        try {
            // Save the Bitmap to a file
            val imageFile = File(externalCacheDir, "image.png")
            val outputStream: OutputStream = FileOutputStream(imageFile)

            // Use higher compression quality for better clarity
            combinedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()

            // Convert the bitmap to PDF
            val pdfDocument = PdfDocument()
            val pageInfo = PageInfo.Builder(combinedBitmap.width, combinedBitmap.height, 1).create()
            val page = pdfDocument.startPage(pageInfo)
            val pdfCanvas = page.canvas
            pdfCanvas.drawBitmap(combinedBitmap, 0f, 0f, null)
            pdfDocument.finishPage(page)

            // Save the PDF to a file
            val pdfFile = File(externalCacheDir, "layout.pdf")
            val pdfOutputStream: OutputStream = FileOutputStream(pdfFile)
            pdfDocument.writeTo(pdfOutputStream)
            pdfDocument.close()


            // Content you want to share

            // Create a sharing Intent
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "application/pdf"
            sharingIntent.putExtra(
                Intent.EXTRA_STREAM,
                FileProvider.getUriForFile(this, "$packageName.fileprovider", pdfFile)
            )
            // Start the sharing activity
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        fun convertDateFormat(inputDate: String?): String? {
            return try {
                val inputFormat = SimpleDateFormat("dd-MM-yyyy")
                val outputFormat = SimpleDateFormat("yyyy-MM-dd")
                val date = inputFormat.parse(inputDate)
                outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
                null // Return null in case of any parsing errors
            }
        }
    }
}