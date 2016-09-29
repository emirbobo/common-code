package cn.domob.android.j;

import cn.domob.android.i.f;

class e$c$1
  implements Runnable
{
  e$c$1(e.c paramc) {}
  
  public void run()
  {
    try
    {
      this.a.a.stopLoading();
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\e$c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */