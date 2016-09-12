package cn.domob.wall.core.f;

import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.DService.ReportDownLoadType;
import cn.domob.wall.core.DService.ReportUserActionType;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  public static final String a = "1";
  public static final int b = 0;
  public static final int c = 1;
  private static d d = new d(a.class.getSimpleName());
  private static a e;
  
  public static a a()
  {
    try
    {
      if (e == null)
      {
        locala = new cn/domob/wall/core/f/a;
        locala.<init>();
        e = locala;
      }
      a locala = e;
      return locala;
    }
    finally {}
  }
  
  public void a(cn.domob.wall.core.b paramb, DService.EWallReportType paramEWallReportType, String paramString)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.e(localb, paramb);
    paramb.a(paramEWallReportType);
    if (paramString != null) {
      paramb.a(paramString);
    }
    paramb.a();
  }
  
  public void a(cn.domob.wall.core.b paramb, DService.ReportUserActionType paramReportUserActionType)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.o(localb, paramb);
    paramb.a(paramReportUserActionType);
    paramb.a();
  }
  
  public void a(cn.domob.wall.core.b paramb, AdInfo paramAdInfo, DService.ReportDownLoadType paramReportDownLoadType)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.d(localb, paramb, paramAdInfo);
    paramb.a(paramReportDownLoadType);
    paramb.a();
  }
  
  public void a(cn.domob.wall.core.b paramb, AdInfo paramAdInfo, b.j paramj)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.b(localb, paramb, paramAdInfo);
    paramb.a(paramj);
    paramb.a();
  }
  
  public void a(cn.domob.wall.core.b paramb, AdInfo paramAdInfo, b.k paramk)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.c(localb, paramb, paramAdInfo);
    paramb.a(paramk);
    if (paramk.name().equals(b.k.b.name()))
    {
      paramAdInfo.setAdActualPosition(0);
      paramb.b(0);
    }
    for (;;)
    {
      paramb.a(1);
      paramb.a();
      return;
      paramb.b(paramAdInfo.getAdActualPosition());
    }
  }
  
  public void a(cn.domob.wall.core.b paramb, AdInfo paramAdInfo, b.m paramm, String paramString)
  {
    b localb = b.a();
    localb.getClass();
    paramb = new b.i(localb, paramb, paramAdInfo);
    paramb.a(paramm);
    paramb.a(paramString);
    paramb.a();
  }
  
  public void a(final cn.domob.wall.core.b paramb, final ArrayList<AdInfo> paramArrayList)
  {
    paramb.h().execute(new Runnable()
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
            localObject1 = paramArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AdInfo)((Iterator)localObject1).next();
              JSONObject localJSONObject = new org/json/JSONObject;
              localJSONObject.<init>();
              localJSONObject.put("id", ((AdInfo)localObject2).getAdId());
              localJSONObject.put("tr", ((AdInfo)localObject2).getAdTracker());
              localJSONObject.put("sn", "1");
              localJSONObject.put("position", ((AdInfo)localObject2).getAdActualPosition());
              localJSONArray.put(localJSONObject);
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
          localObject2 = new cn/domob/wall/core/f/b$g;
          localObject1 = b.a();
          localObject1.getClass();
          ((b.g)localObject2).<init>((b)localObject1, paramb);
          ((b.g)localObject2).a(localException.toString());
          ((b.g)localObject2).b(((AdInfo)paramArrayList.get(0)).getSearchId());
          ((b.g)localObject2).a();
        }
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */