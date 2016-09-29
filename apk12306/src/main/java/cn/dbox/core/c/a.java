package cn.dbox.core.c;

import android.content.Context;
import cn.dbox.core.h.d;
import cn.dbox.core.h.e;
import cn.dbox.core.h.f;
import java.util.HashMap;

public class a
{
  public static boolean a = false;
  private static d b = new d(a.class.getSimpleName());
  private static boolean c = false;
  private c d;
  private cn.dbox.core.c e;
  private Context f;
  
  public a(cn.dbox.core.c paramc)
  {
    this.e = paramc;
    this.f = paramc.f();
  }
  
  private String b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(31));
    localHashMap.put("rt", String.valueOf(1));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", e.f(this.f));
    localHashMap.put("ipb", this.e.a());
    localHashMap.put("ppid", this.e.b());
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20140918", "android", "20140711" }));
    localHashMap.put("sv", "000900");
    return f.a(localHashMap);
  }
  
  public void a()
    throws cn.dbox.core.e.a
  {
    if (c) {
      throw new cn.dbox.core.e.a();
    }
    c = true;
    for (;;)
    {
      try
      {
        String str = b();
        d locald = b;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        locald.b("Config Request Params:" + str);
        localObject2 = new cn/dbox/core/c/c;
        ((c)localObject2).<init>(this.f, this.e.i(), "", null, "POST", str, 20000, null);
        this.d = ((c)localObject2);
        this.d.c();
        str = this.d.e();
        locald = b;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        locald.b("config request response:" + str);
        if (str != null)
        {
          localObject2 = new cn/dbox/core/c/b;
          ((b)localObject2).<init>(str);
          e.a(((b)localObject2).a());
          this.e.a(((b)localObject2).b());
          a = true;
          return;
        }
      }
      catch (Exception localException)
      {
        b.a(localException);
        c = false;
        continue;
      }
      finally
      {
        c = false;
      }
      b.e("Config respStr is null.");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */