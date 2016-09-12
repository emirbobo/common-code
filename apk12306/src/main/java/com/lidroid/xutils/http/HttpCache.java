package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.cache.LruMemoryCache;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import java.util.concurrent.ConcurrentHashMap;

public class HttpCache
{
  private static final int DEFAULT_CACHE_SIZE = 102400;
  private static final long DEFAULT_EXPIRY_TIME = 60000L;
  private static long defaultExpiryTime;
  private static final ConcurrentHashMap<String, Boolean> httpMethod_enabled_map;
  private int cacheSize = 102400;
  private final LruMemoryCache<String, String> mMemoryCache;
  
  static
  {
    JniLib.a(HttpCache.class, 981);
    defaultExpiryTime = 60000L;
    httpMethod_enabled_map = new ConcurrentHashMap(10);
    httpMethod_enabled_map.put(HttpRequest.HttpMethod.GET.toString(), Boolean.valueOf(true));
  }
  
  public HttpCache()
  {
    this(102400, 60000L);
  }
  
  public HttpCache(int paramInt, long paramLong)
  {
    this.cacheSize = paramInt;
    defaultExpiryTime = paramLong;
    this.mMemoryCache = new LruMemoryCache(this.cacheSize)
    {
      static
      {
        JniLib.a(1.class, 980);
      }
      
      protected native int sizeOf(String paramAnonymousString1, String paramAnonymousString2);
    };
  }
  
  public static native long getDefaultExpiryTime();
  
  public static native void setDefaultExpiryTime(long paramLong);
  
  public native void clear();
  
  public native String get(String paramString);
  
  public native boolean isEnabled(HttpRequest.HttpMethod paramHttpMethod);
  
  public native boolean isEnabled(String paramString);
  
  public native void put(String paramString1, String paramString2);
  
  public native void put(String paramString1, String paramString2, long paramLong);
  
  public native void setCacheSize(int paramInt);
  
  public native void setEnabled(HttpRequest.HttpMethod paramHttpMethod, boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\HttpCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */