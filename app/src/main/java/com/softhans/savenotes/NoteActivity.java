package com.softhans.savenotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    public static final String NOTE_INFO = "com.softhans.savenotes.NOTE_INFO";

    private EditText mTitle, mText;
    private NoteInfo mNote;
    private boolean mIsNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitle = findViewById(R.id.text_note_title);
        mText = findViewById(R.id.text_note_text);

 //        Spinner spinnerCourse = findViewById(R.id.spinner_course);


////populating SPinner
//        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.Category));
//
//        //code to get and display spinner as drop down  list
//        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerCourse.setAdapter(mAdapter);


        readDisplayedValues();
            if(!mIsNewNote) // so as to be able to creat new notes.
        displayNote(mTitle, mText);
    }

    private void displayNote(EditText title, EditText text)
    {
        mTitle.setText(mNote.getTitle());
        mText.setText(mNote.getNote());

    }

    private void readDisplayedValues()
    {
        Intent intent = getIntent();
        mNote = intent.getParcelableExtra(NOTE_INFO);

        mIsNewNote = mNote == null;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_send_email) {

            sendEmail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendEmail()
    {
        String subject = mTitle.getText().toString();
        String text = mText.getText().toString();

        //Intent to send the email
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc2822"); // message/rfc2822 is a standard internet mime type for sending emails.
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }
}
