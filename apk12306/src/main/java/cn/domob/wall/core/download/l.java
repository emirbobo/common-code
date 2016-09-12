package cn.domob.wall.core.download;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class l
{
  private static final int a = 15;
  private static m<String, Bitmap> b;
  private static LinkedHashMap<String, SoftReference<Bitmap>> c;
  
  public l(Context paramContext)
  {
    b = new m(8388608)
    {
      protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null) {}
        for (int i = paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();; i = 0) {
          return i;
        }
      }
      
      protected void a(boolean paramAnonymousBoolean, String paramAnonymousString, Bitmap paramAnonymousBitmap1, Bitmap paramAnonymousBitmap2)
      {
        if (paramAnonymousBitmap1 != null) {
          l.b().put(paramAnonymousString, new SoftReference(paramAnonymousBitmap1));
        }
      }
    };
    c = new LinkedHashMap(15, 0.75F, true)
    {
      private static final long serialVersionUID = 6040103833179403725L;
      
      protected boolean removeEldestEntry(Map.Entry<String, SoftReference<Bitmap>> paramAnonymousEntry)
      {
        if (size() > 15) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    };
  }
  
  public Bitmap a(String paramString)
  {
    for (;;)
    {
      synchronized (b)
      {
        Object localObject1 = (Bitmap)b.a(paramString);
        if (localObject1 != null)
        {
          b.b(paramString);
          b.b(paramString, localObject1);
          paramString = (String)localObject1;
          return paramString;
        }
        synchronized (c)
        {
          localObject1 = (SoftReference)c.get(paramString);
          if (localObject1 == null) {
            break label121;
          }
          localObject1 = (Bitmap)((SoftReference)localObject1).get();
          if (localObject1 != null)
          {
            b.b(paramString, localObject1);
            c.remove(paramString);
            paramString = (String)localObject1;
          }
        }
      }
      c.remove(paramString);
      label121:
      paramString = null;
    }
  }
  
  public void a()
  {
    c.clear();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    synchronized (b)
    {
      b.b(paramString, paramBitmap);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */