package cn.domob.wall.core;

import cn.domob.wall.core.c.d.c;
import cn.domob.wall.core.c.f;
import cn.domob.wall.core.h.d;
import java.util.List;

class b$5$1
  implements d.c
{
  b$5$1(b.5 param5) {}
  
  public void a(DService.ErrorCode paramErrorCode, String paramString)
  {
    b.e(this.a.a, false);
    if (b.e(this.a.a) != null) {
      b.e(this.a.a).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void a(f paramf)
  {
    b.e(this.a.a, false);
    if (paramf != null)
    {
      if (b.e(this.a.a) != null) {
        b.e(this.a.a).onSuccessReceiveData(paramf.c());
      }
      if (paramf.c() != null) {
        for (int i = 0; i < paramf.c().size(); i++) {
          b.j().b("hotword:" + (String)paramf.c().get(i));
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b$5$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */