package com.jgmanz.jogal.teacherdasboard.data;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class LocalData {
    public static String PREFS_NAME = "APP2";

    public static void savePreferences(Context con, String k, String v) {
        SharedPreferences settings = con.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(k, v);
        editor.commit();
    }

   /* public static void savePreferences(Context con, String k, Map m) {
        SharedPreferences settings = con.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.commit();
    }*/

    public static String getPreference(Context con, String data) {
        SharedPreferences myPrefs;
        myPrefs = con.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String StoredValue = myPrefs.getString(data, "");
        return StoredValue;
    }
}
