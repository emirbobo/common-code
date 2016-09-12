package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.c.d.e;
import cn.domob.wall.core.c.g;
import cn.domob.wall.core.h.d;
import java.util.List;

class b$3$1
  implements d.e
{
  b$3$1(b.3 param3) {}
  
  public void a(DService.ErrorCode paramErrorCode, String paramString)
  {
    b.c(this.a.b, false);
    if (b.c(this.a.b) != null) {
      b.c(this.a.b).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void a(g paramg)
  {
    b.c(this.a.b, false);
    if (paramg != null)
    {
      if (b.c(this.a.b) != null)
      {
        b.c(this.a.b).onSuccessReceiveData(paramg.c(), paramg.d());
        b.a(this.a.b, paramg.a());
      }
      if (paramg.c() != null) {
        for (int i = 0; i < paramg.c().size(); i++) {
          b.j().b("searchad::", ((AdInfo)paramg.c().get(i)).toString());
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */