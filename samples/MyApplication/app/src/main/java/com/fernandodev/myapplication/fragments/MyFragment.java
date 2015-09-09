package com.fernandodev.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandodev.myapplication.R;

/**
 * Created by fernando on 9/2/15.
 */
public class MyFragment extends Fragment {

  String mMessage;

  public static MyFragment newInstance(String message) {

    Bundle args = new Bundle();
    args.putString("key_message", message);

    MyFragment fragment = new MyFragment();
    fragment.setArguments(args);

    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle arguments = getArguments();
    if (arguments != null) {
      mMessage = arguments.getString("key_message");
    }
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_my, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    TextView textView = (TextView) view.findViewById(R.id.message);
    textView.setText(mMessage);
  }
}
