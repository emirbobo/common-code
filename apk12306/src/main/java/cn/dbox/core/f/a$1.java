package cn.dbox.core.f;

import cn.dbox.core.c;
import cn.dbox.core.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class a$1
  implements Runnable
{
  a$1(a parama, ArrayList paramArrayList, String paramString, c paramc) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>();
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (cn.dbox.core.bean.a)localIterator.next();
          localObject2 = new org/json/JSONObject;
          ((JSONObject)localObject2).<init>();
          ((JSONObject)localObject2).put("id", ((cn.dbox.core.bean.a)localObject1).i());
          ((JSONObject)localObject2).put("acid", this.b);
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
      ((b.m)localObject1).<init>((b)localObject2, this.c);
      ((b.m)localObject1).a(localException.toString());
      ((b.m)localObject1).b(this.c.l());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */