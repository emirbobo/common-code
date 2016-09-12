package cn.domob.android.g.a;

import android.content.Context;
import cn.domob.android.i.c;
import cn.domob.android.i.f;
import java.util.HashMap;
import java.util.Map;

class d
{
  private static final f a = new f(d.class.getSimpleName());
  private static final int b = 20;
  private static final String c = "rt";
  private static final String d = "ua";
  private static final String e = "pb[name]";
  private static final String f = "d[coord]";
  private static final String g = "d[coord_acc]";
  private static final String h = "d[coord_status]";
  private static final String i = "network";
  private static final String j = "ts";
  
  protected static Map<String, String> a(Context paramContext, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("rt", String.valueOf(20));
    localHashMap.put("ua", c.F(paramContext));
    localHashMap.put("network", c.k(paramContext));
    if (paramBoolean)
    {
      String str = c.u(paramContext);
      if (str == null) {
        break label130;
      }
      localHashMap.put("d[coord]", str);
      localHashMap.put("d[coord_acc]", String.valueOf(c.d()));
    }
    for (;;)
    {
      localHashMap.put("pb[name]", c.d(paramContext));
      localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
      a.b("multi domain base request params: " + localHashMap.toString());
      return localHashMap;
      label130:
      localHashMap.put("d[coord_status]", String.valueOf(c.e()));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\g\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */