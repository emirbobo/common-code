package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.cache.LruMemoryCache;

class HttpCache$1
  extends LruMemoryCache<String, String>
{
  static
  {
    JniLib.a(1.class, 980);
  }
  
  HttpCache$1(HttpCache paramHttpCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected native int sizeOf(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\HttpCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */