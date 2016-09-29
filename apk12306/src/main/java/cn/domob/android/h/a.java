package cn.domob.android.h;

import android.content.Context;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.w;
import cn.domob.android.ads.w.c;
import cn.domob.android.ads.w.h;

public class a
{
  public static final String a = "mogo_load";
  public static final String b = "mogo_imp";
  public static final String c = "mogo_dismiss";
  private Context d;
  private String e;
  
  public a(Context paramContext, String paramString)
  {
    this.d = paramContext;
    this.e = paramString;
  }
  
  public void a(String paramString, j paramj)
  {
    w localw = new w(this.d, this.e);
    localw.getClass();
    w.c localc = new w.c(localw);
    if ((paramj != null) && (paramj.d() != null))
    {
      paramj = paramj.d();
      localc.a = paramj.r();
    }
    for (paramj = paramj.q();; paramj = null)
    {
      localw.a(paramj, w.h.s, paramString, localc, null);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */