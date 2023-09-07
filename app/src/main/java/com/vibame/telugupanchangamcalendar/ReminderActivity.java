package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vibame.telugupanchangamcalendar.activities.FestivalActivity;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RemindAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Reminder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReminderActivity extends AppCompatActivity {

    ImageView back;
    FloatingActionButton fab;
    RecyclerView recycler_view;
    DatabaseHelper databaseHelper;


    EditText notesEditText;
    CheckBox remindMeCheckBox;
    Button dateButton;
    Button timeButton;
    TextView okTextView;
    TextView cancelTextView;

    // Declare a variable for the AlertDialog
    Dialog customDialog;


    // Declare variables for date and time pickers
    Calendar calendar;
    int year, month, day, hour, minute;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        activity = ReminderActivity.this;


        fab = findViewById(R.id.fab);
        back = findViewById(R.id.back);
        recycler_view = findViewById(R.id.recycler_view);

        databaseHelper = new DatabaseHelper(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);

        back.setOnClickListener(v -> onBackPressed());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show the custom dialog
                showCustomDialog();
            }
        });

        reminderlist();


    }


    private void reminderlist() {

//        ArrayList<Reminder> reminders = new ArrayList<>();
//
//
//        Reminder rings1 = new Reminder("Hi","Hi","22-02-2023","08:23 pm");
//
//
//
//        reminders.add(rings1);
//
//        RemindAdapter remindAdapter = new RemindAdapter(this, reminders);
//        recycler_view.setAdapter(remindAdapter);



        RemindAdapter remindAdapter = new RemindAdapter(this, databaseHelper.getRemindersList());
        recycler_view.setAdapter(remindAdapter);


    }


    private void showCustomDialog() {
        // Create a custom dialog
        customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.custom_dialog);

        // Initialize elements in the custom dialog
        notesEditText = customDialog.findViewById(R.id.notes);
        remindMeCheckBox = customDialog.findViewById(R.id.reminder);
        dateButton = customDialog.findViewById(R.id.date);
        timeButton = customDialog.findViewById(R.id.time);
        okTextView = customDialog.findViewById(R.id.ok);
        cancelTextView = customDialog.findViewById(R.id.cancel);

        LinearLayout dateLayout = customDialog.findViewById(R.id.date_layout);


        // Set a listener for the remindMeCheckBox to show/hide the date_layout
        remindMeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Show or hide the date_layout based on the checkbox state
                if (isChecked) {
                    dateLayout.setVisibility(View.VISIBLE);
                } else {
                    dateLayout.setVisibility(View.GONE);
                }
            }
        });

        // Set a listener for the dateButton to open the DatePickerDialog
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        // Set a listener for the timeButton to open the TimePickerDialog
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });


        // Set current date in the date button
        setDateButtonCurrentDate();

        // Set current time in the time button
        setTimeButtonCurrentTime();

        // Set click listeners for elements in the custom dialog
        okTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = "Hi";
                boolean remindMe = remindMeCheckBox.isChecked();
                String date = "22-02-2023";
                String time = "08:23 pm";
                String id = "1";


                databaseHelper.AddToReminderTab(activity,id,title, date, time);

                Toast.makeText(ReminderActivity.this, ""+databaseHelper.getRemindersList().size(), Toast.LENGTH_SHORT).show();


                RemindAdapter remindAdapter = new RemindAdapter(ReminderActivity.this, databaseHelper.getRemindersList());
                recycler_view.setAdapter(remindAdapter);



                customDialog.dismiss();


            }
        });

        cancelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Cancel button click in the custom dialog
                // You can perform any actions you need here
                // Dismiss the custom dialog
                customDialog.dismiss();
            }
        });

        // Show the custom dialog
        customDialog.show();
    }


    private void setDateButtonCurrentDate() {
        // Get the current date and format it
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());

        // Set the current date in the date button
        dateButton.setText(currentDate);
    }

    private void setTimeButtonCurrentTime() {
        // Get the current time and format it in 12-hour format with AM/PM
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String currentTime = timeFormat.format(Calendar.getInstance().getTime());

        // Set the current time in the time button
        timeButton.setText(currentTime);
    }


    private void showDatePicker() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        // Update the dateButton with the selected date
                        calendar.set(selectedYear, selectedMonth, selectedDay);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        dateButton.setText(dateFormat.format(calendar.getTime()));
                    }
                }, year, month, day);
        datePickerDialog.show();


    }

    private void showTimePicker() {
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        // Update the timeButton with the selected time
                        calendar.set(Calendar.HOUR_OF_DAY, selectedHour);
                        calendar.set(Calendar.MINUTE, selectedMinute);
                        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                        timeButton.setText(timeFormat.format(calendar.getTime()));
                    }
                }, hour, minute, false); // Use 12-hour format
        timePickerDialog.show();
    }


}

