package cn.domob.android.ads.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import cn.domob.android.ads.c.c;
import cn.domob.android.i.f;
import java.io.File;

class b$b
  extends Thread
{
  private String b;
  private String c;
  
  b$b(b paramb, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.b == null) || (this.b.length() == 0))
        {
          b.b().a("local path is null");
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Bitmap localBitmap;
        Object localObject1;
        long l;
        if (b.a(this.a) == null) {
          continue;
        }
        b.a(this.a).sendEmptyMessage(1);
        b.b().a(localException);
        continue;
        b.a(this.a).sendEmptyMessage(1);
        continue;
      }
      catch (Error localError)
      {
        if (b.a(this.a) == null) {
          continue;
        }
        b.a(this.a).sendEmptyMessage(1);
        b.b().a(localError);
        continue;
      }
      localObject2 = this.b;
      localBitmap = BitmapFactory.decodeFile((String)localObject2);
      localObject1 = new java/io/File;
      ((File)localObject1).<init>((String)localObject2);
      l = ((File)localObject1).length();
      localObject2 = b.b();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((f)localObject2).a("The size of pic taken =" + l);
      if (!c.a(localBitmap, l, this.c)) {
        continue;
      }
      b.a(this.a).sendEmptyMessage(0);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */