package com.example.florian.moncarnetderecettes.activity.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.florian.moncarnetderecettes.R;
import com.example.florian.moncarnetderecettes.activity.activity.AjoutRecetteActivity;
import com.example.florian.moncarnetderecettes.activity.activity.ListeRecetteActivity;
import com.example.florian.moncarnetderecettes.activity.data.Recette;
import com.example.florian.moncarnetderecettes.activity.data.RecetteDataSource;

/**
 * Created by FLORIAN on 07/02/2018.
 */

public class AjoutRecetteFragment extends Fragment {

    public RecetteDataSource rds = ListeRecetteFragment.bds;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ajout_recette,container,false);
        Button valider = (Button)view.findViewById(R.id.buttonValider);
        final Button annuler = (Button)view.findViewById(R.id.buttonAnnuler);
        final EditText editNom = (EditText)view.findViewById(R.id.editTextNom);
        final EditText editContenu = (EditText)view.findViewById(R.id.editTextContenu);
        final EditText editNote = (EditText)view.findViewById(R.id.editTextNote);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editNom.getText().toString().equals("") && !editContenu.getText().toString().equals("")){
                    rds.addRecetteInDB(new Recette(editNom.getText().toString().trim(),
                            editContenu.getText().toString().trim(),editNote.getText().toString().trim()));
                    showOk(v.getContext(),"Ajout réussi");
                    startActivity(new Intent(v.getContext(), ListeRecetteActivity.class));
                }
                else {
                    showAlert(v.getContext(),"Impossible d'ajouter une recette sans nom ni sans contenu");
                }
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent pagePrincipale = new Intent(v.getContext(), ListeRecetteActivity.class);
                startActivity(pagePrincipale);
            }
        });

        return view;
    }

    private void showAlert(Context context, String message) {
        AlertDialog alertDialogBuilder = new AlertDialog.Builder(context).setMessage(message).setTitle("Erreur rencontrée").show();
    }

    private void showOk(Context context, String message) {
        AlertDialog alertDialogBuilder = new AlertDialog.Builder(context).setMessage(message).setTitle("Valider").show();
    }




}
