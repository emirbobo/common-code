package cn.domob.wall.core.f;

import cn.domob.wall.core.bean.AdInfo;
import java.util.HashMap;

class b$i
  extends b.a
{
  b$i(b paramb, cn.domob.wall.core.b paramb1, AdInfo paramAdInfo)
  {
    super(paramb, paramb1, paramAdInfo, b.n.g);
  }
  
  public void a(b.m paramm)
  {
    String str = "";
    switch (b.1.d[paramm.ordinal()])
    {
    default: 
      paramm = str;
    }
    for (;;)
    {
      this.a.put("type", paramm);
      return;
      paramm = "la_success";
      continue;
      paramm = "la_failed";
      continue;
      paramm = "la_failsafe_success";
      continue;
      paramm = "la_failsafe_failed";
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.a.put("failsafe", paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */