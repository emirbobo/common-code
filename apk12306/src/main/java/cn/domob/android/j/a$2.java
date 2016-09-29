package cn.domob.android.j;

import android.app.Dialog;

class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public void run()
  {
    if (a.z(this.a) != null)
    {
      a.s(this.a);
      a.a(this.a, a.A(this.a));
      a.z(this.a).dismiss();
      a.a(this.a, null);
      a.a(this.a, a.B(this.a), a.C(this.a));
      a.D(this.a).topMargin = 0;
      a.D(this.a).leftMargin = 0;
      this.a.addView(a.A(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */