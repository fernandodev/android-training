package com.fernandodev.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by fernando on 9/2/15.
 */
public class MyApplication extends Application {

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    Log.d("MyApp", "MYAPP - attachBaseContext");
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Log.d("MyApp", "MYAPP - onCreate");
  }
}
