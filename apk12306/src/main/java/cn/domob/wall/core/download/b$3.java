package cn.domob.wall.core.download;

import android.os.Handler;
import cn.domob.wall.core.h.d;

class b$3
  implements e
{
  b$3(b paramb) {}
  
  public void a(int paramInt)
  {
    b.p(this.a).sendEmptyMessage(paramInt);
  }
  
  public void a(String paramString)
  {
    b.d().c(this.a, b.c(this.a) + "下载线程出错，错误原因：" + paramString);
    this.a.b();
    if (b.c()) {
      b.c(this.a, paramString);
    }
    if (b.l(this.a) != null) {
      b.l(this.a).a(6, paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\b$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */