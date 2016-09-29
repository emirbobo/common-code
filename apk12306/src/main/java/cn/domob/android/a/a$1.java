package cn.domob.android.a;

import android.util.Log;
import cn.domob.android.offerwall.m;
import java.io.File;

class a$1
  implements i
{
  a$1(a parama) {}
  
  public void a()
  {
    Log.e("DomobSDK", a.b(this.a) + "rom can't chmod");
    if (a.j(this.a) != null) {
      a.j(this.a).a(5, "sd卡不存在");
    }
    a.b(this.a, "sd卡不存在");
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    Log.e("DomobSDK", a.b(this.a) + "not enough size sdsize=" + paramLong2 + " romsize=" + paramLong3);
    if (a.j(this.a) != null) {
      a.j(this.a).a(1, "空间不足");
    }
    a.b(this.a, "空间不足");
  }
  
  public void a(String paramString)
  {
    a.e().a(a.class, a.b(this.a) + " already exists in " + paramString);
    a.a(this.a, paramString);
    a.a(this.a, a.h(this.a), 0L);
  }
  
  public void b(String paramString)
  {
    a.e().a(a.class, a.b(this.a) + " is download but not finished in " + paramString);
    a.a(this.a, paramString);
    paramString = new File(a.h(this.a));
    a.a(this.a, a.h(this.a), paramString.length());
  }
  
  public void c(String paramString)
  {
    a.e().a(a.class, a.b(this.a) + " is  not download,it will download in " + paramString);
    a.a(this.a, paramString);
    a.a(this.a, a.h(this.a), 0L);
  }
  
  public void d(String paramString)
  {
    Log.e("DomobSDK", a.b(this.a) + "无法连接到下载地址");
    if (a.j(this.a) != null) {
      a.j(this.a).a(5, a.b(this.a) + paramString);
    }
    a.b(this.a, "无法连接到下载地址");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */