package cn.dbox.core.f;

import cn.dbox.core.b.g;
import cn.dbox.core.b.n;
import cn.dbox.core.bean.a;
import cn.dbox.core.c;
import java.util.HashMap;

class b$j
  extends b.c
{
  b$j(b paramb, c paramc, a parama)
  {
    super(paramb, paramc, parama, b.n.h);
    this.b.put("id", parama.i());
    this.b.put("sid", paramc.e());
  }
  
  void a(b.g paramg)
  {
    String str = "";
    switch (b.1.g[paramg.ordinal()])
    {
    default: 
      paramg = str;
    }
    for (;;)
    {
      this.b.put("type", paramg);
      return;
      paramg = "download_start";
      continue;
      paramg = "download_repeat";
      continue;
      paramg = "download_finish";
      continue;
      paramg = "download_failed";
      continue;
      paramg = "download_cancel";
      continue;
      paramg = "install_success";
      continue;
      paramg = "run";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */