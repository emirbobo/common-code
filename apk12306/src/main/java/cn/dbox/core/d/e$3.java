package cn.dbox.core.d;

import android.widget.Toast;

class e$3
  implements c
{
  e$3(e parame) {}
  
  public void a()
  {
    Toast.makeText(e.c(this.a), "开始下载 。。。", 0).show();
    if (e.a(this.a) != null) {
      e.a(this.a).i(e.b(this.a));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (e.a(this.a) != null)
    {
      if (paramInt != 512) {
        break label37;
      }
      e.a(this.a).k(e.b(this.a));
    }
    for (;;)
    {
      return;
      label37:
      if (paramInt == 513) {
        e.a(this.a).l(e.b(this.a));
      } else {
        e.a(this.a).h(e.b(this.a));
      }
    }
  }
  
  public void a(String paramString)
  {
    if (e.a(this.a) != null) {
      e.a(this.a).g(e.b(this.a));
    }
    if (e.a(this.a) != null) {
      e.a(this.a).m(e.b(this.a));
    }
  }
  
  public void b()
  {
    if (e.a(this.a) != null) {
      e.a(this.a).j(e.b(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\e$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */