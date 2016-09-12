package cn.domob.wall.core.download;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

class l$1
  extends m<String, Bitmap>
{
  l$1(l paraml, int paramInt)
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
      l.b().put(paramString, new SoftReference(paramBitmap1));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\l$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */