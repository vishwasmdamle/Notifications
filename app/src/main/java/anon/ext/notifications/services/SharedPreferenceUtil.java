package anon.ext.notifications.services;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {
  private static final String PREFERENCES = ReceiverService.class.getCanonicalName() + ".sharedPref";

  private Context context;

  public SharedPreferenceUtil(Context context) {
    this.context = context;
  }

  public void put(String key, boolean value) {
    getSharedPreferences()
        .edit()
        .putBoolean(key, value)
        .commit();
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    return getSharedPreferences()
        .getBoolean(key, defaultValue);
  }

  private SharedPreferences getSharedPreferences() {
    return context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
  }
}
