package com.worklight.androidgap.plugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.worklight.androidgap.analytics.AnalyticsUncaughtExceptionHandler;
import com.worklight.common.WLConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.apache.cordova.DroidGap;
import org.json.JSONObject;

 enum AnalyticsConfigurator$ACTIONS$3
{
  AnalyticsConfigurator$ACTIONS$3()
  {
    super(paramString, paramInt, null);
  }
  
  public void doAction(AnalyticsConfigurator paramAnalyticsConfigurator, String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(AnalyticsConfigurator.prefs.getString(AnalyticsConfigurator.OPTIONS.TEALEAF_PROPS.toString(), "{}"));
        localMethod = Class.forName("com.tl.uic.util.ConfigurationUtil").getMethod("setProperty", new Class[] { String.class, String.class });
        paramString = localJSONObject.keys();
        localWLConfig = new com/worklight/common/WLConfig;
        localWLConfig.<init>(AnalyticsConfigurator.droidGap.getApplication());
        paramAnalyticsConfigurator = null;
      }
      catch (Exception paramAnalyticsConfigurator)
      {
        JSONObject localJSONObject;
        Method localMethod;
        WLConfig localWLConfig;
        Log.w(AnalyticsConfigurator.access$100(), "enable was called, but the required Tealeaf libraries are not present in the classpath.");
        continue;
      }
      try
      {
        if (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localMethod.invoke(null, new Object[] { str, (String)localJSONObject.get(str) });
          if (!str.equals("PostMessageUrl")) {
            continue;
          }
          paramAnalyticsConfigurator = (String)localJSONObject.get(str);
          continue;
        }
        if (paramAnalyticsConfigurator == null)
        {
          paramString = (String)Class.forName("com.tl.uic.util.ConfigurationUtil").getMethod("getString", new Class[] { String.class }).invoke(null, new Object[] { (String)Class.forName("com.tl.uic.Tealeaf").getField("TLF_POST_MESSAGE_URL").get(String.class) });
          paramAnalyticsConfigurator = paramString;
          if (paramString != null)
          {
            paramAnalyticsConfigurator = paramString;
            if (paramString.equals("@USE_WORKLIGHT_DEFAULT@"))
            {
              paramAnalyticsConfigurator = new java/lang/StringBuilder;
              paramAnalyticsConfigurator.<init>();
              paramAnalyticsConfigurator = localWLConfig.getAppURL() + "/analytics";
            }
          }
          localJSONObject.put("PostMessageUrl", paramAnalyticsConfigurator);
          AnalyticsConfigurator.prefs.edit().putString(AnalyticsConfigurator.OPTIONS.TEALEAF_PROPS.toString(), localJSONObject.toString()).commit();
          localMethod.invoke(null, new Object[] { (String)Class.forName("com.tl.uic.Tealeaf").getField("TLF_POST_MESSAGE_URL").get(String.class), paramAnalyticsConfigurator });
        }
        paramAnalyticsConfigurator = Thread.getDefaultUncaughtExceptionHandler();
        paramString = Class.forName("com.tl.uic.Tealeaf");
        if (!((Boolean)paramString.getMethod("isEnabled", new Class[0]).invoke(null, new Object[0])).booleanValue())
        {
          paramString.getMethod("enable", new Class[0]).invoke(null, new Object[0]);
          Thread.setDefaultUncaughtExceptionHandler(paramAnalyticsConfigurator);
          paramAnalyticsConfigurator = new com/worklight/androidgap/analytics/AnalyticsUncaughtExceptionHandler;
          paramAnalyticsConfigurator.<init>(localWLConfig);
          AnalyticsConfigurator.access$202(paramAnalyticsConfigurator);
          Thread.setDefaultUncaughtExceptionHandler(AnalyticsConfigurator.access$200());
        }
        bool = true;
        AnalyticsConfigurator.prefs.edit().putBoolean(AnalyticsConfigurator.OPTIONS.ENABLED.toString(), bool).commit();
        return;
      }
      finally {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\AnalyticsConfigurator$ACTIONS$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */