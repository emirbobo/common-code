package cn.domob.wall.core.c;

import android.content.Context;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.a;
import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class g
{
  private static d a = new d(g.class.getSimpleName());
  private static final String g = "ad";
  private static final String h = "error";
  private String b;
  private String c;
  private a d;
  private List<AdInfo> e;
  private List<AdInfo> f;
  
  private List<AdInfo> a(long paramLong, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString1);
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length()) {
          try
          {
            AdInfo localAdInfo = new cn/domob/wall/core/bean/AdInfo;
            localAdInfo.<init>(paramLong, paramJSONObject.getJSONObject(i), paramString2, paramString1, null);
            localArrayList.add(localAdInfo);
            i++;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              a.a(localJSONException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new org/json/JSONObject;
      localObject2 = new org/json/JSONTokener;
      ((JSONTokener)localObject2).<init>(paramString);
      ((JSONObject)localObject1).<init>((JSONTokener)localObject2);
      this.b = ((JSONObject)localObject1).optString("sid", "");
      this.c = ((JSONObject)localObject1).optString("cid", "");
      if ((this.c != null) && (!this.c.equals(""))) {
        h.a().a(paramContext, this.c);
      }
      paramString = ((JSONObject)localObject1).optJSONObject("ad");
      localObject1 = ((JSONObject)localObject1).optJSONObject("error");
      if (localObject1 == null) {
        break label122;
      }
      paramContext = new cn/domob/wall/core/bean/a;
      paramContext.<init>((JSONObject)localObject1);
      this.d = paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        label122:
        long l;
        a.a(paramContext);
        boolean bool = false;
        continue;
        if (this.f != null)
        {
          localObject1 = this.f.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramString = (AdInfo)((Iterator)localObject1).next();
            a.b("searchad::", paramString.toString());
          }
        }
        h.a().b(paramContext);
        continue;
        a.e("There is no ad response or error response.");
      }
    }
    bool = true;
    return bool;
    if (paramString != null)
    {
      l = h.a().a(paramContext);
      localObject2 = a;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((d)localObject2).b("lasttime request：" + l);
      this.e = a(l, "searchad", paramString, this.b);
      this.f = a(l, "recommend", paramString, this.b);
      if (this.e != null)
      {
        localObject1 = this.e.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramString = (AdInfo)((Iterator)localObject1).next();
          a.b("searchad::", paramString.toString());
        }
      }
    }
  }
  
  g a(Context paramContext, String paramString)
  {
    g localg = new g();
    if (localg.b(paramContext, paramString)) {
      a.a("Ad/Error response is ok.");
    }
    for (paramContext = localg;; paramContext = null) {
      return paramContext;
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public a b()
  {
    return this.d;
  }
  
  public List<AdInfo> c()
  {
    return this.e;
  }
  
  public List<AdInfo> d()
  {
    return this.f;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */