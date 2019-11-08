package com.softhans.savenotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

final public class NoteInfo implements Parcelable {
    private String title;
    private String note;

    public NoteInfo (String title, String note) {
        this.title = title;
        this.note = note;
    }

    private  NoteInfo(Parcel parcel)
    {
        title = parcel.readString();
        note = parcel.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static ArrayList<NoteInfo> getNoteInfo() {
        ArrayList<NoteInfo> noteInfo = new ArrayList<NoteInfo>();
        noteInfo.add(new NoteInfo("Harry", "San Diego"));
        noteInfo.add(new NoteInfo("Marla", "San Francisco"));
        noteInfo.add(new NoteInfo("Sarah", "San Marco"));
        return noteInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(note);

    }

    public static final Parcelable.Creator<NoteInfo> CREATOR = new Parcelable.Creator<NoteInfo>() {
        @Override
        public NoteInfo createFromParcel(Parcel parcel) {
            return new NoteInfo(parcel);
        }

        @Override
        public NoteInfo[] newArray(int size)
        {
            return new NoteInfo[size];
        }
    };
}
