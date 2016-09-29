package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.f.c;
import java.util.HashMap;

class o
{
  public static boolean a = false;
  protected static final int b = 6;
  private static cn.domob.android.i.f c = new cn.domob.android.i.f(o.class.getSimpleName());
  private static boolean d = false;
  private static final String g = "sdk";
  private static final String h = "rt";
  private static final String i = "ts";
  private static final String j = "ua";
  private static final String k = "ipb";
  private static final String l = "v";
  private static final String m = "sv";
  private g e;
  private Context f;
  private cn.domob.android.f.g n;
  
  public o(g paramg)
  {
    c.b("New instance of DomobConfigRequest.");
    this.e = paramg;
    this.f = paramg.x();
  }
  
  private cn.domob.android.f.f c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(1));
    localHashMap.put("rt", String.valueOf(6));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", cn.domob.android.b.a.f(this.f));
    localHashMap.put("ipb", this.e.m());
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20141125", "android", "20140529" }));
    localHashMap.put("sv", "040602");
    return new cn.domob.android.f.f(localHashMap);
  }
  
  protected void a()
    throws cn.domob.android.d.a
  {
    if (d) {
      throw new cn.domob.android.d.a();
    }
    d = true;
    try
    {
      c.b("Start to request config info");
      cn.domob.android.f.g local1 = new cn/domob/android/ads/o$1;
      local1.<init>(this);
      this.n = local1;
      c.a().b(this.f, h.a().b(), c(), this.n);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        d = false;
      }
    }
    finally
    {
      d = false;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(j paramj, int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */