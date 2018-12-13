package com.example.yann.easeychef;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;


public class Utils {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    protected final static String preferencias;

    static {
        preferencias = "ArquivoPreferencia";
    }

    public String getPreferencias() {
        return preferencias;
    }


}
