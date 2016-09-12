package cn.domob.android.i;

import android.util.Log;

public class f
{
  public static String a = "DB";
  private static boolean c = false;
  private static final int d = 7;
  private static long e = 0L;
  private static long f = 0L;
  private String b;
  
  public f(String paramString)
  {
    this.b = paramString;
  }
  
  public f(String paramString1, String paramString2)
  {
    this.b = paramString1;
    if (!h.e(paramString2)) {
      a = paramString2;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static String b()
  {
    return a;
  }
  
  private void b(String paramString, int paramInt)
  {
    a(this.b + "::" + paramString, paramInt);
  }
  
  public void a(Object paramObject, String paramString)
  {
    a(paramString);
  }
  
  public void a(String paramString)
  {
    b(paramString, 2);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (c) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return;
      Log.v(a, paramString);
      continue;
      Log.d(a, paramString);
      continue;
      Log.i(a, paramString);
      continue;
      Log.w(a, paramString);
      continue;
      Log.e(a, paramString);
      continue;
      f = System.currentTimeMillis();
      Log.d(a, paramString + "spend time is:" + String.valueOf((float)(f - e) / 1000.0F));
      e = f;
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (c) {
      paramThrowable.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return c;
  }
  
  public void b(Object paramObject, String paramString)
  {
    b(paramString);
  }
  
  public void b(String paramString)
  {
    b(paramString, 3);
  }
  
  public void c(Object paramObject, String paramString)
  {
    c(paramString);
  }
  
  public void c(String paramString)
  {
    b(paramString, 4);
  }
  
  public void d(Object paramObject, String paramString)
  {
    d(paramString);
  }
  
  public void d(String paramString)
  {
    b(paramString, 5);
  }
  
  public void e(Object paramObject, String paramString)
  {
    e(paramString);
  }
  
  public void e(String paramString)
  {
    b(paramString, 6);
  }
  
  public void f(Object paramObject, String paramString)
  {
    b(paramString);
  }
  
  public void f(String paramString)
  {
    b(paramString, 7);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */