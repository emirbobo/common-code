package cn.domob.android.ads.b;

import android.app.Activity;
import android.app.Dialog;
import cn.domob.android.ads.a.d;
import cn.domob.android.i.f;
import java.util.Map;

class e
  extends b
{
  private static f c = new f(e.class.getSimpleName());
  
  e(Map<String, String> paramMap, m paramm)
  {
    super(paramMap, paramm);
  }
  
  void a()
  {
    Object localObject = null;
    String str = b("url");
    c.a("Open MRAID browser with URL:" + str);
    for (;;)
    {
      try
      {
        if ((this.b.getContext() instanceof Activity)) {
          localObject = (Activity)this.b.getContext();
        }
        if ((localObject == null) || (!((Activity)localObject).isFinishing()))
        {
          localObject = new cn/domob/android/ads/a/d;
          ((d)localObject).<init>(this.b.getContext(), str, null, this.b.k());
          ((d)localObject).a().show();
          if (this.b.j() != null) {
            this.b.j().a();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        c.a(localException);
        continue;
      }
      c.b("can not build with activity finishing");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */