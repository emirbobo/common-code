package cn.domob.android.j;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class a$13
  extends TimerTask
{
  a$13(a parama, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((a.c(this.b) != null) && (a.u(this.b) != null))
    {
      int i = a.s(this.b);
      if ((a.v(this.b) > 0) && (!a.w(this.b)) && (i >= a.v(this.b)))
      {
        a.a(this.b, i);
        a.c(this.b, true);
      }
      while ((this.a.size() > 0) && (((Long)this.a.get(0)).longValue() <= i))
      {
        a.b(this.b, ((Long)this.a.get(0)).longValue());
        this.a.remove(0);
      }
      if (((a.w(this.b)) || (a.v(this.b) <= 0)) && (this.a.size() == 0)) {
        a.x(this.b).cancel();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */