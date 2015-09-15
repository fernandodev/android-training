package com.fernandodev.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

  Service service;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Retrofit build = new Retrofit.Builder()
        .baseUrl("http://kimonolabs.com")
        .client(new OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    service = build.create(Service.class);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Call<Response> response = service.players("GdxdJZvzxQRP6h5lAb3Ts1smNG8Csc6B");
    response.enqueue(new Callback<Response>() {
      @Override
      public void onResponse(retrofit.Response<Response> response) {
        Log.d("Retrofit Sample", "RESULT: " + response.body().name);
      }

      @Override
      public void onFailure(Throwable t) {

      }
    });
  }
}
