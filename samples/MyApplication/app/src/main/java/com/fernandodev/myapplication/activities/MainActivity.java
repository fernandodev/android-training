package com.fernandodev.myapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fernandodev.myapplication.R;
import com.fernandodev.myapplication.fragments.MyFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.container, MyFragment.newInstance("Hi Folks"))
        .commit();
  }

}
