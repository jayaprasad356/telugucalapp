package com.vibame.telugupanchangamcalendar

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vibame.telugupanchangamcalendar.helper.Constant

class NewOldArticleActivity : AppCompatActivity() {


    lateinit var tvDescription: TextView
    lateinit  var tvTitle : TextView
    lateinit  var tvHead : TextView
    lateinit var activity: Activity
    lateinit var imgGod : ImageView
    lateinit var imgBack : ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_old_article)
        activity = this


        val Title = intent.getStringExtra(Constant.TITLE)
        val Decription = intent.getStringExtra(Constant.DESCRIPTION)
        val Image = intent.getStringExtra(Constant.IMAGE)
        val Name = intent.getStringExtra(Constant.NAME)

        tvDescription = findViewById(R.id.tvDescription)
        tvTitle = findViewById(R.id.tvTitle)
        tvHead = findViewById(R.id.tvHead)
        imgGod = findViewById(R.id.imgGod)
        imgBack = findViewById(R.id.imgBack)


        imgBack.setOnClickListener { onBackPressed() }





        tvDescription.text = Decription
        tvTitle.text = Title
        tvHead.text = Name
        Glide.with(activity).load(Image).into(imgGod)


    }
}