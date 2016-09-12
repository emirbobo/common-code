package cn.domob.ui.utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.domob.wall.core.bean.AdInfo;

public class DUtil
{
  public static AdInfo buildAdInfo(DownloadAppInfo paramDownloadAppInfo)
  {
    return new AdInfo(String.valueOf(paramDownloadAppInfo.getAppId()), paramDownloadAppInfo.getPkgName(), paramDownloadAppInfo.getVersionCode(), paramDownloadAppInfo.getVersionName(), paramDownloadAppInfo.getTr(), paramDownloadAppInfo.getSid());
  }
  
  public static DownloadAppInfo buildDownLoadAppInfo(AdInfo paramAdInfo)
  {
    DownloadAppInfo localDownloadAppInfo = new DownloadAppInfo();
    localDownloadAppInfo.setSid(paramAdInfo.getSearchId());
    localDownloadAppInfo.setAppId(Long.parseLong(paramAdInfo.getAdId()));
    localDownloadAppInfo.setAppName(paramAdInfo.getAdName());
    localDownloadAppInfo.setAppSize(paramAdInfo.getAdSize());
    localDownloadAppInfo.setDownloadUrl(paramAdInfo.getAdDownloadURL());
    localDownloadAppInfo.setPkgName(paramAdInfo.getAdPackageName());
    localDownloadAppInfo.setLogoUrl(paramAdInfo.getAdLogoURL());
    localDownloadAppInfo.setVersionCode(paramAdInfo.getAdVersionCode());
    localDownloadAppInfo.setVersionName(paramAdInfo.getAdVersionName());
    localDownloadAppInfo.setTr(paramAdInfo.getAdTracker());
    return localDownloadAppInfo;
  }
  
  public static float getCurrentDensity(Context paramContext)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (0.0F == 0.0F) {}
    try
    {
      f1 = paramContext.getResources().getDisplayMetrics().density;
      return f1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        f1 = f2;
      }
    }
  }
  
  public static int getCurrentScreenHeight(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {}
    for (int i = paramContext.getHeight();; i = 0) {
      return i;
    }
  }
  
  public static int getCurrentScreenWidth(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {}
    for (int i = paramContext.getWidth();; i = 0) {
      return i;
    }
  }
  
  public static float getRealDensity(Context paramContext)
  {
    float f2 = 0.0F;
    if (0.0F == 0.0F) {}
    for (;;)
    {
      try
      {
        Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        paramContext = new android/util/DisplayMetrics;
        paramContext.<init>();
        localDisplay.getMetrics(paramContext);
        f1 = paramContext.density;
        return f1;
      }
      catch (Exception paramContext)
      {
        f1 = f2;
        continue;
      }
      float f1 = 0.0F;
    }
  }
  
  public static int getRealScreenHeight(Context paramContext)
  {
    return Math.round(getCurrentScreenHeight(paramContext) * (getRealDensity(paramContext) / getCurrentDensity(paramContext)));
  }
  
  public static int getRealScreenWidth(Context paramContext)
  {
    return Math.round(getCurrentScreenWidth(paramContext) * (getRealDensity(paramContext) / getCurrentDensity(paramContext)));
  }
  
  public static float getScreenDensity(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return localDisplayMetrics.density;
  }
  
  public static boolean isIntValid(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt < 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      String str = paramInt + "";
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(""))
        {
          bool1 = bool2;
          if (str.length() != 0) {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean isObjectValid(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.equals(""))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isStringValid(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")) || (paramString.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\utility\DUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */