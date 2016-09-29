package cn.domob.android.j;

import android.app.Activity;
import cn.domob.android.i.f;

class e$c
  extends Thread
{
  private int b = 0;
  
  e$c(e parame) {}
  
  public void run()
  {
    while ((this.b < e.d(this.a)) && (!e.e(this.a))) {
      try
      {
        Thread.sleep(1000L);
        this.b += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        e.a().a(localInterruptedException);
      }
    }
    if ((this.b == e.d(this.a)) && (!e.e(this.a)) && (!e.a(this.a)))
    {
      e.a().e("WebView 加载超时");
      e.b(this.a, true);
      e.f(this.a);
      if (e.g(this.a)) {
        ((Activity)this.a.getContext()).runOnUiThread(new Runnable()
        {
          public void run()
          {
            try
            {
              e.c.this.a.stopLoading();
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                e.a().a(localException);
              }
            }
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\e$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */