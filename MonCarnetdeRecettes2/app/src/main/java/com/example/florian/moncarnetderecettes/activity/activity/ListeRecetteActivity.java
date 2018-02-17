package com.example.florian.moncarnetderecettes.activity.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.fragment.ListeRecetteFragment;
import com.example.florian.moncarnetderecettes.activity.fragment.UneRecetteFragment;

public class ListeRecetteActivity extends AppCompatActivity implements ListeRecetteFragment.OnInteractionListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_recette_layout);

        FragmentManager fragManager = getFragmentManager();
        if (fragManager.findFragmentById(R.id.fragment_liste) == null){
            fragManager.beginTransaction().add(R.id.fragment_liste, new ListeRecetteFragment()).commit();
        }



    }

    @Override
    public void onDogSelected(int position) {
        startActivity(UneRecetteActivity.getIntent(this,position));
    }
}
