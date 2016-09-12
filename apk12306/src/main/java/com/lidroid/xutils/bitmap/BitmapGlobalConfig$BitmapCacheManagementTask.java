package com.lidroid.xutils.bitmap;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.core.BitmapCache;
import com.lidroid.xutils.task.Priority;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.util.LogUtils;

class BitmapGlobalConfig$BitmapCacheManagementTask
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
  
  private BitmapGlobalConfig$BitmapCacheManagementTask(BitmapGlobalConfig paramBitmapGlobalConfig)
  {
    setPriority(Priority.UI_TOP);
  }
  
  protected Object[] doInBackground(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (;;)
    {
      return paramVarArgs;
      BitmapCache localBitmapCache = this.this$0.getBitmapCache();
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\BitmapGlobalConfig$BitmapCacheManagementTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */