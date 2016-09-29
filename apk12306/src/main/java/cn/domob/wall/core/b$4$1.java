package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.c.d.b;
import cn.domob.wall.core.c.e;
import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b$4$1
  implements d.b
{
  b$4$1(b.4 param4) {}
  
  public void a(DService.ErrorCode paramErrorCode, String paramString)
  {
    b.d(this.a.b, false);
    if (b.d(this.a.b) != null) {
      b.d(this.a.b).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void a(e parame)
  {
    int j = 0;
    b.d(this.a.b, false);
    if (parame != null)
    {
      if (b.d(this.a.b) != null)
      {
        b.d(this.a.b).onSuccessReceiveData(parame.e());
        b.a(this.a.b, parame.a());
      }
      ArrayList localArrayList = new ArrayList();
      if (localArrayList != null)
      {
        if (parame.d() != null)
        {
          Iterator localIterator = parame.d().iterator();
          while (localIterator.hasNext()) {
            localArrayList.add((AdInfo)localIterator.next());
          }
        }
        int i = j;
        if (parame.f() != null)
        {
          parame = parame.f().iterator();
          for (;;)
          {
            i = j;
            if (!parame.hasNext()) {
              break;
            }
            localArrayList.add((AdInfo)parame.next());
          }
        }
        while (i < localArrayList.size())
        {
          b.j().b("details:" + ((AdInfo)localArrayList.get(i)).toString());
          i++;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */