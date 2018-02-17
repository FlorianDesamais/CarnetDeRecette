package com.example.florian.moncarnetderecettes.activity.data;

/**
 * Created by FLORIAN on 09/02/2018.
 */

public class ElementsBDD {

    public String[] nomsRecettes;
    public String[] contenusRecette;
    public String[] notesRecettes;

    public ElementsBDD(String[] nomsRecettes, String[] contenusRecette, String[] notesRecettes) {
        this.nomsRecettes = nomsRecettes;
        this.contenusRecette = contenusRecette;
        this.notesRecettes = notesRecettes;
    }

    public String[] getNomsRecettes() {
        return nomsRecettes;
    }

    public void setNomsRecettes(String[] nomsRecettes) {
        this.nomsRecettes = nomsRecettes;
    }

    public String[] getContenusRecette() {
        return contenusRecette;
    }

    public void setContenusRecette(String[] contenusRecette) {
        this.contenusRecette = contenusRecette;
    }

    public String[] getNotesRecettes() {
        return notesRecettes;
    }

    public void setNotesRecettes(String[] notesRecettes) {
        this.notesRecettes = notesRecettes;
    }
}
