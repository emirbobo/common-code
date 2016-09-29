package cn.dbox.core.c;

import android.content.Context;
import android.util.Log;
import cn.dbox.core.b.h;
import cn.dbox.core.bean.h;
import java.util.HashMap;

public class d
{
  private static cn.dbox.core.h.d a = new cn.dbox.core.h.d(d.class.getSimpleName());
  private static final int e = 2;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private static final int i = 4;
  private static final int j = 5;
  private c b;
  private cn.dbox.core.c c;
  private Context d;
  private a k;
  
  public d(cn.dbox.core.c paramc)
  {
    this.c = paramc;
    this.d = paramc.f();
  }
  
  private String a(int paramInt, HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cid", f.a().c(this.d));
    long l = f.a().a(this.d);
    if (l != 0L) {
      localHashMap.put("last_time_req", String.valueOf(l));
    }
    localHashMap.put("ratio", this.c.q());
    localHashMap.put("sdk", String.valueOf(31));
    localHashMap.put("rt", String.valueOf(paramInt));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", cn.dbox.core.h.e.f(this.d));
    localHashMap.put("ipb", this.c.a());
    localHashMap.put("ppid", this.c.b());
    localHashMap.put("idv", cn.dbox.core.h.e.h(this.d));
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20140918", "android", "20140711" }));
    localHashMap.put("sv", "000900");
    localHashMap.put("l", cn.dbox.core.h.e.g());
    if (cn.dbox.core.h.f.a(this.c))
    {
      localHashMap.put("c", String.format("%s,%s,%s", new Object[] { "la", "iad", "aw" }));
      localHashMap.put("so", cn.dbox.core.h.e.q(this.d));
      localHashMap.put("sw", String.valueOf(cn.dbox.core.h.e.t(this.d)));
      localHashMap.put("sh", String.valueOf(cn.dbox.core.h.e.u(this.d)));
      localHashMap.put("sd", String.valueOf(cn.dbox.core.h.e.s(this.d)));
      localHashMap.put("pb[identifier]", cn.dbox.core.h.e.a(this.d));
      localHashMap.put("pb[name]", cn.dbox.core.h.e.d(this.d));
      localHashMap.put("pb[version]", cn.dbox.core.h.e.c(this.d));
      if (paramHashMap != null)
      {
        paramInt = paramHashMap.size();
        a.b("param size:" + paramInt);
        if (paramHashMap.containsKey("ids")) {
          localHashMap.put("ids", paramHashMap.get("ids"));
        }
        if (paramHashMap.containsKey("acid")) {
          localHashMap.put("acid", paramHashMap.get("acid"));
        }
        if (paramHashMap.containsKey("q")) {
          localHashMap.put("q", paramHashMap.get("q"));
        }
        if (paramHashMap.containsKey("details")) {
          localHashMap.put("details", paramHashMap.get("details"));
        }
      }
      localHashMap.put("network", cn.dbox.core.h.e.n(this.d));
      paramHashMap = cn.dbox.core.h.e.y(this.d);
      if (paramHashMap != null)
      {
        a.b("des encode dma:" + paramHashMap.toUpperCase() + "-->" + cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
        if (!paramHashMap.equals("")) {
          break label1030;
        }
        localHashMap.put("dma", "");
      }
      label599:
      paramHashMap = cn.dbox.core.h.e.z(this.d);
      if (!paramHashMap.equals("")) {
        break label1051;
      }
      localHashMap.put("odin1", "");
      label629:
      paramHashMap = cn.dbox.core.h.e.x(this.d);
      if (paramHashMap == null) {
        break label1064;
      }
      localHashMap.put("d[coord_timestamp]", String.valueOf(cn.dbox.core.h.e.f()));
      localHashMap.put("d[coord]", paramHashMap);
      localHashMap.put("d[coord_acc]", String.valueOf(cn.dbox.core.h.e.d()));
      localHashMap.put("d[coord_accuracy]", String.valueOf(cn.dbox.core.h.e.h()));
    }
    for (;;)
    {
      paramHashMap = cn.dbox.core.h.e.E(this.d);
      a.b(String.format("Base info: cid=%s, lac=%s, mcc=%s, mnc=%s", new Object[] { paramHashMap[0], paramHashMap[1], paramHashMap[2], paramHashMap[3] }));
      localHashMap.put("cell", paramHashMap[0]);
      localHashMap.put("lac", paramHashMap[1]);
      localHashMap.put("mcc", paramHashMap[2]);
      localHashMap.put("mnc", paramHashMap[3]);
      paramHashMap = cn.dbox.core.h.e.B(this.d);
      if (paramHashMap != null)
      {
        a.b("des encode ama:" + paramHashMap.toUpperCase() + "-->" + cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
        localHashMap.put("ama", cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
      }
      paramHashMap = cn.dbox.core.h.e.C(this.d);
      if (paramHashMap != null)
      {
        a.b("des encode apSSID:" + paramHashMap.toUpperCase() + "-->" + cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap));
        localHashMap.put("an", cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap));
      }
      paramHashMap = cn.dbox.core.h.e.F(this.d);
      if (!cn.dbox.core.h.f.a(paramHashMap)) {
        localHashMap.put("aaid", paramHashMap);
      }
      a.b("ad request params:" + localHashMap.toString());
      return cn.dbox.core.h.f.a(localHashMap);
      localHashMap.put("c", String.format("%s,%s", new Object[] { "la", "iad" }));
      break;
      label1030:
      localHashMap.put("dma", cn.dbox.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
      break label599;
      label1051:
      localHashMap.put("odin1", paramHashMap);
      break label629;
      label1064:
      localHashMap.put("d[coord_status]", String.valueOf(cn.dbox.core.h.e.e()));
    }
  }
  
  public b.h a(int paramInt)
  {
    b.h localh = b.h.a;
    switch (paramInt / 1000)
    {
    }
    for (;;)
    {
      localh = b.h.b;
      for (;;)
      {
        return localh;
        localh = b.h.b;
        continue;
        localh = b.h.b;
        continue;
        localh = b.h.c;
        continue;
        localh = b.h.e;
      }
      localh = b.h.b;
    }
  }
  
  public void a(a parama, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.k = parama;
    try
    {
      String str2 = a(2, paramHashMap);
      paramHashMap = new cn/dbox/core/c/c;
      Context localContext = this.d;
      String str1 = this.c.i();
      parama = new cn/dbox/core/c/d$1;
      parama.<init>(this);
      paramHashMap.<init>(localContext, str1, "", null, "POST", str2, 20000, parama);
      this.b = paramHashMap;
      this.b.b();
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        a.e("Error happens when sending ad request");
        a.a(parama);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b.h paramh, String paramString);
    
    public abstract void a(e parame);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */