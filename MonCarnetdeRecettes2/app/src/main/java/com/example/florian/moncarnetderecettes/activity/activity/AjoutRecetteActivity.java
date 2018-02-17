package com.example.florian.moncarnetderecettes.activity.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.fragment.AjoutRecetteFragment;

/**
 * Created by FLORIAN on 07/02/2018.
 */

public class AjoutRecetteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_recette);

        FragmentManager fragManager = getFragmentManager();
        if (fragManager.findFragmentById(R.id.fragment_ajout) == null){
            fragManager.beginTransaction().add(R.id.fragment_ajout, new AjoutRecetteFragment()).commit();
        }


    }
}
