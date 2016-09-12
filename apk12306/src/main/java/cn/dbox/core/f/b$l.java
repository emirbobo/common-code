package cn.dbox.core.f;

import cn.dbox.core.b.n;
import cn.dbox.core.c;
import cn.dbox.core.h.e;
import java.util.HashMap;

class b$l
  extends b.c
{
  b$l(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.f);
    a(this.b, "-1");
    this.b.put("sid", "");
    this.b.put("type", "start");
    this.b.put("network", e.n(paramc.f()));
    this.b.put("pb[name]", e.d(paramc.f()));
    this.b.put("pb[version]", e.c(paramc.f()));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */