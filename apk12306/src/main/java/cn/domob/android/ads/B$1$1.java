package cn.domob.android.ads;

import cn.domob.android.i.f;

class B$1$1
  implements Runnable
{
  B$1$1(B.1 param1, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.length == 0))
    {
      B.c().e("the HTTP Status-Code is 200, but has received byte array is empty");
      if ((B.a(this.c.a) != null) && (B.b(this.c.a) != null)) {
        B.a(this.c.a).a(B.b(this.c.a).toString());
      }
    }
    for (;;)
    {
      return;
      String str = B.a(this.c.a, this.a, B.c(this.c.a));
      if (str != null)
      {
        B.c().b("Image saved:" + str);
        try
        {
          c localc = new cn/domob/android/ads/c;
          localc.<init>();
          localc.b(this.c.a.getContext(), this.b, str);
          this.c.a.a(String.format("%s.assetReady('%s', '%s')", new Object[] { "domobBridge", this.b, str }));
          if (B.a(this.c.a) == null) {
            continue;
          }
          B.a(this.c.a).a();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            B.c().a(localException);
          }
        }
      }
      else
      {
        B.c().e("Error in saving image.");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\B$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */