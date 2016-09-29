package com.worklight.common;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.bangcle.andjni.JniLib;

class WLPreferences$3
  implements Preference.OnPreferenceChangeListener
{
  static
  {
    JniLib.a(3.class, 1262);
  }
  
  WLPreferences$3(WLPreferences paramWLPreferences) {}
  
  public native boolean onPreferenceChange(Preference paramPreference, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLPreferences$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */