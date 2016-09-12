package cn.dbox.core.f;

import android.content.Context;
import cn.dbox.core.b.a;
import cn.dbox.core.b.c;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.c.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  public static final String a = "1";
  public static final int b = 0;
  public static final int c = 1;
  private static cn.dbox.core.h.d d = new cn.dbox.core.h.d(a.class.getSimpleName());
  private static a e;
  
  public static a a()
  {
    try
    {
      if (e == null)
      {
        locala = new cn/dbox/core/f/a;
        locala.<init>();
        e = locala;
      }
      a locala = e;
      return locala;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new cn.dbox.core.c.c(paramContext, paramString1, null, null, "GET", null, 20000, new c.a()
    {
      public void a(cn.dbox.core.c.c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.f() == 200)) {
          a.b().b("Report finish: ");
        }
      }
    });
    d.b("The third party incident report:" + paramString1);
    paramContext.a(paramString2);
    paramContext.b();
  }
  
  public void a(cn.dbox.core.c paramc, b.c paramc1, cn.dbox.core.bean.c paramc2)
  {
    Object localObject = b.a();
    localObject.getClass();
    localObject = new b.e((b)localObject, paramc);
    ((b.e)localObject).a(paramc1);
    ((b.e)localObject).a(paramc2.a());
    ((b.e)localObject).b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.b.f paramf, cn.dbox.core.bean.d paramd, cn.dbox.core.b.e parame)
  {
    paramf = b.a();
    paramf.getClass();
    paramf = new b.i(paramf, paramc);
    paramf.a(paramd.a());
    paramf.c(paramd.c());
    paramf.a(parame);
    paramf.a(cn.dbox.core.b.f.b);
    paramf.b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.b.o paramo, String paramString1, String paramString2)
  {
    Object localObject = b.a();
    localObject.getClass();
    localObject = new b.r((b)localObject, paramc);
    ((b.r)localObject).a(paramo);
    ((b.r)localObject).a(paramString1);
    ((b.r)localObject).c(paramString2);
    ((b.r)localObject).b(paramc.p());
  }
  
  public void a(cn.dbox.core.c paramc, Entrance.EntryReportType paramEntryReportType)
  {
    paramEntryReportType = b.a();
    paramEntryReportType.getClass();
    new b.l(paramEntryReportType, paramc).b("http://arp.12306.domob.cn/aw/event/");
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.a parama, b.a parama1, cn.dbox.core.b.d paramd)
  {
    parama1 = b.a();
    parama1.getClass();
    parama1 = new b.f(parama1, paramc, parama);
    parama1.a(paramd);
    parama1.a(parama.d());
    parama1.c(parama.c());
    parama1.a(parama.b());
    parama1.b(paramc.j());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.a parama, cn.dbox.core.b.b paramb)
  {
    b localb = b.a();
    localb.getClass();
    parama = new b.d(localb, paramc, parama);
    parama.a(paramb);
    parama.b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.a parama, cn.dbox.core.b.g paramg)
  {
    b localb = b.a();
    localb.getClass();
    parama = new b.j(localb, paramc, parama);
    parama.a(paramg);
    parama.b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.a parama, cn.dbox.core.b.i parami, String paramString)
  {
    b localb = b.a();
    localb.getClass();
    parama = new b.o(localb, paramc, parama);
    parama.a(parami);
    parama.a(paramString);
    parama.b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.a parama, HashMap<String, String> paramHashMap, String paramString1, String paramString2)
  {
    b localb = b.a();
    localb.getClass();
    paramc = new b.b(localb, paramc, parama);
    paramc.a(paramHashMap);
    paramc.a(paramString1);
    paramc.b(paramString2);
  }
  
  public void a(cn.dbox.core.c paramc, cn.dbox.core.bean.d paramd, cn.dbox.core.b.b paramb)
  {
    Object localObject = b.a();
    localObject.getClass();
    localObject = new b.g((b)localObject, paramc);
    ((b.g)localObject).a(paramd.a());
    ((b.g)localObject).c(paramd.c());
    ((b.g)localObject).a(cn.dbox.core.b.f.c);
    ((b.g)localObject).a(paramb);
    ((b.g)localObject).b(paramc.n());
  }
  
  public void a(cn.dbox.core.c paramc, String paramString)
  {
    try
    {
      b.q localq = new cn/dbox/core/f/b$q;
      b localb = b.a();
      localb.getClass();
      localq.<init>(localb, paramc);
      localq.a(paramString);
      localq.b(paramc.m());
      return;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        d.a(paramc);
      }
    }
    catch (Error paramc)
    {
      for (;;)
      {
        d.a(paramc);
      }
    }
  }
  
  public void a(cn.dbox.core.c paramc, String paramString1, cn.dbox.core.b.b paramb, String paramString2)
  {
    paramString1 = b.a();
    paramString1.getClass();
    paramc = new b.h(paramString1, paramc);
    paramc.a(cn.dbox.core.b.f.c);
    paramc.a(paramb);
    paramc.b(paramString2);
  }
  
  public void a(final cn.dbox.core.c paramc, final ArrayList<cn.dbox.core.bean.a> paramArrayList, final String paramString)
  {
    paramc.g().execute(new Runnable()
    {
      public void run()
      {
        Object localObject1;
        Object localObject2;
        try
        {
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          if (paramArrayList != null)
          {
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              localObject1 = (cn.dbox.core.bean.a)localIterator.next();
              localObject2 = new org/json/JSONObject;
              ((JSONObject)localObject2).<init>();
              ((JSONObject)localObject2).put("id", ((cn.dbox.core.bean.a)localObject1).i());
              ((JSONObject)localObject2).put("acid", paramString);
              ((JSONObject)localObject2).put("tr", ((cn.dbox.core.bean.a)localObject1).h());
              ((JSONObject)localObject2).put("position", ((cn.dbox.core.bean.a)localObject1).d());
              localJSONArray.put(localObject2);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          a.b().a(localException);
        }
        for (;;)
        {
          localObject1 = new cn/dbox/core/f/b$m;
          localObject2 = b.a();
          localObject2.getClass();
          ((b.m)localObject1).<init>((b)localObject2, paramc);
          ((b.m)localObject1).a(localException.toString());
          ((b.m)localObject1).b(paramc.l());
        }
      }
    });
  }
  
  public void b(cn.dbox.core.c paramc, Entrance.EntryReportType paramEntryReportType)
  {
    Object localObject = b.a();
    localObject.getClass();
    localObject = new b.k((b)localObject, paramc);
    ((b.k)localObject).a(paramEntryReportType);
    ((b.k)localObject).b(paramc.n());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */