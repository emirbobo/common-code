package cn.domob.android.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;

public class a
{
  private static f a = new f(a.class.getSimpleName());
  private static String b;
  private static int c;
  private static String d;
  private static String e;
  
  protected static String a(Context paramContext)
  {
    if (b == null)
    {
      f(paramContext);
      if (!h.e(b)) {
        a.c("Current package name is " + b);
      }
    }
    return b;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      if (-1 != i) {
        break label23;
      }
      bool = false;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        label23:
        boolean bool = true;
      }
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder = new StringBuilder(f.b() + " 缺少权限：\n");
    int i = 0;
    int j = 0;
    String str;
    boolean bool1;
    if (i < paramArrayOfString.length)
    {
      str = paramArrayOfString[i];
      if (h.e(str)) {
        break label212;
      }
      if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        if (!c.a(3, false)) {
          break label212;
        }
        bool1 = a(paramContext, str);
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        Log.e(f.b(), String.format("you must have %s permission !", new Object[] { str }));
        localStringBuilder.append(str + " \n");
        j = 1;
      }
      i++;
      break;
      if (str.equals("android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (paramBoolean) {
          bool1 = a(paramContext, str);
        }
      }
      else
      {
        bool1 = a(paramContext, str);
        continue;
        if (j != 0) {
          g.a(paramContext, f.b(), localStringBuilder.toString());
        }
        if (j == 0) {}
        for (paramBoolean = bool2;; paramBoolean = false) {
          return paramBoolean;
        }
      }
      label212:
      bool1 = true;
    }
  }
  
  protected static int b(Context paramContext)
  {
    if (b == null) {
      f(paramContext);
    }
    return c;
  }
  
  protected static String c(Context paramContext)
  {
    if (b == null) {
      f(paramContext);
    }
    return d;
  }
  
  protected static String d(Context paramContext)
  {
    if (b == null) {
      f(paramContext);
    }
    return e;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
      a.c("access wifi state is enabled");
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void f(Context paramContext)
  {
    a.b(c.class.getSimpleName(), "Start to get app info.");
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        if (localObject != null)
        {
          PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
          if (localPackageInfo != null)
          {
            b = localPackageInfo.packageName;
            c = localPackageInfo.versionCode;
            d = localPackageInfo.versionName;
          }
        }
        localObject = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
        if (localObject != null)
        {
          if (((ApplicationInfo)localObject).labelRes != 0) {
            e = paramContext.getResources().getString(((ApplicationInfo)localObject).labelRes);
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        a.e(c.class.getSimpleName(), "Failed in getting app info.");
        a.a(paramContext);
        continue;
        paramContext = ((ApplicationInfo)localObject).nonLocalizedLabel.toString();
        continue;
      }
      if (((ApplicationInfo)localObject).nonLocalizedLabel != null) {
        continue;
      }
      paramContext = null;
      e = paramContext;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */