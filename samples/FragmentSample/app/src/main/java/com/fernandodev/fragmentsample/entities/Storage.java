package com.fernandodev.fragmentsample.entities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fernando on 9/11/15.
 */
public class Storage {

  private static final String PREFS_NAME = "user_settings";

  Context context;
  SharedPreferences settings;

  public Storage(Context context) {
    this.context = context;
    settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
  }

  public void setUserName(String name) {
    settings.edit().putString("user.name", name).apply();
  }

  public String getUserName() {
    return settings.getString("user.name","");
  }
}
