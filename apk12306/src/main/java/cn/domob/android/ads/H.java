package cn.domob.android.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import cn.domob.android.ads.c.a;
import cn.domob.android.i.f;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  public static y a;
  private static f b = new f(h.class.getSimpleName());
  private static h c;
  private static volatile String d = "http://r.domob.cn/a/";
  private static String k = null;
  private static String l = null;
  private static String m = null;
  private String e = null;
  private String f = null;
  private boolean g = false;
  private long h;
  private int i;
  private String j = null;
  
  public static h a()
  {
    try
    {
      if (c == null)
      {
        localh = new cn/domob/android/ads/h;
        localh.<init>();
        c = localh;
      }
      h localh = c;
      return localh;
    }
    finally {}
  }
  
  protected String a(Context paramContext)
  {
    localObject1 = null;
    if (this.e == null) {}
    for (;;)
    {
      try
      {
        localObject2 = paramContext.getPackageManager();
        if (localObject2 != null)
        {
          localObject2 = ((PackageManager)localObject2).getApplicationInfo(paramContext.getPackageName(), 128);
          if (localObject2 != null)
          {
            paramContext = ((ApplicationInfo)localObject2).metaData;
            if (paramContext == null) {}
          }
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        Log.e(f.b(), "Failed to get applicationInfo.");
        b.a(paramContext);
        paramContext = (Context)localObject1;
        continue;
      }
      try
      {
        paramContext = ((ApplicationInfo)localObject2).metaData.getString("DOMOB_PID");
        if ((this.e == null) && (paramContext != null))
        {
          this.e = paramContext;
          b(this.e);
        }
        paramContext = this.e;
      }
      catch (Exception paramContext)
      {
        Log.e(f.b(), "DOMOB_PID is missed in AndroidManifest.xml!");
        paramContext = (Context)localObject1;
      }
    }
    return paramContext;
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      b.b("Set AD server url:" + paramString);
      d = paramString;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    k = paramString1;
    l = paramString2;
    m = "0";
    try
    {
      paramString1 = new org/json/JSONObject;
      paramString1.<init>(paramString2);
      paramString2 = paramString1.keys();
      if (paramString2.hasNext())
      {
        str1 = paramString2.next().toString();
        str2 = paramString1.optString(str1, "0");
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        try
        {
          String str1;
          String str2;
          Class.forName(str1);
          f localf = b;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localf.b("origin:" + str1);
          m = str2;
          return;
        }
        catch (Exception localException) {}
        paramString1 = paramString1;
        b.e("ors json exception.");
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    this.g = paramBoolean;
    this.h = paramLong;
    this.i = paramInt;
  }
  
  protected String b()
  {
    return d;
  }
  
  protected String b(Context paramContext)
  {
    if (this.f == null) {
      this.f = new a(paramContext, "domob_config").a("cookie_id", null);
    }
    return this.f;
  }
  
  protected void b(String paramString)
  {
    if ((paramString == null) || ((paramString != null) && (paramString.length() == 0))) {
      Log.e(f.b(), "Incorrect Domob publisher ID.");
    }
    for (;;)
    {
      return;
      Log.i(f.b(), "Current publisherID is " + paramString);
      this.e = paramString;
    }
  }
  
  protected long c()
  {
    return this.h + this.i * 1000;
  }
  
  protected void c(String paramString)
  {
    this.f = paramString;
  }
  
  protected boolean c(Context paramContext)
  {
    boolean bool;
    if (this.g) {
      if (System.currentTimeMillis() < this.h + this.i * 1000) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((!bool) && (this.g))
      {
        this.g = false;
        this.h = 0L;
        this.i = 0;
        HashMap localHashMap = new HashMap();
        localHashMap.put("timestamp", Long.valueOf(0L));
        localHashMap.put("disable", Boolean.valueOf(false));
        localHashMap.put("time", Integer.valueOf(0));
        new a(paramContext, "domob_config").a(localHashMap);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  protected String d()
  {
    return this.j;
  }
  
  protected void d(String paramString)
  {
    this.j = paramString;
  }
  
  protected boolean e()
  {
    if ((k != null) && (l != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected boolean e(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    if (k != null) {}
    for (;;)
    {
      try
      {
        if (Integer.parseInt(paramString) > Integer.parseInt(k)) {
          continue;
        }
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        bool1 = bool2;
        continue;
      }
      return bool1;
      b.b("get origin detection config update");
      bool1 = true;
    }
  }
  
  protected String f()
  {
    return m;
  }
  
  protected String g()
  {
    return k;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\H.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */