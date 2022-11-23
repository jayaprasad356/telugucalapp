package com.vibame.telugupanchangamcalendar.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.vibame.telugupanchangamcalendar.R;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity implements View.OnClickListener {
    int noteId;
    Button saveBtn;
    ImageView imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editText);
        saveBtn = findViewById(R.id.save_btn);
        imgBtn = findViewById(R.id.imgBack);
        imgBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);

        // Fetch data that is passed from MainActivity
        Intent intent = getIntent();

        // Accessing the data using key and value
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1) {
            editText.setText(NotesActivity.notes.get(noteId));
        } else {

            NotesActivity.notes.add("");
            noteId = NotesActivity.notes.size() - 1;
            NotesActivity.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NotesActivity.notes.set(noteId, String.valueOf(charSequence));
                NotesActivity.arrayAdapter.notifyDataSetChanged();
                // Creating Object of SharedPreferences to store data in the phone
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(NotesActivity.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}