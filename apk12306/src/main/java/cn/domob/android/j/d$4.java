package cn.domob.android.j;

import cn.domob.android.i.f;
import java.util.HashMap;

class d$4
  implements Runnable
{
  d$4(d paramd, String paramString, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = d.a(this.c, d.a(this.c, this.a));
        if (localObject1 != null)
        {
          d.j(this.c).put(this.a, localObject1);
          localObject2 = d.h();
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((f)localObject2).b("button img download successfully, download url: " + this.a);
          if (d.k(this.c) != -1)
          {
            d.l(this.c);
            if ((d.k(this.c) == this.b) && (d.a(this.c) != null)) {
              d.a(this.c).j();
            }
          }
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        d.h().a(localException);
        continue;
      }
      localObject1 = d.h();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((f)localObject1).d("button img download failed, download url: " + this.a);
      if ((d.a(this.c) != null) && (d.k(this.c) != -1)) {
        d.a(this.c).j();
      }
      d.a(this.c, -1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */