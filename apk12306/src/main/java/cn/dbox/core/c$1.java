package cn.dbox.core;

import cn.dbox.core.bean.g;
import cn.dbox.core.bean.g.a;
import cn.dbox.core.c.d.a;
import cn.dbox.core.c.e;
import java.util.ArrayList;
import java.util.HashMap;

class c$1
  extends Thread
{
  c$1(c paramc, String paramString, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (!cn.dbox.core.c.a.a)
        {
          localObject = new cn/dbox/core/c/a;
          ((cn.dbox.core.c.a)localObject).<init>(this.c);
          ((cn.dbox.core.c.a)localObject).a();
        }
        localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        if (this.a == null)
        {
          c.u().b("adContainerName:wall");
          localObject = new cn/dbox/core/c/d;
          ((cn.dbox.core.c.d)localObject).<init>(this.c);
          d.a local1 = new cn/dbox/core/c$1$1;
          local1.<init>(this);
          ((cn.dbox.core.c.d)localObject).a(local1, localHashMap);
          return;
        }
      }
      catch (cn.dbox.core.e.a locala)
      {
        HashMap localHashMap;
        c.u().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
        continue;
      }
      catch (Exception localException)
      {
        c.u().a(localException);
        c.a(this.c, false);
        continue;
      }
      localHashMap.put("acid", this.a);
      if (this.b != 0)
      {
        this.c.a = this.c.a(this.a, this.b);
        localHashMap.put("ids", this.c.a);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */