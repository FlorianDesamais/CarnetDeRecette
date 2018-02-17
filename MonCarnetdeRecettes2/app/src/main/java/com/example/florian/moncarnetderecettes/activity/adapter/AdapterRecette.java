package com.example.florian.moncarnetderecettes.activity.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.florian.moncarnetderecettes.R;

/**
 * Created by FLORIAN on 12/01/2018.
 */

public class AdapterRecette extends RecyclerView.Adapter<AdapterRecette.ViewHolder>{

    private String[] nomsRecettes;
    private String[] notesRecettes;


    public interface Callbacks {
        void onRecetteSelected(int position);
    }

    private Callbacks listener;


    public AdapterRecette(String[] nomsRecettes, String[] notesRecettes, Callbacks listen) {
        this.nomsRecettes = nomsRecettes;
        this.notesRecettes = notesRecettes;
        listener = listen;
    }

    @Override
    public AdapterRecette.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_liste_recette, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNom.setText(nomsRecettes[position]);
        holder.tvNote.setText(notesRecettes[position]);
    }



    @Override
    public int getItemCount() {

        if (nomsRecettes == null){
            return 0;
        }
        else return nomsRecettes.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        // each data item
        public TextView tvNom;
        public TextView tvNote;


        public ViewHolder(View view, final Callbacks listener)
        {
            super(view);
            tvNom = (TextView) itemView.findViewById(R.id.tv_titre);
            tvNote = (TextView) itemView.findViewById(R.id.tv_note);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener){
                        listener.onRecetteSelected(getAdapterPosition());
                    }
                }
            });

        }

    }

}

