package com.example.florian.moncarnetderecettes.activity.activity;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.fragment.AjoutRecetteFragment;
import com.example.florian.moncarnetderecettes.activity.fragment.UneRecetteFragment;

/**
 * Created by FLORIAN on 12/02/2018.
 */

public class UneRecetteActivity extends AppCompatActivity {

    private static final String INITIAL_POSITION ="INITIAL_POSITION";

    public static Intent getIntent(Context context, int initialPosition) {
        Intent intent = new Intent(context, UneRecetteActivity.class);
        intent.putExtra(INITIAL_POSITION, initialPosition);
        return  intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_recette);

        FragmentManager fragManager = getFragmentManager();
        if (fragManager.findFragmentById(R.id.fragment_detail_layout) == null){
            fragManager.beginTransaction().add(R.id.fragment_detail_layout, new UneRecetteFragment()).commit();
        }
    }
}
