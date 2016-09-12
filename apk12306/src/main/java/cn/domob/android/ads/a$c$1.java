package cn.domob.android.ads;

import cn.domob.android.i.f;

class a$c$1
  implements Runnable
{
  a$c$1(a.c paramc) {}
  
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
        a.b().a(localException);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a$c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */