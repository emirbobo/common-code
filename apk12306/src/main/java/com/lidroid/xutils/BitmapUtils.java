package com.lidroid.xutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapCacheListener;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.core.BitmapCache;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.bitmap.download.Downloader;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.task.TaskHandler;
import java.io.File;
import java.lang.ref.WeakReference;

public class BitmapUtils
  implements TaskHandler
{
  private boolean cancelAllTask = false;
  private Context context;
  private BitmapDisplayConfig defaultDisplayConfig;
  private BitmapGlobalConfig globalConfig;
  private boolean pauseTask = false;
  private final Object pauseTaskLock = new Object();
  
  static
  {
    JniLib.a(BitmapUtils.class, 915);
  }
  
  public BitmapUtils(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BitmapUtils(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context may not be null");
    }
    this.context = paramContext.getApplicationContext();
    this.globalConfig = BitmapGlobalConfig.getInstance(this.context, paramString);
    this.defaultDisplayConfig = new BitmapDisplayConfig();
  }
  
  public BitmapUtils(Context paramContext, String paramString, float paramFloat)
  {
    this(paramContext, paramString);
    this.globalConfig.setMemCacheSizePercent(paramFloat);
  }
  
  public BitmapUtils(Context paramContext, String paramString, float paramFloat, int paramInt)
  {
    this(paramContext, paramString);
    this.globalConfig.setMemCacheSizePercent(paramFloat);
    this.globalConfig.setDiskCacheSize(paramInt);
  }
  
  public BitmapUtils(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, paramString);
    this.globalConfig.setMemoryCacheSize(paramInt);
  }
  
  public BitmapUtils(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this(paramContext, paramString);
    this.globalConfig.setMemoryCacheSize(paramInt1);
    this.globalConfig.setDiskCacheSize(paramInt2);
  }
  
  private static native <T extends View> boolean bitmapLoadTaskExist(T paramT, String paramString, BitmapLoadCallBack<T> paramBitmapLoadCallBack);
  
  private static native <T extends View> BitmapLoadTask<T> getBitmapTaskFromContainer(T paramT, BitmapLoadCallBack<T> paramBitmapLoadCallBack);
  
  public native void cancel();
  
  public native void clearCache();
  
  public native void clearCache(String paramString);
  
  public native void clearDiskCache();
  
  public native void clearDiskCache(String paramString);
  
  public native void clearMemoryCache();
  
  public native void clearMemoryCache(String paramString);
  
  public native void closeCache();
  
  public native BitmapUtils configBitmapCacheListener(BitmapCacheListener paramBitmapCacheListener);
  
  public native BitmapUtils configDefaultAutoRotation(boolean paramBoolean);
  
  public native BitmapUtils configDefaultBitmapConfig(Bitmap.Config paramConfig);
  
  public native BitmapUtils configDefaultBitmapMaxSize(int paramInt1, int paramInt2);
  
  public native BitmapUtils configDefaultBitmapMaxSize(BitmapSize paramBitmapSize);
  
  public native BitmapUtils configDefaultCacheExpiry(long paramLong);
  
  public native BitmapUtils configDefaultConnectTimeout(int paramInt);
  
  public native BitmapUtils configDefaultDisplayConfig(BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public native BitmapUtils configDefaultImageLoadAnimation(Animation paramAnimation);
  
  public native BitmapUtils configDefaultLoadFailedImage(int paramInt);
  
  public native BitmapUtils configDefaultLoadFailedImage(Bitmap paramBitmap);
  
  public native BitmapUtils configDefaultLoadFailedImage(Drawable paramDrawable);
  
  public native BitmapUtils configDefaultLoadingImage(int paramInt);
  
  public native BitmapUtils configDefaultLoadingImage(Bitmap paramBitmap);
  
  public native BitmapUtils configDefaultLoadingImage(Drawable paramDrawable);
  
  public native BitmapUtils configDefaultReadTimeout(int paramInt);
  
  public native BitmapUtils configDefaultShowOriginal(boolean paramBoolean);
  
  public native BitmapUtils configDiskCacheEnabled(boolean paramBoolean);
  
  public native BitmapUtils configDiskCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator);
  
  public native BitmapUtils configDownloader(Downloader paramDownloader);
  
  public native BitmapUtils configMemoryCacheEnabled(boolean paramBoolean);
  
  public native BitmapUtils configThreadPoolSize(int paramInt);
  
  public native <T extends View> void display(T paramT, String paramString);
  
  public native <T extends View> void display(T paramT, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public native <T extends View> void display(T paramT, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadCallBack<T> paramBitmapLoadCallBack);
  
  public native <T extends View> void display(T paramT, String paramString, BitmapLoadCallBack<T> paramBitmapLoadCallBack);
  
  public native void flushCache();
  
  public native File getBitmapFileFromDiskCache(String paramString);
  
  public native Bitmap getBitmapFromMemCache(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public native boolean isCancelled();
  
  public native boolean isPaused();
  
  public native void pause();
  
  public native void resume();
  
  public native boolean supportCancel();
  
  public native boolean supportPause();
  
  public native boolean supportResume();
  
  public class BitmapLoadTask<T extends View>
    extends PriorityAsyncTask<Object, Object, Bitmap>
  {
    private static final int PROGRESS_LOADING = 1;
    private static final int PROGRESS_LOAD_STARTED = 0;
    private final BitmapLoadCallBack<T> callBack;
    private final WeakReference<T> containerReference;
    private final BitmapDisplayConfig displayConfig;
    private BitmapLoadFrom from = BitmapLoadFrom.DISK_CACHE;
    private final String uri;
    
    static
    {
      JniLib.a(BitmapLoadTask.class, 914);
    }
    
    public BitmapLoadTask(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadCallBack<T> paramBitmapLoadCallBack)
    {
      BitmapLoadCallBack localBitmapLoadCallBack;
      if ((paramString == null) || (paramBitmapDisplayConfig == null) || (paramBitmapLoadCallBack == null) || (localBitmapLoadCallBack == null)) {
        throw new IllegalArgumentException("args may not be null");
      }
      this.containerReference = new WeakReference(paramString);
      this.callBack = localBitmapLoadCallBack;
      this.uri = paramBitmapDisplayConfig;
      this.displayConfig = paramBitmapLoadCallBack;
    }
    
    protected Bitmap doInBackground(Object... arg1)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool;
        synchronized (BitmapUtils.this.pauseTaskLock)
        {
          if ((!BitmapUtils.this.pauseTask) || (isCancelled()))
          {
            localObject1 = null;
            ??? = (Object[])localObject1;
            if (!isCancelled())
            {
              ??? = (Object[])localObject1;
              if (getTargetContainer() != null)
              {
                publishProgress(new Object[] { Integer.valueOf(0) });
                ??? = BitmapUtils.this.globalConfig.getBitmapCache().getBitmapFromDiskCache(this.uri, this.displayConfig);
              }
            }
            localObject1 = ???;
            if (??? == null)
            {
              localObject1 = ???;
              if (!isCancelled())
              {
                localObject1 = ???;
                if (getTargetContainer() != null)
                {
                  localObject1 = BitmapUtils.this.globalConfig.getBitmapCache().downloadBitmap(this.uri, this.displayConfig, this);
                  this.from = BitmapLoadFrom.URI;
                }
              }
            }
            return (Bitmap)localObject1;
          }
        }
      }
    }
    
    public native T getTargetContainer();
    
    protected native void onCancelled(Bitmap paramBitmap);
    
    protected native void onPostExecute(Bitmap paramBitmap);
    
    protected void onProgressUpdate(Object... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
      for (;;)
      {
        return;
        View localView = getTargetContainer();
        if (localView != null) {
          switch (((Integer)paramVarArgs[0]).intValue())
          {
          default: 
            break;
          case 0: 
            this.callBack.onLoadStarted(localView, this.uri, this.displayConfig);
            break;
          case 1: 
            if (paramVarArgs.length == 3) {
              this.callBack.onLoading(localView, this.uri, this.displayConfig, ((Long)paramVarArgs[1]).longValue(), ((Long)paramVarArgs[2]).longValue());
            }
            break;
          }
        }
      }
    }
    
    public native void updateProgress(long paramLong1, long paramLong2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */