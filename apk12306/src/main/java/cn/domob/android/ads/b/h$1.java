package cn.domob.android.ads.b;

import android.os.Handler;

class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public void run()
  {
    boolean bool = this.a.e();
    if (h.a(this.a) != bool)
    {
      h.a(this.a, bool);
      h.b(this.a).a(n.a(h.a(this.a)));
    }
    h.c(this.a).postDelayed(this, 3000L);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\h$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */