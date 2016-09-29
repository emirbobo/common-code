package cn.domob.android.ads;

import a.a.a.a.a.a;
import android.text.TextUtils;
import cn.domob.android.f.h;
import cn.domob.android.i.f;

class i$1
  extends cn.domob.android.f.g
{
  i$1(i parami) {}
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = null;
    String str = null;
    if (!TextUtils.isEmpty(paramString1))
    {
      i.b().a("Ad resp string:" + paramString1);
      paramString1 = j.a(i.a(this.a), paramString1);
      if (paramString1 == null) {
        break label144;
      }
      j.c localc = paramString1.d();
      if (localc == null) {
        break label139;
      }
      paramString2 = localc.r();
      str = localc.q();
      a.a(i.a(this.a), paramString1.g(), paramString2, i.b(this.a).n(), str);
    }
    label139:
    label144:
    for (;;)
    {
      i.b(this.a).a(paramString1, i.c(this.a).a().d());
      return;
      i.b().e("Ad respStr is null.");
      paramString1 = paramString2;
      continue;
      paramString2 = null;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\i$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */