package cn.domob.android.a;

import android.os.Handler;
import cn.domob.android.offerwall.m;

class a$2
  implements d
{
  a$2(a parama) {}
  
  public void a(int paramInt)
  {
    a.l(this.a).sendEmptyMessage(paramInt);
  }
  
  public void a(String paramString)
  {
    a.e().c(this.a, a.b(this.a) + "下载线程出错，错误原因：" + paramString);
    this.a.b();
    if (a.c()) {
      a.b(this.a, paramString);
    }
    if (a.j(this.a) != null) {
      a.j(this.a).a(6, paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */