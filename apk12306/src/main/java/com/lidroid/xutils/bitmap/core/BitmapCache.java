package com.lidroid.xutils.bitmap.core;

import android.graphics.Bitmap;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.BitmapUtils.BitmapLoadTask;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.cache.LruDiskCache;
import com.lidroid.xutils.cache.LruMemoryCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BitmapCache
{
  private final int DISK_CACHE_INDEX = 0;
  private BitmapGlobalConfig globalConfig;
  private final Object mDiskCacheLock = new Object();
  private LruDiskCache mDiskLruCache;
  private LruMemoryCache<MemoryCacheKey, Bitmap> mMemoryCache;
  
  static
  {
    JniLib.a(BitmapCache.class, 932);
  }
  
  public BitmapCache(BitmapGlobalConfig paramBitmapGlobalConfig)
  {
    if (paramBitmapGlobalConfig == null) {
      throw new IllegalArgumentException("globalConfig may not be null");
    }
    this.globalConfig = paramBitmapGlobalConfig;
  }
  
  private native Bitmap addBitmapToMemoryCache(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, Bitmap paramBitmap, long paramLong)
    throws IOException;
  
  private native Bitmap decodeBitmapMeta(BitmapMeta paramBitmapMeta, BitmapDisplayConfig paramBitmapDisplayConfig)
    throws IOException;
  
  private native Bitmap rotateBitmapIfNeeded(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, Bitmap paramBitmap);
  
  public native void clearCache();
  
  public native void clearCache(String paramString);
  
  public native void clearDiskCache();
  
  public native void clearDiskCache(String paramString);
  
  public native void clearMemoryCache();
  
  public native void clearMemoryCache(String paramString);
  
  public native void close();
  
  public native Bitmap downloadBitmap(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapUtils.BitmapLoadTask<?> paramBitmapLoadTask);
  
  public native void flush();
  
  public native File getBitmapFileFromDiskCache(String paramString);
  
  public native Bitmap getBitmapFromDiskCache(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public native Bitmap getBitmapFromMemCache(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public native void initDiskCache();
  
  public native void initMemoryCache();
  
  public native void setDiskCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator);
  
  public native void setDiskCacheSize(int paramInt);
  
  public native void setMemoryCacheSize(int paramInt);
  
  private class BitmapMeta
  {
    public byte[] data;
    public long expiryTimestamp;
    public FileInputStream inputStream;
    
    private BitmapMeta() {}
  }
  
  public class MemoryCacheKey
  {
    private String subKey;
    private String uri;
    
    static
    {
      JniLib.a(MemoryCacheKey.class, 931);
    }
    
    private MemoryCacheKey(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
    {
      this.uri = paramString;
      if (paramBitmapDisplayConfig == null) {}
      for (this$1 = null;; this$1 = paramBitmapDisplayConfig.toString())
      {
        this.subKey = BitmapCache.this;
        return;
      }
    }
    
    public native boolean equals(Object paramObject);
    
    public native int hashCode();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */