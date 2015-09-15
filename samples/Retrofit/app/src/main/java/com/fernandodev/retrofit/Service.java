package com.fernandodev.retrofit;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by fernando on 9/14/15.
 */
public interface Service {
  String ACCEPT_APPLICATION_JSON = "Accept: application/json";
  String CONTENT_TYPE_APPLICATION_JSON = "Content-Type: application/json";
  String API_KEY = "apikey";

  @Headers({ACCEPT_APPLICATION_JSON, CONTENT_TYPE_APPLICATION_JSON})
  @GET("/api/5nn2kvn8")
  Call<Response> players(@Query(API_KEY) String apiKey);
}
