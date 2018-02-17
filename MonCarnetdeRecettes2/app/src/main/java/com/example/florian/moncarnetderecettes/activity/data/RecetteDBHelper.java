package com.example.florian.moncarnetderecettes.activity.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.florian.moncarnetderecettes.activity.data.RecetteContract.RecetteEntry;

/**
 * Created by FLORIAN on 19/01/2018.
 */

public class RecetteDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "RecetteBase.db";

    private static final String SQL_CREATE_RECETTE_TABLE =
            "CREATE TABLE "+RecetteEntry.TABLE_NAME+" (" +
            RecetteEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            RecetteEntry.COLUMN_NAME_NOM + " TEXT, "+
            RecetteEntry.COLUMN_NAME_CONTENU + " TEXT, "+
            RecetteEntry.COLUMN_NAME_NOTE + " TEXT)";

    private static final String SQL_DELETE_RECETTE_TABLE =
            "DROP TABLE IF EXISTS " + RecetteEntry.TABLE_NAME;

    public RecetteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_RECETTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_RECETTE_TABLE);
        onCreate(db);
    }
}
