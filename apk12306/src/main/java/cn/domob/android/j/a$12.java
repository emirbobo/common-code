package cn.domob.android.j;

import android.widget.VideoView;
import cn.domob.android.i.f;
import java.util.Timer;
import java.util.TimerTask;

class a$12
  extends TimerTask
{
  a$12(a parama) {}
  
  public void run()
  {
    try
    {
      if (a.c(this.a) != null) {
        if (a.r(this.a))
        {
          int i = (a.c(this.a).getDuration() - a.s(this.a)) / 1000;
          a.j(this.a).a(i);
        }
      }
      for (;;)
      {
        return;
        a.t(this.a).cancel();
        a.a(this.a, null);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.m().a(localException);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */