package cn.domob.wall.core.f;

import android.content.Context;
import cn.domob.wall.core.c.c;
import cn.domob.wall.core.c.c.a;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;
import java.util.HashMap;

class b$l
  implements c.a
{
  b$l(b paramb) {}
  
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */