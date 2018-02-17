package com.example.florian.moncarnetderecettes.activity.data;

/**
 * Created by FLORIAN on 09/02/2018.
 */

public class Recette {
    private long id;
    private String nom;
    private String contenu;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Recette(String nom, String contenu, String note) {
        this.nom = nom;
        this.contenu = contenu;
        this.note = note;
    }
}
