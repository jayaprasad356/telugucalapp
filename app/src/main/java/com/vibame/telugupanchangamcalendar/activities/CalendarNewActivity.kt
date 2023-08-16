package com.vibame.telugupanchangamcalendar.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ShareCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import com.vibame.telugupanchangamcalendar.*
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter
import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter
import com.vibame.telugupanchangamcalendar.helper.*
import com.vibame.telugupanchangamcalendar.model.Grahalu
import com.vibame.telugupanchangamcalendar.model.Poojalu
import com.vibame.telugupanchangamcalendar.viewpager2_.DailyPage1Activity
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*


class CalendarNewActivity : AppCompatActivity() {

    lateinit var sheet: FrameLayout

    var recyclerView: RecyclerView? = null
    var audioLiveAdapter: AudioLiveAdapter? = null
    var imgLeft: ImageView? = null
    var imgRight: android.widget.ImageView? = null
    lateinit var sliderView: ImageSlider
    var tvMonthYear: TextView? = null
    var month_year: String? = null
    var monthcount = 0
    var cal = Calendar.getInstance()
    var df = SimpleDateFormat("MMMM yyyy")
    var c = Calendar.getInstance()
    var databaseHelper: DatabaseHelper? = null
    var activity: Activity? = null
    lateinit var clicked: String


    var llNavaGrahalu: LinearLayout? = null
    var llNithyaParayana: LinearLayout? = null
    var llRashulu: LinearLayout? = null
    var llMonth: LinearLayout? = null
    var more: LinearLayout? = null
    var less: LinearLayout? = null

    var sakunaActivity: Activity? = null
    var kakiActivity: Activity? = null
    var pilliActivity: Activity? = null
    var balliActivity: Activity? = null
    var kukuta_sasthram: Activity? = null
    var sakunalu: LinearLayout? = null
    var kaki: LinearLayout? = null
    var pilli: LinearLayout? = null
    var balli: LinearLayout? = null
    var kukuta: LinearLayout? = null
    var rvPoojaluNomulu: RecyclerView? = null
    var rvGrahaluStars: RecyclerView? = null
    var grahaluAdapter: GrahaluAdapter? = null
    var poojaluAdapter: PoojaluAdapter? = null
    var cardVideoTab: CardView? = null
    var cardImageTab: CardView? = null
    var llThidhi: LinearLayout? = null
    var llGowri: LinearLayout? = null
    var llRahukalam: LinearLayout? = null
    var llHora: LinearLayout? = null
    var llKaranam: LinearLayout? = null
    var llYogam: LinearLayout? = null
    var mahaBharatham: CardView? = null
    var ramayanam: CardView? = null
    var bhagvathGeetha: CardView? = null
    var bhagvatham: CardView? = null
    var sethakamulu: CardView? = null
    var sivaPuranam: CardView? = null
    var cardShare: CardView? = null
    var Rateus: CardView? = null
    var cardFeedback: CardView? = null
    var cardPrivacy: CardView? = null
    var session: Session? = null
    var cardNewArticles: CardView? = null
    var cardOldArticles: CardView? = null
    var cardSmartTools: CardView? = null
    var cardVideolive: CardView? = null
    var llAudiolive: LinearLayout? = null
    var llVideolive: LinearLayout? = null
    var tvTile: TextView? = null
    var images = intArrayOf(
        R.drawable.panchangam,
        R.drawable.fest_2,
        R.drawable.rasiphalalu_3,
        R.drawable.muhur_2
    )
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var llShareapp: LinearLayout
    lateinit var llFeedback: LinearLayout
    lateinit var llPrivacypolicy: LinearLayout
    lateinit var llRateus: LinearLayout
    var nvDrawer: NavigationView? = null
    var currentversion = ""


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_new)


        activity = this@CalendarNewActivity
        session = Session(activity)
        databaseHelper = DatabaseHelper(activity)



        try {
            val pInfo = (activity as CalendarNewActivity).getPackageManager().getPackageInfo((activity as CalendarNewActivity).getPackageName(), 0)
            currentversion = pInfo.versionCode.toString() + ""
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        appupdate()



        var llAnkelu = findViewById<LinearLayout>(R.id.llAnkelu)
        var llTeluguYear = findViewById<LinearLayout>(R.id.llTeluguYear)
        var llAksharalu = findViewById<LinearLayout>(R.id.llAksharalu)
        var llGuninthalu = findViewById<LinearLayout>(R.id.llGuninthalu)
        var llMonth = findViewById<LinearLayout>(R.id.llMonth)
        var llJanapadha = findViewById<LinearLayout>(R.id.llJanapadha)
        var llKulavruthulu = findViewById<LinearLayout>(R.id.llKulavruthulu)
        var llNavagrahalu = findViewById<LinearLayout>(R.id.llNavagrahalu)
        var llRuthuvulu = findViewById<LinearLayout>(R.id.llRuthuvulu)
        var llKolathalu = findViewById<LinearLayout>(R.id.llKolathalu)
        var llPrasadhamnames = findViewById<LinearLayout>(R.id.llPrasadhamnames)
        var llLagnalu = findViewById<LinearLayout>(R.id.llLagnalu)
        var llThidhiadhi = findViewById<LinearLayout>(R.id.llThidhiadhi)
        var llWeeknames = findViewById<LinearLayout>(R.id.llWeeknames)
        var llFruitnames = findViewById<LinearLayout>(R.id.llFruitnames)
        var llPakshamulu = findViewById<LinearLayout>(R.id.llPakshamulu)
        var llPushapalu = findViewById<LinearLayout>(R.id.llPushapalu)
        var llRashulu = findViewById<LinearLayout>(R.id.llRashulu)


        var Ankelu = findViewById<ImageView>(R.id.Ankelu)
        var TeluguYear = findViewById<ImageView>(R.id.TeluguYear)
        var Aksharalu = findViewById<ImageView>(R.id.Aksharalu)
        var Guninthalu = findViewById<ImageView>(R.id.Guninthalu)
        var Month = findViewById<ImageView>(R.id.Month)
        var Janapadha = findViewById<ImageView>(R.id.Janapadha)
        var Kulavruthulu = findViewById<ImageView>(R.id.Kulavruthulu)
        var Navagrahalu = findViewById<ImageView>(R.id.Navagrahalu)
        var Ruthuvulu = findViewById<ImageView>(R.id.Ruthuvulu)
        var Kolathalu = findViewById<ImageView>(R.id.Kolathalu)
        var Prasadhamnames = findViewById<ImageView>(R.id.Prasadhamnames)
        var Lagnalu = findViewById<ImageView>(R.id.Lagnalu)
        var Thidhiadhi = findViewById<ImageView>(R.id.Thidhiadhi)
        var Weeknames = findViewById<ImageView>(R.id.Weeknames)
        var Fruitnames = findViewById<ImageView>(R.id.Fruitnames)
        var Pakshamulu = findViewById<ImageView>(R.id.Pakshamulu)
        var Pushapalu = findViewById<ImageView>(R.id.Pushapalu)
        var Rashulu = findViewById<ImageView>(R.id.Rashulu)




        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.ANKELU))
            .placeholder(R.drawable.logo).into(Ankelu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.TELUGUYEARS))
            .placeholder(R.drawable.logo).into(TeluguYear)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.AKSHARALU))
            .placeholder(R.drawable.logo).into(Aksharalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.GUNINTHALU))
            .placeholder(R.drawable.logo).into(Guninthalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.TELUGUMONTHS))
            .placeholder(R.drawable.logo).into(Month)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.NAVAGRAHALU))
            .placeholder(R.drawable.logo).into(Navagrahalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.RUTHUVULU))
            .placeholder(R.drawable.logo).into(Ruthuvulu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KOLATHALU))
            .placeholder(R.drawable.logo).into(Kolathalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KOLATHALU))
            .placeholder(R.drawable.logo).into(Kolathalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.PRASADHAMNAMES))
            .placeholder(R.drawable.logo).into(Prasadhamnames)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.LAGNAM))
            .placeholder(R.drawable.logo).into(Lagnalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.THIDHIADDHI))
            .placeholder(R.drawable.logo).into(Thidhiadhi)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.TELUGUWEEKS))
            .placeholder(R.drawable.logo).into(Weeknames)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.FRUITNAMES))
            .placeholder(R.drawable.logo).into(Fruitnames)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.PAKSHAMULU))
            .placeholder(R.drawable.logo).into(Pakshamulu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.PUSHPALU))
            .placeholder(R.drawable.logo).into(Pushapalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.RASHULU))
            .placeholder(R.drawable.logo).into(Rashulu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.VRUTHULU))
            .placeholder(R.drawable.logo).into(Kulavruthulu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KALALU))
            .placeholder(R.drawable.logo).into(Janapadha)


        var card1 = findViewById<CardView>(R.id.card1)
        var card2 = findViewById<CardView>(R.id.card2)
        var cardFestival = findViewById<CardView>(R.id.cardFestival)
        var cardImportant = findViewById<CardView>(R.id.cardImportant)
        var cardHolidays = findViewById<CardView>(R.id.cardHoliday)
        var cardHoroscope = findViewById<CardView>(R.id.cardHoroscope)
        var cardSissujanma = findViewById<CardView>(R.id.cardSissujanma)
        var cardMuhurtham = findViewById<CardView>(R.id.cardMuhurtham)
        var cardShasti = findViewById<CardView>(R.id.cardShasti)
        var llHoroscope = findViewById<LinearLayout>(R.id.llHoroscope)
        var llGowri1 = findViewById<LinearLayout>(R.id.llGowri1)
        var llBhargava = findViewById<LinearLayout>(R.id.llBhargava)
        var llabdhikam = findViewById<LinearLayout>(R.id.llabdhikam)
        var llGrahanam = findViewById<LinearLayout>(R.id.llGrahanam)
        var llMoudyaDinamulu = findViewById<LinearLayout>(R.id.llMoudyaDinamulu)
        var llRahuKaalam = findViewById<LinearLayout>(R.id.llRahuKaalam)
        var llGrahalu = findViewById<LinearLayout>(R.id.llGrahalu)

        if (!session!!.getBoolean(Constant.MONTHLY_PANCH_DATA)){
            montlyPanchangam()

        }
        card1.setOnClickListener {
            clicked="card1"
            dailyPanchangam()
        }
        // pesarathiu keatutha
        card2.setOnClickListener {
            clicked="card2"
            dailyPanchangam()
        }

        cardFestival.setOnClickListener {
            val intent = Intent(activity, FestivalActivity::class.java)
            startActivity(intent)
        }

        cardImportant.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ImpoetantDaysActivity::class.java)
            startActivity(intent)
        });

        cardHolidays.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HolidaysActivity::class.java)
            startActivity(intent)
        });

        cardHoroscope.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HoroscopeActivity::class.java)
            startActivity(intent)

        })


        cardSissujanma.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, SissuJanmaActivity::class.java)
            startActivity(intent)
        })


        cardMuhurtham.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(activity, com.vibame.telugupanchangamcalendar.MuhurthamActivity::class.java)
            startActivity(intent)
        })

        cardShasti.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ShastiVrustiActivity::class.java)
            startActivity(intent)
        })


        llGowri1.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, GowriPanchangamActivity::class.java)
            startActivity(intent)
        })


        llHoroscope.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HoraChakramActivity::class.java)
            startActivity(intent)
        })

        llabdhikam.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, AbdhikamActivity::class.java)
            startActivity(intent)
        })

        llGrahanam.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, GrahanamActivity::class.java)
            startActivity(intent)
        })


        llMoudyaDinamulu.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MoudyaDinamuluActivity::class.java)
            startActivity(intent)
        })


        llRahuKaalam.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, RahukalamActivity::class.java)
            startActivity(intent)
        })


        llGrahalu.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, GrahaluActivity::class.java)
            startActivity(intent)
        })





        llAnkelu.setOnClickListener {
            val intent = Intent(activity, AnkeluActivity::class.java)
            startActivity(intent)
        }
        llRashulu.setOnClickListener {
            val intent = Intent(activity, RashuluActivity::class.java)
            startActivity(intent)
        }
        llTeluguYear.setOnClickListener {
            val intent = Intent(activity, TeluguYearActivity::class.java)
            startActivity(intent)
        }
        llMonth.setOnClickListener {
            val intent = Intent(activity, MonthActivity::class.java)
            startActivity(intent)
        }
        llAksharalu.setOnClickListener {
            val intent = Intent(activity, AksharaluActivity::class.java)
            startActivity(intent)
        }
        llGuninthalu.setOnClickListener {
            val intent = Intent(activity, GunintaluActivity::class.java)
            startActivity(intent)
        }
        llJanapadha.setOnClickListener {
            val intent = Intent(activity, JanaPadhaActivity::class.java)
            startActivity(intent)
        }
        llKulavruthulu.setOnClickListener {
            val intent = Intent(activity, KulaVurthaActivity::class.java)
            startActivity(intent)
        }
        llNavagrahalu.setOnClickListener {
            val intent = Intent(activity, NavaGrahaluActivity::class.java)
            startActivity(intent)
        }
        llRuthuvulu.setOnClickListener {
            val intent = Intent(activity, RuthuvuluActivity::class.java)
            startActivity(intent)
        }
        llKolathalu.setOnClickListener {
            val intent = Intent(activity, KolathaluActivity::class.java)
            startActivity(intent)
        }
        llPrasadhamnames.setOnClickListener {
            val intent = Intent(activity, PrasadhamNamesActivity::class.java)
            startActivity(intent)
        }
        llLagnalu.setOnClickListener {
            val intent = Intent(activity, LagnaluActivity::class.java)
            startActivity(intent)
        }
        llThidhiadhi.setOnClickListener {
            val intent = Intent(activity, ThidhiAdhiActivity::class.java)
            startActivity(intent)
        }
        llWeeknames.setOnClickListener {
            val intent = Intent(activity, WeekNamesActivity::class.java)
            startActivity(intent)
        }
        llFruitnames.setOnClickListener {
            val intent = Intent(activity, FruitNamesActivity::class.java)
            startActivity(intent)
        }
        llPakshamulu.setOnClickListener {
            val intent = Intent(activity, PakahamuluActivity::class.java)
            startActivity(intent)
        }
        llPushapalu.setOnClickListener {
            val intent = Intent(activity, PushapaluActivity::class.java)
            startActivity(intent)
        }

        llBhargava.setOnClickListener(

            View.OnClickListener {
                val intent = Intent(activity, BhargavaPanchangamActivity::class.java)
                startActivity(intent)
            }
        )


        var cvBhakthiGeethalu = findViewById<CardView>(R.id.cvBhakthiGeethalu)
        var cvLiveDharsanam = findViewById<CardView>(R.id.cvLiveDharsanam)

        cvBhakthiGeethalu.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, NewBakthiMusicActivity::class.java)
            startActivity(intent)
        })

        cvLiveDharsanam.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, LiveDharsanamActivity::class.java)
            startActivity(intent)
        })

        var imageold = findViewById<ImageView>(R.id.imageold);
        var imageneti = findViewById<ImageView>(R.id.imageneti);
        var image = findViewById<ImageView>(R.id.image);
        var liveimage = findViewById<ImageView>(R.id.liveimage);
        var imagetab = findViewById<ImageView>(R.id.imagetab);
        var videotab = findViewById<ImageView>(R.id.videotab);
        var imgyogam = findViewById<ImageView>(R.id.imgyogam);
        var imgrahu = findViewById<ImageView>(R.id.imgrahu);
        var imgKaranam = findViewById<ImageView>(R.id.imgKaranam);
        var imgThidhi = findViewById<ImageView>(R.id.imgThidhi);
        var imghora = findViewById<ImageView>(R.id.imghora);
        var imgowri = findViewById<ImageView>(R.id.imgowri);
        var imgsakunalu = findViewById<ImageView>(R.id.imgsakunalu);
        var imgpalli = findViewById<ImageView>(R.id.imgpalli);
        var imgkukuta = findViewById<ImageView>(R.id.imgkukuta);
        var imgkaki = findViewById<ImageView>(R.id.imgkaki);
        var imgballi = findViewById<ImageView>(R.id.imgballi);
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.GODIMAGE))
            .placeholder(R.drawable.logo).into(image)
        Glide.with(activity as CalendarNewActivity)
            .load(session!!.getData(Constant.LIVE_TELECAST_IMAGE)).placeholder(R.drawable.logo)
            .into(liveimage)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.IMAGE_TAB))
            .placeholder(R.drawable.logo).into(imagetab)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.VIDEO_TAB))
            .placeholder(R.drawable.logo).into(videotab)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.GOWRI_IMAGE))
            .placeholder(R.drawable.logo).into(imgowri)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.THIDHI_IMAGE))
            .placeholder(R.drawable.logo).into(imgThidhi)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KARANAM_IMAGE))
            .placeholder(R.drawable.logo).into(imgKaranam)
        Glide.with(activity as CalendarNewActivity)
            .load(session!!.getData(Constant.RAHUKALAM_IMAGE)).placeholder(R.drawable.logo)
            .into(imgrahu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.YOGAM_IMAGE))
            .placeholder(R.drawable.logo).into(imgyogam)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.CHAKRAM_IMAGE))
            .placeholder(R.drawable.logo).into(imghora)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.SAKUNALU_IMAGE))
            .placeholder(R.drawable.logo).into(imgsakunalu)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.PILLI_IMAGE))
            .placeholder(R.drawable.logo).into(imgpalli)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KUKUTA_IMAGE))
            .placeholder(R.drawable.logo).into(imgkukuta)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.KAKI_IMAGE))
            .placeholder(R.drawable.logo).into(imgkaki)
        Glide.with(activity as CalendarNewActivity).load(session!!.getData(Constant.BALLI_IMAGE))
            .placeholder(R.drawable.logo).into(imgballi)
        Glide.with(activity as CalendarNewActivity)
            .load(session!!.getData(Constant.NETI_ARTI_IMAGE)).placeholder(R.drawable.logo)
            .into(imageneti)
        Glide.with(activity as CalendarNewActivity)
            .load(session!!.getData(Constant.OLD_ARTI_IMAGES)).placeholder(R.drawable.logo)
            .into(imageold)



        val mButton = findViewById<RelativeLayout>(R.id.sidemenu)
        val mNotification = findViewById<RelativeLayout>(R.id.notification)


        mNotification.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        })

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mButton.setOnClickListener { //startActivity(new Intent(activity, AksharaluActivity.class));
            drawerLayout!!.openDrawer(GravityCompat.START)
        }
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nvDrawer = findViewById<View>(R.id.nav_view) as NavigationView
        setupDrawerContent(nvDrawer!!)

        val headerView: View = layoutInflater.inflate(R.layout.nav_header_main, nvDrawer, false)
        nvDrawer!!.addHeaderView(headerView)

        /* TODO get the IMAGE and make it clickable */


        /* TODO get the IMAGE and make it clickable */
        llShareapp = headerView.findViewById<View>(R.id.llShareapp) as LinearLayout
        llFeedback = headerView.findViewById<View>(R.id.llFeedback) as LinearLayout
        llPrivacypolicy = headerView.findViewById<View>(R.id.llPrivacypolicy) as LinearLayout
        llRateus = headerView.findViewById<View>(R.id.llRateus) as LinearLayout



        llShareapp!!.setOnClickListener(View.OnClickListener {
            ShareCompat.IntentBuilder.from(activity!!)
                .setType("text/plain")
                .setChooserTitle("Chooser title")
                .setText("http://play.google.com/store/apps/details?id=" + activity!!.packageName)
                .startChooser()
        })
        llRateus!!.setOnClickListener(View.OnClickListener {
            val url = "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
        llFeedback!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, FeedBackActivity::class.java)
            startActivity(intent)
        })
        llPrivacypolicy!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, PrivacyPolicyActivity::class.java)
            startActivity(intent)
        })


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
        recyclerView!!.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
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


        sakunalu!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, SakunaluActivity::class.java)
            startActivity(intent)
        })

        kaki!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, KakiActivity::class.java)
            startActivity(intent)
        })


        pilli!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, PilliSasthramActivity::class.java)
            startActivity(intent)
        })


        balli!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, BalliSasthramActivity::class.java)
            startActivity(intent)
        })

        kukuta!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, KukutaSaathramActivity::class.java)
            startActivity(intent)
        })




        sakunaActivity = SakunaluActivity()
        kakiActivity = KakiActivity()
        pilliActivity = PilliSasthramActivity()
        balliActivity = BalliSasthramActivity()
        kukuta_sasthram = KukutaSaathramActivity()





        llTeluguYear = findViewById(R.id.llTeluguYear)
        llRashulu = findViewById(R.id.llRashulu)
        llMonth = findViewById(R.id.llMonth)
        more = findViewById(R.id.more)
        less=findViewById(R.id.ll_less)


//        sliderView = findViewById(R.id.main_image)
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
        imageList.add(SlideModel(R.drawable.fest_2))
        imageList.add(SlideModel(R.drawable.rasiphalalu_3))
        imageList.add(SlideModel(R.drawable.muhur_2))


//        val imageSlider = findViewById<ImageSlider>(R.id.main_image)
//        imageSlider.setImageList(imageList)
//        imageSlider.startSliding(3000) // with new period
//        imageSlider.startSliding()
//        imageSlider.setImageList(imageList, ScaleTypes.FIT)

//
//        imageSlider.setItemClickListener(object : ItemClickListener {
//            override fun onItemSelected(position: Int) {
//
//                when (position) {
//                    0 -> {
//                        val intent = Intent(activity, PanchangamActivity::class.java)
//                       startActivity(intent)
//                    }
//                    1 -> {
//                        val intent1 = Intent(activity, FestivalActivity::class.java)
//                        startActivity(intent1)
//                    }
//                    2 -> {
//                        val intent2 = Intent(activity, RasiphaluluActivity::class.java)
//                        startActivity(intent2)
//                    }
//                    3 -> {
//                        val intent3 = Intent(activity, MuhurthamActivity::class.java)
//                        startActivity(intent3)
//                    }
//                }
//                // You can listen here
//            }
//        })


        more!!.setOnClickListener(View.OnClickListener {

            var lltelungusanskritmore = findViewById<LinearLayout>(R.id.lltelungusanskritmore);

            lltelungusanskritmore!!.visibility = View.VISIBLE
            llAksharalu!!.visibility = View.VISIBLE
            more!!.visibility = View.GONE


        })

        less!!.setOnClickListener {
            var lltelungusanskritmore = findViewById<LinearLayout>(R.id.lltelungusanskritmore);

            lltelungusanskritmore!!.visibility = View.GONE
            llAksharalu!!.visibility = View.GONE
            more!!.visibility = View.VISIBLE

        }






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

    private fun setupDrawerContent(nvDrawer: NavigationView) {

    }
    private fun poojaluList() {
        if (databaseHelper!!.poojaluList.size != 0) {
            // Create a new array list to hold the data
            val updatedPoojaluList = ArrayList<Poojalu>()

            // Add data from the database helper to the array list
            updatedPoojaluList.addAll(databaseHelper!!.poojaluList)

            // Create a new Poojalu instance for the "Less" item
            val lessItem = Poojalu("new_id", "Less", "local")

            // Add the "Less" item to the array list
            updatedPoojaluList.add(lessItem)

            // Create the adapter with the updated array list
            poojaluAdapter = PoojaluAdapter(activity, updatedPoojaluList, 4, "home")
            rvPoojaluNomulu!!.adapter = poojaluAdapter
        } else {
            rvPoojaluNomulu!!.visibility = View.GONE
        }
    }


   // private fun poojaluList() {
   //
   //    if (databaseHelper!!.poojaluList.size != 0) {

   //        poojaluAdapter = PoojaluAdapter(activity, databaseHelper!!.poojaluList, 4, "home")
   //        rvPoojaluNomulu!!.adapter = poojaluAdapter
   //    } else {
   //        rvPoojaluNomulu!!.visibility = View.GONE
   //    }
   //}

    private fun grahaluList() {
        if (databaseHelper!!.grahaluList.size != 0) {

            val updatedgrahaluList = ArrayList<Grahalu>();

            updatedgrahaluList.addAll(databaseHelper!!.grahaluList)

            // Create a new Poojalu instance for the "Less" item
            val lessItem = Grahalu("new_id", "Less", "local")

            // Add the "Less" item to the array list
            updatedgrahaluList.add(lessItem)
            grahaluAdapter = GrahaluAdapter(activity, updatedgrahaluList, 4, "home")
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
    private fun dailyPanchangam() {
        if (session!!.getBoolean(Constant.DAILY_PANCHANG_DATA)){
            if (clicked.equals("card1")) {
                val intent = Intent(activity, DailyPage1Activity::class.java)
                intent.putExtra("id", "1")
                startActivity(intent)
            }else if (clicked.equals("card2")){
                val intent = Intent(activity, MonthlyPanchangam::class.java)
                startActivity(intent)
            }
        }else {
            val params = HashMap<String, String>()
            ApiConfig.RequestToVolley({ result: Boolean, response: String? ->
                if (result) {
                    try {
                        val jsonObject = JSONObject(response)
                        if (jsonObject.getBoolean(Constant.SUCCESS)) {
                            Log.d("", response!!)
                            val jsonArray3 =
                                jsonObject.getJSONArray(Constant.DATA)
                            for (i in 0 until jsonArray3.length()) {
                                val jsonObject1 = jsonArray3.getJSONObject(i)
                                if (jsonObject1 != null) {
//                                databaseHelper.AddToDailyPanchangam(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MONTH),jsonObject1.getString(Constant.YEAR),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));
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

//                                Toast.makeText(activity, "Daily Panchangam Added Successfully", Toast.LENGTH_SHORT).show();
//                                panchangamlist(Date);
//
//
//                                databaseHelper.getDailyPanchangam().size();
//                                Log.d("dailyPanchangamList", String.valueOf(databaseHelper.getDailyPanchangam().size()));
                                    //   tvTitle.setText(databaseHelper.getsubha_muhurtham(Month,year).get(0).getText1());


//                              Toast.makeText(activity, ""+Date, Toast.LENGTH_SHORT).show();
//


//                                festivalAdapter = new FestivalAdapter(FestivalActivity.this,databaseHelper.getmonthFestivalList(date));
//                                recyclerView.setAdapter(festivalAdapter);
                                } else {
                                    break
                                }
                            }
                            if (clicked.equals("card1")) {
                                session?.setBoolean(Constant.DAILY_PANCHANG_DATA, true)
                                val intent = Intent(activity, DailyPanchangamActivity::class.java)
                                intent.putExtra("id", "1")
                                startActivity(intent)
                            }else if (clicked.equals("card2")){
                                session?.setBoolean(Constant.DAILY_PANCHANG_DATA, true)
                                val intent = Intent(activity, MonthlyPanchangam::class.java)
                                startActivity(intent)
                            }
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
    }
    private fun montlyPanchangam() {



        val params = HashMap<String, String>()

        ApiConfig.RequestToVolley({ result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("monthlypanchangamlist", response!!)
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper!!.AddToMontlyPanchangam(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MONTH),
                                    jsonObject1.getString(Constant.YEAR),
                                    jsonObject1.getString(Constant.TEXT1),
                                    jsonObject1.getString(Constant.POURNAMI),
                                    jsonObject1.getString(Constant.AMAVASYA),
                                    jsonObject1.getString(Constant.AKADHASHI),
                                    jsonObject1.getString(Constant.PRADHOSHA),
                                    jsonObject1.getString(Constant.SHASTI),
                                    jsonObject1.getString(Constant.CHAVITHI),
                                    jsonObject1.getString(Constant.MASASHIVARATRI),
                                    jsonObject1.getString(Constant.SANKATAHARA_CHATHURDHI),
                                    jsonObject1.getString(Constant.FESTIVALS),
                                    jsonObject1.getString(Constant.HOLIDAY)
                                )
                            }
                        }






                        session?.setBoolean(Constant.MONTHLY_PANCH_DATA,true)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }, activity, Constant.MONTHLY_PANCHANGAMLIST, params, true)


    }

    private fun appupdate() {
        val params: Map<String, String> = HashMap()
        ApiConfig.RequestToVolley({ result, response ->
            Log.d("CAT_RES", response)
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("CAT_RES", response)
                        val `object` = JSONObject(response)
                        val jsonArray = `object`.getJSONArray(Constant.DATA)
                        val latestversion = jsonArray.getJSONObject(0).getString(Constant.VERSION)
                        val link = jsonArray.getJSONObject(0).getString(Constant.LINK)
                        if (currentversion.toInt() >= latestversion.toInt()) {
//                            Toast.makeText(
//                                this,
//                                "You are using Latest Version",
//                                Toast.LENGTH_SHORT
//                            ).show()
                        } else {

                            val bottomSheetDialog = BottomSheetDialog(this)
                            val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
                            bottomSheetDialog.setContentView(view)

                            // Assuming there is an update button in the bottom_sheet_layout.xml
                            val updateButton = view.findViewById<Button>(R.id.updateButton)
                            updateButton.setOnClickListener {
                                // Handle the update button click here
                                // You can perform actions like initiating the download or redirecting to the app store.
                                // For example:
//                                redirectToPlayStore(link) // You need to implement this function.
                            //    bottomSheetDialog.dismiss() // Dismiss the bottom sheet after clicking the button.


                                // Redirect the user to the Google Play Store or your server's download page
                                // to download the latest version of the app
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                                startActivity(intent)


                            }

                            bottomSheetDialog.setCancelable(false)

                            bottomSheetDialog.show()

                        }
                    } else {
                        Toast.makeText(
                            this,
                            "Hi" + jsonObject.getString(Constant.MESSAGE).toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toast.makeText(this, "hi$e", Toast.LENGTH_SHORT).show()
                }
            }
        }, this, Constant.APPUPDATE, params, true)
    }


}