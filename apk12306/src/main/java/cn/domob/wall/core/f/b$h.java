package cn.domob.wall.core.f;

import android.content.Context;
import cn.domob.wall.core.c.c;
import cn.domob.wall.core.c.c.a;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;
import java.util.HashMap;

class b$h
  implements c.a
{
  private Context b;
  private c c;
  
  protected b$h(b paramb, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a(c paramc)
  {
    int i = paramc.f();
    b.b().b("imp repoet response: " + i);
    if (i == 200) {
      b.b().b("Imp report finish.");
    }
    for (;;)
    {
      return;
      b.b().e("onConnectionFinished:respCode=" + i);
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, String paramString1, String paramString2)
  {
    paramHashMap = f.a(paramHashMap);
    b.b().b("imp report: " + paramHashMap);
    this.c = new c(this.b, paramString2, "", null, "POST", paramHashMap, 20000, this);
    this.c.run();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */