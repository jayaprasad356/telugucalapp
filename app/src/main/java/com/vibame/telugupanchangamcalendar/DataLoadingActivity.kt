package com.vibame.telugupanchangamcalendar

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vibame.telugupanchangamcalendar.activities.CalendarNewActivity
import com.vibame.telugupanchangamcalendar.helper.*
import org.json.JSONException
import org.json.JSONObject

class DataLoadingActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var progressDialog: ProgressDialog
    private  lateinit var  session: Session
    private lateinit var activity: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_loading)

        activity = this

        session = Session(this)

        databaseHelper = DatabaseHelper(this)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading Data")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.max = 100
        progressDialog.progress = 0
        progressDialog.show()

        loadData()
    }

    private fun loadData() {
        getDatalist()
    }

    private fun monthFestivalsList() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley(VolleyCallback { result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToMonthFestival(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MONTH),
                                    jsonObject1.getString(Constant.YEAR),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        updateProgressDialog(33)
                        holidaysList()
                    } else {
                        Toast.makeText(
                            this,
                            jsonObject.getString(Constant.MESSAGE),
                            Toast.LENGTH_SHORT
                        ).show()
                        progressDialog.dismiss()
                        finish()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    progressDialog.dismiss()
                    finish()
                }
            }
        }, this, Constant.MONTH_FESTIVALS_LIST, params, true)
    }

    private fun holidaysList() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley(VolleyCallback { result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToHolidays(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MONTH),
                                    jsonObject1.getString(Constant.YEAR),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        updateProgressDialog(66)
                        importantDaysList()
                    } else {
                        Toast.makeText(
                            this,
                            jsonObject.getString(Constant.MESSAGE),
                            Toast.LENGTH_SHORT
                        ).show()
                        progressDialog.dismiss()
                        finish()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    progressDialog.dismiss()
                    finish()
                }
            }
        }, this, Constant.HOLIDAYS_LIST, params, true)
    }

    private fun importantDaysList() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley(VolleyCallback { result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToImportantdays(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MONTH),
                                    jsonObject1.getString(Constant.YEAR),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        updateProgressDialog(100)
                        startMainActivity()
                    } else {
                        Toast.makeText(
                            this,
                            jsonObject.getString(Constant.MESSAGE),
                            Toast.LENGTH_SHORT
                        ).show()
                        progressDialog.dismiss()
                        finish()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    progressDialog.dismiss()
                    finish()
                }
            }
        }, this, Constant.IMPORTANT_DAYS_LIST, params, true)
    }

    private fun updateProgressDialog(progress: Int) {
        progressDialog.progress = progress
    }

    private fun getDatalist() {
        val params: Map<String, String> = java.util.HashMap()
        ApiConfig.RequestToVolley({ result: Boolean, response: String? ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("ALL_DATA", response!!)
                        databaseHelper.deleteDb(activity)
                        val `object` = JSONObject(response)
                        val setArray =
                            `object`.getJSONArray(Constant.SETTINGS_LIST)
                        val setArraySakunaSasthram =
                            `object`.getJSONArray(Constant.SAKUNA_SASTHRAM_LIST)
                        val setArrayTeluguSamkrutham =
                            `object`.getJSONArray(Constant.TELUGU_SAMKRUTHAM_LIST)
                        val image = setArray.getJSONObject(0)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.GODIMAGE,
                            image
                        )
                        val live_telecast_image = setArray.getJSONObject(0)
                            .getString(Constant.TELECAST_IMAGE)
                        session.setData(
                            Constant.LIVE_TELECAST_IMAGE,
                            live_telecast_image
                        )
                        val imagetab = setArray.getJSONObject(0)
                            .getString(Constant.IMAGE_TAB)
                        session.setData(
                            Constant.IMAGE_TAB,
                            imagetab
                        )
                        val videotab = setArray.getJSONObject(0)
                            .getString(Constant.VIDEO_TAB)
                        session.setData(
                            Constant.VIDEO_TAB,
                            videotab
                        )
                        val gowri_image = setArray.getJSONObject(0)
                            .getString(Constant.GOWRI_IMAGE)
                        session.setData(
                            Constant.GOWRI_IMAGE,
                            gowri_image
                        )
                        val chakram_image = setArray.getJSONObject(0)
                            .getString(Constant.CHAKRAM_IMAGE)
                        session.setData(
                            Constant.CHAKRAM_IMAGE,
                            chakram_image
                        )
                        val thidhi_image = setArray.getJSONObject(0)
                            .getString(Constant.THIDHI_IMAGE)
                        session.setData(
                            Constant.THIDHI_IMAGE,
                            thidhi_image
                        )
                        val karanam_image = setArray.getJSONObject(0)
                            .getString(Constant.KARANAM_IMAGE)
                        session.setData(
                            Constant.KARANAM_IMAGE,
                            karanam_image
                        )
                        val rahukalam_image = setArray.getJSONObject(0)
                            .getString(Constant.RAHUKALAM_IMAGE)
                        session.setData(
                            Constant.RAHUKALAM_IMAGE,
                            rahukalam_image
                        )
                        val yogam_image = setArray.getJSONObject(0)
                            .getString(Constant.YOGAM_IMAGE)
                        session.setData(
                            Constant.YOGAM_IMAGE,
                            yogam_image
                        )
                        val neti_arti_image = setArray.getJSONObject(0)
                            .getString(Constant.NETI_ARTI_IMAGE)
                        session.setData(
                            Constant.NETI_ARTI_IMAGE,
                            neti_arti_image
                        )
                        val old_arti_images = setArray.getJSONObject(0)
                            .getString(Constant.OLD_ARTI_IMAGES)
                        session.setData(
                            Constant.OLD_ARTI_IMAGES,
                            old_arti_images
                        )
                        val sakunalu_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.SAKUNALU_IMAGE)
                        session.setData(
                            Constant.SAKUNALU_IMAGE,
                            sakunalu_image
                        )
                        val balli_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.BALLI_IMAGE)
                        session.setData(
                            Constant.BALLI_IMAGE,
                            balli_image
                        )
                        val kaki_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.KAKI_IMAGE)
                        session.setData(
                            Constant.KAKI_IMAGE,
                            kaki_image
                        )
                        val kukuta_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.KUKUTA_IMAGE)
                        session.setData(
                            Constant.KUKUTA_IMAGE,
                            kukuta_image
                        )
                        val sasthram_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.SASTHRAM_IMAGE)
                        session.setData(
                            Constant.SASTHRAM_IMAGE,
                            sasthram_image
                        )
                        val pilli_image = setArraySakunaSasthram.getJSONObject(0)
                            .getString(Constant.PILLI_IMAGE)
                        session.setData(
                            Constant.PILLI_IMAGE,
                            pilli_image
                        )
                        val TeluguYears = setArrayTeluguSamkrutham.getJSONObject(0)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.TELUGUYEARS,
                            TeluguYears
                        )
                        val TeluguMonths = setArrayTeluguSamkrutham.getJSONObject(1)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.TELUGUMONTHS,
                            TeluguMonths
                        )
                        val TeluguWeeks = setArrayTeluguSamkrutham.getJSONObject(2)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.TELUGUWEEKS,
                            TeluguWeeks
                        )
                        val Ankelu = setArrayTeluguSamkrutham.getJSONObject(3)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.ANKELU,
                            Ankelu
                        )
                        val Aksharalu = setArrayTeluguSamkrutham.getJSONObject(4)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.AKSHARALU,
                            Aksharalu
                        )
                        val Guninthalu = setArrayTeluguSamkrutham.getJSONObject(5)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.GUNINTHALU,
                            Guninthalu
                        )
                        val Rashulu = setArrayTeluguSamkrutham.getJSONObject(6)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.RASHULU,
                            Rashulu
                        )
                        val kalalu = setArrayTeluguSamkrutham.getJSONObject(7)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.KALALU,
                            kalalu
                        )
                        val Vruthulu = setArrayTeluguSamkrutham.getJSONObject(8)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.VRUTHULU,
                            Vruthulu
                        )
                        val Navagrahalu = setArrayTeluguSamkrutham.getJSONObject(9)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.NAVAGRAHALU,
                            Navagrahalu
                        )
                        val Ruthuvulu = setArrayTeluguSamkrutham.getJSONObject(10)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.RUTHUVULU,
                            Ruthuvulu
                        )
                        val Kolathalu = setArrayTeluguSamkrutham.getJSONObject(11)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.KOLATHALU,
                            Kolathalu
                        )
                        val Pakshamulu = setArrayTeluguSamkrutham.getJSONObject(12)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.PAKSHAMULU,
                            Pakshamulu
                        )
                        val Lagnam = setArrayTeluguSamkrutham.getJSONObject(13)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.LAGNAM,
                            Lagnam
                        )
                        val ThidhiAddhi = setArrayTeluguSamkrutham.getJSONObject(14)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.THIDHIADDHI,
                            ThidhiAddhi
                        )
                        val Pushpalu = setArrayTeluguSamkrutham.getJSONObject(15)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.PUSHPALU,
                            Pushpalu
                        )
                        val FruitNames = setArrayTeluguSamkrutham.getJSONObject(16)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.FRUITNAMES,
                            FruitNames
                        )
                        val PrasadhamNames = setArrayTeluguSamkrutham.getJSONObject(17)
                            .getString(Constant.IMAGE)
                        session.setData(
                            Constant.PRASADHAMNAMES,
                            PrasadhamNames
                        )
                        //Toast.makeText(activity, ""+image, Toast.LENGTH_SHORT).show();
                        val jsonArray2 =
                            `object`.getJSONArray(Constant.PANCHANGAM_TAB_LIST)
                        for (i in 0 until jsonArray2.length()) {
                            val jsonObject1 = jsonArray2.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPanchangamTab(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.PANCHANGAM_ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        //                        JSONArray jsonArray3 = object.getJSONArray(Constant.FESTIVALS_LIST);
//
//                        for (int i = 0; i < jsonArray3.length(); i++) {
//                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
//                            if (jsonObject1 != null) {
//                                databaseHelper.AddToFestival(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.DATE),jsonObject1.getString(Constant.FESTIVAL));
//                            } else {
//                                break;
//                            }
//                        }
                        val jsonArray4 =
                            `object`.getJSONArray(Constant.MUHURTHAM_LIST)
                        for (i in 0 until jsonArray4.length()) {
                            val jsonObject1 = jsonArray4.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToMuhurtham(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MUHURTHAM)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray5 =
                            `object`.getJSONArray(Constant.MUHURTHAM_TAB_LIST)
                        for (i in 0 until jsonArray5.length()) {
                            val jsonObject1 = jsonArray5.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToMuhurthamTab(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MUHURTHAM_ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray6 =
                            `object`.getJSONArray(Constant.POOJALU_LIST)
                        for (i in 0 until jsonArray6.length()) {
                            val jsonObject1 = jsonArray6.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojalu(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.NAME),
                                    jsonObject1.getString(Constant.IMAGE)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray7 =
                            `object`.getJSONArray(Constant.POOJALU_SUB_MENU_LIST)
                        for (i in 0 until jsonArray7.length()) {
                            val jsonObject1 = jsonArray7.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojaluSubMenu(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.POOJALU_ID),
                                    jsonObject1.getString(Constant.NAME),
                                    jsonObject1.getString(Constant.IMAGE)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray8 =
                            `object`.getJSONArray(Constant.POOJALU_TAB_LIST)
                        for (i in 0 until jsonArray8.length()) {
                            val jsonObject1 = jsonArray8.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPoojaluTab(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.POOJALU_ID),
                                    jsonObject1.getString(Constant.SUBCATEGORY_ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION),
                                    jsonObject1.getString(Constant.SUB_TITLE),
                                    jsonObject1.getString(Constant.SUB_DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray9 =
                            `object`.getJSONArray(Constant.GRAHALU_LIST)
                        for (i in 0 until jsonArray9.length()) {
                            val jsonObject1 = jsonArray9.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahalu(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.NAME),
                                    jsonObject1.getString(Constant.IMAGE)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray10 =
                            `object`.getJSONArray(Constant.GRAHALU_SUB_MENU_LIST)
                        for (i in 0 until jsonArray10.length()) {
                            val jsonObject1 = jsonArray10.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahuluSubMenu(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.GRAHALU_ID),
                                    jsonObject1.getString(Constant.NAME),
                                    jsonObject1.getString(Constant.IMAGE)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray11 =
                            `object`.getJSONArray(Constant.GRAHALU_TAB_LIST)
                        for (i in 0 until jsonArray11.length()) {
                            val jsonObject1 = jsonArray11.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToGrahaluTab(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.GRAHALU_ID),
                                    jsonObject1.getString(Constant.SUBCATEGORY_ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION),
                                    jsonObject1.getString(Constant.SUB_TITLE),
                                    jsonObject1.getString(Constant.SUB_DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray12 =
                            `object`.getJSONArray(Constant.NAKSHATRALU_LIST)
                        for (i in 0 until jsonArray12.length()) {
                            val jsonObject1 = jsonArray12.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToNakshatralu(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.NAME),
                                    jsonObject1.getString(Constant.IMAGE)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray13 =
                            `object`.getJSONArray(Constant.VIDEO_LIST)
                        for (i in 0 until jsonArray13.length()) {
                            val jsonObject1 = jsonArray13.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToVideo(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.LINK)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray14 =
                            `object`.getJSONArray(Constant.AUDIO_LIST)
                        Log.d("AUDIO_LIST", jsonArray14.toString())
                        for (i in 0 until jsonArray14.length()) {
                            val jsonObject1 = jsonArray14.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToAudio(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.IMAGE),
                                    jsonObject1.getString(Constant.LYRICS),
                                    jsonObject1.getString(Constant.AUDIO)
                                )
                            } else {
                                break
                            }
                        }
                        val jsonArray15 =
                            `object`.getJSONArray(Constant.NAKSHATRALU_TAB_LIST)
                        for (i in 0 until jsonArray15.length()) {
                            val jsonObject1 = jsonArray15.getJSONObject(i)
                            if (jsonObject1 != null) {
                                databaseHelper.AddToNakshatharaluTab(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.NAKSHATRALU_ID),
                                    jsonObject1.getString(Constant.TITLE),
                                    jsonObject1.getString(Constant.DESCRIPTION),
                                    jsonObject1.getString(Constant.SUB_TITLE),
                                    jsonObject1.getString(Constant.SUB_DESCRIPTION)
                                )
                            } else {
                                break
                            }
                        }
                        updateProgressDialog(15)
                        monthFestivalsList()
                    } else {
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }, activity, Constant.ALLDATALIST_URL, params, true)
    }

    private fun startMainActivity() {
        session.setData(Constant.DATA_LOADING, "1")
        progressDialog.dismiss()
        val intent = Intent(this, CalendarNewActivity::class.java)
        startActivity(intent)
        finish()
    }
}
