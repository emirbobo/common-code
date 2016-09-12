package cn.dbox.core.f;

import android.content.Context;
import cn.dbox.core.c.c;
import cn.dbox.core.c.c.a;
import cn.dbox.core.h.d;
import cn.dbox.core.h.f;
import java.util.HashMap;

class b$p
  implements c.a
{
  b$p(b paramb) {}
  
  protected void a(Context paramContext, HashMap<String, String> paramHashMap, String paramString)
  {
    b.b().b("report type: " + (String)paramHashMap.get("type"));
    b.b().b("report params: " + paramHashMap.toString());
    paramContext = new c(paramContext, paramString, "", null, "POST", f.a(paramHashMap), 20000, this);
    paramContext.a((String)paramHashMap.get("type"));
    paramContext.b();
  }
  
  public void a(c paramc)
  {
    int i = paramc.f();
    b.b().b("report response: " + i);
    if (i == 200) {
      b.b().b("Report " + paramc.a() + " finish.");
    }
    for (;;)
    {
      return;
      b.b().b("onConnectionFinished:respCode = " + i);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */