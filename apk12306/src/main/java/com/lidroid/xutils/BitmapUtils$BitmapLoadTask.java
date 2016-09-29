package com.lidroid.xutils;

import android.graphics.Bitmap;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.core.BitmapCache;
import com.lidroid.xutils.task.PriorityAsyncTask;
import java.lang.ref.WeakReference;

public class BitmapUtils$BitmapLoadTask<T extends View>
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
  
  public BitmapUtils$BitmapLoadTask(T paramT, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadCallBack<T> paramBitmapLoadCallBack)
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
      synchronized (BitmapUtils.access$0(this.this$0))
      {
        if ((!BitmapUtils.access$1(this.this$0)) || (isCancelled()))
        {
          localObject1 = null;
          ??? = (Object[])localObject1;
          if (!isCancelled())
          {
            ??? = (Object[])localObject1;
            if (getTargetContainer() != null)
            {
              publishProgress(new Object[] { Integer.valueOf(0) });
              ??? = BitmapUtils.access$3(this.this$0).getBitmapCache().getBitmapFromDiskCache(this.uri, this.displayConfig);
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
                localObject1 = BitmapUtils.access$3(this.this$0).getBitmapCache().downloadBitmap(this.uri, this.displayConfig, this);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\BitmapUtils$BitmapLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */