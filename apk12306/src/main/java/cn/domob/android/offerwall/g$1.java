package cn.domob.android.offerwall;

import android.widget.Toast;
import cn.domob.android.a.c;

class g$1
  implements c
{
  g$1(g paramg) {}
  
  public void a()
  {
    Toast.makeText(g.a(this.a), "开始下载 。。。", 0).show();
    if (g.b(this.a) != null) {
      g.b(this.a).e(this.a);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (g.b(this.a) != null)
    {
      if (paramInt != 512) {
        break label34;
      }
      g.b(this.a).g(this.a);
    }
    for (;;)
    {
      return;
      label34:
      if (paramInt == 513) {
        g.b(this.a).h(this.a);
      } else {
        g.b(this.a).d(this.a);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (g.b(this.a) != null) {
      g.b(this.a).c(this.a);
    }
    if (g.b(this.a) != null) {
      g.b(this.a).i(this.a);
    }
  }
  
  public void b()
  {
    if (g.b(this.a) != null) {
      g.b(this.a).f(this.a);
    }
  }
  
  public void b(String paramString) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\g$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */