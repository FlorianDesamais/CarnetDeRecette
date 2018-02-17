package com.example.florian.moncarnetderecettes.activity.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLORIAN on 09/02/2018.
 */

public class RecetteDataSource {

    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public RecetteDataSource(Context context) {
        helper = new RecetteDBHelper(context);
    }

    private RecetteDBHelper helper;

    private String[] allColumns = {RecetteContract.RecetteEntry.COLUMN_NAME_ID,RecetteContract.RecetteEntry.COLUMN_NAME_NOM,
            RecetteContract.RecetteEntry.COLUMN_NAME_CONTENU,RecetteContract.RecetteEntry.COLUMN_NAME_NOTE};


    public void open() throws SQLException{
        database = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }

    public List<Recette> getAllRecettes(){
        List<Recette> liste = new ArrayList<>();
        Cursor cursor = database.query(RecetteContract.RecetteEntry.TABLE_NAME, allColumns,null,null,null,null,RecetteContract.RecetteEntry.COLUMN_NAME_NOM);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Recette recette = cursorToRecette(cursor);
            liste.add(recette);
            cursor.moveToNext();
        }
        cursor.close();
        return liste;
    }

    public ElementsBDD getAllElementsBDD(List<Recette> liste){
        String[] nom = new String[20];
        String[] contenu = new String[20];
        String[] note = new String[20];

        for (int i =0; i<liste.size();i++){
            nom[i] = liste.get(i).getNom();
            contenu[i] = liste.get(i).getContenu();
            note[i] = liste.get(i).getNote();
        }

        return new ElementsBDD(nom,contenu,note);
    }

    private Recette cursorToRecette(Cursor cursor) {
        Recette recette = new Recette("","","");
        recette.setId(cursor.getLong(0));
        recette.setNom(cursor.getString(1));
        recette.setContenu(cursor.getString(2));
        recette.setNote(cursor.getString(3));
        return recette;
    }

    public long addRecetteInDB(Recette recette){
        ContentValues values = new ContentValues();
        values.put(RecetteContract.RecetteEntry.COLUMN_NAME_NOM,recette.getNom());
        values.put(RecetteContract.RecetteEntry.COLUMN_NAME_CONTENU,recette.getContenu());
        values.put(RecetteContract.RecetteEntry.COLUMN_NAME_NOTE, recette.getNote());
        return database.insert(RecetteContract.RecetteEntry.TABLE_NAME,null,values);
    }

    public void add3RecettesDeTest(){
       addRecetteInDB(new Recette("Tarte au citron","Du citron et de la meringue","3/5"));
       addRecetteInDB(new Recette("Gateau au chocolat","Du beurre et du chocolat","2/5"));
       addRecetteInDB(new Recette("Crepes au sucre","Du sucre, de la farine et du beurre","5/5"));

    }


}
