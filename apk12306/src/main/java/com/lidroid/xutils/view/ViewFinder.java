package com.lidroid.xutils.view;

import android.app.Activity;
import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.view.View;
import com.bangcle.andjni.JniLib;

public class ViewFinder
{
  private Activity activity;
  private PreferenceActivity preferenceActivity;
  private PreferenceGroup preferenceGroup;
  private View view;
  
  static
  {
    JniLib.a(ViewFinder.class, 1032);
  }
  
  public ViewFinder(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public ViewFinder(PreferenceActivity paramPreferenceActivity)
  {
    this.preferenceActivity = paramPreferenceActivity;
    this.activity = paramPreferenceActivity;
  }
  
  public ViewFinder(PreferenceGroup paramPreferenceGroup)
  {
    this.preferenceGroup = paramPreferenceGroup;
  }
  
  public ViewFinder(View paramView)
  {
    this.view = paramView;
  }
  
  public native Preference findPreference(CharSequence paramCharSequence);
  
  public native View findViewById(int paramInt);
  
  public native View findViewById(int paramInt1, int paramInt2);
  
  public native View findViewByInfo(ViewInjectInfo paramViewInjectInfo);
  
  public native Context getContext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\ViewFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */