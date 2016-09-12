package com.worklight.common;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.bangcle.andjni.JniLib;

class WLPreferences$4
  implements Preference.OnPreferenceChangeListener
{
  static
  {
    JniLib.a(4.class, 1263);
  }
  
  WLPreferences$4(WLPreferences paramWLPreferences) {}
  
  public native boolean onPreferenceChange(Preference paramPreference, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLPreferences$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */