package com.softhans.savenotes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    private static final String TAG = "NoteListActivity";



    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "onCreate started.");


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });


       displayContent();
    }

    private void displayContent()
    {


        // Construct the data source
        ArrayList<NoteInfo> arrayOfNotes = NoteInfo.getNoteInfo();
// Create the adapter to convert the array to views
        NoteAdapter adapter = new NoteAdapter(this, arrayOfNotes);

// Attach the adapter to a ListView
       final ListView listNotes = findViewById(R.id.list_notes);

        listNotes.setAdapter(adapter);

       listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

               Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);

               NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
               intent.putExtra(NoteActivity.NOTE_INFO, note);
               startActivity(intent);

           }
       });


    }


}
