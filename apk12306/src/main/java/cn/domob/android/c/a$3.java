package cn.domob.android.c;

import android.os.Handler;
import cn.domob.android.i.f;

class a$3
  implements c
{
  a$3(a parama) {}
  
  public void a(int paramInt)
  {
    a.p(this.a).sendEmptyMessage(paramInt);
  }
  
  public void a(String paramString)
  {
    a.c().c(this.a, a.c(this.a) + "下载线程出错，错误原因：" + paramString + "; fileName: " + a.k(this.a));
    this.a.a(true);
    a.b(this.a, paramString);
    if (a.l(this.a) != null) {
      a.l(this.a).a(6, paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\a$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */