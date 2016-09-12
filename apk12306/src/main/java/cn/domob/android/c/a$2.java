package cn.domob.android.c;

import android.util.Log;
import cn.domob.android.i.f;
import java.io.File;

class a$2
  implements i
{
  a$2(a parama) {}
  
  public void a()
  {
    Log.e(f.b(), a.c(this.a) + "rom can't chmod");
    if (a.l(this.a) != null) {
      a.l(this.a).a(5, "sd卡不存在");
    }
    a.b(this.a, "sd卡不存在");
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      a.a(this.a, paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    Log.e(f.b(), a.c(this.a) + "not enough size sdsize=" + paramLong2 + " romsize=" + paramLong3);
    if (a.l(this.a) != null) {
      a.l(this.a).a(1, "空间不足");
    }
    a.b(this.a, "空间不足");
  }
  
  public void a(String paramString)
  {
    a.c().a(a.class, a.c(this.a) + " already exists in " + paramString);
    if (a.j(this.a) == 3) {
      if (a.l(this.a) != null) {
        a.l(this.a).b(paramString, a.m(this.a));
      }
    }
    for (;;)
    {
      return;
      a.a(this.a, paramString);
      a.a(this.a, a.i(this.a), 0L);
    }
  }
  
  public void b()
  {
    if (a.l(this.a) != null) {
      a.l(this.a).a(7, "sd卡不存在");
    }
    a.b(this.a, "sd卡不存在");
  }
  
  public void b(String paramString)
  {
    a.c().a(a.class, a.c(this.a) + " is download but not finished in " + paramString);
    a.a(this.a, paramString);
    paramString = new File(a.i(this.a));
    a.a(this.a, a.i(this.a), paramString.length());
  }
  
  public void c(String paramString)
  {
    a.c().a(a.class, a.c(this.a) + " is  not download,it will download in " + paramString);
    a.a(this.a, paramString);
    a.a(this.a, a.i(this.a), 0L);
  }
  
  public void d(String paramString)
  {
    Log.e(f.b(), a.c(this.a) + paramString);
    if (a.l(this.a) != null) {
      a.l(this.a).a(5, a.c(this.a) + paramString + "filename: " + a.k(this.a));
    }
    a.b(this.a, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */