package com.softhans.savenotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<NoteInfo> {
    public NoteAdapter(Context context, ArrayList<NoteInfo> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        NoteInfo note = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_layout_view, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = convertView.findViewById(R.id.title_view);
        TextView tvNotes = convertView.findViewById(R.id.note_view);

        // Populate the data into the template view using the data object
        tvTitle.setText(note.getTitle());
        tvNotes.setText(note.getNote());

        // Return the completed view to render on screen
        return convertView;
    }
}
