package cn.domob.android.ads;

import cn.domob.android.f.g;
import cn.domob.android.f.h;
import cn.domob.android.i.f;

class B$1
  extends g
{
  B$1(B paramB) {}
  
  public void a(final h paramh)
  {
    if (paramh.d() != 200) {}
    for (;;)
    {
      return;
      final byte[] arrayOfByte = paramh.a();
      paramh = paramh.c();
      B.c().b("Download finish:" + paramh);
      new Thread(new Runnable()
      {
        public void run()
        {
          if ((arrayOfByte == null) || (arrayOfByte.length == 0))
          {
            B.c().e("the HTTP Status-Code is 200, but has received byte array is empty");
            if ((B.a(B.1.this.a) != null) && (B.b(B.1.this.a) != null)) {
              B.a(B.1.this.a).a(B.b(B.1.this.a).toString());
            }
          }
          for (;;)
          {
            return;
            String str = B.a(B.1.this.a, arrayOfByte, B.c(B.1.this.a));
            if (str != null)
            {
              B.c().b("Image saved:" + str);
              try
              {
                c localc = new cn/domob/android/ads/c;
                localc.<init>();
                localc.b(B.1.this.a.getContext(), paramh, str);
                B.1.this.a.a(String.format("%s.assetReady('%s', '%s')", new Object[] { "domobBridge", paramh, str }));
                if (B.a(B.1.this.a) == null) {
                  continue;
                }
                B.a(B.1.this.a).a();
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
      }).start();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\B$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */