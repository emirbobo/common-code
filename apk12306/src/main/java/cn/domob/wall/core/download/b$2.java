package cn.domob.wall.core.download;

import android.util.Log;
import cn.domob.wall.core.h.d;
import java.io.File;

class b$2
  implements o
{
  b$2(b paramb) {}
  
  public void a()
  {
    Log.e("DrwSDK", b.c(this.a) + "rom can't chmod");
    if (b.l(this.a) != null) {
      b.l(this.a).a(5, "sd卡不存在");
    }
    b.c(this.a, "sd卡不存在");
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    Log.e("DrwSDK", b.c(this.a) + "not enough size sdsize=" + paramLong2 + " romsize=" + paramLong3);
    if (b.l(this.a) != null) {
      b.l(this.a).a(1, "空间不足");
    }
    b.c(this.a, "空间不足");
  }
  
  public void a(String paramString)
  {
    b.d().a(b.class, b.c(this.a) + " already exists in " + paramString);
    b.a(this.a, paramString);
    b.a(this.a, b.i(this.a), 0L);
  }
  
  public void b(String paramString)
  {
    b.d().a(b.class, b.c(this.a) + " is download but not finished in " + paramString);
    b.a(this.a, paramString);
    paramString = new File(b.i(this.a));
    b.a(this.a, b.i(this.a), paramString.length());
  }
  
  public void c(String paramString)
  {
    b.d().a(b.class, b.c(this.a) + " is  not download,it will download in " + paramString);
    b.a(this.a, paramString);
    b.a(this.a, b.i(this.a), 0L);
  }
  
  public void d(String paramString)
  {
    Log.e("DrwSDK", b.c(this.a) + paramString);
    if (b.l(this.a) != null) {
      b.l(this.a).a(5, b.c(this.a) + paramString);
    }
    b.c(this.a, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */