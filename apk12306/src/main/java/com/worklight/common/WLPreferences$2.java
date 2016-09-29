package com.worklight.common;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.bangcle.andjni.JniLib;

class WLPreferences$2
  implements Preference.OnPreferenceChangeListener
{
  static
  {
    JniLib.a(2.class, 1261);
  }
  
  WLPreferences$2(WLPreferences paramWLPreferences) {}
  
  public native boolean onPreferenceChange(Preference paramPreference, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLPreferences$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */