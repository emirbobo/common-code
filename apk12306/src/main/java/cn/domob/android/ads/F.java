package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.ads.a.c;
import cn.domob.android.ads.b.a;
import cn.domob.android.i.h;

public class f
{
  protected n a(Context paramContext, g paramg, j paramj, int paramInt1, int paramInt2)
  {
    String str = paramj.d().b();
    int i = paramg.o();
    Object localObject2 = null;
    Object localObject1;
    if (i == DomobAdView.a.d.ordinal()) {
      localObject1 = new z(paramContext, new k(paramInt1, paramInt2), paramj, paramg);
    }
    for (;;)
    {
      return (n)localObject1;
      localObject1 = localObject2;
      if (i != DomobAdView.a.e.ordinal()) {
        if (h.e(str))
        {
          localObject1 = new c(paramContext, new k(paramInt1, paramInt2), paramj, paramg);
        }
        else if (str.equals("domob"))
        {
          localObject1 = new c(paramContext, new k(paramInt1, paramInt2), paramj, paramg);
        }
        else if (str.equals("mraid"))
        {
          localObject1 = new a(paramContext, new k(paramInt1, paramInt2), paramj, paramg);
        }
        else
        {
          localObject1 = localObject2;
          if (str.equals("video")) {
            localObject1 = new D(paramContext, new k(paramInt1, paramInt2), paramj, paramg);
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\F.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */