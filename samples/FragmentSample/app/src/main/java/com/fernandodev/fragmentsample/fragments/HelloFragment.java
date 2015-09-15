package com.fernandodev.fragmentsample.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernandodev.fragmentsample.Config;
import com.fernandodev.fragmentsample.R;
import com.fernandodev.fragmentsample.activities.SecondaryActivity;
import com.fernandodev.fragmentsample.entities.Storage;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fernando on 8/28/15.
 */
public class HelloFragment extends Fragment {

  @Bind(R.id.avatar)
  ImageView mAvatar;
  @Bind(R.id.name)
  TextView mName;
  @Bind(R.id.email)
  EditText mEmail;
  @Bind(R.id.login)
  Button mLogin;

  String message;
  Storage storage;
  Config config;

  public static HelloFragment newInstance(String message) {

    Bundle args = new Bundle();
    args.putString("fragment.message", message);

    HelloFragment fragment = new HelloFragment();
    fragment.setArguments(args);

    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle arguments = getArguments();
    message = arguments.getString("fragment.message");
    config = new Config(getActivity());
    storage = new Storage(getActivity());
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_hello, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    mName.setText(storage.getUserName());
    mLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(getActivity(), SecondaryActivity.class);

        String email = mEmail.getText().toString();
        i.putExtra("key_email", email);
        getActivity().startActivity(i);
        getActivity().finish();
      }
    });

    Picasso.with(getContext())
        .load("http://findicons.com/files/icons/1072/face_avatars/300/i03.png")
        .placeholder(R.drawable.profile)
        .into(mAvatar);
  }
}
