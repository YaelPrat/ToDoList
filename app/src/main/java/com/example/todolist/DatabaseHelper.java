package com.example.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NotesDatabase";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //create the db
        String sqlQuery = "CREATE TABLE Note(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // when db version change
        String sqlQuery = "DROP TABLE IF EXISTS Note";
        db.execSQL(sqlQuery);
        onCreate(db); // delete the old one and create new one

    }
}
