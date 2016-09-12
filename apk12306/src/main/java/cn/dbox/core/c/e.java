package cn.dbox.core.c;

import android.content.Context;
import cn.dbox.core.bean.a;
import cn.dbox.core.bean.c;
import cn.dbox.core.bean.d.a;
import cn.dbox.core.bean.g;
import cn.dbox.core.bean.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class e
{
  private static cn.dbox.core.h.d a = new cn.dbox.core.h.d(e.class.getSimpleName());
  private String b;
  private String c;
  private String d;
  private h e;
  private g f;
  private ArrayList<c> g;
  private ArrayList<a> h;
  private HashMap<String, a> i = new HashMap();
  private ArrayList<cn.dbox.core.bean.d> j = new ArrayList();
  private HashMap<String, cn.dbox.core.bean.d> k = new HashMap();
  
  private boolean b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new org/json/JSONObject;
      localObject3 = new org/json/JSONTokener;
      ((JSONTokener)localObject3).<init>(paramString);
      ((JSONObject)localObject1).<init>((JSONTokener)localObject3);
      this.b = ((JSONObject)localObject1).optString("sid");
      this.c = ((JSONObject)localObject1).optString("cid");
      this.d = ((JSONObject)localObject1).optString("dmid");
      if ((this.c != null) && (!this.c.equals(""))) {
        f.a().a(paramContext, this.c);
      }
      paramString = ((JSONObject)localObject1).optJSONObject("error");
      localObject3 = ((JSONObject)localObject1).optJSONObject("control");
      if (paramString == null) {
        break label127;
      }
      paramContext = new cn/dbox/core/bean/h;
      paramContext.<init>(paramString);
      this.e = paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject3;
        label127:
        int m;
        int n;
        a.a(paramContext);
        boolean bool = false;
        continue;
        Object localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        this.g = ((ArrayList)localObject1);
        if (paramString != null)
        {
          m = 0;
          for (;;)
          {
            n = paramString.length();
            if (m < n) {
              try
              {
                localObject1 = this.g;
                localObject4 = new cn/dbox/core/bean/c;
                ((c)localObject4).<init>(paramString.getJSONObject(m));
                ((ArrayList)localObject1).add(localObject4);
                m++;
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  a.a(localJSONException1);
                }
              }
            }
          }
        }
        Object localObject2 = this.h.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (a)((Iterator)localObject2).next();
          this.i.put(paramString.i(), paramString);
        }
        Object localObject4 = this.g.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          paramString = ((c)((Iterator)localObject4).next()).d().iterator();
          while (paramString.hasNext())
          {
            localObject2 = (cn.dbox.core.bean.d)paramString.next();
            this.j.add(localObject2);
            this.k.put(((cn.dbox.core.bean.d)localObject2).c(), localObject2);
          }
        }
        j();
        f.a().b(paramContext);
      }
    }
    bool = true;
    return bool;
    if (localObject3 != null)
    {
      paramString = new cn/dbox/core/bean/g;
      paramString.<init>((JSONObject)localObject3);
      this.f = paramString;
    }
    paramString = ((JSONObject)localObject1).optJSONArray("channels");
    localObject3 = new java/util/ArrayList;
    ((ArrayList)localObject3).<init>();
    this.h = ((ArrayList)localObject3);
    localObject1 = ((JSONObject)localObject1).optJSONArray("ads");
    if (localObject1 != null)
    {
      m = 0;
      for (;;)
      {
        n = ((JSONArray)localObject1).length();
        if (m < n) {
          try
          {
            localObject3 = this.h;
            a locala = new cn/dbox/core/bean/a;
            locala.<init>(((JSONArray)localObject1).getJSONObject(m));
            ((ArrayList)localObject3).add(locala);
            m++;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              a.a(localJSONException2);
            }
          }
        }
      }
    }
  }
  
  public e a(Context paramContext, String paramString)
  {
    e locale = new e();
    if (locale.b(paramContext, paramString)) {
      a.a("Ad/Error response is ok.");
    }
    for (paramContext = locale;; paramContext = null) {
      return paramContext;
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public h d()
  {
    return this.e;
  }
  
  public g e()
  {
    return this.f;
  }
  
  public ArrayList<c> f()
  {
    return this.g;
  }
  
  public ArrayList<a> g()
  {
    return this.h;
  }
  
  public HashMap<String, a> h()
  {
    return this.i;
  }
  
  public HashMap<String, cn.dbox.core.bean.d> i()
  {
    return this.k;
  }
  
  public void j()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      cn.dbox.core.bean.d locald = (cn.dbox.core.bean.d)localIterator.next();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = locald.i();
      ArrayList localArrayList3 = locald.k().b();
      int n;
      for (int m = 0; m < localArrayList2.size(); m++) {
        for (n = 0; n < this.h.size(); n++) {
          if ((((a)this.h.get(n)).i().equals(localArrayList2.get(m))) && (localArrayList4.size() < locald.h())) {
            localArrayList4.add(this.h.get(n));
          }
        }
      }
      if (localArrayList3 != null) {
        for (m = 0; m < localArrayList3.size(); m++) {
          for (n = 0; n < this.h.size(); n++) {
            if (((a)this.h.get(n)).i().equals(localArrayList3.get(m))) {
              localArrayList1.add(this.h.get(n));
            }
          }
        }
      }
      locald.a(localArrayList4);
      locald.k().a(localArrayList1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */