package com.fernandodev.apisample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fernandodev.apisample.R;
import com.fernandodev.apisample.fragments.RankingFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.container, RankingFragment.newInstance())
        .commit();
  }
}
