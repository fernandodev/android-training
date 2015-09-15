package com.fernandodev.fragmentsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fernandodev.fragmentsample.R;
import com.fernandodev.fragmentsample.entities.Storage;
import com.fernandodev.fragmentsample.fragments.HelloFragment;

public class MainActivity extends AppCompatActivity {

  View container;
  Storage storage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    container = findViewById(R.id.container);
    storage = new Storage(this);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, HelloFragment.newInstance("Hello World"))
        .commit();
  }
}
