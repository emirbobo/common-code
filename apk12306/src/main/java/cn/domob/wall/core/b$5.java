package cn.domob.wall.core;

import cn.domob.wall.core.c.d.c;
import cn.domob.wall.core.c.f;
import java.util.List;

class b$5
  extends Thread
{
  b$5(b paramb) {}
  
  public void run()
  {
    try
    {
      if (!cn.domob.wall.core.c.a.a)
      {
        localObject = new cn/domob/wall/core/c/a;
        ((cn.domob.wall.core.c.a)localObject).<init>(this.a);
        ((cn.domob.wall.core.c.a)localObject).a();
      }
      cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
      locald.<init>(this.a);
      Object localObject = new cn/domob/wall/core/b$5$1;
      ((1)localObject).<init>(this);
      locald.a((d.c)localObject, null);
      return;
    }
    catch (cn.domob.wall.core.e.a locala)
    {
      for (;;)
      {
        b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.j().a(localException);
        b.e(this.a, false);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */