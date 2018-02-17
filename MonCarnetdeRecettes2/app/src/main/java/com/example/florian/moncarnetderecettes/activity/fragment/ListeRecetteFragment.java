package com.example.florian.moncarnetderecettes.activity.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.adapter.AdapterRecette;
import com.example.florian.moncarnetderecettes.activity.data.ElementsBDD;
import com.example.florian.moncarnetderecettes.activity.data.Recette;
import com.example.florian.moncarnetderecettes.activity.data.RecetteDataSource;
import com.example.florian.moncarnetderecettes.activity.activity.AjoutRecetteActivity;

import java.util.List;

/**
 * Created by FLORIAN on 09/01/2018.
 */

public class ListeRecetteFragment extends Fragment implements AdapterRecette.Callbacks{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static RecetteDataSource bds;
    private String[] nomsRecettes = new String[20];
    private String[] notesRecettes = new String[20];
    private String[] contenuRecettes = new String[20];

    public interface OnInteractionListener {
        void onDogSelected(int position);

    }
    private OnInteractionListener listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_liste_layout,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMaster);
        mLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        nomsRecettes[0] = "Gateau au chocolat";
        notesRecettes[0] = "3";
        contenuRecettes[0] = "200g de chocolat + 200g de beurre";
        nomsRecettes[1] = "Tarte au citron";
        notesRecettes[1] = "5";
        contenuRecettes[1] = "Citron et meringue";
        bds = new RecetteDataSource(view.getContext());
        bds.open();
        //bds.add3RecettesDeTest();
        List<Recette> liste = bds.getAllRecettes();
        ElementsBDD elem = bds.getAllElementsBDD(liste);
        mAdapter = new AdapterRecette(elem.getNomsRecettes(),elem.getNotesRecettes(),this);
        mRecyclerView.setAdapter(mAdapter);

        Button ajouter = (Button) view.findViewById(R.id.buttonAjouter);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent ajout = new Intent(v.getContext(),AjoutRecetteActivity.class);
                startActivity(ajout);
            }
        });
       return view;
    }

    @Override
    public void onRecetteSelected(int position) {
        listener.onDogSelected(position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInteractionListener) {
            listener = (OnInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
