package com.evanemran.notekeeper.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.evanemran.notekeeper.Models.Notes;

@Database(entities = {Notes.class}, version = 4, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB database;
    private static String DATABASE_NAME = "NoteKeeper";

    public synchronized static RoomDB getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

            /*//adding demo data
            Notes note1 = new Notes();
            Notes note2 = new Notes();
            Notes note3 = new Notes();
            note1.setTitle("Your title");
            note1.setNotes("Your description here!");
            note2.setTitle("Create a new note");
            note2.setNotes("You can edit this note or also make a new note by clicking on the \"plus\" button below.");
            note3.setTitle("Task name");
            note3.setNotes("Things to do!");
            database.mainDAO().insert(note1);
            database.mainDAO().insert(note2);
            database.mainDAO().insert(note3);*/
        }
        return database;
    }

    public abstract MainDAO mainDAO();
}
