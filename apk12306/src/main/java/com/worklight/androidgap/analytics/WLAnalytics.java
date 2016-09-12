package com.worklight.androidgap.analytics;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.WLDroidGap;

public class WLAnalytics
{
  private static final String LOG_TAG = WLAnalytics.class.getName();
  private static final String TEALEAF_CLASS = "com.tl.uic.Tealeaf";
  
  static
  {
    JniLib.a(WLAnalytics.class, 1151);
  }
  
  public static native void initializeTealeaf(WLDroidGap paramWLDroidGap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\analytics\WLAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */