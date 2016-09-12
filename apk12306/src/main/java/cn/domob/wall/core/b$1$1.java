package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import cn.domob.wall.core.c.d.a;
import cn.domob.wall.core.c.e;
import cn.domob.wall.core.h.d;
import java.util.Iterator;
import java.util.List;

class b$1$1
  implements d.a
{
  b$1$1(b.1 param1) {}
  
  public void a(DService.ErrorCode paramErrorCode, String paramString)
  {
    b.a(this.a.a, false);
    if (b.a(this.a.a) != null) {
      b.a(this.a.a).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void a(e parame)
  {
    b.a(this.a.a, false);
    if (parame != null)
    {
      if (b.a(this.a.a) != null)
      {
        this.a.a.a(parame.g());
        b.a(this.a.a, parame.a());
        b.a(this.a.a).onSuccessReceiveData(parame.f(), parame.d(), parame.c(), parame.g());
      }
      Iterator localIterator;
      AdInfo localAdInfo;
      if (parame.f() != null)
      {
        localIterator = parame.f().iterator();
        while (localIterator.hasNext())
        {
          localAdInfo = (AdInfo)localIterator.next();
          b.j().b("BannerList:" + localAdInfo.toString());
        }
      }
      if (parame.d() != null)
      {
        localIterator = parame.d().iterator();
        while (localIterator.hasNext())
        {
          localAdInfo = (AdInfo)localIterator.next();
          b.j().b("AdItemList:" + localAdInfo.toString());
        }
      }
      if (parame.c() != null) {
        b.j().b("ControlInfo:" + parame.c().toString());
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */