package cn.domob.wall.core.f;

import cn.domob.wall.core.DService;
import cn.domob.wall.core.b.a;
import cn.domob.wall.core.h.f;
import java.util.HashMap;

class b$g
  extends b.a
{
  b$g(b paramb, cn.domob.wall.core.b paramb1)
  {
    super(paramb, paramb1, b.n.e);
  }
  
  protected void a()
  {
    b.h localh = new b.h(this.e, this.c.g());
    if (DService.getEndpoint().equals("online")) {
      localh.a(this.a, String.valueOf(b.n.e.ordinal()), f.f(a.l));
    }
    for (;;)
    {
      return;
      localh.a(this.a, String.valueOf(b.n.e.ordinal()), f.f(a.p));
    }
  }
  
  void a(String paramString)
  {
    this.a.put("tr", paramString);
    a(this.a, paramString);
  }
  
  void b(String paramString)
  {
    this.a.put("sid", paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */