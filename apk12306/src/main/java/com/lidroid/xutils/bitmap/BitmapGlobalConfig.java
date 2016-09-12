package com.lidroid.xutils.bitmap;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.core.BitmapCache;
import com.lidroid.xutils.bitmap.download.Downloader;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.task.Priority;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.task.PriorityExecutor;
import com.lidroid.xutils.util.LogUtils;
import java.util.HashMap;

public class BitmapGlobalConfig
{
  private static final PriorityExecutor BITMAP_LOAD_EXECUTOR = new PriorityExecutor(5);
  private static final int DEFAULT_POOL_SIZE = 5;
  private static final PriorityExecutor DISK_CACHE_EXECUTOR = new PriorityExecutor(2);
  public static final int MIN_DISK_CACHE_SIZE = 10485760;
  public static final int MIN_MEMORY_CACHE_SIZE = 2097152;
  private static final HashMap<String, BitmapGlobalConfig> configMap = new HashMap(1);
  private BitmapCache bitmapCache;
  private BitmapCacheListener bitmapCacheListener;
  private long defaultCacheExpiry = 2592000000L;
  private int defaultConnectTimeout = 15000;
  private int defaultReadTimeout = 15000;
  private boolean diskCacheEnabled = true;
  private String diskCachePath;
  private int diskCacheSize = 52428800;
  private Downloader downloader;
  private FileNameGenerator fileNameGenerator;
  private Context mContext;
  private boolean memoryCacheEnabled = true;
  private int memoryCacheSize = 4194304;
  
  static
  {
    JniLib.a(BitmapGlobalConfig.class, 926);
  }
  
  private BitmapGlobalConfig(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context may not be null");
    }
    this.mContext = paramContext;
    this.diskCachePath = paramString;
    initBitmapCache();
  }
  
  public static native BitmapGlobalConfig getInstance(Context paramContext, String paramString);
  
  private native int getMemoryClass();
  
  private native void initBitmapCache();
  
  public native void clearCache();
  
  public native void clearCache(String paramString);
  
  public native void clearDiskCache();
  
  public native void clearDiskCache(String paramString);
  
  public native void clearMemoryCache();
  
  public native void clearMemoryCache(String paramString);
  
  public native void closeCache();
  
  public native void flushCache();
  
  public native BitmapCache getBitmapCache();
  
  public native BitmapCacheListener getBitmapCacheListener();
  
  public native PriorityExecutor getBitmapLoadExecutor();
  
  public native long getDefaultCacheExpiry();
  
  public native int getDefaultConnectTimeout();
  
  public native int getDefaultReadTimeout();
  
  public native PriorityExecutor getDiskCacheExecutor();
  
  public native String getDiskCachePath();
  
  public native int getDiskCacheSize();
  
  public native Downloader getDownloader();
  
  public native FileNameGenerator getFileNameGenerator();
  
  public native int getMemoryCacheSize();
  
  public native int getThreadPoolSize();
  
  public native boolean isDiskCacheEnabled();
  
  public native boolean isMemoryCacheEnabled();
  
  public native void setBitmapCacheListener(BitmapCacheListener paramBitmapCacheListener);
  
  public native void setDefaultCacheExpiry(long paramLong);
  
  public native void setDefaultConnectTimeout(int paramInt);
  
  public native void setDefaultReadTimeout(int paramInt);
  
  public native void setDiskCacheEnabled(boolean paramBoolean);
  
  public native void setDiskCacheSize(int paramInt);
  
  public native void setDownloader(Downloader paramDownloader);
  
  public native void setFileNameGenerator(FileNameGenerator paramFileNameGenerator);
  
  public native void setMemCacheSizePercent(float paramFloat);
  
  public native void setMemoryCacheEnabled(boolean paramBoolean);
  
  public native void setMemoryCacheSize(int paramInt);
  
  public native void setThreadPoolSize(int paramInt);
  
  private class BitmapCacheManagementTask
    extends PriorityAsyncTask<Object, Void, Object[]>
  {
    public static final int MESSAGE_CLEAR = 4;
    public static final int MESSAGE_CLEAR_BY_KEY = 7;
    public static final int MESSAGE_CLEAR_DISK = 6;
    public static final int MESSAGE_CLEAR_DISK_BY_KEY = 9;
    public static final int MESSAGE_CLEAR_MEMORY = 5;
    public static final int MESSAGE_CLEAR_MEMORY_BY_KEY = 8;
    public static final int MESSAGE_CLOSE = 3;
    public static final int MESSAGE_FLUSH = 2;
    public static final int MESSAGE_INIT_DISK_CACHE = 1;
    public static final int MESSAGE_INIT_MEMORY_CACHE = 0;
    
    static
    {
      JniLib.a(BitmapCacheManagementTask.class, 925);
    }
    
    private BitmapCacheManagementTask()
    {
      setPriority(Priority.UI_TOP);
    }
    
    protected Object[] doInBackground(Object... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
      for (;;)
      {
        return paramVarArgs;
        BitmapCache localBitmapCache = BitmapGlobalConfig.this.getBitmapCache();
        if (localBitmapCache != null)
        {
          try
          {
            switch (((Integer)paramVarArgs[0]).intValue())
            {
            }
          }
          catch (Throwable localThrowable)
          {
            LogUtils.e(localThrowable.getMessage(), localThrowable);
          }
          localBitmapCache.initMemoryCache();
          continue;
          continue;
          localThrowable.initDiskCache();
          continue;
          localThrowable.flush();
          continue;
          localThrowable.clearMemoryCache();
          localThrowable.close();
          continue;
          localThrowable.clearCache();
          continue;
          localThrowable.clearMemoryCache();
          continue;
          localThrowable.clearDiskCache();
          continue;
          if (paramVarArgs.length == 2)
          {
            localThrowable.clearCache(String.valueOf(paramVarArgs[1]));
            continue;
            if (paramVarArgs.length == 2)
            {
              localThrowable.clearMemoryCache(String.valueOf(paramVarArgs[1]));
              continue;
              if (paramVarArgs.length == 2) {
                localThrowable.clearDiskCache(String.valueOf(paramVarArgs[1]));
              }
            }
          }
        }
      }
    }
    
    protected native void onPostExecute(Object[] paramArrayOfObject);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\BitmapGlobalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */