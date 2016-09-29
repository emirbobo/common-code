package cn.domob.wall.core.f;

import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class a$1
  implements Runnable
{
  a$1(a parama, ArrayList paramArrayList, cn.domob.wall.core.b paramb) {}
  
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
        localObject1 = this.a.iterator();
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
      ((b.g)localObject2).<init>((b)localObject1, this.b);
      ((b.g)localObject2).a(localException.toString());
      ((b.g)localObject2).b(((AdInfo)this.a.get(0)).getSearchId());
      ((b.g)localObject2).a();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */