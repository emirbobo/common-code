package com.worklight.common;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import com.bangcle.andjni.JniLib;

public class WLPreferences
  extends PreferenceActivity
{
  public static final String APP_ID_PREF_KEY = "appIdPref";
  public static final String APP_VERSION_PREF_KEY = "appVersionPref";
  public static final String EDIT_WL_SERVER_URL_PREF_KEY = "editWLServerURLPref";
  public static final String LAST_SETTINGS_URL_STATE_PREF_KEY = "lastSettingsUrlStatePref";
  public static final String MODIFY_WL_SERVER_URL_PREF_KEY = "resetWLServerURLPref";
  private static final String NEW_APP_ID_PREF_KEY = "newAppIdPref";
  private static final String NEW_APP_VERSION_PREF_KEY = "newAppVersionPref";
  private static final String NEW_LINE = "\n";
  public static final String SHOULD_MODIFY_URL_PREF_KEY = "shouldModifyUrlPref";
  public static final String WL_SERVER_URL = "WLServerURL";
  private EditTextPreference appIdEditTextPreference = null;
  private EditTextPreference appVersionEditTextPreference = null;
  private CheckBoxPreference modifyServerURLCheckBoxPreference = null;
  private EditTextPreference serverURLEditTextPreference = null;
  private String serverURLafter = null;
  private String serverURLbefore = null;
  private WLConfig wlConfig = null;
  
  static
  {
    JniLib.a(WLPreferences.class, 1264);
  }
  
  private native void createModifyServerCheckbox();
  
  private native void createServerURLTextField();
  
  private native EditTextPreference createTextField(String paramString1, String paramString2, String paramString3);
  
  private native boolean isUrlChanged();
  
  private native boolean isWebResourcesChanged();
  
  private native void setServerURLFieldSummary();
  
  public native void onBackPressed();
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */