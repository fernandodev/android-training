package com.fernandodev.apisample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fernandodev.apisample.R;
import com.fernandodev.apisample.entities.Response;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fernando on 9/14/15.
 */
public class RankingFragment extends Fragment {

  @Bind(R.id.list)
  ListView mListView;

  public static RankingFragment newInstance() {

    Bundle args = new Bundle();

    RankingFragment fragment = new RankingFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    return inflater.inflate(R.layout.fragment_ranking, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    Ion.with(getActivity())
        .load("https://www.kimonolabs.com/api/5nn2kvn8?apikey=GdxdJZvzxQRP6h5lAb3Ts1smNG8Csc6B")
        .setHeader("Content-Type", "application/json")
        .as(Response.class)
        .withResponse()
        .setCallback(new FutureCallback<com.koushikdutta.ion.Response<Response>>() {
          @Override
          public void onCompleted(Exception e, com.koushikdutta.ion.Response<Response> result) {
            if (e == null) {
              Log.d("APISAMPLE", "RESULT: " + result.getResult().getName());
            } else {
              Log.d("APISAMPLE", "RESULT E: " + e.getMessage());
            }
          }
        });
  }
}
