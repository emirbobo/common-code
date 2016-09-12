package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import cn.domob.wall.core.c.d.d;
import cn.domob.wall.core.c.e;
import cn.domob.wall.core.h.d;
import java.util.Iterator;
import java.util.List;

class b$2$1
  implements d.d
{
  b$2$1(b.2 param2) {}
  
  public void a(DService.ErrorCode paramErrorCode, String paramString)
  {
    b.b(this.a.a, false);
    if (b.b(this.a.a) != null) {
      b.b(this.a.a).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void a(e parame)
  {
    b.b(this.a.a, false);
    if (parame != null)
    {
      Iterator localIterator;
      AdInfo localAdInfo;
      if (parame.f() != null)
      {
        localIterator = parame.f().iterator();
        while (localIterator.hasNext())
        {
          localAdInfo = (AdInfo)localIterator.next();
          b.j().b("banner:" + localAdInfo.toString());
        }
      }
      if (parame.d() != null)
      {
        localIterator = parame.d().iterator();
        while (localIterator.hasNext())
        {
          localAdInfo = (AdInfo)localIterator.next();
          b.j().b("itemlist:" + localAdInfo.toString());
        }
      }
      if (parame.c() != null) {
        b.j().b("Control:" + parame.c().toString());
      }
      if (b.b(this.a.a) != null)
      {
        this.a.a.a(parame.g());
        b.a(this.a.a, parame.a());
        b.b(this.a.a).onSuccessReceiveData(parame.f(), parame.d(), parame.c(), parame.g());
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */