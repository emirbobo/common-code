package cn.dbox.core;

import cn.dbox.core.bean.g;
import cn.dbox.core.bean.g.a;
import cn.dbox.core.c.d.a;
import cn.dbox.core.c.e;
import java.util.ArrayList;
import java.util.HashMap;

class c$1$1
  implements d.a
{
  c$1$1(c.1 param1) {}
  
  public void a(b.h paramh, String paramString)
  {
    c.a(this.a.c, false);
    if (this.a.a == null) {
      if (c.a(this.a.c) != null) {
        c.a(this.a.c).a(paramh, paramString, this.a.a, this.a.b);
      }
    }
    for (;;)
    {
      return;
      if (c.b(this.a.c) != null) {
        c.b(this.a.c).a(paramh, paramString, this.a.a, this.a.b);
      }
    }
  }
  
  public void a(e parame)
  {
    int i = 0;
    if (parame != null) {
      c.a(this.a.c, parame.a());
    }
    c.a(this.a.c, false);
    if (this.a.b == 0) {
      this.a.c.c = parame.i();
    }
    Object localObject = parame.e();
    if (localObject != null)
    {
      localObject = ((g)localObject).b();
      if (localObject != null) {
        c.b(this.a.c, ((g.a)localObject).b());
      }
    }
    if (this.a.a == null) {
      if (c.a(this.a.c) != null) {
        c.a(this.a.c).a(parame.e(), parame.f(), parame.g(), this.a.a, this.a.b);
      }
    }
    for (;;)
    {
      return;
      if (c.b(this.a.c) != null)
      {
        localObject = new ArrayList();
        HashMap localHashMap = parame.h();
        String[] arrayOfString = this.a.c.a.split(",");
        while (i < arrayOfString.length)
        {
          if (localHashMap.containsKey(arrayOfString[i])) {
            ((ArrayList)localObject).add(localHashMap.get(arrayOfString[i]));
          }
          i++;
        }
        c.b(this.a.c).a(parame.e(), parame.f(), (ArrayList)localObject, this.a.a, this.a.b);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */