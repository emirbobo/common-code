package com.lidroid.xutils;

import android.app.Activity;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.view.ViewFinder;

public class ViewUtils
{
  static
  {
    JniLib.a(ViewUtils.class, 922);
  }
  
  public static native void inject(Activity paramActivity);
  
  public static native void inject(PreferenceActivity paramPreferenceActivity);
  
  public static native void inject(View paramView);
  
  public static native void inject(Object paramObject, Activity paramActivity);
  
  public static native void inject(Object paramObject, PreferenceActivity paramPreferenceActivity);
  
  public static native void inject(Object paramObject, PreferenceGroup paramPreferenceGroup);
  
  public static native void inject(Object paramObject, View paramView);
  
  private static native void injectObject(Object paramObject, ViewFinder paramViewFinder);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */