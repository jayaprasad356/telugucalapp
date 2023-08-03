package com.vibame.telugupanchangamcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vibame.telugupanchangamcalendar.adapter.NotificationAdapter
import com.vibame.telugupanchangamcalendar.model.Notification

class NotificationActivity : AppCompatActivity() {

    // Sample notification list
    private val notificationList = ArrayList<Notification>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // Creating sample notification objects
        val notification1 = Notification("1", "Notification 1", "2023-08-03", "10:00 AM")
        val notification2 = Notification("2", "Notification 2", "2023-08-04", "02:30 PM")

        // Adding them to the list
        notificationList.add(notification1)
        notificationList.add(notification2)

        // Get a reference to the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rv_notification)

        // Create and set the layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create the adapter and set it to the RecyclerView
        val adapter = NotificationAdapter(this, notificationList)
        recyclerView.adapter = adapter
    }
}