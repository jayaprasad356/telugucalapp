package com.vibame.telugupanchangamcalendar

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.FileProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.vibame.telugupanchangamcalendar.Panchang_Frag.selectedGridDate
import com.vibame.telugupanchangamcalendar.activities.CalendarNewActivity
import com.vibame.telugupanchangamcalendar.helper.ApiConfig
import com.vibame.telugupanchangamcalendar.helper.Constant
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper
import com.vibame.telugupanchangamcalendar.helper.Session
import com.vibame.telugupanchangamcalendar.model.MonthlyModel
import org.json.JSONObject
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MontlyActivity : AppCompatActivity() , SwipeableScrollView.SwipeListener{


    lateinit var tvDate: TextView
    lateinit var arrowright: CardView
    lateinit var arrowleft: CardView
    lateinit var ivArrowRight: ImageButton
    lateinit var ivArrowLeft: ImageButton
    var activity: Activity? = null
    var session: Session? = null
    lateinit var text1: TextView
    lateinit var tvPournami: TextView
    lateinit var tvAmavasya: TextView
    lateinit var tvAkadashi: TextView
    lateinit var tvPradosham: TextView
    lateinit var tvShashti: TextView
    lateinit var tvChavithi: TextView
    lateinit var tvMasaShivaratri: TextView
    lateinit var tvSankatacharathi: TextView
    lateinit var tvFestival: TextView
    lateinit var tvHolidays: TextView
    lateinit var databaseHelper: DatabaseHelper


    var month_year = ""
    var year = ""
    var montharray = arrayOf(
        "జనవరి ",
        "ఫిబ్రవరి ",
        "మార్చి ",
        "ఏప్రిల్ ",
        "మే ",
        "జూన్ ",
        "జూలై ",
        "ఆగస్టు ",
        "సెప్టెంబర్ ",
        "అక్టోబర్ ",
        "నవంబర్ ",
        "డిసెంబర్ "
    )
    var c = Calendar.getInstance()
    var df = SimpleDateFormat("MMMM yyyy")
    var monthcount = 0
    var cal = Calendar.getInstance()
    var exampleFragment = Panchang_Frag()

    private var relativeLayout: ConstraintLayout? = null
    private lateinit var scrollView: SwipeableScrollView

    private val gestureDetector =
        GestureDetector(activity, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(
                e1: MotionEvent,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                if (Math.abs(velocityX) > Math.abs(velocityY)) {
                    if (e1.x < e2.x) {
                        // Swipe right
                        onSwipeRight()
                    } else {
                        // Swipe left
                        onSwipeLeft()
                    }
                    return true
                }
                return false
            }
        })


    private lateinit var cal_month: GregorianCalendar
    private lateinit var cal_month_copy: GregorianCalendar
    private var hwAdapter: HwAdapter? = null
    private var currentMonth = 0
    private val cmonth: Calendar? = null
    private var gridview: GridView? = null


    private var loadXmlFile: String? = null
    private var records: ArrayList<XmlRecords>? = null
    private var changed = false
    private var clickedDate = 0
    private var dateFormat: String? = null
    private val calendar = Calendar.getInstance(TimeZone.getDefault())

    private lateinit var tv_month: TextView
    private val month = arrayOf(
        "జనవరి",
        "ఫిబ్రవరి",
        "మార్చి",
        "ఏప్రిల్",
        "మే",
        "జూన్",
        "జూలై",
        "ఆగస్టు",
        "సెప్టెంబర్",
        "అక్టోబర్",
        "నవంబర్",
        "డిసెంబర్"
    )
    private val monthE = arrayOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    )

    private lateinit var ivShare: ImageView
    private lateinit var ivWhatsapp: ImageView


    private lateinit var mAddFab: FloatingActionButton
    private lateinit var mAddAlarmFab: FloatingActionButton
    private lateinit var mAddPersonFab: FloatingActionButton

    // These are taken to make visible and invisible along with FABs
    private lateinit var addAlarmActionText: TextView
    private lateinit var addPersonActionText: TextView

    // to check whether sub FAB buttons are visible or not.
    private var isAllFabsVisible: Boolean? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_montly)
        activity = this
        session = Session(activity)
        databaseHelper= DatabaseHelper(activity);

        tv_month = findViewById(R.id.tvDate)






        HomeCollection.date_collection_arr = ArrayList()





        ivShare = findViewById(R.id.ivShare)
        ivWhatsapp = findViewById(R.id.ivWhatsapp)



        ivShare.setOnClickListener {

            convertLayoutAndShare()

        }

        ivWhatsapp.setOnClickListener {

            convertLayoutToPDFAndShare()

        }


        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = findViewById(R.id.add_fab)

        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab)
        mAddPersonFab = findViewById(R.id.add_person_fab)

        // Also register the action name text, of all the FABs.
        addAlarmActionText = findViewById(R.id.add_alarm_action_text)
        addPersonActionText = findViewById(R.id.add_person_action_text)

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab.visibility = View.GONE
        mAddPersonFab.visibility = View.GONE
        addAlarmActionText.visibility = View.GONE
        addPersonActionText.visibility = View.GONE

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(View.OnClickListener {
            (if (!isAllFabsVisible!!) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show()
                mAddPersonFab.show()
                addAlarmActionText.visibility = View.VISIBLE
                addPersonActionText.visibility = View.VISIBLE

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                true
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide()
                mAddPersonFab.hide()
                addAlarmActionText.visibility = View.GONE
                addPersonActionText.visibility = View.GONE

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                false
            }).also { isAllFabsVisible = it }
        })
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddPersonFab.setOnClickListener {


            convertLayoutAndShare()

        }

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab.setOnClickListener {

            convertLayoutToPDFAndShare()


        }

        cal_month = GregorianCalendar.getInstance() as GregorianCalendar


        val Month = intent.getIntExtra("month", 0)


        cal_month.set(
            GregorianCalendar.MONTH,
            Month
        )


        cal_month_copy = cal_month.clone() as GregorianCalendar
        hwAdapter = HwAdapter(
            activity,
            cal_month,
            HomeCollection.date_collection_arr
        )
        currentMonth =
            cal_month.get(
                GregorianCalendar.MONTH
            )

        Panchang_Frag.cutmonth =
            cal_month.get(
                GregorianCalendar.MONTH
            )








        tv_month.text =
            month[currentMonth] + " - " + cal_month!!.get(
                GregorianCalendar.YEAR
            )

        var year =
            cal_month.get(
                GregorianCalendar.YEAR
            ).toString()
        var month = month[currentMonth].toString()



        loadXmlFile =
            monthE[currentMonth] + "_" + calendar[Calendar.YEAR]
        if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2021
        ) {
            dateFormat =
                calendar[Calendar.DATE].toString() + " - " + month[currentMonth] + " - " + calendar[Calendar.YEAR] + " - స్వస్తిశ్రీ ప్లవ"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2022 && currentMonth < 3
        ) {
            dateFormat =
                calendar[Calendar.DATE].toString() + " - " + month[currentMonth] + " - " + calendar[Calendar.YEAR] + " - స్వస్తిశ్రీ ప్లవ"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2022 && currentMonth > 3
        ) {
            dateFormat =
                calendar[Calendar.DATE].toString() + " - " + month[currentMonth] + " - " + calendar[Calendar.YEAR] + " - శుభకృతు"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2023 && currentMonth < 3 && calendar[Calendar.DATE] < 21
        ) {
            dateFormat =
                calendar[Calendar.DATE].toString() + " - " + month[currentMonth] + " - " + calendar[Calendar.YEAR] + " - శుభకృతు"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2023 && currentMonth > 2
        ) {
            // dateFormat = calendar[Calendar.DATE].toString() + " - " + month[currentMonth] + " - " + calendar[Calendar.YEAR] + " -  శోభకృతు"
        }


        clickedDate = calendar[Calendar.DATE] - 1
        Panchang_Frag.selectedGridDate = ""




        gridview = findViewById(R.id.gv_calendar)



        gridViewSet()
        parseXML()





        arrowright = findViewById(R.id.arrowright)
        arrowleft = findViewById(R.id.arrowleft)
        ivArrowRight = findViewById(R.id.ivArrowRight)
        ivArrowLeft = findViewById(R.id.ivArrowLeft)
        relativeLayout = findViewById(R.id.slider)
        scrollView = findViewById(R.id.scroll_view)
        scrollView.setSwipeListener(this)


        tvHolidays = findViewById(R.id.tvHolidays)
        text1 = findViewById(R.id.text1)
        tvPournami = findViewById(R.id.tvPournami)
        tvAmavasya = findViewById(R.id.tvAmavasya)
        tvAkadashi = findViewById(R.id.tvAkadashi)
        tvPradosham = findViewById(R.id.tvPradosha)
        tvShashti = findViewById(R.id.tvShashti)
        tvChavithi = findViewById(R.id.tvChavithi)
        tvMasaShivaratri = findViewById(R.id.tvMasaShivaratri)
        tvSankatacharathi = findViewById(R.id.tvSankatacharathi)
        tvFestival = findViewById(R.id.tvFestival)
        tvHolidays = findViewById(R.id.tvHolidays)













        arrowleft.setOnClickListener({


            leftarrow()

        })

        arrowright.setOnClickListener({


            rightarrow()

        })

        ivArrowLeft.setOnClickListener({

            leftarrow()

        })


        ivArrowRight.setOnClickListener({

            rightarrow()

        })
        montlyPanchangam(year, month)


    }

    private fun montlyPanchangam(year: String, month: String) {

        var Months = ""

        if (month == "జనవరి") {

            Months = "January"

        } else if (month == "ఫిబ్రవరి") {
            Months = "February"

        } else if (month == "మార్చి") {
            Months = "March"

        } else if (month == "ఏప్రిల్") {
            Months = "April"

        } else if (month == "మే") {
            Months = "May"

        } else if (month == "జూన్") {
            Months = "June"

        } else if (month == "జూలై") {
            Months = "July"

        } else if (month == "ఆగస్టు") {
            Months = "August"

        } else if (month == "సెప్టెంబర్") {
            Months = "September"

        } else if (month == "అక్టోబర్") {
            Months = "October"

        } else if (month == "నవంబర్") {
            Months = "November"

        } else if (month == "డిసెంబర్") {
            Months = "December"

        }
        var panchangamList = ArrayList<MonthlyModel>()


        panchangamList = databaseHelper.getMonthlyPanchangam(Months, year)




        text1.text = panchangamList.get(0).text1
        tvPournami.setText(panchangamList.get(0).pournami)
        tvAmavasya.setText(panchangamList.get(0).amavasya)
        tvAkadashi.setText(panchangamList.get(0).akadhashi)
        tvPradosham.setText(panchangamList.get(0).pradhosha)
        tvShashti.setText(panchangamList.get(0).shasti)
        tvChavithi.setText(panchangamList.get(0).chavithi)
        tvMasaShivaratri.setText(
            panchangamList.get(0).masa_shiva_Rathri
        )
        tvSankatacharathi.setText(
            panchangamList.get(0).sankatahara_chathurdhi
        )
        tvFestival.setText(panchangamList.get(0).festivals)
        tvHolidays.setText(panchangamList.get(0).holiday)


    }

    @SuppressLint("ResourceType")
    private fun rightarrow() {


        NextMonth()


    }

    @SuppressLint("ResourceType")
    private fun leftarrow() {


        privouaMonth()


    }

    private fun getMonthNum(): String? {
        var newDate: Date? = null
        try {
            newDate = df.parse("" + month_year)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val format = SimpleDateFormat("MM")
        return format.format(newDate)
    }

    private fun getYearNum(): String? {
        var newDate: Date? = null
        try {
            newDate = df.parse("" + month_year)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val format = SimpleDateFormat("yyyy")
        return format.format(newDate)
    }


    private fun setTeluguMonth(month_year: String): String? {
        val index = month_year.indexOf(' ')
        val month = month_year.substring(0, index)
        val p = Arrays.asList(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        ).indexOf(month)
        return montharray[p]
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onSwipeLeft() {
        // Handle swipe left
        rightarrow()
    }

    override fun onSwipeRight() {
        // Handle swipe right
        leftarrow()

    }


    @SuppressLint("ResourceType")
    private fun privouaMonth() {

        if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) > 2020
        ) {
            if (currentMonth == 0 && cal_month!!.get(
                    GregorianCalendar.YEAR
                ) == 2023
            ) {
                Toast.makeText(activity, "ప్రదర్శించడానికి డేటా లేదు", Toast.LENGTH_SHORT)
                    .show()
            } else {
                relativeLayout!!.startAnimation(
                    AnimationUtils.loadAnimation(
                        activity,
                        R.xml.slide_out_left
                    )
                )
                setPreviousMonth()
                allFunc()


            }
        }


    }

    @SuppressLint("ResourceType")
    private fun NextMonth() {


        if (currentMonth == 3 && cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2024
        ) {
            Toast.makeText(activity, "ప్రదర్శించడానికి డేటా లేదు", Toast.LENGTH_SHORT)
                .show()
        } else {
            relativeLayout!!.startAnimation(
                AnimationUtils.loadAnimation(
                    activity,
                    R.xml.slide_in_right
                )
            )
            setNextMonth()
            allFunc()
        }


    }


    protected fun setPreviousMonth() {
        currentMonth--
        if (cal_month!!.get(
                GregorianCalendar.MONTH
            ) == cal_month!!.getActualMinimum(
                GregorianCalendar.MONTH
            )
        ) {
            currentMonth = 11
            cal_month!!.set(
                cal_month!!.get(
                    GregorianCalendar.YEAR
                ) - 1,
                cal_month!!.getActualMaximum(
                    GregorianCalendar.MONTH
                ),
                1
            )
        } else {
            cal_month!!.set(
                GregorianCalendar.MONTH,
                cal_month!!.get(
                    GregorianCalendar.MONTH
                ) - 1
            )
        }
        tv_month!!.setText(
            month.get(currentMonth) + " - " + cal_month!!.get(
                GregorianCalendar.YEAR
            )
        )


        var year =
            cal_month.get(
                GregorianCalendar.YEAR
            ).toString()
        var month = month[currentMonth].toString()


        montlyPanchangam(year, month)


    }

    protected fun setNextMonth() {
        currentMonth++
        if (cal_month!!.get(
                GregorianCalendar.MONTH
            ) == cal_month!!.getActualMaximum(
                GregorianCalendar.MONTH
            )
        ) {
            currentMonth = 0
            cal_month!!.set(
                cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + 1,
                cal_month!!.getActualMinimum(
                    GregorianCalendar.MONTH
                ),
                1
            )
        } else {
            cal_month!!.set(
                GregorianCalendar.MONTH,
                cal_month!!.get(
                    GregorianCalendar.MONTH
                ) + 1
            )
        }
        tv_month.text =
            month[currentMonth] + " - " + cal_month!!.get(
                GregorianCalendar.YEAR
            )
        var year =
            cal_month.get(
                GregorianCalendar.YEAR
            ).toString()
        var month = month[currentMonth].toString()


        montlyPanchangam(year, month)
    }

    private fun allFunc() {
        refreshCalendar()
        gridViewSet()
        clickedDate = 0
        Panchang_Frag.selectedGridDate =
            HwAdapter.day_string[HwAdapter.firstDay - 1]
        if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2021
        ) {
            dateFormat =
                1.toString() + " - " + month.get(currentMonth) + " - " + cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + " - స్వస్తిశ్రీ ప్లవ"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2022 && currentMonth < 3
        ) {
            dateFormat =
                1.toString() + " - " + month.get(currentMonth) + " - " + cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + " - స్వస్తిశ్రీ ప్లవ"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2022 && currentMonth > 2
        ) {
            dateFormat =
                1.toString() + " - " + month.get(currentMonth) + " - " + cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + " -  శుభకృతు"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2023 && currentMonth < 3
        ) {
            dateFormat =
                1.toString() + " - " + month.get(currentMonth) + " - " + cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + " -  శుభకృతు"
        } else if (cal_month!!.get(
                GregorianCalendar.YEAR
            ) == 2023 && currentMonth > 2
        ) {
            dateFormat =
                1.toString() + " - " + month.get(currentMonth) + " - " + cal_month!!.get(
                    GregorianCalendar.YEAR
                ) + " -  శోభకృతు"
        }
        hwAdapter!!.notifyDataSetChanged()
        loadXmlFile =
            monthE.get(currentMonth) + "_" + cal_month!!.get(
                GregorianCalendar.YEAR
            )
        parseXML()
    }

    private fun gridViewSet() {
        gridview!!.adapter = hwAdapter
        gridview!!.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                selectedGridDate =
                    HwAdapter.day_string[position]
                val separatedTime: List<String> = HwAdapter.day_string[position].split("-")
                val cl_day = separatedTime[2].replaceFirst("^0*".toRegex(), "")
                val cl_month = separatedTime[1].replaceFirst("^0*".toRegex(), "")
                val cl_year = separatedTime[0].replaceFirst("^0*".toRegex(), "")
                clickedDate = cl_day.toInt() - 1
                if (cal_month!!.get(
                        GregorianCalendar.YEAR
                    ) == 2021
                ) {
                    dateFormat =
                        cl_day + " - " + month.get(cl_month.toInt() - 1) + " - " + cl_year + " -  ప్లవ"
                } else if (cal_month!!.get(
                        GregorianCalendar.YEAR
                    ) == 2022 && currentMonth < 3
                ) {
                    dateFormat =
                        cl_day + " - " + month.get(cl_month.toInt() - 1) + " - " + cl_year + " -  ప్లవ"
                } else if (cal_month!!.get(
                        GregorianCalendar.YEAR
                    ) == 2022 && currentMonth > 3
                ) {
                    dateFormat =
                        cl_day + " - " + month.get(cl_month.toInt() - 1) + " - " + cl_year + " -  శుభకృతు"
                } else if (cal_month!!.get(
                        GregorianCalendar.YEAR
                    ) == 2023 && currentMonth < 3 && clickedDate < 21
                ) {
                    dateFormat =
                        cl_day + " - " + month.get(cl_month.toInt() - 1) + " - " + cl_year + " -  శుభకృతు"
                } else if (cal_month!!.get(
                        GregorianCalendar.YEAR
                    ) == 2023 && currentMonth > 1 && clickedDate > 20
                ) {
                    dateFormat =
                        cl_day + " - " + month.get(cl_month.toInt() - 1) + " - " + cl_year + " -  శోభకృతు"
                }
                (parent.adapter as HwAdapter).getPositionList(
                    selectedGridDate,
                    activity
                )
                hwAdapter!!.notifyDataSetChanged()
                if (loadXmlFile == monthE.get(cl_month.toInt() - 1) + "_" + cl_year.toInt()) {
                    try {

                        val date = (clickedDate + 1).toString() + ""
                        val strCurrentDate = loadXmlFile + "_" + date
                        var format = SimpleDateFormat("MMMM_yyyy_dd")
                        var newDate: Date? = null
                        newDate = format.parse(strCurrentDate)
                        format = SimpleDateFormat("dd-MM-yyyy")
                        val cadate = format.format(newDate)


                        val Intent = Intent(activity, DailyActivity::class.java)
                        Intent.putExtra("clickedDate", cadate)
                        startActivity(Intent)

                    } catch (e: ParseException) {
                        e.printStackTrace()
                    }
                } else {
                    loadXmlFile = monthE.get(cl_month.toInt() - 1) + "_" + cl_year.toInt()
                    parseXML()
                }
            }
    }


    fun refreshCalendar() {
        hwAdapter!!.refreshDays()
        hwAdapter!!.notifyDataSetChanged()
    }

    private fun parseXML() {
        val parserFactory: XmlPullParserFactory
        try {
            parserFactory = XmlPullParserFactory.newInstance()
            val pullParser = parserFactory.newPullParser()
            try {
                val inputStream: InputStream =
                    activity!!.getAssets().open("Months/$loadXmlFile.xml")
                pullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
                pullParser.setInput(inputStream, null)
                processParser(pullParser)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        }
    }


    @Throws(IOException::class, XmlPullParserException::class, ParseException::class)
    private fun processParser(pullParser: XmlPullParser) {
        records = ArrayList()
        var eventType = pullParser.eventType
        var currentRecord: XmlRecords? = null
        while (eventType != XmlPullParser.END_DOCUMENT) {
            var eltName: String? = null
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    eltName = pullParser.name
                    if ("record" == eltName) {
                        currentRecord = XmlRecords()
                        records!!.add(currentRecord)
                    } else if (currentRecord != null) {
                        if ("date" == eltName) {
                            currentRecord.Date = pullParser.nextText()
                        } else if ("sunrise" == eltName) {
                            currentRecord.Sunrise = pullParser.nextText()
                        } else if ("sunset" == eltName) {
                            currentRecord.Sunset = pullParser.nextText()
                        } else if ("moonrise" == eltName) {
                            currentRecord.Moonrise = pullParser.nextText()
                        } else if ("moonset" == eltName) {
                            currentRecord.Moonset = pullParser.nextText()
                        } else if ("rutuvu" == eltName) {
                            currentRecord.Ruthu = pullParser.nextText()
                        } else if ("masam" == eltName) {
                            currentRecord.Masam = pullParser.nextText()
                        } else if ("paksham" == eltName) {
                            currentRecord.Paksham = pullParser.nextText()
                        } else if ("kalam" == eltName) {
                            currentRecord.Kalam = pullParser.nextText()
                        } else if ("thidi" == eltName) {
                            currentRecord.Thidi = pullParser.nextText()
                        } else if ("vaara" == eltName) {
                            currentRecord.Week = pullParser.nextText()
                        } else if ("nakshatra" == eltName) {
                            currentRecord.Nakshatram = pullParser.nextText()
                        } else if ("yogam" == eltName) {
                            currentRecord.Yogam = pullParser.nextText()
                        } else if ("karana" == eltName) {
                            currentRecord.Karanam = pullParser.nextText()
                        } else if ("rahu" == eltName) {
                            currentRecord.Rahuv = pullParser.nextText()
                        } else if ("yamag" == eltName) {
                            currentRecord.Yama = pullParser.nextText()
                        } else if ("varjyam" == eltName) {
                            currentRecord.Varjyam = pullParser.nextText()
                        } else if ("gulika" == eltName) {
                            currentRecord.Gulika = pullParser.nextText()
                        } else if ("dhurmuhu" == eltName) {
                            currentRecord.Dhurmuhurth = pullParser.nextText()
                        } else if ("festival" == eltName) {
                            currentRecord.Festival = pullParser.nextText()
                        }
                    }
                }
            }
            eventType = pullParser.next()
        }
        printRecords()

    }

    @Throws(ParseException::class)
    private fun printRecords() {
        val date = (clickedDate + 1).toString() + ""
        val strCurrentDate = loadXmlFile + "_" + date
        var format = SimpleDateFormat("MMMM_yyyy_dd")
        var newDate: Date? = null
        newDate = format.parse(strCurrentDate)
        format = SimpleDateFormat("yyyy-MM-dd")
        val cadate = format.format(newDate)
        Log.d("CURRENTDATE", "" + cadate)
        //panchangamApi(cadate);
//        panchangamList(cadate)
        val festival: String
        festival = if (records!![clickedDate].Festival == null) {
            ""
        } else {
            records!![clickedDate].Festival
        }
        val htmlData: String
        if (!changed) {
            changed = true
            htmlData =
                "<html><style type='text/css'>@font-face { font-family: sree; src: url('fonts/sree.ttf'); } body p {font-family: sree;}</style><head><meta name='viewport' user-scalable=no' /></head><body align='center' style='padding: 0' >" +
                        "<div style='color:#0F1970;text-align:center;font-size:19;font-family: sree;'>" + dateFormat + "</div>" +
                        "<div style='font-weight:bold;text-align:left;margin-left:10px;line-height:1.5;font-size:15;font-family: sree;'>" +
                        "<span style='color:#006600'>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "తిథి " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Thidi + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "వారము " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Week + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "నక్షత్రం " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Nakshatram + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "యోగం " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Yogam + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "కరణం " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Karanam + "</div>" + "</span>" + "<br>" +
                        "<span style='color:#d31d8c'>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "రాహుకాలం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Rahuv + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "యమగండము" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Yama + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "వర్జ్యం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Varjyam + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "గుళికా " + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Gulika + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "దుర్ముహుర్తం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Dhurmuhurth + "</div>" + "</span>" + "<br>" +
                        "<div style='color:#0F1970;font-weight:bold;margin-top:7px;text-align:center;font-size:17;font-family: sree;'>" +
                        "* &nbsp; " + festival + "&nbsp; *" + "<br>" + "</div>" +
                        "</body></html>"
        } else {
            changed = false
            htmlData =
                "<html><style type='text/css'>@font-face { font-family: sree; src: url('fonts/sree.ttf'); } body p {font-family: sree;}</style><head><meta name='viewport' user-scalable=no' /></head><body align='center' style='padding: 0' >" +
                        "<div style='color:#0F1970;text-align:center;font-size:19;font-family: sree;'>" + dateFormat + "</div>" +
                        "<div style='font-weight:bold;text-align:left;margin-left:10px;line-height:1.5;font-size:15;font-family: sree;'>" +
                        "<span style='color:#006600'>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "తిథి " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Thidi + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "వారము " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Week + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "నక్షత్రం" + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Nakshatram + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "యోగం " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Yogam + "</div>" + "<br>" +
                        "<div style='width:20%;text-align:left;float:left'>" + "కరణం " + "</div>" +
                        "<div style='width:80%;text-align:left;float:left'>" + ": &nbsp;" + records!![clickedDate].Karanam + "</div>" + "</span>" + "<br>" +
                        "<span style='color:#d31d8c'>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "రాహుకాలం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Rahuv + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "యమగండము" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Yama + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "వర్జ్యం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Varjyam + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "గుళికా " + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Gulika + "</div>" + "<br>" +
                        "<div style='width:26%;text-align:left;float:left'>" + "దుర్ముహుర్తం" + "</div>" +
                        "<div style='width:74%;text-align:left;float:left'>" + ":&nbsp;" + records!![clickedDate].Dhurmuhurth + "</div>" + "</span>" + "<br>" +
                        "<div style='color:#0F1970;font-weight:bold;margin-top:7px;text-align:center;font-size:17;font-family: sree;'>" +
                        "* &nbsp;" + festival + "&nbsp; *" + "<br>" + "</div>" +
                        "</body></html>"
        }
    }


    override fun onBackPressed() {
        // Add your desired behavior here

        // Add your desired behavior here
        val intent = Intent(this@MontlyActivity, CalendarNewActivity::class.java)
        startActivity(intent)

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
            val pageInfo = PdfDocument.PageInfo.Builder(combinedBitmap.width, combinedBitmap.height, 1).create()
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
                Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                    this,
                    "$packageName.fileprovider", pdfFile
                )
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
            val pageInfo = PdfDocument.PageInfo.Builder(combinedBitmap.width, combinedBitmap.height, 1).create()
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
                Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                    this,
                    "$packageName.fileprovider", pdfFile
                )
            )
            // Start the sharing activity
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}