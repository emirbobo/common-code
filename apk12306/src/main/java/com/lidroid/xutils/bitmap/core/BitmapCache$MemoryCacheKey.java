package com.lidroid.xutils.bitmap.core;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

public class BitmapCache$MemoryCacheKey
{
  private String subKey;
  private String uri;
  
  static
  {
    JniLib.a(MemoryCacheKey.class, 931);
  }
  
  private BitmapCache$MemoryCacheKey(BitmapCache paramBitmapCache, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    this.uri = paramString;
    if (paramBitmapDisplayConfig == null) {}
    for (paramBitmapCache = null;; paramBitmapCache = paramBitmapDisplayConfig.toString())
    {
      this.subKey = paramBitmapCache;
      return;
    }
  }
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\BitmapCache$MemoryCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */