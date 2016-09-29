package cn.domob.wall.core.c;

import android.content.Context;
import android.util.Log;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.b;
import java.util.HashMap;

public class d
{
  private static cn.domob.wall.core.h.d a = new cn.domob.wall.core.h.d(d.class.getSimpleName());
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private static final int l = 4;
  private static final int m = 5;
  private c b;
  private b c;
  private Context d;
  private a n;
  private d o;
  private e p;
  private b q;
  private c r;
  
  public d(b paramb)
  {
    this.c = paramb;
    this.d = paramb.g();
  }
  
  private String a(int paramInt, HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cid", h.a().c(this.d));
    localHashMap.put("sdk", String.valueOf(30));
    localHashMap.put("rt", String.valueOf(paramInt));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", cn.domob.wall.core.h.e.f(this.d));
    localHashMap.put("ipb", this.c.d());
    localHashMap.put("ppid", this.c.e());
    localHashMap.put("idv", cn.domob.wall.core.h.e.h(this.d));
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20140217", "android", "20131101" }));
    localHashMap.put("sv", "020100");
    localHashMap.put("l", cn.domob.wall.core.h.e.g());
    localHashMap.put("c", String.format("%s,%s,%s", new Object[] { "ltx", "la", "iad" }));
    localHashMap.put("so", cn.domob.wall.core.h.e.q(this.d));
    localHashMap.put("sw", String.valueOf(cn.domob.wall.core.h.e.t(this.d)));
    localHashMap.put("sh", String.valueOf(cn.domob.wall.core.h.e.u(this.d)));
    localHashMap.put("sd", String.valueOf(cn.domob.wall.core.h.e.s(this.d)));
    localHashMap.put("pb[identifier]", cn.domob.wall.core.h.e.a(this.d));
    localHashMap.put("pb[name]", cn.domob.wall.core.h.e.d(this.d));
    localHashMap.put("pb[version]", cn.domob.wall.core.h.e.c(this.d));
    if (paramHashMap != null)
    {
      paramInt = paramHashMap.size();
      a.b("param size:" + paramInt);
      if (paramHashMap.containsKey("ids")) {
        localHashMap.put("ids", paramHashMap.get("ids"));
      }
      if (paramHashMap.containsKey("q")) {
        localHashMap.put("q", paramHashMap.get("q"));
      }
      if (paramHashMap.containsKey("details")) {
        localHashMap.put("details", paramHashMap.get("details"));
      }
    }
    localHashMap.put("network", cn.domob.wall.core.h.e.n(this.d));
    paramHashMap = cn.domob.wall.core.h.e.y(this.d);
    if (paramHashMap != null)
    {
      a.b("des encode dma:" + paramHashMap.toUpperCase() + "-->" + cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
      if (paramHashMap.equals("")) {
        localHashMap.put("dma", "");
      }
    }
    else
    {
      paramHashMap = cn.domob.wall.core.h.e.z(this.d);
      if (!paramHashMap.equals("")) {
        break label912;
      }
      localHashMap.put("odin1", "");
      label528:
      paramHashMap = cn.domob.wall.core.h.e.x(this.d);
      if (paramHashMap == null) {
        break label924;
      }
      localHashMap.put("d[coord_timestamp]", String.valueOf(cn.domob.wall.core.h.e.f()));
      localHashMap.put("d[coord]", paramHashMap);
      localHashMap.put("d[coord_acc]", String.valueOf(cn.domob.wall.core.h.e.d()));
      localHashMap.put("d[coord_accuracy]", String.valueOf(cn.domob.wall.core.h.e.h()));
    }
    for (;;)
    {
      paramHashMap = cn.domob.wall.core.h.e.E(this.d);
      a.b(String.format("Base info: cid=%s, lac=%s, mcc=%s, mnc=%s", new Object[] { paramHashMap[0], paramHashMap[1], paramHashMap[2], paramHashMap[3] }));
      localHashMap.put("cell", paramHashMap[0]);
      localHashMap.put("lac", paramHashMap[1]);
      localHashMap.put("mcc", paramHashMap[2]);
      localHashMap.put("mnc", paramHashMap[3]);
      paramHashMap = cn.domob.wall.core.h.e.B(this.d);
      if (paramHashMap != null)
      {
        a.b("des encode ama:" + paramHashMap.toUpperCase() + "-->" + cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
        localHashMap.put("ama", cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
      }
      paramHashMap = cn.domob.wall.core.h.e.C(this.d);
      if (paramHashMap != null)
      {
        a.b("des encode apSSID:" + paramHashMap.toUpperCase() + "-->" + cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap));
        localHashMap.put("an", cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap));
      }
      paramHashMap = cn.domob.wall.core.h.e.F(this.d);
      if (!cn.domob.wall.core.h.f.a(paramHashMap)) {
        localHashMap.put("aaid", paramHashMap);
      }
      a.b("ad request params:" + localHashMap.toString());
      return cn.domob.wall.core.h.f.a(localHashMap);
      localHashMap.put("dma", cn.domob.wall.core.h.f.a("d!j@d#g$r%s^j&h*", paramHashMap.toUpperCase()));
      break;
      label912:
      localHashMap.put("odin1", paramHashMap);
      break label528;
      label924:
      localHashMap.put("d[coord_status]", String.valueOf(cn.domob.wall.core.h.e.e()));
    }
  }
  
  public DService.ErrorCode a(int paramInt)
  {
    DService.ErrorCode localErrorCode = DService.ErrorCode.NONE;
    switch (paramInt / 1000)
    {
    }
    for (;;)
    {
      localErrorCode = DService.ErrorCode.INTERNAL_ERROR;
      for (;;)
      {
        return localErrorCode;
        localErrorCode = DService.ErrorCode.INTERNAL_ERROR;
        continue;
        localErrorCode = DService.ErrorCode.INTERNAL_ERROR;
        continue;
        localErrorCode = DService.ErrorCode.INVALID_REQUEST;
        continue;
        localErrorCode = DService.ErrorCode.NO_FILL;
      }
      localErrorCode = DService.ErrorCode.INTERNAL_ERROR;
    }
  }
  
  public void a(a parama, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.n = parama;
    for (;;)
    {
      try
      {
        paramHashMap = a(2, paramHashMap);
        if (DService.getEndpoint().equals("online"))
        {
          parama = cn.domob.wall.core.h.f.f(cn.domob.wall.core.b.a.i);
          c localc = new cn/domob/wall/core/c/c;
          Context localContext = this.d;
          c.a local1 = new cn/domob/wall/core/c/d$1;
          local1.<init>(this);
          localc.<init>(localContext, parama, "", null, "POST", paramHashMap, 20000, local1);
          this.b = localc;
          this.b.b();
          return;
        }
      }
      catch (Exception parama)
      {
        a.e("Error happens when sending ad request");
        a.a(parama);
        continue;
      }
      parama = cn.domob.wall.core.b.a.m;
    }
  }
  
  public void a(b paramb, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.q = paramb;
    for (;;)
    {
      try
      {
        paramHashMap = a(4, paramHashMap);
        if (DService.getEndpoint().equals("online"))
        {
          paramb = cn.domob.wall.core.h.f.f(cn.domob.wall.core.b.a.i);
          c localc = new cn/domob/wall/core/c/c;
          Context localContext = this.d;
          c.a local4 = new cn/domob/wall/core/c/d$4;
          local4.<init>(this);
          localc.<init>(localContext, paramb, "", null, "POST", paramHashMap, 20000, local4);
          this.b = localc;
          this.b.b();
          return;
        }
      }
      catch (Exception paramb)
      {
        a.e("Error happens when sending ad request");
        a.a(paramb);
        continue;
      }
      paramb = cn.domob.wall.core.b.a.m;
    }
  }
  
  public void a(c paramc, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.r = paramc;
    for (;;)
    {
      try
      {
        paramHashMap = a(5, paramHashMap);
        if (DService.getEndpoint().equals("online"))
        {
          paramc = cn.domob.wall.core.h.f.f(cn.domob.wall.core.b.a.i);
          c localc = new cn/domob/wall/core/c/c;
          Context localContext = this.d;
          c.a local5 = new cn/domob/wall/core/c/d$5;
          local5.<init>(this);
          localc.<init>(localContext, paramc, "", null, "POST", paramHashMap, 20000, local5);
          this.b = localc;
          this.b.b();
          return;
        }
      }
      catch (Exception paramc)
      {
        a.e("Error happens when sending ad request");
        a.a(paramc);
        continue;
      }
      paramc = cn.domob.wall.core.b.a.m;
    }
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.o = paramd;
    for (;;)
    {
      try
      {
        paramHashMap = a(2, paramHashMap);
        if (DService.getEndpoint().equals("online"))
        {
          paramd = cn.domob.wall.core.h.f.f(cn.domob.wall.core.b.a.i);
          c localc = new cn/domob/wall/core/c/c;
          Context localContext = this.d;
          c.a local2 = new cn/domob/wall/core/c/d$2;
          local2.<init>(this);
          localc.<init>(localContext, paramd, "", null, "POST", paramHashMap, 20000, local2);
          this.b = localc;
          this.b.b();
          return;
        }
      }
      catch (Exception paramd)
      {
        a.e("Error happens when sending ad request");
        a.a(paramd);
        continue;
      }
      paramd = cn.domob.wall.core.b.a.m;
    }
  }
  
  public void a(e parame, HashMap<String, String> paramHashMap)
  {
    a.b("Start to request ad.");
    this.p = parame;
    for (;;)
    {
      try
      {
        paramHashMap = a(3, paramHashMap);
        if (DService.getEndpoint().equals("online"))
        {
          parame = cn.domob.wall.core.h.f.f(cn.domob.wall.core.b.a.i);
          c localc = new cn/domob/wall/core/c/c;
          Context localContext = this.d;
          c.a local3 = new cn/domob/wall/core/c/d$3;
          local3.<init>(this);
          localc.<init>(localContext, parame, "", null, "POST", paramHashMap, 20000, local3);
          this.b = localc;
          this.b.b();
          return;
        }
      }
      catch (Exception parame)
      {
        a.e("Error happens when sending ad request");
        a.a(parame);
        continue;
      }
      parame = cn.domob.wall.core.b.a.m;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(e parame);
  }
  
  public static abstract interface b
  {
    public abstract void a(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(e parame);
  }
  
  public static abstract interface c
  {
    public abstract void a(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(f paramf);
  }
  
  public static abstract interface d
  {
    public abstract void a(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(e parame);
  }
  
  public static abstract interface e
  {
    public abstract void a(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(g paramg);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */