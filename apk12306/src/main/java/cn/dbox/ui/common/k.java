package cn.dbox.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.dbox.core.bean.c;
import cn.dbox.core.bean.d;
import java.util.ArrayList;

public class k
{
  static float a = 0.0F;
  public static final float b = 0.7072368F;
  public static final float c = 0.55921054F;
  private static float d;
  private static int e;
  private static int f;
  
  public static float a(Context paramContext)
  {
    try
    {
      if (a == 0.0F) {
        a = paramContext.getResources().getDisplayMetrics().density;
      }
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(b(paramContext) * paramFloat);
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return (int)(a(paramContext) * paramInt);
  }
  
  public static ArrayList<d> a(ArrayList<c> paramArrayList)
  {
    ArrayList localArrayList1 = null;
    if (paramArrayList != null)
    {
      localArrayList1 = new ArrayList();
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        ArrayList localArrayList2 = ((c)paramArrayList.get(i)).d();
        if (localArrayList2 != null) {
          for (int j = 0; j < localArrayList2.size(); j++) {
            localArrayList1.add(localArrayList2.get(j));
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public static int b(Context paramContext)
  {
    e = Math.round(c(paramContext) * (d(paramContext) / a(paramContext)));
    return e;
  }
  
  protected static int c(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      f = paramContext.getWidth();
    }
    return f;
  }
  
  protected static float d(Context paramContext)
  {
    try
    {
      if (d == 0.0F)
      {
        Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        paramContext = new android/util/DisplayMetrics;
        paramContext.<init>();
        localDisplay.getMetrics(paramContext);
        d = paramContext.density;
      }
      return d;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static float e(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return localDisplayMetrics.density;
  }
  
  public static int f(Context paramContext)
  {
    return b(paramContext);
  }
  
  public static int g(Context paramContext)
  {
    return b(paramContext) - a(paramContext, 16);
  }
  
  public static int h(Context paramContext)
  {
    return (int)(g(paramContext) * 0.7072368F);
  }
  
  public static int i(Context paramContext)
  {
    return (int)(g(paramContext) * 0.55921054F);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */