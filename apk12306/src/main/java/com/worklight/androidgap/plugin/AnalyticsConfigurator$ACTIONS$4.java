package com.worklight.androidgap.plugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.worklight.androidgap.analytics.AnalyticsUncaughtExceptionHandler;
import java.lang.reflect.Method;

 enum AnalyticsConfigurator$ACTIONS$4
{
  AnalyticsConfigurator$ACTIONS$4()
  {
    super(paramString, paramInt, null);
  }
  
  public void doAction(AnalyticsConfigurator paramAnalyticsConfigurator, String paramString)
  {
    try
    {
      paramAnalyticsConfigurator = Class.forName("com.tl.uic.Tealeaf");
      if (((Boolean)paramAnalyticsConfigurator.getMethod("isEnabled", new Class[0]).invoke(null, new Object[0])).booleanValue())
      {
        paramAnalyticsConfigurator.getMethod("disable", new Class[0]).invoke(null, new Object[0]);
        AnalyticsConfigurator.access$200().setDefaultUncaughtExceptionHandler();
        AnalyticsConfigurator.access$202(null);
      }
      AnalyticsConfigurator.prefs.edit().putBoolean(AnalyticsConfigurator.OPTIONS.ENABLED.toString(), false).commit();
      return;
    }
    catch (Exception paramAnalyticsConfigurator)
    {
      for (;;)
      {
        Log.w(AnalyticsConfigurator.access$100(), "disable was called, but the required Tealeaf libraries are not present in the classpath.");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\AnalyticsConfigurator$ACTIONS$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */