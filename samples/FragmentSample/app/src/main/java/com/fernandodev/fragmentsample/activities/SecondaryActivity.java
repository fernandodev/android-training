package com.fernandodev.fragmentsample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fernandodev.fragmentsample.R;

/**
 * Created by fernando on 9/9/15.
 */
public class SecondaryActivity extends AppCompatActivity {

  TextView mContent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_secondary);

    mContent = (TextView) findViewById(R.id.content);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();

    if (extras != null) {
      String email = extras.getString("key_email");
      mContent.setText(mContent.getText() + email);
    }

  }
}
