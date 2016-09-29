package com.worklight.androidgap.plugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

 enum AnalyticsConfigurator$ACTIONS$5
{
  AnalyticsConfigurator$ACTIONS$5()
  {
    super(paramString, paramInt, null);
  }
  
  public void doAction(AnalyticsConfigurator paramAnalyticsConfigurator, String paramString)
  {
    AnalyticsConfigurator.prefs.edit().clear().commit();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\AnalyticsConfigurator$ACTIONS$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */