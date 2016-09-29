package com.lidroid.xutils.bitmap.core;

import android.graphics.Bitmap;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.cache.LruMemoryCache;

class BitmapCache$1
  extends LruMemoryCache<BitmapCache.MemoryCacheKey, Bitmap>
{
  static
  {
    JniLib.a(1.class, 930);
  }
  
  BitmapCache$1(BitmapCache paramBitmapCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected native int sizeOf(BitmapCache.MemoryCacheKey paramMemoryCacheKey, Bitmap paramBitmap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\BitmapCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */