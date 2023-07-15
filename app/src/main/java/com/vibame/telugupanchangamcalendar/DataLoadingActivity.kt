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



        loadData()
    }

    private fun loadData() {
        subha_muhurtham()
    }


    private fun subha_muhurtham() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley(VolleyCallback { result, response ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("horo", response)
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                // databaseHelper.AddToHolidays(jsonObject1.getString(Constant.ID), jsonObject1.getString(Constant.MONTH), jsonObject1.getString(Constant.YEAR), jsonObject1.getString(Constant.TITLE), jsonObject1.getString(Constant.DESCRIPTION));
                                databaseHelper.AddToSubhaMuhurtha(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.MONTH),
                                    jsonObject1.getString(Constant.YEAR),
                                    jsonObject1.getString(Constant.TEXT1)

                                            // 2nd API call
                                )


                                subha_muhurthamList()

                            } else {
                                break
                            }
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
        }, activity, Constant.SUBHA_MUHURTHAMULU_LIST, params, true)
    }

    private fun subha_muhurthamList() {
        val params = HashMap<String, String>()
        ApiConfig.RequestToVolley(VolleyCallback { result, response ->
            if (result) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("horo", response)
                        val jsonArray3 = jsonObject.getJSONArray(Constant.DATA)
                        for (i in 0 until jsonArray3.length()) {
                            val jsonObject1 = jsonArray3.getJSONObject(i)
                            if (jsonObject1 != null) {
                                // databaseHelper.AddToHolidays(jsonObject1.getString(Constant.ID), jsonObject1.getString(Constant.MONTH), jsonObject1.getString(Constant.YEAR), jsonObject1.getString(Constant.TITLE), jsonObject1.getString(Constant.DESCRIPTION));
                                databaseHelper.AddToSubhaMuhurthaList(
                                    jsonObject1.getString(Constant.ID),
                                    jsonObject1.getString(Constant.SUBHA_MUHURTHAM_ID),
                                    jsonObject1.getString(Constant.DATE_MONTH),
                                    jsonObject1.getString(Constant.DESCRIPTION)
                                )

                                val i = Intent(activity, CalendarNewActivity::class.java)
                                session.setData(Constant.DATA_LOADING, "1")
                                startActivity(i)
                                finish()


                            } else {
                                break
                            }
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
        }, activity, Constant.SUBHA_MUHURTHAM_VARIANT_LIST, params, true)
    }



















}
