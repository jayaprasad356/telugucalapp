package com.vibame.telugupanchangamcalendar.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.vibame.telugupanchangamcalendar.*
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter
import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter
import com.vibame.telugupanchangamcalendar.helper.Constant
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper
import com.vibame.telugupanchangamcalendar.helper.Session
import java.text.SimpleDateFormat
import java.util.*

class CalendarNewActivity : AppCompatActivity() {

    lateinit var sheet : FrameLayout

    var recyclerView: RecyclerView? = null
    var audioLiveAdapter: AudioLiveAdapter? = null
    var imgLeft: ImageView? = null
    var imgRight:android.widget.ImageView? = null
    lateinit  var sliderView: ImageSlider
    var tvMonthYear: TextView? = null
    var month_year: String? = null
    var monthcount = 0
    var cal = Calendar.getInstance()
    var df = SimpleDateFormat("MMMM yyyy")
    var c = Calendar.getInstance()
    var databaseHelper: DatabaseHelper? = null
    var activity: Activity? = null


    var llNavaGrahalu: LinearLayout? = null
    var llNithyaParayana:LinearLayout? = null
    var llTeluguYear: LinearLayout? = null
    var llRashulu:LinearLayout? = null
    var llMonth:LinearLayout? = null
    var more:LinearLayout? = null
    var sakunaActivity: Activity? = null
    var kakiActivity:Activity? = null
    var pilliActivity:Activity? = null
    var balliActivity:Activity? = null
    var kukuta_sasthram:Activity? = null
    var sakunalu: LinearLayout? = null
    var kaki:LinearLayout? = null
    var pilli:LinearLayout? = null
    var balli:LinearLayout? = null
    var kukuta:LinearLayout? = null
    var rvPoojaluNomulu: RecyclerView? = null
    var rvGrahaluStars:RecyclerView? = null
    var grahaluAdapter: GrahaluAdapter? = null
    var poojaluAdapter: PoojaluAdapter? = null
    var cardVideoTab: CardView? = null
    var cardImageTab:CardView? = null
    var llThidhi: LinearLayout? = null
    var llGowri:LinearLayout? = null
    var llRahukalam:LinearLayout? = null
    var llHora:LinearLayout? = null
    var llKaranam:LinearLayout? = null
    var llYogam:LinearLayout? = null
    var mahaBharatham: CardView? = null
    var ramayanam:CardView? = null
    var bhagvathGeetha:CardView? = null
    var bhagvatham:CardView? = null
    var sethakamulu:CardView? = null
    var sivaPuranam:CardView? = null
    var cardShare:CardView? = null
    var Rateus:CardView? = null
    var cardFeedback:CardView? = null
    var cardPrivacy:CardView? = null
    var session: Session? = null
    var cardNewArticles: CardView? = null
    var cardOldArticles:CardView? = null
    var cardSmartTools:CardView? = null
    var cardVideolive:CardView? = null
    var llAudiolive: LinearLayout? = null
    var llVideolive:LinearLayout? = null
    var tvTile: TextView? = null
    var images = intArrayOf(R.drawable.panchangam, R.drawable.fest_2, R.drawable.rasiphalalu_3, R.drawable.muhur_2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_new)


        activity = this@CalendarNewActivity
        session = Session(activity)
        databaseHelper = DatabaseHelper(activity)


        // Video Live


        // Video Live
        cardVideolive = findViewById(R.id.cardVideolive)
        cardVideolive!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, VideoLiveActivity::class.java)
            startActivity(intent)
        })


        //Audio Live


        //Audio Live
        databaseHelper = DatabaseHelper(activity)
        recyclerView = findViewById(R.id.recyclerView)
       // val gridLayoutManager = GridLayoutManager(activity, 2)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false))
        audiolive()



        rvGrahaluStars = findViewById(R.id.rvGrahaluStars)
        rvPoojaluNomulu = findViewById(R.id.rvPoojaluNomulu)



        cardSmartTools = findViewById(R.id.cardSmartTools)
        cardSmartTools!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, SmartToolsActivity::class.java)
            startActivity(intent)
        })


        cardImageTab = findViewById(R.id.cardImageTab)
        cardVideoTab = findViewById(R.id.cardVideoTab)


        //Pochangam View


        //Pochangam View
        llThidhi = findViewById(R.id.llThidhi)
        llGowri = findViewById(R.id.llGowri)
        llRahukalam = findViewById(R.id.llRahukalam)
        llHora = findViewById(R.id.llHora)
        llKaranam = findViewById(R.id.llKaranam)
        llYogam = findViewById(R.id.llYogam)

        llThidhi!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ThidhiluActivity::class.java)
            startActivity(intent)
        })
        llGowri!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, GowriPanchangamActivity::class.java)
            startActivity(intent)
        })
        llRahukalam!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, RahukalamActivity::class.java)
            startActivity(intent)
        })
        llHora!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HoraChakramActivity::class.java)
            startActivity(intent)
        })
        llKaranam!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, KaranamActivity::class.java)
            startActivity(intent)
        })
        llYogam!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, YogamActivity::class.java)
            startActivity(intent)
        })



        sakunalu = findViewById(R.id.sakunalu)
        kaki = findViewById(R.id.kaki)
        pilli = findViewById(R.id.pilli_sasthram)
        balli = findViewById(R.id.balli)
        kukuta = findViewById(R.id.kukuta_sasthram)

        sakunaActivity = SakunaluActivity()
        kakiActivity = KakiActivity()
        pilliActivity = PilliSasthramActivity()
        balliActivity = BalliSasthramActivity()
        kukuta_sasthram = KukutaSaathramActivity()





        llTeluguYear = findViewById(R.id.llTeluguYear)
        llRashulu = findViewById(R.id.llRashulu)
        llMonth = findViewById(R.id.llMonth)
        more = findViewById(R.id.more)


        sliderView = findViewById(R.id.main_image)
//        val adapter = SliderAdapter(this)
//        adapter.addItem(SliderItem(images[0], "Panchangam"))
//        adapter.addItem(SliderItem(images[1], "Festivals"))
//        adapter.addItem(SliderItem(images[2], "Rasiphalalu"))
//        adapter.addItem(SliderItem(images[3], "Muhurthamulu"))
//        sliderView!!.setIndicatorAnimation(IndicatorAnimationType.WORM);
//        sliderView!!.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView!!.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR)
//        sliderView!!.setSliderAdapter(adapter)
//        sliderView!!.setAutoCycle(true);
//        sliderView!!.startAutoCycle();


        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.panchangam))
        imageList.add(SlideModel( R.drawable.fest_2))
        imageList.add(SlideModel( R.drawable.rasiphalalu_3))
        imageList.add(SlideModel(  R.drawable.muhur_2 ))



        val imageSlider = findViewById<ImageSlider>(R.id.main_image)
        imageSlider.setImageList(imageList)
        imageSlider.startSliding(3000) // with new period
        imageSlider.startSliding()
        imageSlider.setImageList(imageList, ScaleTypes.FIT)


        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {

                when (position) {
                    0 -> {
                        val intent = Intent(activity, PanchangamActivity::class.java)
                       startActivity(intent)
                    }
                    1 -> {
                        val intent1 = Intent(activity, FestivalActivity::class.java)
                        startActivity(intent1)
                    }
                    2 -> {
                        val intent2 = Intent(activity, RasiphaluluActivity::class.java)
                        startActivity(intent2)
                    }
                    3 -> {
                        val intent3 = Intent(activity, MuhurthamActivity::class.java)
                        startActivity(intent3)
                    }
                }
                // You can listen here
            }
        })


        llTeluguYear!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, TeluguYearActivity::class.java)
            startActivity(intent)
        })
        llRashulu!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, RashuluActivity::class.java)
            startActivity(intent)
        })
        llMonth!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MonthActivity::class.java)
            startActivity(intent)
        })

        more!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MoreTeluguSamskruthamActivity::class.java)
            startActivity(intent)
        })





        mahaBharatham = findViewById(R.id.maha_bharatham)
        ramayanam = findViewById(R.id.ramayanam)
        bhagvathGeetha = findViewById(R.id.bhagvath_geetha)
        bhagvatham = findViewById(R.id.bhagvatham)
        sethakamulu = findViewById(R.id.sethakamulu)
        sivaPuranam = findViewById(R.id.shiva_puranam)


        ramayanam!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "ramayanam")
            session!!.setData(Constant.MENU, "ramayanam_menu")
            session!!.setData(Constant.SUBMENU, "ramayanam_submenu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Ramayanam")
            startActivity(intent)
        })
        mahaBharatham!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "mahabharatham")
            session!!.setData(Constant.MENU, "mahabharatham_menu")
            session!!.setData(Constant.SUBMENU, "mahabharatham_submenu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Maha Bharatham")
            startActivity(intent)
        })
        bhagvathGeetha!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "bhagawath_geetha")
            session!!.setData(Constant.MENU, "bhagawath_geetha_menu")
            session!!.setData(Constant.SUBMENU, "bhagawath_geetha_submenu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Bhagvath Geetha")
            startActivity(intent)
        })
        bhagvatham!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "bhagawatham")
            session!!.setData(Constant.MENU, "bhagawatham_menu")
            session!!.setData(Constant.SUBMENU, "bhagawatham_submenu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Bhagvatham")
            startActivity(intent)
        })
        sethakamulu!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "telugu_sethakamulu")
            session!!.setData(Constant.MENU, "telugu_sethakamulu_menu")
            session!!.setData(Constant.SUBMENU, "telugu_sethakamulu_submenu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Sethakamulu")
            startActivity(intent)
        })
        sivaPuranam!!.setOnClickListener(View.OnClickListener {
            session!!.setData(Constant.TAB, "shivapuranam")
            session!!.setData(Constant.MENU, "")
            session!!.setData(Constant.SUBMENU, "shivapuranam_menu")
            val intent = Intent(activity, RamayanamActivity::class.java)
            intent.putExtra(Constant.TITLE, "Shiva Puranam")
            startActivity(intent)
        })




        cardOldArticles = findViewById(R.id.cardOldArticles)
        cardNewArticles = findViewById(R.id.cardNewArticles)
        cardNewArticles!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, NetiArticlesActivity::class.java)
            startActivity(intent)
        })
        cardOldArticles!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, OldArticlesActivity::class.java)
            startActivity(intent)
        })




        rvGrahaluStars!!.setLayoutManager(GridLayoutManager(activity, 4))
        rvPoojaluNomulu!!.setLayoutManager(GridLayoutManager(activity, 4))


        grahaluList()
        poojaluList()


        cardImageTab!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ImageTabActivity::class.java)
            startActivity(intent)
        })
        cardVideoTab!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, VideoTabActivity::class.java)
            startActivity(intent)
        })




        cardShare = findViewById(R.id.cardShare)
        Rateus = findViewById(R.id.Rateus)
        cardFeedback = findViewById(R.id.cardFeedback)
        cardPrivacy = findViewById(R.id.cardPrivacy)
        cardShare!!.setOnClickListener(View.OnClickListener {
            ShareCompat.IntentBuilder.from(activity!!)
                    .setType("text/plain")
                    .setChooserTitle("Chooser title")
                    .setText("http://play.google.com/store/apps/details?id=" + activity!!.packageName)
                    .startChooser()
        })
        Rateus!!.setOnClickListener(View.OnClickListener {
            val url = "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
        cardFeedback!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, FeedBackActivity::class.java)
            startActivity(intent)
        })
        cardPrivacy!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, PrivacyPolicyActivity::class.java)
            startActivity(intent)
        })











        sheet = findViewById(R.id.sheet)
        BottomSheetBehavior.from(sheet).apply {

            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

    }


    private fun poojaluList() {
        if (databaseHelper!!.poojaluList.size != 0) {
            poojaluAdapter = PoojaluAdapter(activity, databaseHelper!!.poojaluList,4,"home")
            rvPoojaluNomulu!!.adapter = poojaluAdapter
        } else {
            rvPoojaluNomulu!!.visibility = View.GONE
        }
    }

    private fun grahaluList() {
        if (databaseHelper!!.grahaluList.size != 0) {
            grahaluAdapter = GrahaluAdapter(activity, databaseHelper!!.grahaluList,4,"home")
            rvGrahaluStars!!.adapter = grahaluAdapter
        } else {
            rvGrahaluStars!!.visibility = View.GONE
        }
    }


    private fun loadSakunaSastharam(linearLayout: LinearLayout, activity: Activity) {
        linearLayout.setOnClickListener {
            val intent = Intent(activity, activity.javaClass)
            startActivity(intent)
        }
    }


    private fun audiolive() {
        Log.d("AUDIO_COUNT", databaseHelper!!.audiosCount.toString() + "")
        if (databaseHelper!!.audioList.size != 0) {
            audioLiveAdapter = AudioLiveAdapter(activity, databaseHelper!!.audioList)
            recyclerView!!.adapter = audioLiveAdapter
        } else {
            recyclerView!!.visibility = View.GONE
        }
    }
}