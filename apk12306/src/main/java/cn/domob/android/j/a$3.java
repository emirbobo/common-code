package cn.domob.android.j;

import android.widget.RelativeLayout;
import java.util.Timer;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    if (a.k(this.a)) {
      a.l(this.a);
    }
    a.A(this.a).removeAllViews();
    a.F(this.a).setLayoutParams(a.E(this.a));
    a.b(this.a, a.F(this.a));
    b.a locala = a.m(this.a).e();
    if (locala.f()) {
      a.b(this.a, a.j(this.a).b());
    }
    if (locala.h()) {
      a.b(this.a, a.j(this.a).a(false));
    }
    if (a.t(this.a) != null) {
      a.t(this.a).cancel();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */