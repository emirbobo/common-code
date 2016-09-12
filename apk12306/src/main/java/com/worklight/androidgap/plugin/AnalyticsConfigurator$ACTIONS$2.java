package com.worklight.androidgap.plugin;

import android.util.Log;
import android.webkit.CookieManager;
import com.worklight.common.WLConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.DroidGap;
import org.apache.cordova.api.LOG;
import org.json.JSONException;
import org.json.JSONObject;

 enum AnalyticsConfigurator$ACTIONS$2
{
  AnalyticsConfigurator$ACTIONS$2()
  {
    super(paramString, paramInt, null);
  }
  
  public void doAction(AnalyticsConfigurator paramAnalyticsConfigurator, String paramString)
    throws JSONException
  {
    localObject1 = null;
    try
    {
      localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      localObject3 = new com/worklight/common/WLConfig;
      ((WLConfig)localObject3).<init>(AnalyticsConfigurator.droidGap.getApplication());
      paramString = CookieManager.getInstance();
      paramAnalyticsConfigurator = new com/worklight/common/WLConfig;
      paramAnalyticsConfigurator.<init>(AnalyticsConfigurator.droidGap);
      localObject2 = paramString.getCookie(paramAnalyticsConfigurator.getAppURL().toString());
      paramAnalyticsConfigurator = new java/lang/StringBuilder;
      paramAnalyticsConfigurator.<init>();
      paramAnalyticsConfigurator = ((WLConfig)localObject3).getAppURL() + "/analytics";
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      paramString = "/" + paramAnalyticsConfigurator.split("https?://[^/w]+/*")[1];
      localObject5 = paramAnalyticsConfigurator.substring(0, paramAnalyticsConfigurator.length() - paramString.length());
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      Log.d("TL Cookies", "Cookie URL: " + paramAnalyticsConfigurator + ", Cookie Domain: " + (String)localObject5 + ", Cookie Path: " + paramString);
      paramString = ((WLConfig)localObject3).getContext();
      paramAnalyticsConfigurator = ((WLConfig)localObject3).getAppURL().getHost();
      if ((paramString == null) || (paramString.trim().length() <= 1)) {
        break label516;
      }
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      paramAnalyticsConfigurator = paramAnalyticsConfigurator + paramString;
    }
    catch (ClassNotFoundException paramAnalyticsConfigurator)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        HashMap localHashMap;
        Object localObject3;
        Object localObject5;
        Object localObject4;
        if (paramAnalyticsConfigurator != null) {
          Log.w(AnalyticsConfigurator.access$100(), "send was called, but the required Tealeaf libraries are not present on the classpath.", paramAnalyticsConfigurator);
        }
        return;
        continue;
        localHashMap.put("x-wl-tlt-forward-cookies", paramAnalyticsConfigurator);
        Class.forName("com.tl.uic.Tealeaf").getMethod("setAdditionalHeaders", new Class[] { HashMap.class }).invoke(null, new Object[] { localHashMap });
        paramAnalyticsConfigurator = Class.forName("com.tl.uic.Tealeaf").getMethod("getAdditionalHeaders", null).invoke(null, null).toString();
        Object localObject2 = AnalyticsConfigurator.access$100();
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        LOG.d((String)localObject2, "Headers in Tealeaf: " + paramAnalyticsConfigurator);
        Class.forName("com.tl.uic.Tealeaf").getMethod("requestManualServerPost", null).invoke(null, null);
        paramAnalyticsConfigurator = (AnalyticsConfigurator)localObject1;
      }
    }
    catch (InvocationTargetException paramAnalyticsConfigurator)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException paramAnalyticsConfigurator)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramAnalyticsConfigurator)
    {
      for (;;) {}
    }
    paramString = (String)localObject2;
    if (!((String)localObject2).contains(CookieManager.getInstance().getCookie(paramAnalyticsConfigurator)))
    {
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      paramString = (String)localObject2 + ";" + CookieManager.getInstance().getCookie(paramAnalyticsConfigurator);
    }
    Class.forName("com.tl.uic.Tealeaf").getMethod("setAdditionalCookie", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    paramAnalyticsConfigurator = Class.forName("com.tl.uic.Tealeaf").getMethod("getAdditionalCookie", null).invoke(null, null).toString();
    paramString = AnalyticsConfigurator.access$100();
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    LOG.d(paramString, "Tealeaf additional cookies= " + paramAnalyticsConfigurator);
    localHashMap.put("x-wl-app-version", ((WLConfig)localObject3).getApplicationVersion());
    localObject5 = localJSONObject.keys();
    for (;;)
    {
      boolean bool = ((Iterator)localObject5).hasNext();
      if (bool) {
        try
        {
          localObject4 = (String)((Iterator)localObject5).next();
          localObject3 = localJSONObject.get((String)localObject4).toString();
          localObject2 = AnalyticsConfigurator.access$100();
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          LOG.d((String)localObject2, "Saving header: " + (String)localObject4 + ", " + (String)localObject3);
          localHashMap.put(localObject4, localObject3);
        }
        catch (JSONException paramAnalyticsConfigurator)
        {
          LOG.e(AnalyticsConfigurator.access$100(), "Error when getting headers", paramAnalyticsConfigurator);
          throw paramAnalyticsConfigurator;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\AnalyticsConfigurator$ACTIONS$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */