package cn.domob.wall.core.f;

import cn.domob.wall.core.bean.AdInfo;
import java.util.HashMap;

class b$b
  extends b.a
{
  b$b(b paramb, cn.domob.wall.core.b paramb1, AdInfo paramAdInfo)
  {
    super(paramb, paramb1, paramAdInfo, b.n.c);
  }
  
  public void a(b.j paramj)
  {
    String str = "";
    switch (b.1.c[paramj.ordinal()])
    {
    default: 
      paramj = str;
    }
    for (;;)
    {
      this.a.put("type", paramj);
      return;
      paramj = "load_success";
      continue;
      paramj = "load_failed";
      continue;
      paramj = "load_cancel";
      continue;
      paramj = "close_lp";
      continue;
      paramj = "lp_url";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */