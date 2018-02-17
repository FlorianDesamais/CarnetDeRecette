package com.example.florian.moncarnetderecettes.activity.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.activity.AjoutRecetteActivity;

/**
 * Created by FLORIAN on 12/02/2018.
 */

public class UneRecetteFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_layout,container,false);
        return v;
    }
}
