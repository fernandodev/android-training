package com.fernandodev.fragmentsample;

import android.content.Context;

import com.github.fernandodev.androidproperties.lib.AssetsProperties;
import com.github.fernandodev.androidproperties.lib.Property;

/**
 * Created by fernando on 9/11/15.
 */
public class Config extends AssetsProperties {

  @Property("endpoint") String endpoint;
  @Property("scheme_version") int schemeVersion;

  public Config(Context context) {
    super(context);
  }

  public String getEndpoint() {
    return endpoint;
  }

  public int getSchemeVersion() {
    return schemeVersion;
  }
}
