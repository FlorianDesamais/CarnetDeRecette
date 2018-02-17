package com.example.florian.moncarnetderecettes.activity.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.content.ContentResolver;

/**
 * Created by FLORIAN on 19/01/2018.
 */

public final class RecetteContract {
    public static final String CONTENT_AUTHORITY = "com.example.florian.moncarnetderecettes" ;
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_RECETTE = "recette";

    private RecetteContract(){}

    public static abstract class RecetteEntry implements BaseColumns{

        /** The content URI to access the recette data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_RECETTE);
        /** The MIME type of the {@link #CONTENT_URI} for a list of recettes. */
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RECETTE;
        /** The MIME type of the {@link #CONTENT_URI} for a single recette. */
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RECETTE;




        public static final String TABLE_NAME = "recette";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NOM = "nom";
        public static final String COLUMN_NAME_CONTENU = "contenu";
        public static final String COLUMN_NAME_NOTE = "note";
    }

}
