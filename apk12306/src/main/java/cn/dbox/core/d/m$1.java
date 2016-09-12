package cn.dbox.core.d;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

class m$1
  extends n<String, Bitmap>
{
  m$1(m paramm, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    for (int i = paramBitmap.getRowBytes() * paramBitmap.getHeight();; i = 0) {
      return i;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 != null) {
      m.b().put(paramString, new SoftReference(paramBitmap1));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\m$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */