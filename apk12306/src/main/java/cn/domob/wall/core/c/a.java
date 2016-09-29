package cn.domob.wall.core.c;

import android.content.Context;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.e;
import cn.domob.wall.core.h.f;
import java.util.HashMap;

public class a
{
  public static boolean a = false;
  private static d b = new d(a.class.getSimpleName());
  private static boolean c = false;
  private c d;
  private cn.domob.wall.core.b e;
  private Context f;
  
  public a(cn.domob.wall.core.b paramb)
  {
    this.e = paramb;
    this.f = paramb.g();
  }
  
  private String b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(30));
    localHashMap.put("rt", String.valueOf(1));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", e.f(this.f));
    localHashMap.put("ipb", this.e.d());
    localHashMap.put("ppid", this.e.e());
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20140217", "android", "20131101" }));
    localHashMap.put("sv", "020100");
    return f.a(localHashMap);
  }
  
  public void a()
    throws cn.domob.wall.core.e.a
  {
    if (c) {
      throw new cn.domob.wall.core.e.a();
    }
    c = true;
    for (;;)
    {
      try
      {
        str = b();
        Object localObject3 = b;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((d)localObject3).b("Config Request Params:" + str);
        if (!DService.getEndpoint().equals("online")) {
          continue;
        }
        localObject2 = new cn/domob/wall/core/c/c;
        ((c)localObject2).<init>(this.f, f.f(cn.domob.wall.core.b.a.i), "", null, "POST", str, 20000, null);
        this.d = ((c)localObject2);
        this.d.c();
        str = this.d.e();
        localObject2 = b;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((d)localObject2).b("config request response:" + str);
        if (str == null) {
          continue;
        }
        localObject2 = new cn/domob/wall/core/c/b;
        ((b)localObject2).<init>(str);
        e.a(((b)localObject2).a());
      }
      catch (Exception localException)
      {
        String str;
        Object localObject2;
        b.a(localException);
        c = false;
        continue;
        b.e("Config respStr is null.");
        continue;
      }
      finally
      {
        c = false;
      }
      c = false;
      return;
      localObject2 = new cn/domob/wall/core/c/c;
      ((c)localObject2).<init>(this.f, cn.domob.wall.core.b.a.m, "", null, "POST", str, 20000, null);
      this.d = ((c)localObject2);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */