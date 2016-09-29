package cn.domob.android.ads;

import android.text.TextUtils;
import android.util.Log;
import cn.domob.android.c.b;
import cn.domob.android.i.f;

class x
  extends g
{
  private static f J = new f(x.class.getSimpleName());
  
  public x(DomobAdView paramDomobAdView, String paramString1, String paramString2)
  {
    super(paramDomobAdView, paramString1, paramString2);
    J.b("Init Splash controller.");
  }
  
  private void a(final String paramString1, final c paramc, final String paramString2)
  {
    cn.domob.android.c.a.a(paramString1, "", "", this.a, new b()
    {
      public void a() {}
      
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(String paramAnonymousString) {}
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        if (paramAnonymousLong > 0L) {
          if (paramc.c(x.this.a, paramString2)) {
            paramc.a(x.this.a, paramString2, paramAnonymousString, System.currentTimeMillis());
          }
        }
        for (;;)
        {
          return;
          paramc.b(x.this.a, paramString2, paramAnonymousString);
          continue;
          x.this.a(x.this.e, "sp_load_img_fail", paramString1);
        }
      }
      
      public void b() {}
      
      public void b(String paramAnonymousString, long paramAnonymousLong) {}
    }, "", false, paramString2, -1);
  }
  
  public void a(j paramj, int paramInt)
  {
    J.a("An ad response is received by splash controller.");
    if ((paramj != null) && (((y)this.d).l())) {
      if (paramInt == -1)
      {
        J.a("There is a cached ad witch is about to be show.");
        super.a(paramj, paramInt);
      }
    }
    for (;;)
    {
      c(false);
      String str1;
      for (;;)
      {
        return;
        if (paramj.d() == null) {
          break label282;
        }
        str1 = paramj.d().e();
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        J.b("adResponse image_url is null !");
      }
      J.a("There is a new ad witch is about to be inserted into DB.");
      Object localObject = new K();
      String str2 = paramj.d().a();
      ((K)localObject).b(str2);
      ((K)localObject).d(paramj.d().c() + "*" + paramj.d().d());
      ((K)localObject).c(paramj.a());
      ((K)localObject).a(paramj.d().A());
      ((K)localObject).b(System.currentTimeMillis());
      ((K)localObject).a(cn.domob.android.b.a.r(this.a));
      paramj = new c();
      if (paramj.a(this.a, (K)localObject))
      {
        localObject = cn.domob.android.c.a.b(str1);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)) && (paramj.d(this.a, str2, (String)localObject)) && (TextUtils.isEmpty(paramj.d(x(), (String)localObject))))
        {
          a(str1, paramj, (String)localObject);
          continue;
          label282:
          if (paramj.e() != null)
          {
            J.e("There is a error info response.");
            Log.e("DomobSDK", String.format("Response contains error info. Error code is [%d-%s] and error content is [%s]", new Object[] { Integer.valueOf(paramj.e().a()), paramj.b(), paramj.e().b() }));
            continue;
            super.a(paramj, paramInt);
          }
        }
      }
    }
  }
  
  protected void a(j paramj, String paramString1, String paramString2)
  {
    J.b("Failed to splash.Report fail event type " + paramString1);
    w localw = new w(this.a, this.c);
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.h = paramString2;
    if ((paramj != null) && (paramj.d() != null))
    {
      paramString2 = paramj.d().q();
      localc.a = paramj.d().r();
    }
    for (paramj = paramString2;; paramj = null)
    {
      if (paramj != null)
      {
        paramString2 = paramj;
        if (paramj.length() != 0) {}
      }
      else
      {
        paramString2 = "http://e.domob.cn/event_report";
      }
      localw.a(paramString2, w.h.i, paramString1, localc, null);
      return;
    }
  }
  
  protected void b(j paramj, String paramString)
  {
    a(paramj, paramString, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */