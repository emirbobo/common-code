package cn.domob.wall.core.download;

import android.widget.Toast;

class d$3
  implements c
{
  d$3(d paramd) {}
  
  public void a()
  {
    Toast.makeText(d.c(this.a), "开始下载 。。。", 0).show();
    if (d.a(this.a) != null) {
      d.a(this.a).o(d.b(this.a));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (d.a(this.a) != null)
    {
      if (paramInt != 512) {
        break label37;
      }
      d.a(this.a).q(d.b(this.a));
    }
    for (;;)
    {
      return;
      label37:
      if (paramInt == 513) {
        d.a(this.a).r(d.b(this.a));
      } else {
        d.a(this.a).n(d.b(this.a));
      }
    }
  }
  
  public void a(String paramString)
  {
    if (d.a(this.a) != null) {
      d.a(this.a).m(d.b(this.a));
    }
    if (d.a(this.a) != null) {
      d.a(this.a).s(d.b(this.a));
    }
  }
  
  public void b()
  {
    if (d.a(this.a) != null) {
      d.a(this.a).p(d.b(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\d$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */